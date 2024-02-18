### Syndicate Prediction System

#### Introduction
This project is a Syndicate Prediction System designed to provide real-time market insights, syndicate detection, and awareness functionalities. It offers a RESTful API for government officials and general users to manage products, create awareness messages, and detect syndicate activities.

#### Front-end Repository link: https://github.com/hasnat-shohag/hackathon-sust-cse-carnival-2024

#### Technologies Used
- Java
- Spring Boot
- Lombok
- MySql

#### Controllers
1. **GovtController**: Manages product creation, editing, and syndicate detection for government officials.
2. **UserController**: Handles requests related to retrieving products and awareness messages for general users.
3. **SyndicateController**: Deals with user authentication and registration.

#### Services
1. **ProductService**: Handles CRUD operations for products.
2. **AwarenessService**: Manages CRUD operations for awareness messages and syndicate detection.

#### How to Run
1. Ensure you have Java and MySQL installed.
2. Clone the repository.
3. Set up the database configurations in `application.yml`.
4. Run the application using Maven or your preferred IDE.

#### Endpoints
- **Government Endpoints**:
  - `/api/v1/govt/createProduct`: POST request to create a new product.
  - `/api/v1/govt/editProduct/{product_name}`: PUT request to edit an existing product.
  - `/api/v1/govt/awareness`: POST request to create awareness messages.
  - `/api/v1/govt/getSyndicateDetection`: GET request to detect syndicate activities.

- **User Endpoints**:
  - `/api/v1/user/getAllProducts`: GET request to retrieve all products.
  - `/api/v1/user/getAllAwareness`: GET request to retrieve all awareness messages.

- **Authentication Endpoints**:
  - `/api/v1/auth/register`: POST request to register a new user.
  - `/api/v1/auth/login`: POST request to login.

#### Team name: RU Code Smiths
  ##### team member: shakib hasan,kadir swaccho,hasnat sohag
