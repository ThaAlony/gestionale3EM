<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Utenti</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>



<table class="table-primary">
  <thead>
    <tr>
    <th scope="col">ID</th>
      <th scope="col">Nome</th>
      <th scope="col">Cognome</th>
      <th scope="col">Età</th>
    </tr>
  </thead>
  <c:forEach items="${ls}" var="ls">
  <tr>
  	<th scope="row">${ls.id}</th>
      <th scope="row">${ls.nome}</th>
      <th scope="row">${ls.cognome}</th>
      <th scope="row">${ls.eta}</th>
      <th scope="row"> 
      <form method="POST" action="Cancella">
      <input type="hidden" name="id" value="${ls.id}">
       <button class="btn btn-primary">Cancella</button>
       </form>
       
       <a href="CaricaModifica?id=${ls.id}&nome=${ls.nome}&cognome=${ls.cognome}&eta=${ls.eta}"> <button class="btn btn-primary">Modifica</button> </a>
       
       <!--   
       <form action="update.jsp" method="POST">
      <input type="hidden" name="id" value="${ls.id}">
      <input type="hidden" name="nome" value="${ls.nome}">
      <input type="hidden" name="cognome" value="${ls.cognome}">
      <input type="hidden" name="eta" value="${ls.eta}">
       <button class="btn btn-primary">Update</button>
       </form>
       -->
      
      </th>
      
          </tr>
    </c:forEach>
  <tbody>
    
  </tbody>
</table>

<form action="home.jsp"> <button class="btn btn-primary">Home</button></form>




<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>

</body>
</html>