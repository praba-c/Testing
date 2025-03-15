package steps;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pojo.DataPojo;
import utils.ConfigReader;
import utils.RestAssuredUtils;

import java.io.FileNotFoundException;

public class RequestSteps {


    @Given("user calls the endpoint {string}")
    public void userCallsTheEndpoint(String endPoint) {
        RestAssuredUtils.setEndPointWith(endPoint);
    }

    @When("user sets header {string} to {string}")
    public void userSetsHeaderTo(String key, String value) {
        RestAssuredUtils.setHeader(key, value);
    }

    @And("set request body from file {string}")
    public void setRequestBodyFromFile(String filePath) throws FileNotFoundException, JsonProcessingException {
        String body = RestAssuredUtils.getDataFromJsonFile(filePath);
        ObjectMapper mapper = new ObjectMapper();
        DataPojo pojo = null;
        try {
            pojo = mapper.readValue(body, DataPojo.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        ConfigReader.setObject("createDataPojo", pojo);
        RestAssuredUtils.setBody(filePath);
    }

    @Then("user performs post method")
    public void userPerformsPostMethod() {
        RestAssuredUtils.post();
    }


    @Then("user performs put method")
    public void userPerformsPutMethod() {
        RestAssuredUtils.put();
    }

    @Then("user performs get method")
    public void userPerformsGetMethod() {
        RestAssuredUtils.get();
    }
}
