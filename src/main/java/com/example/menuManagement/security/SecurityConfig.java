package com.example.menuManagement.security;

import com.example.menuManagement.jwt.JwtTokenVerifierFilter;
import com.example.menuManagement.jwt.JwtUserNamePasswordAuthFilter;
import com.example.menuManagement.service.authService.DomainUserDetailsService;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;

public class SecurityConfig extends WebSecurityConfigurerAdapter {

    protected void configure(HttpSecurity http) throws Exception {
       http
               .csrf().disable()
               .addFilter(new JwtUserNamePasswordAuthFilter(authenticationManager(),new DomainUserDetailsService()))
               .addFilterAfter(new JwtTokenVerifierFilter(),new JwtUserNamePasswordAuthFilter(authenticationManager(),new DomainUserDetailsService()).getClass())
                       .authorizeHttpRequests()
                       .antMatchers(HttpMethod.POST,"/api/order/**").hasRole(AppUserRoles.CUSTOMER.name())
                       .antMatchers(HttpMethod.PUT,"/api/order/**").hasRole(AppUserRoles.CUSTOMER.name())
                       .antMatchers(HttpMethod.DELETE,"/api/order/**").hasRole(AppUserRoles.CUSTOMER.name())
                       .antMatchers(HttpMethod.GET,"/api/order/**").hasRole(AppUserRoles.WAITER.name())
                       .antMatchers(HttpMethod.GET,"/api/order/**").hasRole(AppUserRoles.CHEF.name())
                       .anyRequest().authenticated();
//        http.formLogin();
//        http.httpBasic();
    }


}

