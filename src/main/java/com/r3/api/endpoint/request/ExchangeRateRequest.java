package com.r3.api.endpoint.request;

import com.r3.api.endpoint.BaseRequest;
import com.r3.api.endpoint.Router;
import com.r3.logger.RestAssuredLogger;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ExchangeRateRequest extends BaseRequest {

    public Response get(String baseCurrencyCode) {
        return
                given()
                        .relaxedHTTPSValidation()
                        .filter(new RestAssuredLogger())
                        .contentType("application/json")
                        .when()
                        .get(Router.getExchangeRateEndPoint(baseCurrencyCode))
                        .then()
                        .extract()
                        .response();
    }
}