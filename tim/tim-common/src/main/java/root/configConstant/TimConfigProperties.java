package root.configConstant;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@ConfigurationProperties(prefix="tim.config")
@Component
public class TimConfigProperties {

	private LoginProperties login;
	
	private UserDefaultProperties userDefault;
	
	private QiNiuProperties qiniu;
	
}
