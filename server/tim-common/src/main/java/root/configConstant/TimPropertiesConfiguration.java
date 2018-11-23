package root.configConstant;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(TimConfigProperties.class)
public class TimPropertiesConfiguration {

}
