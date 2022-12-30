package tr.edu.ku.cmhg.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PredictionResponse {
    String riskLevel;
    Double confidence;
}
