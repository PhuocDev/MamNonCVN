package com.example.mamnoncvn.security;

import com.example.mamnoncvn.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Autowired
    UserService userService;



//    @Bean
//    @Override
//    public UserDetailsService userDetailsServiceBean() throws Exception {
//
//        // add users in List
//        List<UserDetails> users = new ArrayList<UserDetails>();
//        List<com.example.mamnoncvn.users.entity.User> userList = userService.getAll();
//        for (com.example.mamnoncvn.users.entity.User account : userList) {
//            System.out.println(account.getUsername() + " " + account.getPassword());
//            users.add(User.withDefaultPasswordEncoder()
//                    .username(account.getUsername())
//                    .password(account.getPassword()).roles(account.getRole()).build());
//        }
//        users.add(User.withDefaultPasswordEncoder()
//                .username("phuoc")
//                .password("phuoc").roles("admin").build());
////        users.add(User.withDefaultPasswordEncoder()
////                .username("admin")
////                .password("admin").roles("manager").build());
////        users.add(User.withDefaultPasswordEncoder()
////                .username("phuoc")
////                .password("phuoc").roles("manager").build());
////        users.add(User.withDefaultPasswordEncoder()
////                .username("thuha")
////                .password("thuha123").roles("manager").build());
//        return new InMemoryUserDetailsManager(users);
//    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors().and()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/admin/user/**").hasRole("admin")
                .antMatchers("/admin/**").hasAnyRole("admin", "modifier")
                .antMatchers("/resources/**").permitAll()
                .antMatchers("/*.js").permitAll()
                .antMatchers("/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().and().logout();
    }

    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager()
    {
        List<UserDetails> users = new ArrayList<UserDetails>();
        List<com.example.mamnoncvn.users.entity.User> userList = userService.getAll();
        for (com.example.mamnoncvn.users.entity.User account : userList) {
            users.add(User.withDefaultPasswordEncoder()
                    .username(account.getUsername())
                    .password(account.getPassword()).roles(account.getRole()).build());
        }
        return new InMemoryUserDetailsManager(users);
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception
    {
        auth.userDetailsService(inMemoryUserDetailsManager());
    }
}