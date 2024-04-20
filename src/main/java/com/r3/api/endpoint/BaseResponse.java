package com.r3.api.endpoint;

import io.restassured.response.Response;

public class BaseResponse {

    protected Response response;

    public BaseResponse(Response response) {
        this.response = response;
    }
}
