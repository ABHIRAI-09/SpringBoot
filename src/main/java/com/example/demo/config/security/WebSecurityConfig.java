package com.example.demo.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.SecurityFilterChain;

import com.example.demo.service.CustomUserDetailService;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	
	@Autowired
	CustomUserDetailService customUserDetailService;
	
	@Bean
	 public  SecurityFilterChain  bean1(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeHttpRequests().antMatchers("/welcome","/").permitAll().anyRequest().authenticated();
		http.httpBasic();
		
		http.authenticationProvider(bean2());
		DefaultSecurityFilterChain s=http.build();
		return s;
	 }
	@Bean
	 public DaoAuthenticationProvider bean2() {
		 DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
		 provider.setUserDetailsService(customUserDetailService);
		 provider.setPasswordEncoder(bean3());
		 return provider;
	 }
	@Bean
	 public BCryptPasswordEncoder bean3() {
		 return new BCryptPasswordEncoder();
	 }
	
	
	
	
	

}
