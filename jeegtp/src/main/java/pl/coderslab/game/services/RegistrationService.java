package pl.coderslab.game.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.game.dto.RegistrationFormDTO;
import pl.coderslab.game.models.User;
import pl.coderslab.game.repositories.UserRepository;


@Service
@Transactional
public class RegistrationService {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public RegistrationService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public boolean isEmailAvailable(String email) {
        long count = userRepository.countByEmail(email);
        if (count > 0){
            return false;
        }else {
            return true;
        }
    }

    public boolean isLoginAvailable(String login) {
        long count = userRepository.countByLogin(login);
        if (count > 0){
            return false;
        }else {
            return true;
        }
    }

    public void registerUser(RegistrationFormDTO data) {
        User user = new User();
        user.setLogin(data.getLogin());
        user.setEmail(data.getEmail());
        String encodedPassword = passwordEncoder.encode(((data.getPassword())));
        user.setPassword(encodedPassword);
        userRepository.save(user);
    }

}
