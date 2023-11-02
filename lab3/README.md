# Atention!
## Each maven project needs to be run in its root, otherwise, it will not compile!

## Lab3_1 Section c)

### The “UserController” class gets an instance of “userRepository” through its constructor; how is this new repository instantiated?

The "userRepository" instance is created automatically by the Spring Framework using the @Repository annotation on the "UserRepository" interface. Spring manages the creation and lifecycle of these components, allowing the "UserController" class to access and utilize the repository through dependency injection performed with the @Autowired annotation in the class's constructor. This simplifies dependency management and makes the code more flexible and decoupled.

### List the methods invoked in the “userRepository” object by the “UserController”. Where are these methods defined?

The following methods are invoked on the "userRepository" object called by the "UserController":

- **save(user)** to store a user.
- **findAll()** to retrieve all users.
- **findById(id)** to retrieve a user by ID.
- **delete(user)** to delete a user.

These methods are defined in the "UserRepository" interface, which extends the Spring Data "CrudRepository" interface. The concrete implementation of these methods is provided by Spring Data JPA, which automatically generates SQL queries based on the method names defined in the interface, simplifying interaction with the database.

### Where is the data being saved?

The data is being stored in an in-memory H2 database, which is embedded and used for development and testing.

### Where is the rule for the “not empty” email address defined?

The "not empty" rule for the email address is defined above the "email" field in the "User" class using the @NotBlank annotation from Jakarta Validation. It indicates that the email field cannot be empty.