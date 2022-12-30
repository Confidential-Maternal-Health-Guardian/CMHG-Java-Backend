package tr.edu.ku.cmhg.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "maternal_health_risk_data", schema = "public")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DatasetRow {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer age;
    private Integer systolic_bp;
    private Integer diastolic_bp;
    private Double bs;
    private Integer body_temp;
    private Integer heart_rate;
    private String risk_level;
}
