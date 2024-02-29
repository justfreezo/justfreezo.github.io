<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
    <title>Catalogue</title>
</head>
<body>
    <h1>Catalogue de produits</h1>
    
    <form action="Catalogue" method="post">
        <label for="nomProd">Nom du produit :</label>
        <input type="text" id="nomProd" name="nomProd">
        <button type="submit">Ajouter un produit</button>
    </form>
</body>
</html>