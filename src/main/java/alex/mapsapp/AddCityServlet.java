package alex.mapsapp;

import alex.mapsapp.domain.CityDaoImpl;
import alex.mapsapp.exception.ValidationException;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AddCityServlet", urlPatterns = {"/addCity"})
public class AddCityServlet extends HttpServlet {

    CityDaoImpl cityDao = new CityDaoImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/add.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String cityName = req.getParameter("cityName");
        String cityLocation = req.getParameter("cityLocation");

        try {
            if (cityLocation == null) {
                throw new ValidationException("City name cannot be empty");
            }
            cityDao.addCity(cityName, Integer.parseInt(cityLocation));

        } catch (ValidationException e) {
            req.setAttribute("errMsgC", e.getLocalizedMessage());
            req.getRequestDispatcher("WEB-INF/add.jsp").forward(req, resp);
        } catch (NumberFormatException e) {
            req.setAttribute("errMsgC", "Location must be number format and not empty");
            req.getRequestDispatcher("WEB-INF/add.jsp").forward(req, resp);
        }

        req.setAttribute("success", "Operation successful");
        req.getRequestDispatcher("WEB-INF/add.jsp").forward(req, resp);
    }

}
