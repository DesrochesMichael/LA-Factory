package fr.formation.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {
	
//	@Configuration
//	@Order(1)
//	public static class ApiWebSecurityConfig extends WebSecurityConfigurerAdapter {
//		//CONFIGURATION DES ACCES POUR L'API
//		@Override
//		protected void configure(HttpSecurity http) throws Exception {
//			http.antMatcher("/api/**").authorizeRequests()
//				.antMatchers(HttpMethod.OPTIONS).permitAll()
//				.antMatchers("/**").hasAnyRole("ADMIN", "TECH")
//				.and().httpBasic()
//				.and().csrf().disable();
//		}
//	}
	
	@Configuration
	public static class FormLoginWebSecurityConfig extends WebSecurityConfigurerAdapter {
		//CONFIGURATION DES ACCES
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.authorizeRequests()
				.antMatchers("/**").hasAnyRole("ADMIN", "TECH")
				.and()
				.formLogin()
					.loginPage("/connexion")
					.loginProcessingUrl("/performLogin")
					.defaultSuccessUrl("/menuPrincipal", true)
					.failureUrl("/connexion?error=true")
					.permitAll();
		}
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
