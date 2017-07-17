package alex.mapsapp.domain;

import alex.mapsapp.config.HibernateUtil;
import alex.mapsapp.exception.ValidationException;
import java.util.ArrayList;
import java.util.List;
import javafx.util.Pair;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class CityDaoImpl implements CityDao {

    private static final CityDaoImpl cityDao = new CityDaoImpl();
    private static final RoadDaoImpl roadDao = new RoadDaoImpl();

    @Override
    public void addCity(String name, Integer location) throws ValidationException {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        City city = new City(name, location);

        try {
            trns = session.beginTransaction();
            if (getCityByLocation(city.getLocation()) == null) {
                session.save(city);
            } else {
                throw new ValidationException("Wrong location");
            }
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }

    @Override
    public void removeCity(Integer id) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            City city = (City) session.load(City.class, id);
//            city.getRoadList().clear();
//            city.getRoadList1().clear();
//            session.save(city);
//TODO СДЕЛАТЬ КАСКАДНОЕ УДАЛЕНИЕ
            roadDao.removeRoads(city.getRoadList());
            roadDao.removeRoads(city.getRoadList1());

            session.delete(city);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }

    @Override
    public City getCityById(Integer id) {
        City city = null;
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            city = (City) session.createCriteria(City.class)
                    .add(Restrictions.eq("id", id)).uniqueResult();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return city;
    }

    @Override
    public City getCityByLocation(Integer location) {
        City city = null;
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            city = (City) session.createCriteria(City.class)
                    .add(Restrictions.eq("location", location)).uniqueResult();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return city;
    }

    public Pair<List<Road>, List<Road>> getRoadList(Integer id) {

        return new Pair<>(cityDao.getCityById(id).getRoadList(), cityDao.getCityById(id).getRoadList1());

    }

    public List<City> getAllCities() {

        List<City> cities = new ArrayList<>();
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            cities = session.createCriteria(City.class).list();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return cities;
    }

    public void editCity(City city) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.update(city);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }

}
