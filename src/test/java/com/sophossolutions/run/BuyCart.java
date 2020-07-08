package com.sophossolutions.run;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        glue = { "com.sophossolutions.stepdefinitions" },
        features = {"src/test/resources/com/sophossolutions/features/buy_cart.feature"},
        snippets = SnippetType.CAMELCASE,
        monochrome = true,
        strict = true
)
public class BuyCart {
}
