
package alex.mapsapp;

import alex.mapsapp.domain.City;
import alex.mapsapp.domain.CityDaoImpl;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "EditServlet", urlPatterns = {"/edit"})
public class CityEditServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CityDaoImpl dao = new CityDaoImpl();
        City city = dao.getCityById(Integer.parseInt(req.getParameter("id")));
        city.setName(req.getParameter("cityName"));
        dao.editCity(city);
        resp.sendRedirect("cities");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = 0;
        try {
            id = Integer.parseInt(req.getParameter("id"));
        } catch (NumberFormatException e) {
            resp.sendRedirect("cities");
        }
        req.setAttribute("city", new CityDaoImpl().getCityById(id));
        req.getRequestDispatcher("WEB-INF/editCity.jsp").forward(req, resp);
    }
}
