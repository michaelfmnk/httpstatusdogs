package dev.fomenko.httpstatusdogs;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = FakeControllerApplication.class)
public class HttpStatusDogsApplicationTests {

    @LocalServerPort
    private int port;

    @BeforeEach
    public void setup() {
        RestAssured.port = port;
    }

    @Test
    public void shouldLoadContext() {
        Assertions.assertTrue(true);
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
