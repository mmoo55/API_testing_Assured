package com.cucumber;

import clientAPI.FactoryRequest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import static org.hamcrest.Matchers.equalTo;

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


    @And("I will expect the {string} is equal to my email")
    public void iWillExpectTheUserEmailIsEqualToMyEmail(String key) {
        world.response.then()
                .body(key,equalTo(world.email));
    }
}
