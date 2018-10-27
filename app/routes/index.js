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

module.exports = router;
