package utilis;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class APIBase extends SystemProperties {
    public static Response GET(String EndPoint) {
        RestAssured.baseURI = getBaseAPIsURL();
        Response response = given()
                .when()
                .get(EndPoint)
                .then()
                .extract().response();
        System.out.printf("Time is %s for %s EndPoint %s%n", response.getTime(), "GET", EndPoint);
//        logger.info(String.format("Time is %s for %s EndPoint %s", response.getTime(), "GET", EndPoint));
        return response;
    }
}
