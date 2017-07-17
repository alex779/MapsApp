
package alex.mapsapp;

import alex.mapsapp.domain.RoadDaoImpl;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "RoadsServlet", urlPatterns = {"/roads"})
public class RoadsServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       req.setAttribute("roads", new RoadDaoImpl().getAllRoads());
        req.getRequestDispatcher("WEB-INF/roads.jsp").forward(req, resp);
    }
}
