package tr.edu.ku.cmhg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.edu.ku.cmhg.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
