
package alex.mapsapp;

import alex.mapsapp.domain.Road;
import alex.mapsapp.domain.RoadDaoImpl;
import alex.mapsapp.exception.ValidationException;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AddRoadServlet", urlPatterns = {"/addRoad"})
public class AddRoadServlet extends HttpServlet {

    RoadDaoImpl roadDao = new RoadDaoImpl();

    Road road = new Road();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/add.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String roadName = req.getParameter("roadName");
        String roadLocation1 = req.getParameter("roadLocation1");
        String roadLocation2 = req.getParameter("roadLocation2");

        try {
            if (roadLocation1 == null || roadLocation2 == null) {
                throw new ValidationException("Road location cannot be empty");
            }
            roadDao.addRoad(roadName, Integer.parseInt(roadLocation1), Integer.parseInt(roadLocation2));
        } catch (ValidationException e) {
            req.setAttribute("errMsgR", e.getLocalizedMessage());
            req.getRequestDispatcher("WEB-INF/add.jsp").forward(req, resp);
        } catch (NumberFormatException e) {
            req.setAttribute("errMsgR", "Location must be number format and not empty");
            req.getRequestDispatcher("WEB-INF/add.jsp").forward(req, resp);
        }

        req.setAttribute("success", "Operation successful");
        req.getRequestDispatcher("WEB-INF/add.jsp").forward(req, resp);
    }

}
