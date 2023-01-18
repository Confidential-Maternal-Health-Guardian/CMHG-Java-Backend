package tr.edu.ku.cmhg.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import tr.edu.ku.cmhg.dto.PredictionDto;
import tr.edu.ku.cmhg.entity.User;
import tr.edu.ku.cmhg.repository.UserRepository;
import tr.edu.ku.cmhg.response.PredictionResponse;
import tr.edu.ku.cmhg.util.AuthenticatedUser;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class PredictionService {
    private final UserRepository userRepository;

    @Value("${PREDICTION_URL}")
    private String predictionUrl;

    public ResponseEntity<PredictionResponse> getPrediction(PredictionDto predictionDto) {
        log.info("Trying to obtaining prediction for the {}", predictionDto.toString());

        User user = new AuthenticatedUser(userRepository).getAuthenticatedUser();

        if (user.getEpsilonValue() < predictionDto.getEpsilon()) {
            log.error("User {}, does not have sufficient epsilon to perform this operation.", user.getEpsilonValue());
            return null;
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<PredictionDto> entity = new HttpEntity<>(predictionDto, headers);

        RestTemplate restTemplate = new RestTemplate();

        log.info("Sending request to the internal endpoint.");
        ResponseEntity<PredictionResponse> response = restTemplate.exchange(predictionUrl, HttpMethod.POST, entity, PredictionResponse.class);
        log.info("Received response from the internal endpoint.");

        user.setEpsilonValue(user.getEpsilonValue() - predictionDto.getEpsilon());

        return ResponseEntity.ok().body(response.getBody());
    }
}
