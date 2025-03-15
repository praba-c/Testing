package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.junit.Assert;
import pojo.DataPojo;
import utils.ConfigReader;
import utils.RestAssuredUtils;

public class ResponseSteps {

    @Then("verify status code is {int}")
    public void verifyStatusCodeIs(int statusCode) {
        Assert.assertEquals(statusCode, RestAssuredUtils.getStatusCode());
    }

    @And("verify response body has a field {string} with value {string}")
    public void verifyResponseBodyHasAFieldWithValue(String field, String value) {
        Assert.assertEquals(field, RestAssuredUtils.getResponseFieldValue(value));
    }

    @Then("verify response body has a field {string}")
    public void verifyResponseBodyHasAField(String key) {
        String responseBody = RestAssuredUtils.getResponse().getBody().asString();
        Assert.assertTrue(responseBody.contains(key));
    }


    @Then("store the id {string} in variable {string}")
    public void storeTheIdInVariable(String field, String fieldName) {
        String id = RestAssuredUtils.getResponse().jsonPath().getString(field);
        ConfigReader.setConfigValue(fieldName, id);
    }

    @And("retrieve the created data with id {string}")
    public void retrieveTheCreatedDataWithId(String id) {
        RestAssuredUtils.setEndPointWith(id);
    }

    @And("verify response matches schema {string}")
    public void verifyResponseMatchesSchema(String fileName) {
        Response response = RestAssuredUtils.getResponse();
        response.then().assertThat().
                body(JsonSchemaValidator.matchesJsonSchemaInClasspath("data\\" + fileName));
    }

    @Then("user performs delete method")
    public void userPerformsDeleteMethod() {
        RestAssuredUtils.delete();
    }

    @And("verify response body matches request body of create data")
    public void verifyResponseBodyMatchesRequestBodyOfCreateData() {
        DataPojo requestPojo = (DataPojo) ConfigReader.getObject("createDataPojo");
        DataPojo responsePojo = RestAssuredUtils.getResponse().as(DataPojo.class);
        Assert.assertEquals(requestPojo, responsePojo);
    }
}
