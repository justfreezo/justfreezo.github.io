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
        <h1>Votre �ge est : <%= pAge %></h1>
        <h1>Votre statut :
        <c:choose>
            <c:when test="${param.pAge lt 18}"> Vous �tes mineur</c:when>
            <c:when test="${param.pAge gt 65}"> Vous �tes �g�</c:when>
            <c:otherwise>Vous �tes majeur</c:otherwise>
        </c:choose>
        </h1>
        
<%
    } else {
%>
        <h1>Param�tres manquants</h1>
<%
    }
%>
</body>
</html>
