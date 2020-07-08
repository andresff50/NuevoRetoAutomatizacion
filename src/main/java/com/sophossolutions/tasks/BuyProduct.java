package com.sophossolutions.tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.sophossolutions.userinterfaces.Page;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.questions.Text;

public class BuyProduct implements Task, Question<String>{

	private Page a;
	
	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.wasAbleTo(Open.browserOn(a));
		actor.attemptsTo(Click.on(Page.A));
		actor.attemptsTo(Click.on(Page.C));
		actor.attemptsTo(Enter.theValue("Ariel").into(Page.D), Hit.the(Keys.ENTER).into(Page.D));
		actor.attemptsTo(Click.on(Page.E));
	}

	public static BuyProduct buy() {
		return Tasks.instrumented(BuyProduct.class);
	}

	@Override
	public String answeredBy(Actor actor) {
		return Text.of(By.xpath("//*[@id='minicart-navigation']/div[2]/div[2]/div[1]/div[1]/div[1]")).viewedBy(actor).asString();
	}
	
	public static BuyProduct name() {
		return new BuyProduct();
	}
}
