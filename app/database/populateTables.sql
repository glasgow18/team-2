INSERT INTO activity (name, price, address, lat, lng, contact_phone_number, contact_email)
VALUES("Multi purpose church hall", 0, "23 Broomhill Rd, Penicuik EH26 9EE", 
		55.824911, -3.227965, "01968 768954", "phillg13@toucansurf.com");

INSERT INTO activity (name, price, address, lat, lng, contact_phone_number)
VALUES("Outdoor Environmental Day Service", 0, "55 Torphin Rd, Edinburgh EH13 0PQ", 
		55.899668, -3.272208,"0131 441 2055");
		
INSERT INTO activity (name, price, address, lat, lng, contact_phone_number)
VALUES("Long fence to make sound on at Vogrie", 0, "Edinburgh, city of Edinburgh EH23 4NU", 
		55.857549, -2.992875, "01875 821716");

INSERT INTO activity (name, price, address, lat, lng, contact_website)
VALUES("Wheelchair friendly Cycle Path with 500m long tunnel", 0, "Innocent Railway, Edinburgh EH16 5BQ", 
		55.941456, -3.172207, "https://www.sustrans.org.uk/ncn/map/route/edinburgh-to-musselburgh");

INSERT INTO activity (name, price, address, lat, lng, contact_website)
VALUES("135m Bendy Tunnel with darkness", 0, "Edinburgh EH13 0JX", 
		55.907921, -3.260044, "http://www.waterofleith.org.uk/walkway/");

INSERT INTO activity (name, price, address, lat, lng)
VALUES("Machines and Steam Trains", 3.50, "Lady Victoria Colliery, Newtongrange, Dalkeith EH22 4QN", 
		55.862409, -3.066688);

INSERT INTO activity (name, price, address, lat, lng, contact_phone_number,contact_email)
VALUES("Aquarium", 0, "Dobbies Garden Centre, Melville Nurseries, Lasswade EH18 1AZ", 
		55.895718, -3.098972,"0131 663 1941","https://www.dobbies.com/find-a-garden-centre/edinburgh/");

INSERT INTO activity (name, price, address, lat, lng, contact_phone_number,contact_email)
VALUES("Natural tree dens", 0, "Edinburgh, city of Edinburgh EH23 4NU", 
		55.858177, -2.992503,"01875 821716","https://www.midlothian.gov.uk/info/200283/parks/236/vogrie_country_park");

INSERT INTO activity (name, price, address, lat, lng, contact_phone_number,contact_email)
VALUES("Natural tree dens", 0, "Edinburgh, city of Edinburgh EH23 4NU", 
		55.858177, -2.992503,"01875 821716","https://www.midlothian.gov.uk/info/200283/parks/236/vogrie_country_park");



INSERT INTO review (activity_id, content)
VALUES(1,"Very Good for my son since it is a nice, quiet, calming place");

INSERT INTO review (activity_id, content)
VALUES(1,"My caree loves this place due to how peaceful it is during the day");

INSERT INTO review (activity_id, content)
VALUES(1,"Enjoyed every second!");

INSERT INTO review (activity_id, content)
VALUES(2,"My son has just started working at Tiphereth having left school in June this year. At Tiphereth he is valued and is treated with dignity and respect. He is able to ‘go to work’ and contribute in a positive way.");

INSERT INTO review (activity_id, content)
VALUES(4,"This is a fantastic place to take wheelchaits as it's entirely tarmac.");

INSERT INTO review (activity_id, content)
VALUES(4,"The tunnel is really long and great for making sound in, we played an echo game which resulted in loads of laughter. ");

INSERT INTO review (activity_id, content)
VALUES(5,"The water of Leith is such a magical place for so many reasons. The walk has wind, sound, things to collect, splashing stones in the water, pooh stick games and the tunnel of course which can be used as a game in itself.");

INSERT INTO review (activity_id, content)
VALUES(7,"This museum is such a good find for people who like large machinery or trains. There's a model steam train and plenty of metallic and wood surfaces to feel.");

INSERT INTO review (activity_id, content)
VALUES(8,"You are very welcome to explore Vogrie's dens which are natural tree spaces rather than man made dens, In summer they are cobered in leaves and a natural shelter from the rain.");

INSERT INTO keyword(word)
VALUES("Sound");
INSERT INTO keyword(word)
VALUES("Play");
INSERT INTO keyword(word)
VALUES("Fun");
INSERT INTO keyword(word)
VALUES("Outdoors");
INSERT INTO keyword(word)
VALUES("Vibration");
INSERT INTO keyword(word)
VALUES("Forest");
INSERT INTO keyword(word)
VALUES("Quiet");
INSERT INTO keyword(word)
VALUES("Safe");
INSERT INTO keyword(word)
VALUES("darkness");
INSERT INTO keyword(word)
VALUES("Nature");

INSERT INTO activity_to_keyword(activity_id, keyword_id)
VALUES(1,1);

INSERT INTO activity_to_keyword(activity_id, keyword_id)
VALUES(1,7);

INSERT INTO activity_to_keyword(activity_id, keyword_id)
VALUES(1,8);

INSERT INTO activity_to_keyword(activity_id, keyword_id)
VALUES(2,10);

INSERT INTO activity_to_keyword(activity_id, keyword_id)
VALUES(3,1);

INSERT INTO activity_to_keyword(activity_id, keyword_id)
VALUES(3,2);

INSERT INTO activity_to_keyword(activity_id, keyword_id)
VALUES(3,3);

INSERT INTO activity_to_keyword(activity_id, keyword_id)
VALUES(3,4);

INSERT INTO activity_to_keyword(activity_id, keyword_id)
VALUES(3,5);

INSERT INTO activity_to_keyword(activity_id, keyword_id)
VALUES(3,6);

INSERT INTO activity_to_keyword(activity_id, keyword_id)
VALUES(3,10);

INSERT INTO activity_to_keyword(activity_id, keyword_id)
VALUES(4,1);

INSERT INTO activity_to_keyword(activity_id, keyword_id)
VALUES(4,2);

INSERT INTO activity_to_keyword(activity_id, keyword_id)
VALUES(4,3);

INSERT INTO activity_to_keyword(activity_id, keyword_id)
VALUES(4,4);

INSERT INTO activity_to_keyword(activity_id, keyword_id)
VALUES(4,5);

INSERT INTO activity_to_keyword(activity_id, keyword_id)
VALUES(4,6);

INSERT INTO activity_to_keyword(activity_id, keyword_id)
VALUES(4,9);

INSERT INTO activity_to_keyword(activity_id, keyword_id)
VALUES(4,10);
