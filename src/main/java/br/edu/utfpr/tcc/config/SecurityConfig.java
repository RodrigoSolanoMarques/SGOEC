package br.edu.utfpr.tcc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import br.edu.utfpr.tcc.repository.ContaUsuarioRepository;
import br.edu.utfpr.tcc.services.ContaUsuarioService;

@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private ContaUsuarioRepository contaUsuarioRepository;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
			.exceptionHandling().accessDeniedPage("/erro403")
			.and()
			.authorizeRequests()
			.antMatchers("/empresa/**").hasRole("ADMIN")
			.antMatchers("/cidade/**").permitAll()
			.antMatchers("/registrar").permitAll()
				//.antMatchers("/**").hasRole("ADMIN");
			.anyRequest().authenticated()
			.and().formLogin()
			.loginPage("/login")
			.defaultSuccessUrl("/empresa/index")
			.failureUrl("/login?error=bad_credentials").permitAll()
			.and()
	        .logout().logoutSuccessUrl("/login");
	}

	@Bean
	public UserDetailsService userDetailsService(){
		return new ContaUsuarioService(contaUsuarioRepository);
	}

	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder(10);
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService())
				.passwordEncoder(passwordEncoder());
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/webjars/**");
		web.ignoring().antMatchers("/static/**");
	}
}
