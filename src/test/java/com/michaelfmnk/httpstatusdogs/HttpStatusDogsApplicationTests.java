package com.michaelfmnk.httpstatusdogs;

import io.restassured.RestAssured;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = FakeControllerApplication.class)
public class HttpStatusDogsApplicationTests {

    @LocalServerPort
    private int port;

    @Before
    public void setup() {
        RestAssured.port = port;
    }

    @Test
    public void shouldLoadContext() {
        Assert.assertTrue(true);
    }

    @Test
    public void shouldSetRightHeaderForOk() {
        RestAssured
                .given()
                .when()
                .get("/200")
                .then()
                .statusCode(200)
                .header("StatusDog", "https://httpstatusdogs.com/img/200.jpg");
    }

    @Test
    public void shouldSetRightHeaderForNotFound() {
        RestAssured
                .given()
                .when()
                .get("/404")
                .then()
                .statusCode(404)
                .header("StatusDog", "https://httpstatusdogs.com/img/404.jpg");
    }

}
