package com.akushylun.telephonebook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.akushylun.telephonebook.repository.PersonRepository;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    PersonRepository repository;
    
    Environment env;
    
    @Autowired
    @Qualifier("${personRepository}")
    public void setRepository(PersonRepository repository) {
	this.repository = repository;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
	http.authorizeRequests().antMatchers("/registration").permitAll().anyRequest().authenticated().and().formLogin()
		.loginPage("/login").permitAll().and().logout().logoutUrl("/logout").permitAll().and().rememberMe()
		.tokenValiditySeconds(1209600).and().csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	UserService service = new UserService();
	service.setRepository(repository);
	auth.userDetailsService(service);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
	web.ignoring().antMatchers("/js/**").antMatchers("/css/**").antMatchers("/favicon.ico");
    }

}
