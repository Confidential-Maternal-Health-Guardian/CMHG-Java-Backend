package tr.edu.ku.cmhg.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PredictionDto {
    private Integer age;
    private Integer systolicBp;
    private Integer diastolicBp;
    private Double bs;
    private Integer bodyTemp;
    private Integer heartRate;
}
