package com.example.jd.analyzer.service;

import com.example.jd.analyzer.dto.AnalyzeRequest;
import com.example.jd.analyzer.dto.AnalyzeResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AiAnalysisService {

    public AnalyzeResponse analyze(AnalyzeRequest request) {
        // Dummy logic for now – no external API
        double matchScore = 75.0;

        List<String> keySkills = List.of(
                "Java",
                "Spring Boot",
                "REST APIs",
                "SQL",
                "Cloud platforms"
        );

        List<String> suggestions = List.of(
                "Highlight Spring Boot microservices projects in your resume.",
                "Add concrete metrics for performance improvements (e.g., response time, throughput).",
                "Mention any experience with CI/CD tools like GitHub Actions or Jenkins."
        );

        return new AnalyzeResponse(matchScore, keySkills, suggestions);
    }
}