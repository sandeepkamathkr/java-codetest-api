package com.sandeepkamathkr.webservice.config.swagger.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
/**
 * Swagger properties for custom config
 */

@ConfigurationProperties(prefix = "webservice.swagger",ignoreUnknownFields = false)
public class SwaggerProperties {

    private String defaultIncludePattern = "/.*";

    private String authorizationName = "jwt";

    public String getDefaultIncludePattern() {
        return defaultIncludePattern;
    }

    public void setDefaultIncludePattern(String defaultIncludePattern) {
        this.defaultIncludePattern = defaultIncludePattern;
    }

    public String getAuthorizationName() {
        return authorizationName;
    }

    public void setAuthorizationName(String authorizationName) {
        this.authorizationName = authorizationName;
    }
}
