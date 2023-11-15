package project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import project.config.JwtFilter;



@SpringBootApplication
public class CmsApplication {
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Bean
	public FilterRegistrationBean jwtFilter()
	{
		final FilterRegistrationBean registrationBean=new FilterRegistrationBean();
			registrationBean.setFilter(new JwtFilter());
		    registrationBean.addUrlPatterns("/api/*");
			return registrationBean;
	
	}

	public static void main(String[] args) {
		SpringApplication.run(CmsApplication.class, args);
	}

}
