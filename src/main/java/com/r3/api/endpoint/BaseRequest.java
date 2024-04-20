package com.r3.api.endpoint;

import com.r3.config.GlobalVariable;
import io.restassured.RestAssured;

public class BaseRequest {

    protected BaseRequest() {
        RestAssured.baseURI = GlobalVariable.CONFIG.baseUrl();
    }
}
