## Manga Management System
A Manga Management System built using Java and MySQL database, implementing Object Oriented Programming principles and following the Data Access Object (DAO) pattern. The interface is console based and the application manages a collection of mangas and their respective mangakas (authors). The application used Java Database Connectivity (JDBC) to interact with the database.

## Features
- Add a manga (title, publication year, status and mangaka (author) name)
- Update and delete manga entries
- Search manga based on title
- Console-based UI which guides the user and makes it user-friendly

## Tech Stack
- Java - Core programming language
- MySQL - Relational database system
- JDBC - Java API to interact with databases

## Data Access Object (DAO) Pattern
- DAO is an object/pattern which is used to retrieve access from a database.
- It **separates a data resource's client interface from its data access mechanisms**
- Makes it easier to switch databases e.g. if I wanted to switch from MySQL to MongoDB.
- DAO Interface:
   - The Interface that defines the operations to be performed on a models object
   - mangaDAO.java, mangakaDAO.java
   - E.g. addManga, getAllMangas
- DAO Concrete class:
   - The class implements the interface class and responsible from getting data such as from a database
   - MangaDaoImpl.java, mangakaDaoImpl.java
   - E.g. implements addManga method and does the logic for adding manga to db
- Model Objects:
  - POJO containing getters/setters
  - Manga.java, Mangaka.java 

## Classes
- Manga/Mangaka - POJO with getters/setters
- MangaDAO/MangakaDAO - Interface class
- MangaDaoImpl/MangakaDaoImpl - Implementation Class
- DatabaseConnection - establishes connection to db
- UserInterface - Handles UI of the program
- App - Entry point of the program

## Database Schema
- MySQL is used as the database
- Mangaka table stores mangaka information
- Manga table stores manga information
> You can access the SQL scripts for manga/mangaka in db_structuredump

![image](https://github.com/user-attachments/assets/7fb65d14-7249-49ef-94e9-c3756126a01a)

## Demonstration
- Viewing All Mangas

![image](https://github.com/user-attachments/assets/2eb6163b-a511-4730-bbcc-fb6e0f377b2c)

- Adding a manga

![image](https://github.com/user-attachments/assets/626d3eff-398a-48e7-957c-5d70957b2134)

- Database Example

![image](https://github.com/user-attachments/assets/b4869ee3-77a9-4b57-b853-9428b32b9cde)

## Notes (Extra Information)
- The user can create a new manga by entering mangaka name
  - Logic to check if mangaka exists
  - If mangaka exists uses that id
  - Or else creates new mangaka entry for mangaka table and uses that id
- title is unique index and add manga contains sql integrity exception to avoid duplicates

## Further Work
- Web-based UI: Implementing a web based front-end
- Java Persistance API (JPA)/Hibernates implementation
  - JDBC requires manually writing the SQL queries and result mapping
  - Using JPA can help hide the SQL and simplify database interactions
  - Using Hibernate (JPA's implementation)
- UI validation: Adding input validation for console-based UI
