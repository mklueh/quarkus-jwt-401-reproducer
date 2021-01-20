package com.example;

import io.quarkus.test.junit.QuarkusTest;
import io.smallrye.jwt.build.Jwt;
import org.junit.jupiter.api.Test;

import java.security.PrivateKey;
import java.util.HashSet;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class ExampleResourceTest {

    @Test
    public void testHelloEndpoint() {
        String token = getToken();
        given()
                .when()
                .auth().oauth2(token)
                .get("/hello")
                .then()
                .statusCode(200)
                .body(is("Hello RESTEasy"));
    }

    private String getToken() {
        return Jwt
                .issuer("some-id")
                .groups("user")
                .expiresAt(System.currentTimeMillis() + 1000000000L)
                .sign();
    }

}