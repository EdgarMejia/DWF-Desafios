# Book API

This project is a basic RESTful API for a fictional publishing house, "Letras Vivas". The API allows for managing a catalog of books using a layered architecture with Spring Boot.

## Features

The API provides the following functionalities for managing books:

- **List all books**: Retrieve a list of all books in the catalog.
- **Add a new book**: Create a new book entry.
- **Search books by title**: Find books whose titles match a given search string.
- **Delete a book**: Remove a book from the catalog by its ID.

## Technologies

- **Java 17**: The programming language used.
- **Spring Boot**: Framework for building the application.
- **Spring Data JPA**: For data persistence.
- **H2 Database**: An in-memory database used for development and testing.
- **Maven**: The build automation tool.

## Project Structure

The project follows a standard multi-layered architecture:

- `controller`: Handles incoming HTTP requests and responses.
- `service`: Contains the business logic of the application.
- `repository`: Manages data access operations with the database.
- `model`: Defines the data entities (e.g., the `Book` class).

## How to Run the Project

1.  **Clone the repository:**
    ```bash
    git clone [https://docs.github.com/en/repositories/creating-and-managing-repositories/about-repositories](https://docs.github.com/en/repositories/creating-and-managing-repositories/about-repositories)
    ```

2.  **Open in IntelliJ IDEA:**
    * Open IntelliJ and select `Open` from the welcome screen.
    * Navigate to the cloned folder and select the project's root directory.

3.  **Run the application:**
    * Locate the main class `BookApiApplication.java` in `src/main/java/com/letrasvivas/bookapi`.
    * Right-click on the file and select `Run 'BookApiApplication.main()'`.
    * The application will start on port 8080.

## API Endpoints

You can use a tool like Postman to test the following endpoints:

| Method | Endpoint | Description | Example Request Body |
| :--- | :--- | :--- | :--- |
| `GET` | `/api/books` | Retrieves all books. | N/A |
| `GET` | `/api/books?title=word` | Searches for books by a keyword in the title. | N/A |
| `POST`| `/api/books` | Adds a new book. | `{"title": "The Hobbit", "author": "J.R.R. Tolkien", "publicationYear": "1937"}` |
| `DELETE`| `/api/books/{id}` | Deletes a book by its ID. | N/A |