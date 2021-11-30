package io.tbc.spring.ws.stepDefinations;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.hamcrest.MatcherAssert;
import org.springframework.boot.test.context.SpringBootTest;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import io.tbc.spring.ws.MediumCalculatorApplication;

@CucumberContextConfiguration
@SpringBootTest(classes = MediumCalculatorApplication.class)
public class CalculatorSteps {

	HttpClient client = HttpClient.newHttpClient();
	HttpResponse<String> httpResponse;
	final String BASE_URI = "http://localhost:9091";
	HttpRequest request;

	@When("Two numbers {int} and {int}")
	public void two_numbers_and(Integer int1, Integer int2) {

		String body = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:cal=\"http://medium.com/types/calculator\">\r\n"
				+ "    <soapenv:Header/>\r\n" + "    <soapenv:Body>\r\n" 
				+ "        <cal:AdditionInput>\r\n"
				+ "            <cal:number1>" + int1 + "</cal:number1>\r\n" 
				+ "            <cal:number2>" + int2 + "</cal:number2>\r\n" 
				+ "        </cal:AdditionInput>\r\n" + "    </soapenv:Body>\r\n"
				+ "</soapenv:Envelope>";

		request = HttpRequest.newBuilder().uri(URI.create(BASE_URI + "/medium/ws")).header("Content-Type", "text/xml")
				.POST(HttpRequest.BodyPublishers.ofString(body)).build();
		try {
			httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());
			System.out.println("Response::==" + httpResponse.body());
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Then("Result of addtion with status code {int}")
	public void result_of_addtion_with_status_code(Integer statusCode) {
		final int currentHttpStatusCode = httpResponse.statusCode();
		MatcherAssert.assertThat("The status code is incorrect", currentHttpStatusCode == statusCode);
	}

	@When("two numbers are {int} and {int}")
	public void two_numbers_are_and(Integer int1, Integer int2) {
		String body = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:cal=\"http://medium.com/types/calculator\">\r\n"
				+ "    <soapenv:Header/>\r\n" 
				+ "    <soapenv:Body>\r\n" 
				+ "        <cal:AdditionInput>\r\n"
				+ "            <cal:number1>" + int1 + "</cal:number1>\r\n" 
				+ "            <cal:number2>" + int2 + "</cal:number2>\r\n" 
				+ "        </cal:AdditionInput>\r\n" + "    </soapenv:Body>\r\n"
				+ "</soapenv:Envelope>";

		request = HttpRequest.newBuilder().uri(URI.create(BASE_URI + "/medium/ws")).header("Content-Type", "text/xml")
				.POST(HttpRequest.BodyPublishers.ofString(body)).build();
		try {
			httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());
			System.out.println("Response::==" + httpResponse.body());
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Then("Result with Status code {int}")
	public void result_with_Status_code(Integer statusCode) {
		final int currentHttpStatusCode = httpResponse.statusCode();
		MatcherAssert.assertThat("The status code is incorrect", currentHttpStatusCode == statusCode);
	}

}
