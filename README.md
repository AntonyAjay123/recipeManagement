# Recipe Management API


### Frameworks,Technology and Language used:
* Spring
* Spring boot
* Java
* AWS
* SQL


### Data Flow
* Controller :
  * In this api, I have used one controller class ie., RecipeController handles the incoming requests and business logic with the help of RecipeService
* Service
  *  In this api, I have used one service class ie., RecipeService handles the business logic of the project.
* Repository
  * for this API, I have created one repository class ie., RecipeRepository which is used to access the database for CRUD operations.

### Database design:
* For this API, I have added one database table tbl_recipe to store the recipes. This table has 4 fields:
id(int) which is the primary key,
name(string/varchar) to store the name of the recipe,
instructions(List<String>) to store the instructions,
ingredients(List<String>) to store the ingredients


### Project Summary
Recipe Management API to create , update, read and delete recipes from a database.
