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
          <div class="panel-heading"><h3>Confirmation</h3></div>
          <div class="panel-body">
              <div class="form-group">
                   <label>Id :</label>
                   <label>${produit.id_prod}</label>
             </div>
              <div class="form-group">
                   <label>Désigniation :</label>
                   <label>${produit.designiation}</label>
             </div>
              <div class="form-group">
                   <label>Prix :</label>
                   <label>${produit.prix}</label>
             </div>
              <div class="form-group">
                   <label>Quantité :</label>
                   <label>${produit.quantite}</label>
             </div>
          </div>
     </div>
</div>
</body>
</html>