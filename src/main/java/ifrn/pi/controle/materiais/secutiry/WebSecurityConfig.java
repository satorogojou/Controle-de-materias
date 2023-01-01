package ifrn.pi.controle.materiais.secutiry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

//@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	UserDetailsServiceImpl userDetailsService;
	
	public WebSecurityConfig(UserDetailsServiceImpl userDetailsService) {
		this.userDetailsService = userDetailsService;
	}
	
	@Override
	protected void configure (HttpSecurity http) throws Exception{
		
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
		
	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.inMemoryAuthentication()
				.withUser("Luiz Manoel")
				.password(passwordEncoder().encode("ml1240mj"))
				.roles("ADMIN");
	}



	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		HttpSecurity security = http.csrf().disable()
				.authorizeHttpRequests(
						(authorize) -> authorize.regexMatchers("/", "/", "/home", "/default")
								.permitAll().antMatchers("/accounts").hasRole("ADMIN"))
				.formLogin((form) -> form.loginPage("/login").loginProcessingUrl("/login").defaultSuccessUrl("/default")
						.permitAll())
				.logout((logout) -> logout.logoutRequestMatcher(new AntPathRequestMatcher("/logout")).permitAll());
				
		return http.build();
	}

	//@Autowired
	//public void ConfigureGlobal(AuthenticationManagerBuilder authorization) throws Exception {
		//authorization.userDetailsService(this.userDetailsService).passwordEncoder(WebSecurityConfig.passwordEncoder());
	//}

}