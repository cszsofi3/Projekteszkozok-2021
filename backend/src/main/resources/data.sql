INSERT INTO users(name, basket_price) VALUES('George', 0);
INSERT INTO users(name, basket_price) VALUES('Kate', 0);
INSERT INTO users(name, basket_price) VALUES('Lotte', 0);

INSERT INTO FOOD(name, type, price) VALUES('Margherita', 'PIZZA', 1500);
INSERT INTO FOOD(name, type, price) VALUES('Cheese', 'HAMBURGER', 2000);
INSERT INTO FOOD(name, type, price) VALUES('Hawaii', 'PIZZA', 1450);

INSERT INTO BASKET_FOOD(name, price, owner_id) VALUES ('Cheese', 2000, 1);

-- INSERT INTO BASKET(user_id) VALUES(1);

INSERT INTO INGREDIENT(name) VALUES('tomato');
INSERT INTO INGREDIENT(name) VALUES('mushrooms');
INSERT INTO INGREDIENT(name) VALUES('cheddar');

INSERT INTO FOOD_INGREDIENT(food_id, ingredient_id) VALUES(1,1);
INSERT INTO FOOD_INGREDIENT(food_id, ingredient_id) VALUES(1,3);

-- INSERT INTO BASKET_FOOD_EXTRA_INGREDIENT(basket_food_id, extra_ingredient_id) VALUES(1,1);

-- INSERT INTO USER_BASKET(user_id, basket_id) VALUES(1,1);

-- INSERT INTO BASKET_FOOD(basket_id, food_id) VALUES(1,1);