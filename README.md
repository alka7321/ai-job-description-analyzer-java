# AI Job Description Analyzer (Java + Spring Boot)

AI Job Description Analyzer is a minimal Spring Boot REST API that uses a large language model (LLM) to analyze software engineering job descriptions against a candidate profile.

Given a job description and a candidate's profile, the service returns:
- A match score between 0 and 100
- Key skills extracted from the job description
- Concrete suggestions to improve the candidate's resume/profile

This project is built in Java and designed to be simple, useful, and easy to understand for interviews and portfolio use.

---

## Features

- `POST /api/v1/analyze`
  - **Request body**:
    ```json
    {
      "jobDescription": "We are hiring a backend engineer with Java, Spring Boot, Kafka, PostgreSQL and GCP.",
      "candidateProfile": "3 years experience with Java, Kotlin, Spring Boot, Kafka, PostgreSQL, GCP, microservices."
    }
    ```
  - **Response body** (example):
    ```json
    {
      "matchScore": 87.5,
      "keySkills": [
        "Java",
        "Spring Boot",
        "Kafka",
        "PostgreSQL",
        "GCP",
        "Microservices"
      ],
      "suggestions": [
        "Highlight experience with distributed systems and microservices in the summary.",
        "Add more detail about your work with Kafka event-driven architectures.",
        "Mention any experience with monitoring tools or SRE practices."
      ]
    }
    ```

- Input validation using `@NotBlank` for required fields.
- OpenAI Java SDK integration to call an LLM from Java.
- JSON parsing and robust error handling around the AI response.

---

## Tech Stack

- **Language:** Java 17  
- **Framework:** Spring Boot (Web, Validation)  
- **AI:** OpenAI Java SDK (LLM API)  
- **Build Tool:** Maven  
- **Architecture:** Simple layered architecture (Controller → Service → OpenAI client)

---

## Getting Started

### Prerequisites

- Java 17 installed (if running locally)  
- Maven installed  
- An OpenAI API key  
- Or, a cloud development environment like GitHub Codespaces / Gitpod

### Clone the repository

```bash
git clone https://github.com/<your-username>/ai-job-description-analyzer-java.git
cd ai-job-description-analyzer-java/ai-job-description-analyzer
```

(If you generated the Spring Boot project inside a subfolder, adjust the path accordingly.)

### Configure OpenAI API key

Set the `OPENAI_API_KEY` environment variable:

```bash
export OPENAI_API_KEY=your_openai_api_key_here
```

On Windows (PowerShell):

```powershell
$env:OPENAI_API_KEY="your_openai_api_key_here"
```

### Run the application

```bash
mvn spring-boot:run
```

By default, the application starts on port `8080`.

---

## Usage

Send a `POST` request to the `/api/v1/analyze` endpoint.

Example using `curl`:

```bash
curl -X POST http://localhost:8080/api/v1/analyze \
  -H "Content-Type: application/json" \
  -d '{
    "jobDescription": "We are hiring a backend engineer with Java, Spring Boot, Kafka, PostgreSQL and GCP.",
    "candidateProfile": "3 years experience with Java, Kotlin, Spring Boot, Kafka, PostgreSQL, GCP, microservices."
  }'
```

You should receive a JSON response containing:

- `matchScore` (0–100)
- `keySkills` (array of strings)
- `suggestions` (array of strings)

---

## Project Structure

```text
src/main/java/com/alka/ai/
  ├── dto/
  │   ├── AnalyzeRequest.java      # Request body DTO
  │   └── AnalyzeResponse.java     # Response body DTO
  ├── service/
  │   └── AiAnalysisService.java   # Business logic, OpenAI integration
  ├── controller/
  │   └── AnalysisController.java  # REST endpoint /api/v1/analyze
  └── AiJobDescriptionAnalyzerApplication.java  # Spring Boot main class
```

---

## Future Improvements

- Add authentication (API key/JWT) for the endpoint.
- Add basic rate limiting to protect the OpenAI API.
- Persist analysis requests in a database for history.
- Create a simple frontend to paste a JD and profile and see results.

---

## License

This project is open-source and available for learning and portfolio purposes.
