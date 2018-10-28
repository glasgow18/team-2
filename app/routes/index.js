var express = require('express');
var router = express.Router();

var sqlite3 = require('sqlite3').verbose();
var app = require('../app');

var db = app.db;


/* GET home page. */
router.get('/', function(req, res, next) {
  res.render('index', { title: 'Express' });
});

router.get('/activities', function(req, res, next) { 
    var data = []; 
    db.each("SELECT * FROM activity", function(err, row) {
      if (err) {
        console.log(err.message);
      }
        //TODO: Add rest of table columns
        var o = JSON.stringify([row.id, row.name, row.address, row.lat, row.lng]);
        console.log(o);
        data.push(o);
        console.log(data);
    },
    function() {
      //Complete callback
      res.json(data);
    }
    );
  
});

router.get('/activities/search/:keywords', function (req, res, next) {

  var splits = req.params.keywords.toLowerCase().split(",");
  var keyword_ids = [];
  var activities = [];
  console.log(splits.length);
  console.log(splits[0]);
  console.log("TRYING");

  //Loop through each keyword
  for (var i = 0; i <= splits.length - 1; i++) {
    console.log("TRYING2");
    console.log(splits[i].trim());
    //Get each keyword's id
    db.each(`SELECT id FROM keyword WHERE LOWER(word) = "${splits[i].trim().toLowerCase()}"`, function(err, row) {
      console.log("INSIDE HERE");
      //Push the id to an array
      keyword_ids.push(row.id);
    }, function() {
      console.log("DONE ONE");
      //Complete callback
      console.log(keyword_ids);
      console.log(keyword_ids.length);
      //Loop through the array of keyword ID's
      var j = 0;
      while (j <= keyword_ids.length) {
        if (j == keyword_ids) {
          res.send(activities);
        }
      //for (var j = 0; j <= keyword_ids.length - 1; j++) {
  console.log("TRYING3");

        console.log(keyword_ids[j]); 
        //Get the activity_id's for each activitiy that has a keyword we're looking for
        db.each(`SELECT activity_id FROM activity_to_keyword WHERE keyword_id = ${keyword_ids[j]}`, function (err, row) {
          console.log(row);
          console.log(row.activity_id);
          //Get all the activities from the ID's we got in the previous statement
          db.each(`SELECT * FROM activity WHERE id = ${row.activity_id}`, function(err, row) {
            //JSONify the stuff
            var object = JSON.stringify([row.id, row.name, row.price, row.address, row.lat, row.lng, row.contact_phone_number, row.contact_email, row.contact_website]);
            //push json object to array
            activities.push(object);
            console.log("pushed");
            console.log(activities);
            console.log(keyword_ids[j]);
            j++;
          }, function() {
            //last callback
            console.log("DONE TWO");
            console.log(activities);

            //TODO: PROBLEM IS HERE WITH res.json(activities);
            //Need to return all the final array of activities, but this res.json either
            //fires too early or stops prematurely due to a call
            //res.json(activities);
            
          });
        }, function() {
          console.log("counter"); 

        }
);
      }
    });
  }
});

router.post('/activities/add/:name/:price/:address/:lat/:lng/:phone?/:email?/:website?/:extra?/:keywords', function(req, res, next) { 
  //Make undefined parametres null to insert into the db
  if (req.params.phone == undefined) {
    req.params.phone = null;
  }
  if (req.params.email == undefined) {
    req.params.email = null;
  }
  if (req.params.website == undefined) {
    req.params.website = null;
  }
  if (req.params.extra == undefined) {
    req.params.extra = null;
  }


  db.run(`INSERT INTO activity (name, price, address, lat, 
        lng, contact_phone_number, contact_email, 
        contact_website, extra_info) VALUES (
          "${req.params.name}", ${req.params.price}, "${req.params.address}", 
          ${req.params.lat}, ${req.params.lng}, "${req.params.phone}", "${req.params.email}", "${req.params.website}", "${req.params.extra}"
          )`);

  var activity_id = null;
  db.get(`SELECT * FROM activity WHERE LOWER(name) = "${req.params.name}".toLowerCase()`, function(err, row) {
    if (err) {
      console.log(err);
    }
      console.log(row);
      activity_id = row.id;

      var splits = req.params.keywords.split(",");
  for (var i = 0; i < splits.length - 1; i++) {
  
    //trim each string since there can be whitespace from the route url
    db.run(`INSERT INTO keyword (word) VALUES ("${splits[i].trim()}")`, function(err) {
      //We can just ignore duplicate keywords
      if (err) {
        console.log(err);
      }

    db.get(`SELECT * FROM keyword WHERE LOWER(word) = "${splits[i].trim().toLowerCase()}"`, function(err, row) {
      if (err) {
        console.log(err);
        console.log(err);
            console.log(splits[i]);
            console.log(i);
      }
      console.log(splits[0]);
        db.run(`INSERT INTO activity_to_keyword VALUES (${activity_id}, ${row.id})`, function(err) {
          if (err) {
            
          }
        });
    });
    })

    };
  });
  
  
  res.send(req.params);

});

module.exports = router;
