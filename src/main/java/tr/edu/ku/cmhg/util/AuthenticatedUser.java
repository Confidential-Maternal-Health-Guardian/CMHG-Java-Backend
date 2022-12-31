package tr.edu.ku.cmhg.util;

import lombok.Data;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import tr.edu.ku.cmhg.entity.User;
import tr.edu.ku.cmhg.repository.UserRepository;

@Data
public class AuthenticatedUser {
    private final UserRepository userRepository;

    public User getAuthenticatedUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        String username = "";

        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }

        return userRepository.findByUsername(username);
    }

}
