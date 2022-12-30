package tr.edu.ku.cmhg.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tr.edu.ku.cmhg.dto.PredictionDto;
import tr.edu.ku.cmhg.response.PredictionResponse;

@Service
@RequiredArgsConstructor
@Slf4j
public class PredictionService {
    public ResponseEntity<PredictionResponse> getPrediction(PredictionDto predictionDto) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<PredictionDto> entity = new HttpEntity<>(predictionDto, headers);

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<PredictionResponse> response = restTemplate.exchange("http://localhost:5000/predict", HttpMethod.POST, entity, PredictionResponse.class);

        return ResponseEntity.ok().body(response.getBody());
    }
}
