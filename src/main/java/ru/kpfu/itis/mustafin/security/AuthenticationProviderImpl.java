package ru.kpfu.itis.mustafin.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.kpfu.itis.mustafin.models.User;
import ru.kpfu.itis.mustafin.services.UserService;

import java.util.HashSet;
import java.util.Set;

@Component
public class AuthenticationProviderImpl implements AuthenticationProvider {

    //private final PasswordEncoder bcryptEncoder = new BCryptPasswordEncoder();

    private UserService userService;

    @Autowired
    public AuthenticationProviderImpl(UserService userService){
        this.userService = userService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) {
        String name = authentication.getName();
        User user = userService.getByLogin(name);
        if(user == null){
            throw new UsernameNotFoundException("User not found!");
        }

        String password = authentication.getCredentials().toString();
        if (!password.equals(user.getPassword())) {
            throw new BadCredentialsException("Invalid password!");
        }

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(user.getRole()));

        return new UsernamePasswordAuthenticationToken(user, null,grantedAuthorities);
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(UsernamePasswordAuthenticationToken.class);
    }
}