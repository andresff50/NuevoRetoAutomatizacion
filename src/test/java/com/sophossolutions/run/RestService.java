package com.sophossolutions.run;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        glue = { "com.sophossolutions.stepdefinitions" },
		features = { "src/test/resources/com/sophossolutions/features/REST_Service.feature" },
        snippets = SnippetType.CAMELCASE,
        monochrome = true,
        strict = true
)
public class RestService {

}
