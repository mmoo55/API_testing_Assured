package clientAPI;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class RequestPOST implements IRequest {
    public Response send(RequestInformation request, ResponseInformation responseInformation) {
        System.out.println("POST " + request.getUrl());
        System.out.println("body " + request.getBody());

        Response response = given()
                .auth()
                .preemptive()
                .basic(request.getEmail(), request.getPassword())
                .body(request.getBody().toString())
                .log().all()
        .when()
                .post(request.getUrl());

        response.then()
                .log().all()
                .statusCode(responseInformation.getResponseCode())
                .body("Content", equalTo(request.getBody().getString("Content")));

        return response;
    }
}
