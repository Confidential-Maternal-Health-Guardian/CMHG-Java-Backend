package tr.edu.ku.cmhg.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponse {
    private String username;
    private Double epsilonValue;
}
