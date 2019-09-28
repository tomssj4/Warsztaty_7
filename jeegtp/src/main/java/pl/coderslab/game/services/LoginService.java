package pl.coderslab.game.services;


        import org.springframework.stereotype.Service;
        import org.springframework.transaction.annotation.Transactional;
        import pl.coderslab.game.models.User;
        import pl.coderslab.game.repositories.UserRepository;

@Service
@Transactional
public class LoginService {
    private UserRepository userRepository;

    public LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findByUserLogin(String login) {
        return userRepository.findByLogin(login);
    }


}
