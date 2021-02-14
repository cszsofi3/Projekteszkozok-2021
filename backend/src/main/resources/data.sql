INSERT INTO user(name) VALUES('George');
INSERT INTO user(name) VALUES('Kate');

INSERT INTO FOOD(name, type) VALUES('Margherita', 'pizza');
INSERT INTO FOOD(name, type) VALUES('Cheese', 'burger');

INSERT INTO BASKET(USER_ID) VALUES(1);
INSERT INTO BASKET(USER_ID) VALUES(2);

INSERT INTO INGREDIENT(name, food_id) VALUES('tomato', 1);
INSERT INTO INGREDIENT(name, food_id) VALUES('mushrooms', 1);
INSERT INTO INGREDIENT(name, food_id) VALUES('cheddar', 2);

INSERT INTO BASKET_FOOD(BASKET_ID, FOOD_ID) VALUES(1,1);
INSERT INTO BASKET_FOOD(BASKET_ID, FOOD_ID) VALUES(2,2);
