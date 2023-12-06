package com.xm.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "classpath:config/${app}.properties",
        "classpath:config/chromemax.properties"
})
public interface App extends Config {
    @Key("url")
    String url();

    @Key("browser.name")
    String browser();

    @Key("browser.size")
    String browserSize();
}