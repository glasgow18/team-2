CREATE TABLE activity (
	id integer PRIMARY KEY,
	name text		NOT NULL,
	price float		NOT NULL,
	address text	NOT NULL,
	lat float		NOT NULL,
	lng float		NOT NULL,
	contact_phone_number text,
	contact_email text,
	contact_website text,
	extra_info text
);

CREATE TABLE review (
	id integer PRIMARY KEY,
	activity_id int	NOT NULL REFERENCES activity_id(id),
	content text	NOT NULL
);

CREATE TABLE keyword (
	id integer PRIMARY KEY,
	word text		NOT NULL UNIQUE
);

CREATE TABLE activity_to_keyword (
	activity_id int	NOT NULL REFERENCES activity_id(id),
	keyword_id  int	NOT NULL	REFERENCES keyword_id(id),
	PRIMARY KEY (activity_id, keyword_id)
);
