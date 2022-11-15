create database sqlInjection;

CREATE TABLE users_ (
                        id int,
                        username varchar(255),
                        password varchar(255),
                        firstname varchar(255),
                        lastname varchar(255)
);


INSERT INTO users_ VALUES (1,'test@test.it','XXXX','Mario','Rossi');
INSERT INTO users_ VALUES (2,'tuccia@test.it','XXXX','Giac','Tuccia');
INSERT INTO users_ VALUES (3,'abc@test.it','XXXX','Giuseppe','Gallo');
