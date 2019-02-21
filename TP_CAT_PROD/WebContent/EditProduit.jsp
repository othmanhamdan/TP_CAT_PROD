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
          <div class="panel-heading"><h3>Modifier le Produit</h3></div>
          <div class="panel-body">
          <form action="UpdateProduit.php" method="post">
                 <div class="form-group">
                  <div class="form-group">
                 <label class="control-label"><h4>Id :</h4></label>
                 <input class="form-control" value="${Editproduits.id_prod }" type="hidden" name="id_prod"/>
                 <label>${Editproduits.id_prod }</label>
                 <span></span>
           </div>
                 <label class="control-label"><h4>Désigniation :</h4></label>
                 <input class="form-control" value="${Editproduits.designiation }" type="text" name="Designiation" required="required"/>
                 <span></span>
           </div>
            <div class="form-group">
                 <label class="control-label"><h4>Prix :</h4></label>
                 <input class="form-control" value="${Editproduits.prix }" type="text" name="Prix"/>
                 <span></span>
           </div>
            <div class="form-group">
                 <label class="control-label"><h4>Quantité :</h4></label>
                 <input class="form-control" value="${Editproduits.quantite }"type="text" name="Quantite"/>
                 <span></span>
           </div>
           <button type="submit" class="btn btn-primary">Save</button>
          </form>
          </div>
     </div>
</div>
</body>
</html>