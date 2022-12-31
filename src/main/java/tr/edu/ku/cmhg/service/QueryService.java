package tr.edu.ku.cmhg.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tr.edu.ku.cmhg.dto.QueryDto;
import tr.edu.ku.cmhg.entity.User;
import tr.edu.ku.cmhg.repository.DatasetRepository;
import tr.edu.ku.cmhg.repository.UserRepository;
import tr.edu.ku.cmhg.util.AuthenticatedUser;
import tr.edu.ku.cmhg.util.LaplaceNoise;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class QueryService {
    private final DatasetRepository datasetRepository;
    private final UserRepository userRepository;

    private Double applyAggregateFunction(String function, String field) {
        if ("average".equalsIgnoreCase(function)) {
            if ("age".equalsIgnoreCase(field)) {
                return datasetRepository.averageAge();
            } else if ("systolic_bp".equalsIgnoreCase(field)) {
                return datasetRepository.averageSbp();
            } else if ("diastolic_bp".equalsIgnoreCase(field)) {
                return datasetRepository.averageDbp();
            } else if ("bs".equalsIgnoreCase(field)) {
                return datasetRepository.averageBs();
            } else if ("body_temp".equalsIgnoreCase(field)) {
                return datasetRepository.averageBt();
            } else {
                return datasetRepository.averageHr();
            }
        } else if ("min".equalsIgnoreCase(function)) {
            if ("age".equalsIgnoreCase(field)) {
                return datasetRepository.minAge();
            } else if ("systolic_bp".equalsIgnoreCase(field)) {
                return datasetRepository.minSbp();
            } else if ("diastolic_bp".equalsIgnoreCase(field)) {
                return datasetRepository.minDbp();
            } else if ("bs".equalsIgnoreCase(field)) {
                return datasetRepository.minBs();
            } else if ("body_temp".equalsIgnoreCase(field)) {
                return datasetRepository.minBt();
            } else {
                return datasetRepository.minHr();
            }
        } else if ("max".equalsIgnoreCase(function)) {
            if ("age".equalsIgnoreCase(field)) {
                return datasetRepository.maxAge();
            } else if ("systolic_bp".equalsIgnoreCase(field)) {
                return datasetRepository.maxSbp();
            } else if ("diastolic_bp".equalsIgnoreCase(field)) {
                return datasetRepository.maxDbp();
            } else if ("bs".equalsIgnoreCase(field)) {
                return datasetRepository.maxBs();
            } else if ("body_temp".equalsIgnoreCase(field)) {
                return datasetRepository.maxBt();
            } else {
                return datasetRepository.maxHr();
            }
        }

        log.error("applyAggregateFunction encountered with an error.");

        return 0.0;
    }

    public Double getNoisyResult(QueryDto queryDto) {
        User user = new AuthenticatedUser(userRepository).getAuthenticatedUser();

        Double rawResult = applyAggregateFunction(queryDto.getFunction(), queryDto.getField());

        if (user.getEpsilonValue() < queryDto.getEpsilon()) {
            log.error("User {}, does not have sufficient epsilon to perform this operation.", user.getEpsilonValue());
            return null;
        }

        user.setEpsilonValue(user.getEpsilonValue() - queryDto.getEpsilon());

        Double laplaceNoise = new LaplaceNoise().getLaplaceNoise(1.0, queryDto.getEpsilon());

        log.info("Calculated result of the query with real answer: {} and laplace noise: {}", rawResult, laplaceNoise);

        return rawResult + laplaceNoise;
    }
}
