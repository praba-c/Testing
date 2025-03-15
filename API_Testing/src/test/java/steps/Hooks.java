package steps;

import io.cucumber.java.Before;
import io.restassured.RestAssured;
import utils.ConfigReader;

public class Hooks {
    @Before
    public void startUp() {
        RestAssured.baseURI="https://PROJECT_TOKEN.mockapi.io/";
        ConfigReader.initConfig();
    }
}
