package ak.patel.piersquere.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
@ConfigurationProperties(prefix = "company")
@Data
public class CompanyInfoConfig {
    private String name;
    private String contactNumber;
    private String address;
}
