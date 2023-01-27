<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8" />
<title>Registrazione</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

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
                <a class="nav-link active" href="insert.jsp">Registrazione</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="Lettura">Lista Utenti</a>
              </li>
            </ul>
          </div>
        </div>
      </nav>
      
      
      <div class="card text-center" style="width: fit-content; margin: auto; margin-top: 100;">
  <div class="card-body">
  <form action="Inserimento" method="POST">
  <div class="mb-3">
    <label for="nome" class="form-label">Nome</label>
    <input type="nome" class="form-control" id="nome" name="nome">
  </div>
  <div class="mb-3">
    <label for="cognome" class="form-label">Cognome</label>
    <input type="text" class="form-control" id="cognome" name="cognome">
  </div>
  <div class="mb-3">
    <label for="eta" class="form-label">Età</label>
    <input type="number" class="form-control" id="eta" name="eta">
  </div>
  <button type="submit" class="btn btn-primary">Lets go</button>
</form>
  </div>
</div>




<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
</body>
</html>