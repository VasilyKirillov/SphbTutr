<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="address" value="${person.address}" />
<html>
    <head>
        <title>edit person</title>
    </head>
    <body>
        <h1>edit person</h1>
        <form action="person" method="post">
            <input type="hidden" name="edit">
            <input type="hidden" name="id" value="${person.id}">
            <ul>
                <li>name: <input type="text" name="name" value="${person.name}"></li>
                <li>street: <input type="text" name="street" value="${address.street}"></li>
                <li>city: <input type="text" name="city" value="${address.city}"></li>
                <li>state: <input type="text" name="state" value="${address.state}"></li>
                <li>zip: <input type="text" name="zip" value="${address.zip}"></li>
                <li>
                    manager:
                    <select name="manager_id">
                        <option value="0">none</option>
                        <c:forEach items="${managers}" var="manager">
                            <c:if test="${person ne manager}">
                                <option value="${manager.id}" ${manager eq person.manager ? 'selected' : ''}>
                                    ${manager.name}
                                </option>
                            </c:if>                                
                        </c:forEach>
                    </select>
                </li>
                <li>
                    employer:
                    <select name="employer_id">
                        <option value="0">none</option>
                        <c:forEach items="${employers}" var="employer">
                            <option value="${employer.id}" ${employer eq person.employer ? 'selected' : ''}>
                                ${employer.name}
                            </option>                                
                        </c:forEach>
                    </select>
                </li>
            </ul>
            <input type="submit" value="edit">
        </form>
        <form action="person" method="post">
            <input type="hidden" name="delete">
            <input type="hidden" name="id" value="${person.id}">
            <input type="submit" value="delete">
        </form>
        <a href="contacts">back to contacts list</a>
    </body>
</html>