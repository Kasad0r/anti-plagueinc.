package org.kasad0r.domain;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Region {
    private String name;
    private long population;
    private long deaths;
    private long recovered;
    private long infected;
    private boolean closedAirports;
    private boolean closedPorts;
    private Color currentColorContagion;

    private List<Point> airportsCoords;
    private List<Point> portsCoords;
    public List<Point> regionFillCords;

    public Region() {
        airportsCoords = new ArrayList<>();
        portsCoords = new ArrayList<>();
        regionFillCords = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public long getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public long getRecovered() {
        return recovered;
    }

    public void setRecovered(int recovered) {
        this.recovered = recovered;
    }

    public Color getCurrentColorContagion() {
        return currentColorContagion;
    }

    public List<Point> getRegionFillCords() {
        return regionFillCords;
    }

    public void setRegionFillCords(List<Point> regionFillCords) {
        this.regionFillCords = regionFillCords;
    }

    public void setCurrentColorContagion(Color currentColorContagion) {
        this.currentColorContagion = currentColorContagion;
    }

    public List<Point> getAirportsCoords() {
        return airportsCoords;
    }

    public void setAirportsCoords(List<Point> airportsCoords) {
        this.airportsCoords = airportsCoords;
    }

    public List<Point> getPortsCoords() {
        return portsCoords;
    }

    public void setPortsCoords(List<Point> portsCoords) {
        this.portsCoords = portsCoords;
    }

    public void setDeaths(long deaths) {
        this.deaths = deaths;
    }

    public void setRecovered(long recovered) {
        this.recovered = recovered;
    }

    public long getInfected() {
        return infected;
    }

    public void setInfected(long infected) {
        this.infected = infected;
    }

    public boolean isClosedPorts() {
        return closedPorts;
    }

    public void setClosedPorts(boolean closedPorts) {
        this.closedPorts = closedPorts;
    }

    public boolean isClosedAirports() {
        return closedAirports;
    }

    public void setClosedAirports(boolean closedAirports) {
        this.closedAirports = closedAirports;
    }
}
