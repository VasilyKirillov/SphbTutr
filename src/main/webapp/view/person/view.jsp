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
        <a href="${person.url}&edit">edit contact</a> |
        <a href="contacts">back to person list</a>
    </body>
</html>