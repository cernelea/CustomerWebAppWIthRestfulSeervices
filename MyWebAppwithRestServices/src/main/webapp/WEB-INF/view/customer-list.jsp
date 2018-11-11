<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>


    <title>Customer List</title>


    Customer Table-List
    <br><br>

</head>

<body>

<input type="button" value="Add Customer"
       onclick="window.location.href='addForm';return false;"/>


<table>


    <tr>
        <th>First name</th>
        <th> Last name</th>
        <th>email</th>
        <th>action</th>


    </tr>

    <c:forEach var="customer" items="${customerList}">
        <c:url var="updateLink" value="/customer/showFormForUpdate">

            <c:param name="customerId" value="${customer.id}"/>

        </c:url>
        <c:url var="deleteLink" value="/customer/delete">

            <c:param name="customerId" value="${customer.id}"/>


        </c:url>


        <tr>
            <td>${customer.firstName}</td>
            <td>${customer.lastName}</td>
            <td>${customer.email}</td>
            <td>

                <a href="${updateLink}"> Update Customer</a>
                <a href="${deleteLink}"
                   onclick="if(!(confirm('Are you sure you want to delete this customer: ${customer.firstName} ${customer.lastName}'))) return false">
                    Delete Customer
                </a>

            </td>


        </tr>


    </c:forEach>


</table>
<br><br>

<a href="/api/customers">Rest Api</a>


</body>


</html>