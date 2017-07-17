
package alex.mapsapp;

import alex.mapsapp.domain.RoadDaoImpl;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "RoadDeleteServlet", urlPatterns = {"/roadDelete"})
public class RoadDeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        new RoadDaoImpl().removeRoad(Integer.parseInt(req.getParameter("id")));
        resp.sendRedirect("roads");
    }
}