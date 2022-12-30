package tr.edu.ku.cmhg.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tr.edu.ku.cmhg.dto.PredictionDto;
import tr.edu.ku.cmhg.response.PredictionResponse;
import tr.edu.ku.cmhg.service.PredictionService;

@RestController
@RequestMapping("/api/v2")
@RequiredArgsConstructor
public class PredictionController {
    private final PredictionService predictionService;

    @PostMapping("/predict")
    public ResponseEntity<PredictionResponse> predict(@RequestBody PredictionDto predictionDto) {
        return predictionService.getPrediction(predictionDto);
    }
}
