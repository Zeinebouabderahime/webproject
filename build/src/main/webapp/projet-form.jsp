<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
<div class="container col=md-5">
   <div class="card">
       <div class="card=body">
       <c:if test="${joueur != null }">
          <form action="update" method="post">
        </c:if>
        
          <c:if test="${joueur == null }">
          <form action="insert" method="post">
        </c:if>
        
          <caption>
             <h2>
                  <c:if test="${joueur != null }">
                        Edit joueur
                </c:if>             
                    <c:if test="${joueur == null }">
                      addnew joueur
                </c:if>             
             </h2>
          </caption>
          
           <c:if test="${joueur != null }">
                        <input type="hidden" name="ID" value="<c:out value='${joueur.ID }'/>" />
                </c:if>
          
          <fieldset class="form-group">
          <label>Numero</label> <input type="number" value="<c:out value='${joueur.Numero }'/>"  class="form=control" name="Number">
          </fieldset>
          
           <fieldset class="form-group">
          <label>Nom</label><input type="text" value="<c:out value='${joueur.Nom }'/>"  class="form=control" name="Nom">
          </fieldset>
           <fieldset>
          <label>Poste</label><input type="text" value="<c:out value='${joueur.Poste }'/>"  class="form=control" name="Poste">
          </fieldset>
          
           <fieldset class="form-group">
          <label>Nationalite</label><input type="text" value="<c:out value='${joueur.Nationalite }'/>"  class="form=control" name="Nationalite">
          </fieldset>
           <fieldset class="form-group">
          <label>Salaire</label><input type="number" value="<c:out value='${joueur.Salaire}'/>"  class="form=control" name="Salaire">
          </fieldset>
          
           <fieldset class="form-group">
          <label>IDEquipe</label><input type="number" value="<c:out value='${joueur.IDEquipe}'/>"  class="form=control" name="IDEquipe">
          
          </fieldset >
          <buttom type="submit" class="btn btn-success">SAVE</buttom>
          
          </form>
       </div>
   </div>
</div>

</body>
</html>