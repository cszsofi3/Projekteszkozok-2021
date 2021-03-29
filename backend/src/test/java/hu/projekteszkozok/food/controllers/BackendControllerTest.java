package hu.projekteszkozok.food.controllers;

import hu.projekteszkozok.food.FoodOrderApplication;
import hu.projekteszkozok.food.repositories.UserRepository;
import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.junit.Rule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(
        classes = FoodOrderApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
class BackendControllerTest {

    @LocalServerPort
    private int port;

    @BeforeEach
    public void init() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = port;
    }

    @Test
    void home() {
        when()
            .get("/api/home")
            .then()
            .statusCode(HttpStatus.SC_OK)
            .assertThat()
            .body(is(equalTo("welcome home")));
    }

    @Test
    void find_user_by_id(){
        int id = 1;
        given()
            .pathParam("id", id)
            .when()
            .get("/api/user/{id}")
            .then()
            .statusCode(HttpStatus.SC_OK)
            .body(is(not(equalTo(null))));
    }

    @Test
    void fail_for_not_existing_user() throws RuntimeException{
        given()
            .pathParam("id", 3000)
            .when()
            .get("/api/user/{id}")
            .then()
            .statusCode(HttpStatus.SC_INTERNAL_SERVER_ERROR);
        //Assertions.assertThrows(RuntimeException.class, () -> BackendController.getUserById(3000));
    }

    @Test
    void products_no_product_given() {
        when()
            .get("/api/products")
            .then()
            .statusCode(HttpStatus.SC_OK)
            .assertThat()
            .body(is(equalTo("no data given")));
    }

    @Test
    void products_with_product_given() {
        given()
            .param("productList","test")
            .when()
            .get("/api/products")
            .then()
            .statusCode(HttpStatus.SC_OK)
            .assertThat()
            .body(is(equalTo("order data collected")));
    }

    @Test
    void allproducts() {
        when()
            .get("/api/allproducts")
            .then()
            .statusCode(HttpStatus.SC_OK)
            .assertThat()
            .body(is(not(equalTo(null))));
    }

    @Test
    void allusers() {
        when()
            .get("/api/allusers")
            .then()
            .statusCode(HttpStatus.SC_OK)
            .assertThat()
            .body(is(not(equalTo(null))));
    }
}