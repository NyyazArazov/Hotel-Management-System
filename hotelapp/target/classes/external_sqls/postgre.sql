CREATE TABLE staff (
  id serial NOT NULL,
  full_name varchar(45) NOT NULL,
  hotel_id int NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT staff_id_UNIQUE UNIQUE  (id),
  CONSTRAINT full_name_UNIQUE UNIQUE  (full_name)
) ;


CREATE TABLE other_staff (
  id serial NOT NULL,
  type varchar(45) NOT NULL,
  CONSTRAINT other_staff_id_UNIQUE UNIQUE  (id),
  CONSTRAINT staff_id FOREIGN KEY (id) REFERENCES staff (id) ON DELETE CASCADE ON UPDATE CASCADE
) ;


CREATE TABLE owner (
  id serial NOT NULL,
  tax_number varchar(45) NOT NULL,
  CONSTRAINT tax_number_UNIQUE UNIQUE  (tax_number),
  CONSTRAINT owner_id_UNIQUE UNIQUE  (id),
  CONSTRAINT owner_id FOREIGN KEY (id) REFERENCES staff (id) ON DELETE CASCADE ON UPDATE CASCADE
) ;


CREATE TABLE hotel (
  id serial NOT NULL,
  type varchar(45) NOT NULL,
  name varchar(45) NOT NULL,
  location varchar(45) NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT hotel_id_UNIQUE UNIQUE  (id)
) ;


CREATE TABLE room_type (
  type varchar(45) NOT NULL,
  CONSTRAINT room_type_UNIQUE UNIQUE  (type)
) ;


CREATE TABLE room (
  id serial NOT NULL,
  hotel_id int NOT NULL,
  room_no varchar(45) NOT NULL,
  type varchar(45) NOT NULL,
  cost double precision NOT NULL,
  is_reserved boolean NOT NULL DEFAULT '0',
  PRIMARY KEY (id),
  CONSTRAINT room_id_UNIQUE UNIQUE  (id),
  CONSTRAINT hotel_id FOREIGN KEY (hotel_id) REFERENCES hotel (id) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT type FOREIGN KEY (type) REFERENCES room_type (type) ON DELETE RESTRICT ON UPDATE CASCADE
);
CREATE INDEX type_idx ON room (type); 


CREATE TABLE customer (
  id serial NOT NULL,
  full_name varchar(45) NOT NULL,
  mail varchar(45) NOT NULL,
  mobile varchar(15) NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT mail_UNIQUE UNIQUE  (mail),
  CONSTRAINT mobile_UNIQUE UNIQUE  (mobile)
) ;


CREATE TABLE reservation (
  id serial NOT NULL,
  customer_id int NOT NULL,
  room_id int NOT NULL,
  reservation_date varchar(15) NOT NULL,
  entry_date varchar(15) NOT NULL,
  staying_days int NOT NULL,
  status varchar(15) NOT NULL DEFAULT 'pending',
  PRIMARY KEY (id),
  CONSTRAINT reservation_id_UNIQUE UNIQUE  (id)
 ,
  CONSTRAINT customer_id FOREIGN KEY (customer_id) REFERENCES customer (id) ON UPDATE CASCADE,
  CONSTRAINT room_id FOREIGN KEY (room_id) REFERENCES room (id) ON UPDATE CASCADE
);

CREATE INDEX customer_id ON reservation (customer_id);
CREATE INDEX room_id ON reservation (room_id);

CREATE TABLE accommodation (
  id serial NOT NULL,
  customer_id int NOT NULL,
  room_id int NOT NULL,
  check_in varchar(15) NOT NULL,
  check_out varchar(15) NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT accommodation_id_UNIQUE UNIQUE  (id)
 ,
  CONSTRAINT cst_id FOREIGN KEY (customer_id) REFERENCES customer (id) ON UPDATE CASCADE,
  CONSTRAINT rm_id FOREIGN KEY (room_id) REFERENCES room (id) ON UPDATE CASCADE
);

CREATE INDEX cst_id ON accommodation (customer_id);
CREATE INDEX rm_id ON accommodation (room_id); 

CREATE TABLE payment (
  id serial NOT NULL,
  amount double precision NOT NULL,
  date varchar(15) NOT NULL,
  accommodation_id int NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT payment_id_UNIQUE UNIQUE  (id)
 ,
  CONSTRAINT accommodation_id FOREIGN KEY (accommodation_id) REFERENCES accommodation (id) ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE INDEX accommodation_id ON payment (accommodation_id); 

ALTER TABLE staff
ADD CONSTRAINT hotel_id FOREIGN KEY (hotel_id) REFERENCES hotel (id) ON DELETE CASCADE ON UPDATE CASCADE;

	





