package com.example.jd.analyzer.controller;

import com.example.jd.analyzer.dto.AnalyzeRequest;
import com.example.jd.analyzer.dto.AnalyzeResponse;
import com.example.jd.analyzer.service.AiAnalysisService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class AnalysisController {

    private final AiAnalysisService aiAnalysisService;

    public AnalysisController(AiAnalysisService aiAnalysisService) {
        this.aiAnalysisService = aiAnalysisService;
    }

    @PostMapping("/analyze")
    public ResponseEntity<AnalyzeResponse> analyze(@Valid @RequestBody AnalyzeRequest request) {
        AnalyzeResponse response = aiAnalysisService.analyze(request);
        return ResponseEntity.ok(response);
    }
}