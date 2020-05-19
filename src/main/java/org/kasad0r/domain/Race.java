package org.kasad0r.domain;

import org.kasad0r.TransportController;
import org.kasad0r.RaceType;

import java.awt.*;
import java.util.Random;

public class Race implements Cloneable {
    private Region regionFrom;
    private Region regionTo;
    private Point startPoint;
    private Point endPoint;
    private Point currentPosition;
    private RaceType raceType;
    public int time;
    public int totalTime;
    public Image img;
    public boolean infected = false;

    public Race() {

    }

    public Region getRegionFrom() {
        return regionFrom;
    }

    public void setRegionFrom(Region regionFrom) {
        this.regionFrom = regionFrom;
    }

    public Region getRegionTo() {
        return regionTo;
    }

    public void setRegionTo(Region regionTo) {
        this.regionTo = regionTo;
    }

    @Override
    public String toString() {
        return "Race{" +
                "startPoint=" + startPoint +
                ", endPoint=" + endPoint +
                ", currentPosition=" + currentPosition +
                '}';
    }

    public void infect() {
        infected = true;
        img = TransportController.imgInfectedPlanes.get(new Random().nextInt(TransportController.imgInfectedPlanes.size()));
    }

    private double angle;

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    public Image getRaceImage() {
        return raceImage;
    }

    public void setRaceImage(Image raceImage) {
        this.raceImage = raceImage;
    }

    private Image raceImage;

    public Point getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(Point startPoint) {
        this.startPoint = startPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(Point endPoint) {
        this.endPoint = endPoint;
    }

    public RaceType getRaceType() {
        return raceType;
    }

    public void setRaceType(RaceType raceType) {
        this.raceType = raceType;
    }

    public Race(Point startPoint, Point endPoint, RaceType raceType) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.raceType = raceType;
        this.angle = Math.atan2(endPoint.getY() - startPoint.getY(), endPoint.getX() - startPoint.getX());
        time = 0;
        totalTime = (int) (TransportController.dist(startPoint.x, startPoint.y, endPoint.x, endPoint.y));
        this.img = TransportController.imgPlanes.get(new Random().nextInt(TransportController.imgPlanes.size()));
    }

    public Point getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(Point currentPosition) {
        this.currentPosition = currentPosition;
    }
}
