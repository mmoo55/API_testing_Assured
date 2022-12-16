package clientAPI;

import io.restassured.response.Response;
import org.json.JSONObject;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class RequestDELETE implements IRequest {
    public Response send(RequestInformation request, ResponseInformation responseInformation) {
        System.out.println("DELETE " + request.getUrl());

        JSONObject body = new JSONObject();
        body.put("Content", "BootcampItemUpdated");

        int idItem = 11093072;

        Response response=given()
                .auth()
                .preemptive()
                .basic(request.getEmail(),request.getPassword())
                .body(body.toString())
                .log().all()
                .when()
                .delete(request.getUrl());

        response.then()
                .log().all()
                .statusCode(response.statusCode())
                .body("Deleted",equalTo(true))
                .body("Content",equalTo(request.getBody().getString("Content")));

        return response;
    }

}
