<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<head>
    <title>Welcome to SnowSky</title>
    <link type="text/css" rel="stylesheet" href="/webjars/bootstrap/4.3.1/css/bootstrap.min.css">
    <style>
        body, .container {
          margin: 0;
          padding: 0;
          height: 100%;
        }
        body{
          background-image: url(images/StartingPicture.jpg);
          background-position: center center;
          background-repeat: no-repeat;
          background-attachment: fixed;
          background-size: cover;
          background-color: #464646;
        }
        .container {
          display: table;
          width: 100%;
        }
        .content {
          display: table-cell;
          vertical-align: middle;
          text-align: center;
        }
      </style>
</head>
    <body>
        <h1><p align="center">Welcome to the SnowSky!</p></h1>
        <h3>Enter your name and password</h1>
        	<form:form method="POST" action="/SnowSky/user" modelAttribute="account">
        		<table>
        		    <tr>
        			    <td><form:label path="login">Login</form:label></td>
        			    <td><form:input type="text" path="login"/></td>
        			    <font color="red"> <form:errors path="login" class="control-label"/></font>
        			</tr>
        			<tr>
           			    <td><form:label path="password">Password</form:label></td>
        			    <td><form:input type="password" path="password"/></td>
        			    <font color="red"> <form:errors path="password" class="control-label"/></font>
        			</tr>
        			<tr>
                        <td><input type="submit" value="Submit"/></td>
        	</form:form>
        	<form action="/SnowSky/registration" method="GET">
                        <td><input type="submit" value="Registration"/></td>
                    </tr>
                </table>
           	</form>
    </body>
</html>