package swemu.tdd.spring.user;

import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email)
                .map(data -> new User(data.getName(), data.getEmail()));
    }

    public void createUser(String name, String email) {
        userRepository.save(new UserData(UUID.randomUUID(), name, email));
    }
}
