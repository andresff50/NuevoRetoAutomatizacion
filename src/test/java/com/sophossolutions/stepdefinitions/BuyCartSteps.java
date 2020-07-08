package com.sophossolutions.stepdefinitions;

import com.sophossolutions.exceptions.ExceptionError;
import com.sophossolutions.tasks.BuyProduct;
import com.sophossolutions.utilities.MsgError;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

public class BuyCartSteps {
    @Before
    public void prepareStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("{string} select the {word}")
    public void selectThe(String actorName, String article) {
        theActorCalled(actorName).attemptsTo(BuyProduct.buy());
    }

    @When("Add to shopping cart the {word}")
    public void addToShoppingCartThe(String string) {
        System.out.println(string);
    }

    @Then("Check if the product was added to the cart {word}")
    public void checkIfTheProductWasAddedToTheCart(String string) {
        theActorInTheSpotlight().should(seeThat(BuyProduct.name(), equalTo(string))
                .orComplainWith(ExceptionError.class, MsgError.MSG_VALUE_ERROR.getMsg()));
    }
}
