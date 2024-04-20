package com.r3.api.endpoint.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.r3.api.endpoint.BaseResponse;
import com.r3.api.model.response.GetExchangeRateData;
import io.restassured.response.Response;
import lombok.SneakyThrows;

public class ExchangeRateResponse extends BaseResponse {

    GetExchangeRateData getExchangeRateData;

    public ExchangeRateResponse(Response response) {
        super(response);
        getExchangeRateData = createExchangeRateObjectFromResponse();
    }

    @SneakyThrows
    private GetExchangeRateData createExchangeRateObjectFromResponse() {
        return new ObjectMapper().readValue(response.getBody().asString(), GetExchangeRateData.class);
    }

    public GetExchangeRateData body() {
        return getExchangeRateData;
    }
}
