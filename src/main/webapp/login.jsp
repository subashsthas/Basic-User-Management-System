</html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <title>User Management Application</title>
        <link rel="stylesheet"
               href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
               integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
               crossorigin="anonymous">
        	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" integrity="sha384-gfdkjb5BdAXd+lj+gudLWI+BXq4IuLW5IT+brZEZsLFm++aCMlF1V92rMkPaX4PP" crossorigin="anonymous">

    </head>
    <style>
                body,
		html {
			margin: 0;
			padding: 0;
			height: 100%;
			background: -webkit-linear-gradient(left, #3931af, #00c6ff);
		}
		.user_card {
			height: 400px;
			width: 350px;
			margin-top: auto;
			margin-bottom: auto;
			background: #f39c12;
			position: relative;
			display: flex;
			justify-content: center;
			flex-direction: column;
			padding: 10px;
			box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
			-webkit-box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
			-moz-box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
			border-radius: 5px;

		}
		.brand_logo_container {
			position: absolute;
			height: 170px;
			width: 170px;
			top: -75px;
			border-radius: 50%;
			background: #60a3bc;
			padding: 10px;
			text-align: center;
		}
		.brand_logo {
			height: 150px;
			width: 150px;
			border-radius: 50%;
			border: 2px solid white;
		}
		.form_container {
			margin-top: 100px;
		}
		.login_btn {
			width: 100%;
			background: #c0392b !important;
			color: white !important;
		}
		.login_btn:focus {
			box-shadow: none !important;
			outline: 0px !important;
		}
		.login_container {
			padding: 0 2rem;
		}
		.input-group-text {
			background: #c0392b !important;
			color: white !important;
			border: 0 !important;
			border-radius: 0.25rem 0 0 0.25rem !important;
		}
		.input_user,
		.input_pass:focus {
			box-shadow: none !important;
			outline: 0px !important;
		}
		.custom-checkbox .custom-control-input:checked~.custom-control-label::before {
			background-color: #c0392b !important;
		}
    </style>
   <body>

	<br>
        <body>
            <div class="container h-100">
                <div class="d-flex justify-content-center h-100">
                    <div class="user_card">
                        <div class="d-flex justify-content-center">
                                <div class="brand_logo_container">
                                        <img src="data:image/png;base64,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" class="brand_logo" alt="Logo">
                                </div>
                        </div>
                        <div class="d-flex justify-content-center form_container">
                            <form action="Login" method="post">
                                        <div class="input-group mb-3">
                                                <div class="input-group-append">
                                                        <span class="input-group-text"><i class="fas fa-user"></i></span>
                                                </div>
                                                <input type="text" name="email" class="form-control input_user" placeholder="Email" required>
                                        </div>
                                        <div class="input-group mb-2">
                                                <div class="input-group-append">
                                                        <span class="input-group-text"><i class="fas fa-key"></i></span>
                                                </div>
                                            <input type="password" name="password" class="form-control input_pass"  placeholder="password" required>
                                        </div>
                                        <div class="d-flex justify-content-center mt-3 login_container">
                                            <button type="submit" class="btn login_btn">Login</button>
                                        </div>
                                </form>
                        </div>
                        <div class="mt-4">
                            <div class="d-flex justify-content-center links">
                                Don't have an account? <a href="register.jsp" class="ml-2">Sign Up</a>
                            </div>
                        </div>
                        <div class="mt-4">
                            <div class="d-flex justify-content-center links">
                                Forgot Password? <a href="forget.jsp" class="ml-2">Forget Password</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </body>
    </body>
</html>
