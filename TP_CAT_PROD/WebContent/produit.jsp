<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Produit</title>
<link rel="stylesheet" href="css/bootstrap.min.css" />
</head>
<body>
<%@include file="header.jsp" %>
<div class="container col-md-8 col-md-offset-2 col-xs-12">
     <div class="panel panel-primary">
          <div class="panel-heading"><h3>chercher des produits</h3></div>
          <div class="panel-body">
          <form action="chercher.php" method="get">
          <div class="input-group mb-3">
          <input name="monCle" value="${model.monCle }" type="text" class="form-control" placeholder="saisie votre produit" aria-label="Recipient's username" aria-describedby="button-addon2">
          <div class="input-group-append">
          <button   type="submit" class="btn btn-outline-secondary" type="button" id="button-addon2">chercher</button>
          </div>
          </div>
          </form>
          <table class="table table-striped">
                 <tr>
                        <th>Id</th><th>Designiation</th><th>prix</th><th>quantite</th><th>pour Supprimer</th><th>pour Modifier</th>
                </tr>
                 <c:forEach items="${model.prod}" var="p">
                 <tr>
                 <td>${p.id_prod }</td>
                 <td>${p.designiation }</td>
                 <td>${p.prix }</td>
                 <td>${p.quantite }</td>
                 <td><a href="Supprimer.php?id_prod=${p.id_prod }">Supprimer</a></td>
                 <td><a href="Edit.php?id_prod=${p.id_prod }">Edit</a></td>
                 </c:forEach>
                  </tr>
          </table>
          </div>
     </div>
</div>
</body>
</html>