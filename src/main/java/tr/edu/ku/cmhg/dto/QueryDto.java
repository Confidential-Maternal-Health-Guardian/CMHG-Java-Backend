package tr.edu.ku.cmhg.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class QueryDto {
    String username;
    String function;
    String field;
    Double epsilon;
}
