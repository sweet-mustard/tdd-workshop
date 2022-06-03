package swemu.tdd.spring.user;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<UserData, String> {
    Optional<UserData> findByEmail(String email);
}
