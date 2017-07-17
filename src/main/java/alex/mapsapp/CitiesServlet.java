
package alex.mapsapp;

import alex.mapsapp.domain.CityDaoImpl;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hovercat
 */
@WebServlet(name = "CitiesServlet", urlPatterns = {"/cities"})
public class CitiesServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("cities", new CityDaoImpl().getAllCities());
        req.getRequestDispatcher("WEB-INF/cities.jsp").forward(req, resp);
    }
}
