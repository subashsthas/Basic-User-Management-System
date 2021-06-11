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
    </head>
   <body>
	<header>
            <nav class="navbar navbar-expand-md navbar-dark"
                    style="background-color: tomato">
                <div>
                    <a class="navbar-brand"> User Management App </a>
                </div>
                <ul class="navbar-nav">
                    <li><a href="<%=request.getContextPath()%>/"
                        class="nav-link">Users</a></li>
                </ul>
            </nav>
	</header>
	<br>
	<div class="container col-md-5">
            <div class="card">
                <div class="card-body">
                    <c:if test="${user != null}">
                        <form action="update" method="post">
                    </c:if>
                    <c:if test="${user == null}">
                        <form action="insert" method="post">
                    </c:if>
                            <caption>
                                <h2>
                                    <c:if test="${user != null}">
                                        Edit User
                                    </c:if>
                                    <c:if test="${user == null}">
                                        Add New User
                                    </c:if>
                                </h2>
                            </caption>    
                            <c:if test="${user != null}">
                                <input type="hidden" name="userId" value="<c:out value='${user.userId}' />" />
                            </c:if>
                            <fieldset class="form-group">
                                <label>Enter Name</label> <input type="text" value="<c:out value='${user.name}'/>" class="form-control" name="name" required="required">
                            </fieldset>
                            <fieldset class="form-group">
                                <label>Enter Email</label> <input type="email" value="<c:out value='${user.email}' />" class="form-control" name="email" required="required">
                            </fieldset>
                            <fieldset class="form-group">
                                <label>Enter Password</label> <input type="password" value="<c:out value='${user.password}' />" class="form-control" name="password" required="required">
                            </fieldset> 
                            <fieldset class="form-group">
                                <label>Phone Number</label> <input type="text" value="<c:out value='${user.phone}' />" class="form-control" name="phone" required="required">
                            </fieldset>
                            <fieldset class="form-group">
                                <label>Enter Sex</label> <input type="text" value="<c:out value='${user.sex}' />" class="form-control" name="sex" required="required">
                            </fieldset>
                             <fieldset class="form-group">
                                <label>Enter Age</label> <input type="text" value="<c:out value='${user.age}' />" class="form-control" name="age" required="required">
                            </fieldset>
                            <button type="submit" class="btn btn-success">Save</button>
                        </form>
                </div>
            </div>
	</div>
    </body>
</html>
