<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8" />
<title>Utenti</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>

  <nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
      <a class="navbar-brand" href="#">TOP SITO FORTISSIMO</a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
          <li class="nav-item">
            <a class="nav-link" aria-current="page" href="home.jsp">Home</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="insert.jsp">Registrazione</a>
          </li>
          <li class="nav-item">
            <a class="nav-link active" href="Lettura">Lista Utenti</a>
          </li>
          <li>
           <form action="Cerca" class="form-inline my-2 my-lg-0">
           <input class="form-control mr-sm-2" type="number" placeholder="ID" aria-label="Search" name="id" value="${id }">
      <input class="form-control mr-sm-2" type="text" placeholder="Nome" aria-label="Search" name="nome" value="${nome }">
      <input class="form-control mr-sm-2" type="text" placeholder="Cognome" aria-label="Search" name="cognome" value="${cognome }">
      <input class="form-control mr-sm-2" type="number" placeholder="Età" aria-label="Search" name="eta" value="${eta }">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Cerca</button>
    </form>
    </li>
        </ul>
      </div>
    </div>
  </nav>
  
  
  <table class="table">
  <thead class="table-warning">
    <tr class="table-warning">
      <th class="table-warning" scope="col">ID</th>
      <th class="table-warning" scope="col">Nome</th>
      <th class="table-warning" scope="col">Cognome</th>
      <th class="table-warning" scope="col">Età</th>
      <th class="table-warning" scope="col"></th>
    </tr>
  </thead>
  <tbody class="table-warning">
  
  <c:forEach items="${ls}" var="ls"> 
  <tr class="table-warning">
  <td class="table-warning">${ls.id }</td>
      <td class="table-warning">${ls.nome }</td>
      <td class="table-warning">${ls.cognome }</td>
      <td class="table-warning">${ls.eta }</td>
      <td class="table-warning"> <a href="Cancella?id=${ls.id }"> 
       <button class="btn btn-primary">Cancella</button> <a href="CaricaModifica?id=${ls.id}&nome=${ls.nome}&cognome=${ls.cognome}&eta=${ls.eta}"> <button class="btn btn-primary">Modifica</button> </a></td>
      
    </tr>
  </c:forEach>
    
  </tbody>
</table>

 

 
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
</body>
</html>