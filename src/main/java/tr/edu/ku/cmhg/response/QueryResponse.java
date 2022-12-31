package tr.edu.ku.cmhg.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class QueryResponse {
    private Double queryResult;
}
