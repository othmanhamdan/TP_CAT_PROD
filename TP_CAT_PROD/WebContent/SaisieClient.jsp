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
          <div class="panel-heading"><h3>Saisie d'un Client</h3></div>
          <div class="panel-body">
          <form action="AjouterClient.php" method="post">
               <div class="form-group">
                 <label class="control-label"><h4>Nom :</h4></label>
                 <input class="form-control" value="${cli.nom }" type="text" name="nom" required="required"/>
                 <span></span>
           </div>
            <div class="form-group">
                 <label class="control-label"><h4>Prenom :</h4></label>
                 <input class="form-control" value="${cli.prenom }" type="text" name="prenom" required="required"/>
                 <span></span>
           </div>
            <div class="form-group">
                 <label class="control-label"><h4>Adresse :</h4></label>
                 <input class="form-control" value="${cli.adresse }"type="text" name="adresse" required="required"/>
                 <span></span>
           </div>
           <div class="form-group">
                 <label class="control-label"><h4>Email :</h4></label>
                 <input class="form-control" value="${cli.email }"type="email" name="email" required="required"/>
                 <span></span>
           </div>  
           <div class="form-group">
                 <label class="control-label"><h4>Telephone :</h4></label>
                 <input class="form-control" value="${cli.tele }"type="text" name="tele" required="required"/>
                 <span></span>
           </div>  
           <div class="form-group">
                 <label class="control-label"><h4>Mot de passe :</h4></label>
                 <input class="form-control" value="${cli.motPass }"type="text" name="motPass" required="required"/>
                 <span></span>
           </div> 
           <button type="submit" class="btn btn-primary">Save</button>
          </form>
          </div>
     </div>
</div>
</body>
</html>