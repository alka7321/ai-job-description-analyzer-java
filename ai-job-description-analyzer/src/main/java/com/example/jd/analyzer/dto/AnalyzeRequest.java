package com.example.jd.analyzer.dto;

import jakarta.validation.constraints.NotBlank;

public class AnalyzeRequest {

    @NotBlank
    private String jobDescription;

    @NotBlank
    private String candidateProfile;

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getCandidateProfile() {
        return candidateProfile;
    }

    public void setCandidateProfile(String candidateProfile) {
        this.candidateProfile = candidateProfile;
    }
}