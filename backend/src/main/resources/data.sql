INSERT INTO user(name) VALUES('George');
INSERT INTO user(name) VALUES('Kate');

INSERT INTO FOOD(name, type) VALUES('Margherita', 'pizza');
INSERT INTO FOOD(name, type) VALUES('Cheese', 'burger');
INSERT INTO FOOD(name, type) VALUES('Hawaii', 'pizza');
INSERT INTO BASKET(USER_ID) VALUES(1);

INSERT INTO INGREDIENT(name, food_id) VALUES('tomato', 1);
INSERT INTO INGREDIENT(name, food_id) VALUES('mushrooms', 1);
INSERT INTO INGREDIENT(name, food_id) VALUES('cheddar', 2);

INSERT INTO BASKET_FOOD(basket_id, food_id) VALUES(1,1);