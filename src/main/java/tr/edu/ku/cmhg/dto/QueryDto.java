package tr.edu.ku.cmhg.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class QueryDto {
    private String function;
    private String field;
    private Double epsilon;
}
