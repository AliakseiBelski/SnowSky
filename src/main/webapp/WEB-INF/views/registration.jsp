<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
    <head>
        <title>Welcome to registration in SnowSky</title>
    </head>
    <body>
        <h3>Registration, fill in the fields</h3>
            <form:form method="POST" action="/registration" modelAttribute="registration">
            </form:form>
    </body>
</html>