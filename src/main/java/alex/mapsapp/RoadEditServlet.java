package alex.mapsapp;

import alex.mapsapp.domain.Road;
import alex.mapsapp.domain.RoadDaoImpl;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "RoadEditServlet", urlPatterns = {"/roadEdit"})
public class RoadEditServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RoadDaoImpl dao = new RoadDaoImpl();
        Road road = dao.getRoadById(Integer.parseInt(req.getParameter("id")));
        road.setName(req.getParameter("roadName"));
        dao.editRoad(road);
        resp.sendRedirect("roads");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = 0;
        try {
            id = Integer.parseInt(req.getParameter("id"));
        } catch (NumberFormatException e) {
            resp.sendRedirect("roads");
        }
        req.setAttribute("road", new RoadDaoImpl().getRoadById(id));
        req.getRequestDispatcher("WEB-INF/editRoad.jsp").forward(req, resp);
    }
}
