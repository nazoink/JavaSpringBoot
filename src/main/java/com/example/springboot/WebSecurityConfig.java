package com.example.springboot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.ldap.authentication.ad.ActiveDirectoryLdapAuthenticationProvider;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/*
* Commented sections are some default config stuff that might be useful starting point
* when connecting AD cred auth
*/

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // This currently allows anonymous connections
        http.authorizeRequests()
            .anyRequest().permitAll()
            .and()
            .csrf().disable()
            .anonymous();
        // This is a basic in memory auth
//            .antMatchers("/").permitAll()
//            .anyRequest().authenticated()
//            .and()
//            .formLogin()
//            .permitAll()
//            .and()
//            .logout()
//            .permitAll()
//            .and()
//            .csrf().disable();
        // This makes it require auth to connect
//            .anyRequest().fullyAuthenticated()
//            .and()
//            .formLogin();
        // Another way to setup AD ldap
//            .httpBasic().and()
//            .logout().and()
//            .authorizeRequests()
//            .antMatchers("/index.html", "/", "/home", "/login", "/assets/**").permitAll()
//            .anyRequest().authenticated()
//            .and()
//            .csrf()
//            .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
    }

    // This section is used to connect into AD cred services
//    @Bean
//    public ActiveDirectoryLdapAuthenticationProvider activeDirectoryLdapAuthenticationProvider(){
//        ActiveDirectoryLdapAuthenticationProvider activeDirectoryLdapAuthenticationProvider = new
//                ActiveDirectoryLdapAuthenticationProvider("pizzashop.com.us", "ldap://10.100.100.100:389/");
//        return activeDirectoryLdapAuthenticationProvider;
//    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        UserDetails user =
                User.withDefaultPasswordEncoder()
                        .username("user")
                        .password("password")
                        .roles("USER")
                        .build();

        return new InMemoryUserDetailsManager(user);
    }

}
