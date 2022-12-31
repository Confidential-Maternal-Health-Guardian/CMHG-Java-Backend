package tr.edu.ku.cmhg.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tr.edu.ku.cmhg.dto.QueryDto;
import tr.edu.ku.cmhg.response.QueryResponse;
import tr.edu.ku.cmhg.service.QueryService;

@RestController
@RequestMapping("/api/v2")
@RequiredArgsConstructor
public class QueryController {
    private final QueryService queryService;

    @PostMapping("/query")
    public ResponseEntity<QueryResponse> query(@RequestBody QueryDto queryDto) {
        return ResponseEntity.ok().body(QueryResponse.builder().response(queryService.getNoisyResult(queryDto)).build());
    }
}
