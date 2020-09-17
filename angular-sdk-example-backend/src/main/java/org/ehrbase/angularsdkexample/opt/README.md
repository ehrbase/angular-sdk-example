To create or recreate the generated DTOs 

- Have the client lib locally cloned and build
- Navigate to the generator target folder
- Run (your version of), for each OPT you want to generate a DTO from:

``
java -jar generator-0.3.5.jar -opt /$REPO_PATH/num-app-backend/src/main/resources/opt/$OPT_NAME.opt -out /$REPO_PATH/num-app-backend/src/main/java -package org.ehrbase.angularsdkexample.opt
``