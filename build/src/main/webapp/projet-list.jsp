<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> list de fotbool</title>
<link rel="stylesheet"
href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
integrity="sha384-gg0yROiXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQU0hcWr7x9JvoRxT2MZw1T"
crossorigin="anonymous">
</head>
<body>
  <header>
<nav class="navbar navbar-expand-md navbar-dark " style="background-color: blue"> 
<div>
<a herf="http://www.xadmin.net" class="navbar-brand"> gffdyhjlk</a>

</div>
<ul class="navbar-nav">
<li>
<a href="<%=request.getContextPath() %>/list" class="nav-link" >web</a>

</li></ul>

</nav>
  </header>
  
  <br>
  <div class="row">
  <div class="container">
  <h3 class="text-center">JOUEUR </h3>
  <hr>
  <div class="container text-left"> 
  
  <a herf="<%=request.getContextPath()%>/new"   class=" btn btn-success">hjhbjk</a>
  </div>
  <br>
  <table class="tablr table-bordered">
  <thead>
  <tr>
  <th>ID</th>
  <th>Numero</th>
  <th>Nom</th>
  <th>Poste</th>
  <th>Nationalite</th>
  <th> Salaire</th>
  <th>IDEquipe</th>
  <th> Actions</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach var ="joueur" items="${listJoueur}">
  
  <tr>
  <td><c:out value="${joueur.ID }" /></td>
  <td><c:out value="${joueur.Numero}"/></td>
  <td><c:out value="${ joueur.Nom}"/></td>
  <td><c:out value="${joueur.Poste }"/></td>
  <td><c:out value="${joueur.Nationalite }"/></td>
  <td><c:out value="${ joueur.Salaire}"/></td>
  <td><c:out value="${ joueur.IDEquipe}"/></td>
  <td><a herf="edit?ID=<c:out value='${joueur.ID }'/> " >Edit</a>
  &nbsp;&nbsp;&nbsp;&nbsp;<a herf="delete?ID=<c:out value='${joueur.ID }'/>">Delete</a></td>
  </tr>
  
  </c:forEach>
  </tbody>
  
  </table>
  </div>
  </div>
</body>
</html>