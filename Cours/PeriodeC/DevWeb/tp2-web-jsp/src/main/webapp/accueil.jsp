<!DOCTYPE html>
<html>
<head>
    <title>Accueil</title>
</head>
<body>
<%
    String pNom = request.getParameter("pNom");
    String pAge = request.getParameter("pAge");
    if (pNom != null && pAge != null) {
%>
        <h1>Bonjour <%= pNom %>, vous avez <%= pAge %> ans !</h1>
<%
    } else {
%>
        <h1>Paramètres manquants</h1>
<%
    }
%>
</body>
</html>
