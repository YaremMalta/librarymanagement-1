
 # LIBRARY MANAGEMENT SYSTEM

This project is a Java-based Library Management System developed using the Spring Boot framework. 

The application provides infrastructure for users to borrow books, manage book information, and track borrowing activities.

PostgreSQL is used as the database for this project.

 # PROJECT FEATURES

CRUD Operations: Full CRUD operations (Create, Read, Update, Delete) are available for books, users, and borrowing activities.

MVC Architecture: The application is designed using the Model-View-Controller (MVC) layered architecture. Separate controller, service, and repository classes are created for each class.

User Management: A specific user can borrow a book by its unique ID. User and borrowing information is stored in the database.

Book Types and Factory Design Pattern: The Factory Design Pattern is used to dynamically manage book types.

API Testing: Postman is used to test the API endpoints of the project.


 # TECHNOLOGIES USED

Spring Boot: Used for Java-based backend development.

PostgreSQL: Used as the database.

Postman: Used for testing API requests.

Factory Design Pattern: Applied for managing book types.


 # SET UP
To Run The Project, You Can Follow These Steps:

Clone your repository:

git clone https://github.com/YaremMalta/library.git

Install the required dependencies:

mvn install

Set up the PostgreSQL database and add connection details in the application.properties file.

Start the application:

mvn spring-boot:run


 # API USAGE

The following API endpoints are used for managing books, users, and borrowing activities in the project:
GET /books: List all books

POST /books: Add a new book

PUT /books/{id}: Update book information by ID

DELETE /books/{id}: Delete a book by ID

POST /borrow/{bookId}: A user can borrow a book by its unique ID

For Users and Borrow operations, the following CRUD operations are provided:

Users API:

GET /users: List all users

POST /users: Add a new user

PUT /users/{id}: Update user information by ID

DELETE /users/{id}: Delete a user by ID

Borrow API:
GET /borrow: List all borrowings

POST /borrow/{bookId}: Borrow a book for a user by book ID

PUT /borrow/{id}: Update borrowing information by ID

DELETE /borrow/{id}: Delete a borrowing by ID


 # POSTMAN API TESTING

A Postman collection is provided to test the API endpoints. You can download the collection and test the API requests directly via Postman.
