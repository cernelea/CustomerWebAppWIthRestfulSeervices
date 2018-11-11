<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<html>
<head>
    <title> Save customer </title>


</head>

<body>
<form:form action="saveCustomer" modelAttribute="newCustomer" method="post">
    <form:hidden path="id"/>

    <table>
        <tbody>
        <tr>
            <td>
                <label>First name: </label>
            </td>
            <td>
                <form:input path="firstName"/>

            </td>


        </tr>
        <tr>
            <td>
                <label>Last name: </label>
            </td>
            <td>
                <form:input path="lastName"/>

            </td>


        </tr>
        <tr>
            <td>
                <label>Email: </label>
            </td>
            <td>
                <form:input path="email"/>

            </td>
        </tr>

        <tr>
            <td>
                <label></label>
            </td>
            <td>
                <input type="submit" value="Save"/>

            </td>


        </tr>


        </tbody>


    </table>


</form:form>


</body>


</html>
