import org.junit.Test;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ru.kpfu.itis.mustafin.models.User;
import ru.kpfu.itis.mustafin.repositories.UserRepository;
import ru.kpfu.itis.mustafin.security.AuthenticationProviderImpl;
import ru.kpfu.itis.mustafin.services.UserService;
import ru.kpfu.itis.mustafin.services.impl.UserServiceImpl;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AuthenticationTest {

    final UserRepository userRepository = mock(UserRepository.class);
    final UserService userService = new UserServiceImpl(userRepository);
    final AuthenticationProvider authenticationProvider = new AuthenticationProviderImpl(userService);
    final Authentication authentication = mock(Authentication.class);

    @Test(expected = UsernameNotFoundException.class)
    public void providerMustThrowUsernameNotFoundException() {
        when(userRepository.findByLogin("admin")).thenReturn(null);
        when(authentication.getName()).thenReturn("admin");
        authenticationProvider.authenticate(authentication);
    }

    @Test(expected = BadCredentialsException.class)
    public void providerMustThrowBadCredentialsException() {
        User testUser = new User();
        testUser.setPassword("123");
        testUser.setLogin("admin");
        when(userRepository.findByLogin("admin")).thenReturn(testUser);
        when(authentication.getName()).thenReturn("admin");
        when(authentication.getCredentials()).thenReturn("321");
        authenticationProvider.authenticate(authentication);
    }


}
