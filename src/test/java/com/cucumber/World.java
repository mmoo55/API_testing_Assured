package com.cucumber;

import clientAPI.RequestInformation;
import clientAPI.RequestPOST;
import clientAPI.ResponseInformation;
import io.restassured.response.Response;
import org.json.JSONObject;
import util.GetProperties;

public class World {
    String url = GetProperties.getInstance().getUrl();
    String email = GetProperties.getInstance().getEmail();
    String password = GetProperties.getInstance().getPwd();

    JSONObject body = new JSONObject();

    int code = 200;

    Response response;

    RequestInformation requestInformation = new RequestInformation();
    ResponseInformation responseInformation = new ResponseInformation();
    RequestPOST requestPOST = new RequestPOST();

    public String replaceVariables(String url, String add) {
        String value = url+add;
        return value;
    }

}