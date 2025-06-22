# Quiz App

A simple RESTful API for creating and taking quizzes.

## Technologies Used

- Java 21
- Spring Boot 3
- Spring Data JPA
- PostgreSQL
- Maven


### Question Endpoints

- **GET `/question/allQuestions`**: Fetches all questions from the database.
- **GET `/question/category/{category}`**: Fetches all questions belonging to a specific category.
- **POST `/question/add`**: Adds a new question to the database.
  - **Request Body**:
    ```json
    {
      "questionTitle": "What is the capital of India?",
      "option1": "Mumbai",
      "option2": "Bangalore",
      "option3": "New Delhi",
      "option4": "Chennai",
      "rightAnswer": "New Delhi",
      "difficultyLevel": "Easy",
      "category": "Geography"
    }
    ```
- **PUT `/question/update/{id}`**: Updates an existing question.
- **DELETE `/question/delete/{id}`**: Deletes a question from the database.

### Quiz Endpoints

- **POST `/quiz/create?category={category}&numQ={numQ}&title={title}`**: Creates a new quiz.
- **GET `/quiz/get/{id}`**: Fetches a specific quiz for the user to take.
- **POST `/quiz/submit/{id}`**: Submits the answers for a quiz and returns the user's score.
  - **Request Body**:
    ```json
    [
      {
        "id": 1,
        "answer": "Paris"
      },
      {
        "id": 2,
        "answer": "4"
      }
    ]
    ```

## How to Run

1. **Clone the repository:**
   ```bash
   git clone https://github.com/sathwikhbhat/quiz-app.git
   ```
2. **Configure the database:**
   - Open `src/main/resources/application.properties`.
   - Update the `spring.datasource.url`, `spring.datasource.username`, and `spring.datasource.password` properties to match your PostgreSQL configuration.
3. **Run the application:**
   ```bash
   ./mvnw spring-boot:run
   ```
The application will be available at `http://localhost:8080`.
