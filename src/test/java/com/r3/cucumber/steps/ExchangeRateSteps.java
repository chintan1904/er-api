package com.r3.cucumber.steps;

import com.r3.api.endpoint.request.ExchangeRateRequest;
import com.r3.api.endpoint.response.ExchangeRateResponse;
import com.r3.enums.CurrencyCode;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.testng.Assert;

public class ExchangeRateSteps {

    Response response;

    @Then("I receive api response with status code as {string}")
    public void iReceiveApiResponseWithStatusCodeAs(String expectedStatusCodeString) {
        int expectedStatusCode = Integer.parseInt(expectedStatusCodeString);
        Assert.assertEquals(response.getStatusCode(), expectedStatusCode);
    }

    @And("I verify result value in response body as {string}")
    public void iVerifyResultValueInResponseBodyAs(String expectedResultString) {
        ExchangeRateResponse exchangeRateResponse = new ExchangeRateResponse(response);
        Assert.assertEquals(exchangeRateResponse.body().getResult(), expectedResultString);
    }

    @And("I verify that {string} are returned by endpoint")
    public void iVerifyThatAreReturnedByEndpoint(String expectedNumberOfCurrencyCodesString) {
        int expectedNumberOfCurrencyCodes = Integer.parseInt(expectedNumberOfCurrencyCodesString);
        ExchangeRateResponse exchangeRateResponse = new ExchangeRateResponse(response);
        Assert.assertEquals(exchangeRateResponse.body().getRates().size(), expectedNumberOfCurrencyCodes);
    }

    @And("I verify exchange rate for currency {string} is between {string} and {string}")
    public void iVerifyExchangeRateForCurrencyIsBetweenAnd(String expectedCurrencyCodeString, String expectedLowerBoundaryString, String expectedUpperBoundaryString) {
        CurrencyCode expectedCurrencyCode =  CurrencyCode.valueOf(expectedCurrencyCodeString);
        double expectedLowerBoundary = Double.parseDouble(expectedLowerBoundaryString);
        double expectedUpperBoundary = Double.parseDouble(expectedUpperBoundaryString);
        ExchangeRateResponse exchangeRateResponse = new ExchangeRateResponse(response);
        Assert.assertTrue(exchangeRateResponse.body().getRates().get(expectedCurrencyCode) >= expectedLowerBoundary);
        Assert.assertTrue(exchangeRateResponse.body().getRates().get(expectedCurrencyCode) <= expectedUpperBoundary);
    }

    @Given("I call GET exchange rate api endpoint for {string}")
    public void iCallGETExchangeRateApiEndpointFor(String baseCurrencyCode) {
        response = new ExchangeRateRequest().get(baseCurrencyCode);
    }
}
