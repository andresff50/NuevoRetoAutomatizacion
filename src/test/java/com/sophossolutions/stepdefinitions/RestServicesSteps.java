package com.sophossolutions.stepdefinitions;

import com.sophossolutions.exceptions.ExceptionError;
import com.sophossolutions.tasks.PostMethod;
import com.sophossolutions.utilities.MsgError;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import java.util.Map;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.equalTo;

public class RestServicesSteps {
    @Before
    public void prepareStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("{word} create a user with the post method in {string}")
    public void createAUserWithThePostMethod(String actor, String url) {
        theActorCalled(actor).whoCan(CallAnApi.at(url));
    }

    @When("Candidate provide information the post method with {string}")
    public void provideInformationThePostMethod(String post, Map<String, String> dataTable) {
        theActorInTheSpotlight().attemptsTo(PostMethod.createUser(post, PostMethod.bodyUser(dataTable)));
    }

    @Then("Candidate verify the creation of this user with the get method")
    public void verifyTheCreationOfThisUserWithTheGetMethod() {
        theActorInTheSpotlight()
                .should(seeThatResponse(response -> response.body("result.first_name", equalTo("Cloud")))
                        .orComplainWith(ExceptionError.class, MsgError.MSG_VALUE_ERROR.getMsg()));
    }
}
