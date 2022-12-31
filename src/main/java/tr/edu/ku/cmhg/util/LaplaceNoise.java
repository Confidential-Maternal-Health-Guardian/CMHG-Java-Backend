package tr.edu.ku.cmhg.util;

import lombok.Data;
import org.apache.commons.math3.distribution.LaplaceDistribution;

@Data
public class LaplaceNoise {
    public Double getLaplaceNoise(Double sensitivity, Double epsilon) {
        double b = sensitivity / epsilon;
        LaplaceDistribution laplace = new LaplaceDistribution(0.0, b);

        return laplace.sample();
    }
}
