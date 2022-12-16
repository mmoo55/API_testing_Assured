package com.cucumber;

import clientAPI.FactoryRequest;
import clientAPI.RequestInformation;
import clientAPI.ResponseInformation;
//import com.google.gson.*;
//import cucumber.api.java.en.And;
//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Then;
//import cucumber.api.java.en.When;
//import helpers.JsonHelper;
import io.cucumber.core.backend.Container;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.JSONException;
//import org.junit.Assert;
import org.junit.jupiter.api.Assertions;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.equalTo;

//import static junit.framework.TestCase.assertTrue;

public class MyStepdefs {

    private World world;

    public MyStepdefs(World world) {
        this.world = world;
    }


    @Given("^I had authentication to todo\\.ly$")
    public void iHaveAuthenticationToTodoLy() {

    }

    @When("I send {string} request {string}")
    public void iSendRequest(String method, String url) {

        world.requestInformation.setUrl(world.replaceVariables(world.url, url));
        world.requestInformation.setEmail(world.email);
        world.requestInformation.setPassword(world.password);

        world.responseInformation.setResponseCode(world.code);
        world.response = FactoryRequest.make(method.toLowerCase()).send(world.requestInformation, world.responseInformation);
    }

    @Then("I will expect the response code {int}")
    public void iExpectedTheResponseCode(int expectResponseCode) {
        System.out.println("THE STATUS IS: " + world.response.getStatusCode());
        Assertions.assertEquals(expectResponseCode, world.response.getStatusCode());
    }

    @And("I will expect the item was deleted is equal {string}")
    public void iWillExpectTheItemWasDeletedIsEqualTrue(String status) {
        world.response.then()
                .body("Deleted",equalTo(Boolean.valueOf(status)));
    }

    @And("I will expect the {string} is equal to {int}")
    public void iWillExpectTheIdIsEqualTo(String key,int id) {
        world.response.then()
                .body(key,equalTo(id));
    }

    @When("I send {string} request {string} and the name of item is {string}")
    public void iSendPOSTRequestItemsJsonAndTheNameOfItemIsBootcampItem(String method, String url, String item) {

        world.requestInformation.setUrl(world.replaceVariables(world.url, url));
        world.requestInformation.setEmail(world.email);
        world.requestInformation.setPassword(world.password);
        world.requestInformation.setBody(world.body.put("Content", item));

        world.responseInformation.setResponseCode(world.code);
        world.response = FactoryRequest.make(method.toLowerCase()).send(world.requestInformation, world.responseInformation);
    }


}
