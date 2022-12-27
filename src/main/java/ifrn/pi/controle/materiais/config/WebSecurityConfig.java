package ifrn.pi.controle.materiais.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	@Autowired
	private UserDetailsService userDetailsService;

	@Bean
	public static PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		HttpSecurity security = http.csrf().disable()
				.authorizeHttpRequests(
						(authorize) -> authorize.regexMatchers("/resources/**", "/register/**", "/home", "/default")
								.permitAll().antMatchers("/accounts").hasRole("ADMIN"))
				.formLogin((form) -> form.loginPage("/login").loginProcessingUrl("/login").defaultSuccessUrl("/default")
						.permitAll())
				.logout((logout) -> logout.logoutRequestMatcher(new AntPathRequestMatcher("/logout")).permitAll());

		return http.build();
	}

	@Autowired
	public void ConfigureGlobal(AuthenticationManagerBuilder authorization) throws Exception {
		authorization.userDetailsService(this.userDetailsService).passwordEncoder(WebSecurityConfig.encoder());
	}

}