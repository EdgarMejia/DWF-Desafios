# Book API

This project is a complete RESTful API for a fictional publishing house, "Letras Vivas." The API allows for managing a catalog of books using a robust, layered architecture with Spring Boot, following professional development standards.

## Features

The API provides the following functionalities for managing books:

- **List all books**: Retrieve a list of all books in the catalog.
- **Add a new book**: Create a new book entry with robust data validation.
- **Update a book**: Modify an existing book's data by its ID.
- **Search for books by title**: Find books whose titles match a given search string.
- **Delete a book**: Remove a book from the catalog by its ID.
- **Centralized Error Handling**: Provides clear and consistent error responses for clients.
- **API Documentation**: Automatically generates interactive documentation with OpenAPI/Swagger UI.

## Technologies

- **Java 17**: The programming language used.
- **Spring Boot 3.3.0**: The framework for building the application.
- **Spring Data JPA**: For data persistence and database access.
- **Spring Validation**: For validating incoming data in DTOs.
- **Lombok**: To reduce boilerplate code (getters, setters, constructors).
- **Springdoc-openapi**: For the automatic generation of documentation with Swagger UI.
- **H2 Database**: An in-memory database used for development and testing.
- **Maven**: The build automation tool.
- **Apache Commons Lang3**: A library for general utility functions.

## Project Structure

The project follows a standard layered architecture for a clear separation of concerns:

- `controller`: Handles incoming HTTP requests and responses.
- `service`: Contains the application's business logic.
- `repository`: Manages data access operations with the database.
- `model`: Defines the data entities (e.g., the `Book` class).
- `dto`: Contains the Data Transfer Objects used for requests and responses.
- `exception`: Manages custom exception classes and the global error handler.

## How to Run the Project

1.  **Clone the repository:**

    ```bash
    git clone https://github.com/EdgarMejia/DWF-Desafios.git
    ```

2.  **Open in IntelliJ IDEA:**

    * Open IntelliJ and select `Open` from the welcome screen.
    * Navigate to the cloned folder and select the project's root directory.
    * IntelliJ will automatically import the Maven dependencies.

3.  **Run the application:**

    * Locate the main class `BookApiApplication.java` in `src/main/java/com/letrasvivas/book_api`.
    * Right-click on the file and select `Run 'BookApiApplication.main()'`.
    * The application will start on port 8080.

## API Documentation and Endpoints

The API documentation is automatically generated with Swagger UI. You can access it in your browser once the application is running.

**Documentation URL:**
`http://localhost:8080/swagger-ui.html`

The available endpoints are:

| Method | Endpoint | Description | Example Request Body |
| :--- | :--- | :--- | :--- |
| `GET` | `/api/books` | Retrieves all books. | N/A |
| `GET` | `/api/books?title=word` | Searches for books by a keyword in the title. | N/A |
| `GET` | `/api/books/{id}` | Retrieves a specific book by its ID. | N/A |
| `POST`| `/api/books` | Adds a new book with data validation. | `{"title": "One Hundred Years of Solitude", "author": "Gabriel García Márquez", "isbn": "9780307474748"}` |
| `PUT`| `/api/books/{id}` | Updates an existing book by its ID. | `{"title": "One Hundred Years of Solitude", "author": "Gabo", "isbn": "9780307474748"}` |
| `DELETE`| `/api/books/{id}` | Deletes a book from the catalog by its ID. | N/A |


