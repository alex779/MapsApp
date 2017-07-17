/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alex.mapsapp.domain;

import alex.mapsapp.config.HibernateUtil;
import alex.mapsapp.exception.ValidationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author hovercat
 */
public class RoadDaoImpl implements RoadDao {

    private static final CityDaoImpl cityDao = new CityDaoImpl();

    @Override
    public void addRoad(String name, Integer location1, Integer location2) throws ValidationException {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        Road road = new Road(name, location1, location2);
        road.setCityid(cityDao.getCityByLocation(location1));
        road.setCityid1(cityDao.getCityByLocation(location2));
        try {
            trns = session.beginTransaction();
            if (roadCheck(road)) {
                session.save(road);
            } else {
                throw new ValidationException("Cannot create route");
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

    public boolean roadCheck(Road road) {
        boolean result = false;
        Integer location1 = road.getLocation1();
        Integer location2 = road.getLocation2();
        Integer cityLoc = road.getCityid().getLocation();

        if (cityLoc + 1 == location2 || cityLoc - 1 == location2) { //начало или конец дороги совпадает с координатами города
            if (!Objects.equals(location1, location2)) { //координаты не совпадают друг с другом
                if (cityDao.getCityByLocation(location1) != null
                        && cityDao.getCityByLocation(location2) != null) { //координаты уже существуют
                    if (getRoadByLocation(location1, location2) == null) { //данная дорога еще не существует
                        if (location1 + 1 == location2
                                || location1 - 1 == location2) { //данная дорога соединяет только сосдение города
                            result = true;
                        }
                    }
                }
            }
        }

        return result;
    }

    @Override
    public void removeRoad(Integer id) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            Road road = (Road) session.load(Road.class, id);
            session.delete(road);
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
    public Road getRoadByLocation(Integer location1, Integer location2) {
        Road road = null;
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            road = (Road) session.createCriteria(Road.class)
                    .add(Restrictions.eq("location1", location1)).add(Restrictions.eq("location2", location2)).uniqueResult();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return road;
    }

    public List<Road> getAllRoads() {

        List<Road> roads = new ArrayList<>();
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            roads = session.createCriteria(Road.class).list();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return roads;
    }

    public Road getRoadById(Integer id) {
        Road road = null;
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            road = (Road) session.createCriteria(Road.class)
                    .add(Restrictions.eq("id", id)).uniqueResult();
//            Hibernate.initialize(road.getCityid());
//            Hibernate.initialize(road.getCityid1());
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return road;
    }

    public void editRoad(Road road) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.update(road);
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

    public void removeRoads(List<Road> list) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();

            for (Road road : list) {
                session.delete(road);
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
}
