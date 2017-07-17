/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alex.mapsapp.domain;

/**
 *
 * @author hovercat
 */
 public interface RoadDao {
    
    void addRoad(String name, Integer location1, Integer location2) throws Exception;
    void removeRoad(Integer id);
    Road getRoadByLocation(Integer location1, Integer location2);
    
}
