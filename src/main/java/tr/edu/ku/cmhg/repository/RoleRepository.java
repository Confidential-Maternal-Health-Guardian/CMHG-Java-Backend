package tr.edu.ku.cmhg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.edu.ku.cmhg.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
