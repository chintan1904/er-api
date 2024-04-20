package com.r3.logger;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RestAssuredLogger implements Filter {

    public static final Logger log = LogManager.getLogger(RestAssuredLogger.class);

    @Override
    public Response filter(FilterableRequestSpecification filterableRequestSpecification, FilterableResponseSpecification filterableResponseSpecification, FilterContext filterContext) {
        Response response = filterContext.next(filterableRequestSpecification, filterableResponseSpecification);

        log.info(("%s %s \n" +
                " Request Body =>%s\n" +
                " Response Status => %d %s \n" +
                " Response Body => %s").formatted(filterableRequestSpecification.getMethod(),
                filterableRequestSpecification.getURI(),
                filterableRequestSpecification.getBody(),
                response.getStatusCode(),
                response.getStatusLine(),
                response.getBody().prettyPrint()));
        return response;
    }
}
