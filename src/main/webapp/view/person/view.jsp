<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="address" value="${person.address}" />
<html>
    <head>
        <title>${person.name}</title>
    </head>
    <body>
        <h1>${person.name}</h1>
        <ul>            
            <li>${address.street}</li>
            <li>${address.city}, ${address.state} ${address.zip}</li>
        </ul>
        <h2>manager: ${person.manager.name}</h2>
        <h2>employer ${person.employer.name}</h2>
        <a href="${person.url}&edit">edit contact</a> |
        <a href="contacts">back to contacts list</a>
    </body>
</html>