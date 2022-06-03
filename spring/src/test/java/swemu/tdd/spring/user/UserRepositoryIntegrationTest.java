package swemu.tdd.spring.user;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import swemu.tdd.spring.user.UserData;
import swemu.tdd.spring.user.UserRepository;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class UserRepositoryIntegrationTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    @DisplayName("findByEmail() should return return user with email")
    void findByEmail() {
        userRepository.save(new UserData(UUID.randomUUID(), "John Doe", "john.doe@gmail.com"));

        var result = userRepository.findByEmail("john.doe@gmail.com");

        assertThat(result).hasValueSatisfying(value ->
                assertThat(value.getName()).isEqualTo("John Doe"));
    }
}
