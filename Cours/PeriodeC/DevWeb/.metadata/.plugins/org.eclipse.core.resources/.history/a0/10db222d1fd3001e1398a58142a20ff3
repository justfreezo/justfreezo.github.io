<%@ taglib uri="jakarta.tags.core"  prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Statut</title>
</head>
<body>
<%
    String pNom = request.getParameter("pNom");
    String pAge = request.getParameter("pAge");
    if (pNom != null && pAge != null) {
%>
        <h1>Votre nom est : <%= pNom %></h1>
        <h1>Votre âge est : <%= pAge %></h1>
        <h1>Votre statut :</h1>
        <c:choose>
            <c:when test="${param.pAge lt 18}"> Vous êtes mineur</c:when>
            <c:when test="${param.pAge gt 65}"> Vous êtes âgé</c:when>
            <c:otherwise>Vous êtes majeur</c:otherwise>
        </c:choose>
        
<%
    } else {
%>
        <h1>Paramètres manquants</h1>
<%
    }
%>
</body>
</html>
