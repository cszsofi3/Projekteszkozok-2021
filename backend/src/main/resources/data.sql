INSERT INTO user(name) VALUES('George');
INSERT INTO user(name) VALUES('Kate');
INSERT INTO user(name) VALUES('Lotte');

INSERT INTO FOOD(name, type) VALUES('Margherita', 'PIZZA');
INSERT INTO FOOD(name, type) VALUES('Cheese', 'HAMBURGER');
INSERT INTO FOOD(name, type) VALUES('Hawaii', 'PIZZA');

-- INSERT INTO BASKET(user_id) VALUES(1);

INSERT INTO INGREDIENT(name) VALUES('tomato');
INSERT INTO INGREDIENT(name) VALUES('mushrooms');
INSERT INTO INGREDIENT(name) VALUES('cheddar');

INSERT INTO FOOD_INGREDIENT(food_id, ingredient_id) VALUES(1,1);
INSERT INTO FOOD_INGREDIENT(food_id, ingredient_id) VALUES(1,3);

-- INSERT INTO BASKET_FOOD(basket_id, food_id) VALUES(1,1);