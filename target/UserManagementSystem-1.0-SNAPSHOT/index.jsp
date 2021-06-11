<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
        <title>Index</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-primary">
            <a class="navbar-brand" href="#">User Management System</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarText">
              <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                </li>
              </ul>
              <span class="navbar-text">
                  <a href="login.jsp">Login</a>
              </span>
                <span class="navbar-text">
                    <a class="nav-link" href="register.jsp">Register </a>
                </span>
            </div>
        </nav>
        <br>

        <div class="jumbotron jumbotron-fluid">
            <div class="container">
              <h1 class="display-4">Guest Instruction</h1>
            <p>Congratulations! You’ve been invited to join a User Management System .....</p>
            </div>
          </div>
        <ul class="list-group list-group-flush">
            <b>Features of the website</b>
            <li class="list-group-item">Admin cannot be created but is added directly by developer.</li>
            <li class="list-group-item">Admin can create new user, delete user accounts, edit information of user and view detail information of the user following some rules.</li>
            <li class="list-group-item">User can create their account and user the website resources.</li>
            <li class="list-group-item">Both user and admin can reset their password following some rule.</li>
            <li class="list-group-item"> If you like the features of the website you can login or if you are new to the site you can register for a new account from the navigation bar above.</li>
          </ul>
    </body>
</html>
