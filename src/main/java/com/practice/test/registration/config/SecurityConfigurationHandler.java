package com.practice.test.registration.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfigurationHandler extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http
		     .csrf()
		     .disable()
		     .authorizeRequests()
		     .anyRequest()
		     .authenticated()
		     .and()
		     .httpBasic()
		     .and()
		     .logout().permitAll()
		     ;
	}

	@Autowired	
	public void configuerGlobal(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.inMemoryAuthentication()
		.withUser("admin").password("{noop}pa$$word").roles("ADMIN")
		.and()
		.withUser("user").password("{noop}pa$$word").roles("USER")
		;
		
	}
	
}
