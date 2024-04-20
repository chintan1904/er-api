package com.r3.config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;

@Config.Sources({
        "classpath:config/config.properties"
})
public interface RunConfig extends Config {

    @Key("api.base.url")
    String baseUrl();

    @Key("api.version")
    String apiVersion();

    @Key("api.release")
    String apiRelease();

    static RunConfig load() {
        return ConfigFactory.create(RunConfig.class);
    }
}
