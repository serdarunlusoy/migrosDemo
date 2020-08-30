CREATE TABLE STORE(
store_id INT NOT NULL AUTO_INCREMENT,
NAME VARCHAR(100) NOT NULL,
LATITUDE DOUBLE,
LONGITUDE DOUBLE,
PRIMARY KEY(store_id)
);


INSERT INTO store(NAME,latitude,longitude) VALUES('Atasehir MMM Migros',40.9923307,29.1244229);
INSERT INTO store(NAME,latitude,longitude) VALUES('Novada MMM Migros',40.986106,29.1161293);
INSERT INTO store(NAME,latitude,longitude) VALUES('Beylikdüzü 5M Migros',41.0066851,28.6552262);
INSERT INTO store(NAME,latitude,longitude) VALUES('Ortaköy MMM Migros',41.055783,29.0210292);
INSERT INTO store(NAME,latitude,longitude) VALUES('Caddebostan MMM Migros',40.9632463,29.0630908);

CREATE TABLE COURIER_LOCATION(
courier_location_id INT NOT NULL AUTO_INCREMENT,
courier_id INT NOT NULL,
store_id INT NOT NULL,
cdate long NOT NULL,
latitude DOUBLE NOT NULL,
longitude DOUBLE NOT NULL,
PRIMARY KEY(courier_location_id),
FOREIGN KEY(store_id) REFERENCES Store(store_id));