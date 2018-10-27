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

router.post('/activities/add/:name/:price/:address/:lat/:lng/:phone?/:email?/:website?/:extra?', function(req, res, next) { 
  res.send(req.params);
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
          ${req.params.name}, ${req.params.price}, ${req.params.address}, 
          ${req.params.lat}, ${req.params.lng}, ${req.params.phone}, ${req.params.email}, ${req.params.website}, ${req.params.extra}
          )`);
  console.log(req.params);
});

router.post('/keywords/add/:keywords', function(req, res, next) { 
  var splits = req.params.keywords.split(",");
  console.log(splits);
  for (var i = 0; i < splits.length; i++) {
    db.run(`INSERT INTO keyword (word) VALUES ("${splits[i].trim()}")`, function(err) {
      //We can just ignore duplicate keywords
      console.log(err);
    })
    };
  
  res.send(req.param);

});

module.exports = router;
