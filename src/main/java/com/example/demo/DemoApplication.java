package com.example.demo;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.data.User;
import com.example.demo.repository.UserRepository;

@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class DemoApplication //implements CommandLineRunner
{
	
	/*@Autowired
	UserRepository userRepository;
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder; 
	 @Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		HashSet<String> p=new HashSet<String>();
		p.add("Normal");
		User user=new User("999","Abhishek Rai",bCryptPasswordEncoder.encode("999"),"","ROLE_ADMIN");
		userRepository.save(user);
		
	}*/
	/*
	 * http.authorizeHttpRequests()
		//.antMatchers("/welcome").permitAll()
		.anyRequest().authenticated();
	 */

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

  

}
