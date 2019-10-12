package pl.coderslab.game.services;

import org.hibernate.Hibernate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.game.dto.UserEmailFormDTO;
import pl.coderslab.game.dto.UserLoginFormDTO;
import pl.coderslab.game.dto.UserPasswordFormDTO;
import pl.coderslab.game.models.Character;
import pl.coderslab.game.models.User;
import pl.coderslab.game.repositories.UserRepository;

import java.util.List;

@Service
@Transactional
public class UserService {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User readUser(String login) {
        return userRepository.findByLogin(login);
    }

    public void updateUserLogin(UserLoginFormDTO newData, String login) {
        User user = userRepository.findByLogin(login);
        user.setLogin(newData.getLogin());
        userRepository.save(user);
    }

    public void updateUserEmail(UserEmailFormDTO newData, String login) {
        User user = userRepository.findByLogin(login);
        user.setEmail(newData.getEmail());
        userRepository.save(user);
    }

    public void updateUserPassword(UserPasswordFormDTO newData, String login) {
        User user = userRepository.findByLogin(login);
        String encodedPassword = passwordEncoder.encode(((newData.getPassword())));
        user.setPassword(encodedPassword);
        userRepository.save(user);
    }


    public List<Character> getCharacterList(String userLogin) {
        List<Character> characters =userRepository.findByLogin(userLogin).getCharacterList();
        Hibernate.initialize(characters.size());
        return characters;
    }


    public void deleteUser(String login) {
        userRepository.delete(userRepository.findByLogin(login));
    }

    public boolean isEmailAvailable(String email) {
        long count = userRepository.countByEmail(email);
        if (count > 0) {
            return false;
        } else {
            return true;
        }
    }

    public boolean isLoginAvailable(String login) {
        long count = userRepository.countByLogin(login);
        if (count > 0) {
            return false;
        } else {
            return true;
        }
    }


    public void updateUser(User user) {
        userRepository.save(user);
    }
}
