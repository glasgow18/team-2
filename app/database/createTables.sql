CREATE TABLE activity (
	id int			PRIMARY_KEY AUTO_INCREMENT,
	name text		NOT_NULL,
	price float		NOT_NULL,
	address text	NOT_NULL,
	gmap_link text  NOT_NULL,
	extra_info text
);

CREATE TABLE review (
	id int			PRIMARY_KEY AUTO_INCREMENT,
	activity_id int	NOT_NULL REFERENCES activity_id(id),
	content text	NOT_NULL
);

CREATE TABLE keyword (
	id int			PRIMARY_KEY AUTO_INCREMENT,
	word text		NOT_NULL
);

CREATE TABLE activity_to_keyword (
	activity_id int	NOT_NULL REFERENCES activity_id(id),
	keyword_id  int	NOT_NULL	REFERENCES keyword_id(id),
	PRIMARY KEY (activity_id, keyword_id)
);
