package ru.kpfu.itis.mustafin.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import ru.kpfu.itis.mustafin.security.AuthenticationProviderImpl;


@Configuration
@EnableWebSecurity
@ComponentScan("ru.kpfu.itis.mustafin.security")
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    private AuthenticationProviderImpl authProvider;

    @Autowired
    public void configure(AuthenticationManagerBuilder auth){auth.authenticationProvider(authProvider);}

    protected void configure(HttpSecurity http) throws Exception{
        http
                .authorizeRequests()
                .antMatchers("/", "/resources/**","/login").permitAll()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/catalog/**").hasAnyRole("ADMIN","USER")
                .anyRequest().permitAll();
        http
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/login/process")
                .defaultSuccessUrl("/catalog/", true)
                .failureUrl("/login?error=true")
                .usernameParameter("login").passwordParameter("password")
                .permitAll();

        http
                .logout()
                .permitAll()
                .invalidateHttpSession(true)
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login");
        http.csrf().disable();
    }
}