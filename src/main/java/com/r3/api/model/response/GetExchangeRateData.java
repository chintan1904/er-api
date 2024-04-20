package com.r3.api.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.r3.enums.CurrencyCode;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.util.Map;

@Data
@Builder
@Jacksonized
public class GetExchangeRateData {

    @JsonProperty("result")
    private String result;
    @JsonProperty("provider")
    private String provider;
    @JsonProperty("documentation")
    private String documentation;
    @JsonProperty("terms_of_use")
    private String termsOfUse;
    @JsonProperty("time_last_update_unix")
    private long timeLastUpdateUnix;
    @JsonProperty("time_last_update_utc")
    private String timeLastUpdateUtc;
    @JsonProperty("time_next_update_unix")
    private long timeNextUpdateUnix;
    @JsonProperty("time_next_update_utc")
    private String timeNextUpdateUtc;
    @JsonProperty("time_eol_unix")
    private long timeEolUnix;
    @JsonProperty("base_code")
    private CurrencyCode baseCode;
    @JsonProperty("rates")
    private Map<CurrencyCode, Double> rates;
}