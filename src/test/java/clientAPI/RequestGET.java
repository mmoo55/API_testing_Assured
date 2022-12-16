package clientAPI;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RequestGET implements IRequest {

    public Response send(RequestInformation request, ResponseInformation responseInformation){
        System.out.println("GET " + request.getUrl());

        Response response = given()
                .auth()
                .preemptive()
                .basic(request.getEmail(), request.getPassword())
                .log().all()
                .when()
                .get(request.getUrl());

        response.then()
                .log().all()
                .statusCode(responseInformation.getResponseCode());

        return response;
    }

}
