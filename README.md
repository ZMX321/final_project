## Final Project

1. Integrated university and provider service into the weather project.

2. Centralized configuration files using Spring Cloud Config Server.

   - Encrypt at rest, using keytool generate key pairs for cipher the config file folder path

3. Combined Ribbon and restTemplate to fetch service internally.

   - Implemented CompletableFuture and CachedThreadPool to achieved multithreading data fetching.

   ```json
   {
       "students": [
           {
               "id": "1",
               "fistName": "Tony",
               "lastName": "Stark"
           },
           ...
           {
               "id": "15",
               "fistName": "Steve",
               "lastName": "X"
           }
       ],
       "providers": [
           {
               "first_name": "John",
               "last_name": "Zen"
           }
       ]
   }
   ```

   