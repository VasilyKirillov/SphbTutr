<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="address" value="${office.address}" />
<html>
    <head>
        <title>edit office</title>
    </head>
    <body>
        <h1>edit office</h1>
        <form action="office" method="post">
            <input type="hidden" name="edit">
            <input type="hidden" name="id" value="${office.id}">
            <ul>
                <li>name: <input type="text" name="name" value="${office.name}"></li>
                <li>street: <input type="text" name="street" value="${address.street}"></li>
                <li>city: <input type="text" name="city" value="${address.city}"></li>
                <li>state: <input type="text" name="state" value="${address.state}"></li>
                <li>zip: <input type="text" name="zip" value="${address.zip}"></li>
            </ul>
            <input type="submit" value="edit">
        </form>
        <form action="office" method="post">
            <input type="hidden" name="delete">
            <input type="hidden" name="id" value="${office.id}">
            <input type="hidden" name="company_id" value="${office.company.id}">
            <input type="submit" value="delete">
        </form>
        <a href="${office.url}">back to ${office.name}</a>
    </body>
</html>