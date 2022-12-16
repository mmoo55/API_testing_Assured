package clientAPI;

import io.restassured.response.Response;

public interface IRequest {

    public Response send(RequestInformation request, ResponseInformation responseInformation);
}
