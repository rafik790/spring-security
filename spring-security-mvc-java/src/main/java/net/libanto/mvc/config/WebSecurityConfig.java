package net.libanto.mvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebSecurity
@ComponentScan({ "net.libanto.mvc.controller" })  
public class WebSecurityConfig implements WebMvcConfigurer {
	@Bean
	public UserDetailsService userDetailsService() throws Exception {
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		manager.createUser(
				User.withDefaultPasswordEncoder().username("javatpoint").password("java123").roles("ADMIN").build());
		return manager;
	}
	
	protected void configure(HttpSecurity http) throws Exception {

		 http                              
	        .authorizeRequests()  
	            .anyRequest().hasRole("ADMIN")  
	            .and().formLogin().and()  
	        .httpBasic()  
	        .and()  
	        .logout()  
	        .logoutUrl("/j_spring_security_logout")  
	        .logoutSuccessUrl("/") ;  
	}
}
