package servlet;

import bo.Couleur;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/home")
public class ServletParameters extends HttpServlet {


    @Override
    public void init() throws ServletException {
       // super.init();
        ServletContext application = this.getServletContext();
        List<Couleur> listeCouleurs = new ArrayList<Couleur>();
        listeCouleurs.add(new Couleur("blanc","#FFFFFF"));
        listeCouleurs.add(new Couleur("bleu","#3380FF"));
        listeCouleurs.add(new Couleur("noir","#000000"));
        listeCouleurs.add(new Couleur("rouge","#DA0D0D"));
        listeCouleurs.add(new Couleur("orange","#EB7B12"));
       application.setAttribute("listeCouleurs", listeCouleurs);




    }

    public ServletParameters() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Couleur couleurSelected = (Couleur) req.getSession().getAttribute("couleurSelected");

        if (couleurSelected == null){
            req.getSession().setAttribute("couleurSelected",((List<Couleur>) this.getServletContext().getAttribute("listeCouleurs")).get(0));
        }
        this.getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

       List<Couleur> listeCouleurs = ( List<Couleur>)  this.getServletContext().getAttribute("listeCouleurs");
       String str = req.getParameter("couleurSelected");
      Couleur couleurSelected = listeCouleurs.stream().filter(c->c.getHexaCouleur().equals(str)).findFirst().orElse(null);

        req.getSession().setAttribute("couleurSelected", couleurSelected);

        this.getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(req, resp);
    }
}
