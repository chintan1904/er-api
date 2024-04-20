package com.r3.api.endpoint;

import com.r3.config.GlobalVariable;

public class Router {

    private Router() {

    }
    private static final String VERSION = GlobalVariable.CONFIG.apiVersion();
    private static final String RELEASE = GlobalVariable.CONFIG.apiRelease();

    public static String getExchangeRateEndPoint(String currencyCode) {
        return VERSION+RELEASE+"/"+currencyCode;
    }
}
