package root.filter;


import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {
	
	@Bean
	public FilterRegistrationBean ThreadFilter() {
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
		// filterRegistrationBean.setOrder(1);
		filterRegistrationBean.setFilter(new ThreadRequestFilter());
		List<String> urlList = new ArrayList<String>();
		urlList.add("/*");
		filterRegistrationBean.setUrlPatterns(urlList);
		return filterRegistrationBean;
	}
	
}
