To create or recreate the generated DTOs 

- Have the client lib locally cloned and build
- Navigate to its target folder
- and run (your version of), for each OPT you want to generate a DTO from:

``
java -jar client-library-0.3.0.jar -opt /$REPO_PATH/num-app-backend/templates/$OPT_NAME.opt -out /$REPO_PATH/num-app-backend/src/main/java -package org.ehrbase.numappbackend.opt
``