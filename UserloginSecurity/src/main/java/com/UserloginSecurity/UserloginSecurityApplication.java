package com.UserloginSecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserloginSecurityApplication {//implements CommandLineRunner{
	
//	@Autowired
//	private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(UserloginSecurityApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		
//		System.out.println(this.passwordEncoder.encode("123"));
//	}

	
}
