package com.ncsa.step_definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class SearchRepositoriesSteps {

    private Response response;
    private String url;

    @Given("github rest api endpoint {string}")
    public void github_rest_api_endpoint(String url) {
        this.url = url;
    }

    @When("I search for a repository with details")
    public void i_search_for_a_repository_with_details(Map<String, String> searchDetails) {
        response = given()
                .accept(ContentType.JSON)
                .queryParams(searchDetails)
                .when()
                .get(url).prettyPeek();
    }

    @Then("the following result should be returned")
    public void the_following_result_should_be_returned(Map<String, String> result) {
        String expectedKeyword = result.get("expectedKeyword");
        assertThat(response.prettyPrint(), containsString(expectedKeyword));

        int expectedStatusCode = Integer.parseInt(result.get("expectedStatusCode"));
        assertThat(response.getStatusCode(), equalTo(expectedStatusCode));
    }

}
