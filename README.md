Object-oriented programming is about creating objects that contain both data and methods.

## Definition of Terms

- **Classes** – Serve as blueprints for creating objects, and allow you to define the structure and behavior of objects.
- **Objects** – Instances of a class.

- **Fields** – The state or characteristics of an object, also called attributes (variables).
- **Methods** – Define the behavior of the objects (functions).
- **Method Overloading** – Allows you to define multiple methods with the same name in the same class, but with different parameter lists.

- **Constructors** – Special methods that automatically run once an object is created. They must have the same name as the class. When no (parameterized) constructor is defined, the default constructor is called, with no parameters and no initialization.
- **Constructor Overloading** – Allows you to define multiple constructors within the same class, each taking a different set of parameters (i.e., different data types, different order of data type definition).
- **Constructor Chaining** – The process of calling one constructor from another constructor within the same class. Can be done through keywords like `this()` or `super()`.

- **Access Specifiers** – Keywords used to control the visibility and accessibility of class members (fields, methods, and nested classes) within different parts of the program.
  - `public` – Members declared public are accessible from anywhere within the program, including other classes and packages.
  - `private` – Only accessible within the class.
  - `protected` – Only accessible within the same package or its subclasses.
  - *Package-private* – The default, accessible within the same package.

## Principles of OOP

- **Encapsulation**  
  Bundling data (fields) and methods that operate on the data into a single unit (class), and restricting access to some of the object's components. This protects the integrity of the data by preventing outside code from directly modifying it.

- **Inheritance**  
  Mechanism that allows one class to acquire the properties and behaviors (fields and methods) of another class. This promotes code reusability and establishes a natural hierarchy between classes.

- **Polymorphism**  
  The ability of different classes to be treated as instances of the same class through a common interface, typically by method overriding or overloading. This allows for flexibility and the ability to use a single interface to represent different underlying forms (data types). This can be done through method overriding or implementation in interfaces.

- **Abstraction**  
  Hiding complex implementation details and showing only the necessary features of an object. Allows you to focus on what an object does instead of how it does it.



