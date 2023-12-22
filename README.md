# HikeOn_REST_Application_Assignment
This repo consist of REST API project which was assigned by HikeOn Technologies.


## Running Application
- Download the zip or clone the Git repository.
- Unzip the zip file (if you downloaded one)
- Navigate to the directory to folder containing pom.xml
- Open intellij Idea
    - Open -> Navigate to the folder where you unzipped the zip (Contains pom.xml file)
    - Select the right project
- Choose the Spring Boot Application file (search for @SpringBootApplication)
- Right Click on the file and then click on Run
- You are all Set
## Screenshots for testing the edge conditions
-  If the email domain is @hikeon.tech, assign the customer to the "hikeon" customer group.
    - Providing input from postman as JSON as below..
      ```
        {
            "name" : "Nitesh",
            "email" : "abc.work@hikeon.tech",
            "dateOfBirth" : "12-03-2002",
            "occupation" : "DEVELOPER"
        }
      ```
   - Getting response model as below..
        ```
        {
            "timestamp": "Sat Dec 23 00:31:04 IST 2023",
            "statusCode": 201,
            "status": "CREATED",
            "message": "Customer details Validated successfully....",
            "devMessage": "Customer details saved successfully.....",
            "requestMethod": "POST",
            "value": {
                "CustomerDetails": {
                    "id": "HikeOn-2023-2",
                    "name": "Nitesh",
                    "email": "abc.work@hikeon.tech",
                    "dateOfBirth": "12-03-2002",
                    "occupation": "DEVELOPER",
                    "customer_group": "HIKEON"
                }
            }
        }
        ```
    - Find below the screeshot for clarification
      
      ![image](https://github.com/Nitesh232/HikeOn_REST_Application_Assignment/assets/92843270/c6e8679b-ca62-4b27-93a4-a6cdfc8d3c9d)

- For any other domain and occupations: 'developer' or 'chef', assign the customer group as
'developer' or 'chef' respectively.
  - Providing input from postman as JSON as below..
      ```
        {
            "name" : "Nitesh",
            "email" : "abc@gmail.com",
            "dateOfBirth" : "12-03-2002",
            "occupation" : "CHEF"
        }
      ```
   - Getting response model as below..
        ```
        {
            "timestamp": "Sat Dec 23 00:38:54 IST 2023",
            "statusCode": 201,
            "status": "CREATED",
            "message": "Customer details Validated successfully....",
            "devMessage": "Customer details saved successfully.....",
            "requestMethod": "POST",
            "value": {
                "CustomerDetails": {
                    "id": "HikeOn-2023-3",
                    "name": "Nitesh",
                    "email": "abc@gmail.com",
                    "dateOfBirth": "12-03-2002",
                    "occupation": "CHEF",
                    "customer_group": "CHEF"
                }
            }
        }
        ```
    - Find below the screeshot for clarification
      
      ![image](https://github.com/Nitesh232/HikeOn_REST_Application_Assignment/assets/92843270/0adbf88b-1a40-463f-9647-54fcd6b77510)

- If the user's DOB indicates they are below 18 years old, throw an error and do not save the
data into the database.
    - Providing DOB as "19-12-2016"
      ```
        {
            "name" : "Nitesh",
            "email" : "xyz@gmail.com",
            "dateOfBirth" : "19-12-2016",
            "occupation" : "HIKEON"
        }
      ```

  - Getting Exception as UnderAgeException as calculated age in not more that 18 years.
    ```
        {
            "timestamp": "2023-12-23T00:46:55.845439300",
            "statusCode": 500,
            "status": "INTERNAL_SERVER_ERROR",
            "message": "Customer Age is below 18..",
            "devMessage": "Age is below 18......."
        }
    ```
  - Below find the attached image.

      ![image](https://github.com/Nitesh232/HikeOn_REST_Application_Assignment/assets/92843270/1f19e806-5d2e-4e22-8f54-6d9121990a4e)

- If we provide existing email as input we recieve CustomerExistException as bleow attached image
       ![image](https://github.com/Nitesh232/HikeOn_REST_Application_Assignment/assets/92843270/06a4cecc-c7eb-42c2-895e-e09ffbe1b887/468x300)

## Screenshot for database schema with columns: name, email, dob, occupation, and customer group

- Unique identifier for each customer (Auto-incremented)
- Name of the customer
- Email address of the customer (Unique)
- Date of birth of the customer (with age limit of 18 Years)
- Occupation of the customer (it should allow these values only: developer, chef, plumber, carpenter, other)
- Customer group based on rules (it should allow these values only: hikeon, chef, developer, NA)


    ![image](https://github.com/Nitesh232/HikeOn_REST_Application_Assignment/assets/92843270/f2b16429-10de-4c09-b7e6-0f56c9bded64)

