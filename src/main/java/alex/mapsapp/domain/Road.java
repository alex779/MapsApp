/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alex.mapsapp.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author hovercat
 */
@Entity
@Table(name = "Road")
@NamedQueries({
    @NamedQuery(name = "Road.findAll", query = "SELECT r FROM Road r")})
public class Road implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Location1")
    private int location1;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Location2")
    private int location2;
    @JoinColumn(name = "City_id", referencedColumnName = "id")
    @ManyToOne(fetch=FetchType.EAGER, optional = false)
    private City cityid;
    @JoinColumn(name = "City_id1", referencedColumnName = "id")
    @ManyToOne(fetch=FetchType.EAGER, optional = false)
    private City cityid1;

    public Road() {
    }

    public Road(Integer id) {
        this.id = id;
    }

    public Road(String name, int location1, int location2) {
        this.name = name;
        this.location1 = location1;
        this.location2 = location2;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLocation1() {
        return location1;
    }

    public void setLocation1(int location1) {
        this.location1 = location1;
    }

    public int getLocation2() {
        return location2;
    }

    public void setLocation2(int location2) {
        this.location2 = location2;
    }

    public City getCityid() {
        return cityid;
    }

    public void setCityid(City cityid) {
        this.cityid = cityid;
    }

    public City getCityid1() {
        return cityid1;
    }

    public void setCityid1(City cityid1) {
        this.cityid1 = cityid1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Road)) {
            return false;
        }
        Road other = (Road) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Road ID: " + id + ", " + "Locations: " + location1 + ", " + location2;
    }
    
}
