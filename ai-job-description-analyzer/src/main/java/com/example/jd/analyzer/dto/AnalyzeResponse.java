package com.example.jd.analyzer.dto;

import java.util.List;

public class AnalyzeResponse {

    private double matchScore;
    private List<String> keySkills;
    private List<String> suggestions;

    public AnalyzeResponse(double matchScore, List<String> keySkills, List<String> suggestions) {
        this.matchScore = matchScore;
        this.keySkills = keySkills;
        this.suggestions = suggestions;
    }

    public double getMatchScore() {
        return matchScore;
    }

    public List<String> getKeySkills() {
        return keySkills;
    }

    public List<String> getSuggestions() {
        return suggestions;
    }
}