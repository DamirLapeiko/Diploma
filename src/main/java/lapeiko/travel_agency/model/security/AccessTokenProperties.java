package lapeiko.travel_agency.model.security;

import lombok.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.time.Duration;

@ConfigurationProperties(prefix = "travel-agency.access-token")
@Value
public class AccessTokenProperties {
    String secret;
    Duration timeToLive;
}
