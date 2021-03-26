<%@ page import="bo.Couleur" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Téo
  Date: 26/03/2021
  Time: 15:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>


<head>
    <title>Title</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://bootswatch.com/4/simplex/bootstrap.min.css">
    <link rel="stylesheet" href="/administration/decoration/style.css">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
    <%
        List<Couleur> listeCouleur = (List<Couleur>) application.getAttribute("listeCouleurs");
        Couleur couleurSelected = (Couleur) request.getSession().getAttribute("couleurSelected");

    %>
</head>
<body style="background: <%=couleurSelected.getHexaCouleur()%>">

<form action="home" method="post">


    <div class="form-group row justify-content-center mt-4">
        <select name="couleurSelected" class="form-select col-4" aria-label="Default select example">
            <%
                for (Couleur couleur: listeCouleur ) {
                    if(couleur == couleurSelected) {
                        out.print("<option  value=\"" + couleur.getHexaCouleur()+ "\" selected>" + couleur.getNomCouleur() + "</option>");
                    }
                    else{
                        out.print( "<option  value=\""+couleur.getHexaCouleur()+"\" >"+couleur.getNomCouleur()+"</option>");

                      }

                }
            %>


        </select>

        <button class="col-4 " type="submit">Valider</button>

    </div>

    <div class="form-group row justify-content-center mt-4">
        <label>Vous êtes venus X fois</label>

    </div>


</form>


</body>
</html>
