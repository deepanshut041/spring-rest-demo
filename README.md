## Serendeepia Server

## Rest Api Link
http://serendeepia.herokuapp.com/swagger-ui.html

## Highlights

1. Spring Boot
2. Swagger
3. Solid Principle

## Requirements

* There are 4 rest endpoints: Authenticate User, Register User, Get All User and Get Current User.
* The Authenticate User will check the user and password and return an authentication token.
* The Register User will register new user.
* The Get All User will return all users. Requires ADMIN privileges to hit this endpoint.
* The Get Current User will return data about current user. Requires user to be authenticated.

## API
[Rest Api Doc](http://serendeepia.herokuapp.com/swagger-ui.html) - Documentation Link

1. To Register new user - http://serendeepia.herokuapp.com/api/auth/register
2. To SignIn user - http://serendeepia.herokuapp.com/api/auth/login
3. To Get All User - http://serendeepia.herokuapp.com/api/users (Requires Admin Privileges)
4. To get user profile - http://serendeepia.herokuapp.com/api/users/me (Requires Authorization)

## Library Used
1. Spring Web: https://spring.io/
2. Spring Security: https://spring.io/
3. Swagger SpringFox: http://springfox.github.io/springfox/docs/snapshot/
4. Lombok: https://projectlombok.org/
5. Mapstruct: https://mapstruct.org/
6. Jwt IO(jsonwebtoken:): https://github.com/jwtk/jjwt
