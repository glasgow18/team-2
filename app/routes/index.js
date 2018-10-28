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
  db.get(`SELECT * FROM activity WHERE name = "${req.params.name}"`, function(err, row) {
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

      if (splits[i] == undefined) {
        console.log("HIT UNDEFINED at " + i);
      }
    db.get(`SELECT * FROM keyword WHERE word = "${splits[i].trim()}"`, function(err, row) {
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
