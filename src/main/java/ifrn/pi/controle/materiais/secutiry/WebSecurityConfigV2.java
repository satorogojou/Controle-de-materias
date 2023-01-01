package ifrn.pi.controle.materiais.secutiry;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfigV2 {
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http
		
		.httpBasic()
		.and()
		.authorizeHttpRequests()
		.antMatchers(HttpMethod.GET, "/materiais/**").permitAll()
		.antMatchers(HttpMethod.POST, "/materiais").hasRole("USER")
		.antMatchers(HttpMethod.DELETE, "/materiais/**").hasRole("ADMIN")
		.anyRequest().authenticated()
		.and()
		.csrf().disable();	
		return http.build();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	//private PasswordEncoder BCryptPasswordEncoder() {
		// TODO Auto-generated method stub
//		return null;
	//}
}
