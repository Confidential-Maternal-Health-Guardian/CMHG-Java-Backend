package tr.edu.ku.cmhg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tr.edu.ku.cmhg.entity.DatasetRow;

public interface DatasetRepository extends JpaRepository<DatasetRow, Integer> {

    @Query(value = "SELECT avg(age) FROM maternal_health_risk_data", nativeQuery = true)
    Double averageAge();

    @Query(value = "SELECT avg(systolic_bp) FROM maternal_health_risk_data", nativeQuery = true)
    Double averageSbp();

    @Query(value = "SELECT avg(diastolic_bp) FROM maternal_health_risk_data", nativeQuery = true)
    Double averageDbp();

    @Query(value = "SELECT avg(bs) FROM maternal_health_risk_data", nativeQuery = true)
    Double averageBs();

    @Query(value = "SELECT avg(body_temp) FROM maternal_health_risk_data", nativeQuery = true)
    Double averageBt();

    @Query(value = "SELECT avg(heart_rate) FROM maternal_health_risk_data", nativeQuery = true)
    Double averageHr();

    @Query(value = "SELECT min(age) FROM maternal_health_risk_data", nativeQuery = true)
    Double minAge();

    @Query(value = "SELECT min(systolic_bp) FROM maternal_health_risk_data", nativeQuery = true)
    Double minSbp();

    @Query(value = "SELECT min(diastolic_bp) FROM maternal_health_risk_data", nativeQuery = true)
    Double minDbp();

    @Query(value = "SELECT min(bs) FROM maternal_health_risk_data", nativeQuery = true)
    Double minBs();

    @Query(value = "SELECT min(body_temp) FROM maternal_health_risk_data", nativeQuery = true)
    Double minBt();

    @Query(value = "SELECT min(heart_rate) FROM maternal_health_risk_data", nativeQuery = true)
    Double minHr();

    @Query(value = "SELECT max(age) FROM maternal_health_risk_data", nativeQuery = true)
    Double maxAge();

    @Query(value = "SELECT max(systolic_bp) FROM maternal_health_risk_data", nativeQuery = true)
    Double maxSbp();

    @Query(value = "SELECT max(diastolic_bp) FROM maternal_health_risk_data", nativeQuery = true)
    Double maxDbp();

    @Query(value = "SELECT max(bs) FROM maternal_health_risk_data", nativeQuery = true)
    Double maxBs();

    @Query(value = "SELECT max(body_temp) FROM maternal_health_risk_data", nativeQuery = true)
    Double maxBt();

    @Query(value = "SELECT max(heart_rate) FROM maternal_health_risk_data", nativeQuery = true)
    Double maxHr();

}
