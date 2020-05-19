package org.kasad0r.domain;

import org.kasad0r.RaceType;
import org.kasad0r.TransportController;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class ShipRace extends Race implements Cloneable {
    public List<Point> way;
    public int currentPoint = 0;

    public void clean() {
        currentPoint = 0;
        setCurrentPosition(null);
        setStartPoint(null);
        setEndPoint(null);
        updateTotalTime();
    }

    public double getShipPosAngle() {
        return Math.atan2(way.get(currentPoint + 1).getY() - way.get(currentPoint).getY(),
                way.get(currentPoint + 1).getX() - way.get(currentPoint).getX());
    }

    public void updateTotalTime() {
        totalTime = (int) (TransportController.dist(way.get(currentPoint).x, way.get(currentPoint).y,
                way.get(currentPoint + 1).x, way.get(currentPoint + 1).y)) * 6;
    }

    public ShipRace() {
        way = new ArrayList<>();
        time = 0;
        super.setRaceType(RaceType.WATER);
        img = TransportController.imgShips.get(new Random().nextInt(TransportController.imgShips.size()));
    }

    public Point getWhooleLastPoints() {
        return way.get(way.size() - 1);
    }

    public Point getStartsPoints() {
        return way.get(currentPoint);
    }

    public Point getLastPointOfPart() {
        return way.get(currentPoint + 1);
    }

    public void nextPoints() {
        currentPoint++;
        //   System.out.println(currentPoint);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShipRace shipRace = (ShipRace) o;
        return currentPoint == shipRace.currentPoint &&
                Objects.equals(way, shipRace.way);
    }

    @Override
    public int hashCode() {
        return Objects.hash(way, currentPoint);
    }
}
