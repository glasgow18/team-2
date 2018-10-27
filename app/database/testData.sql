INSERT INTO activity (
	name,
	price,
	address,
	lat,
	lng,
	extra_info
) VALUES (
	"JPMorgan Chase & Co",
	0,
	"45 Waterloo St, Glasgow G2 6HS",
	55.8601998,
	-4.2618775,
	"Big smashing bank"	
);

INSERT INTO keyword VALUES (null, "rocks");
INSERT INTO keyword VALUES (null, "sound");
INSERT INTO keyword VALUES (null, "sand");
INSERT INTO keyword VALUES (null, "ice");
INSERT INTO keyword VALUES (null, "snow");
INSERT INTO keyword VALUES (null, "mud");

INSERT INTO activity_to_keyword VALUES (1, 1);
INSERT INTO activity_to_keyword VALUES (1, 2);
INSERT INTO activity_to_keyword VALUES (1, 5);
