package com.moeller.decenc.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by Bernd on 05.11.2017.
 *
 * Package com.moeller.decenc.security
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{

  @Override
  public void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.inMemoryAuthentication().withUser("bmtrash").password("4711").roles("ADMIN");
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.httpBasic().and().authorizeRequests().antMatchers("/**").hasRole("ADMIN");
  }
}
