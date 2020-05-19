package org.kasad0r;

import org.kasad0r.domain.Race;
import org.kasad0r.domain.Region;
import org.kasad0r.domain.ShipRace;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static org.kasad0r.EpidemicController.infectRegion;

public class TransportController {
    private static double chanceStartRaceAir = 0.05;
    private static double chanceStartRaceShip = 0.03;
    public static Image airPortImage;
    public static Image portImage;


    public static List<Image> imgPlanes = new ArrayList<>() {{
        try {
            add(ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("airplane-2.png"))
                    .getScaledInstance(20, 20, Image.SCALE_SMOOTH));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }};
    public static List<Image> imgInfectedPlanes = new ArrayList<>() {{
        try {
            add(ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("airplane-2-infected.png"))
                    .getScaledInstance(20, 20, Image.SCALE_SMOOTH));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }};
    public static List<Image> imgShips = new ArrayList<>() {{
        try {
            add(ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("ship.png"))
                    .getScaledInstance(40, 15, Image.SCALE_SMOOTH));
            add(ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("ship2.png"))
                    .getScaledInstance(40, 15, Image.SCALE_SMOOTH));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }};

    public TransportController() {
        try {
            portImage = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("port.png"))
                    .getScaledInstance(25, 30, 0);
            airPortImage = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("airport.png"))
                    .getScaledInstance(30, 30, 0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Race> generatePlanesRaces() {
        ArrayList<Race> result = new ArrayList<Race>();
        var random = new Random();
        var worldRegionsList = RegionData.worldRegionsList;
        for (Region startRegion : worldRegionsList) {
            if (startRegion.getPopulation() != 0) {
                for (Point airport : startRegion.getAirportsCoords()) {
                    Region regionEnd =
                            worldRegionsList
                                    .get(random.nextInt(worldRegionsList.size()));
                    Point endRace = regionEnd.getAirportsCoords()
                            .get(random.nextInt(regionEnd.getAirportsCoords().size()));
                    Race race = new Race(airport, endRace, RaceType.AIR);
                    race.setRegionFrom(startRegion);
                    race.setRegionTo(regionEnd);
                    if (EpidemicController.infectPlane(startRegion)) {
                        race.infect();
                    }
                    result.add(race);
                }
            }
        }
        return result;
    }

    public List<ShipRace> generateShipRaces() {
        List<ShipRace> result = new ArrayList<>();
        List<ShipRace> shipRaces = ShipRaceWayMap.shipRaces;
        int count = 1;
        int size = shipRaces.size();
        while (count <= size) {
            ShipRace shipRace = shipRaces.get(count - 1);

            result.add(shipRace);
            count++;

        }
        return result;
    }

    public void renderPlane(Race race, Graphics g) {

        if (race.getCurrentPosition() == null) {
            race.setCurrentPosition(race.getStartPoint());
        }
        if (race.getRaceType() == RaceType.AIR) {
            if (race.getCurrentPosition() != race.getEndPoint()) {
                Graphics2D graphics2D = (Graphics2D) g;
                AffineTransform tr = graphics2D.getTransform();
                tr.translate(race.getCurrentPosition().x, race.getCurrentPosition().y);
                tr.rotate(Math.atan2(race.getEndPoint().getY() - race.getCurrentPosition().getY(),
                        race.getEndPoint().getX() - race.getCurrentPosition().getX()));
                tr.translate(-50 / 2d, -50 / 2d);
                graphics2D.drawImage(race.img, tr, null);

                tr.translate(-race.getCurrentPosition().getX() + 50 / 2d,
                        -race.getCurrentPosition().getY() + 50 / 2d);
            }
        }
    }

    public void renderShips(ShipRace shipRace, Graphics g) {
        Point currPos = shipRace.getCurrentPosition();

        if (currPos == null) {
            shipRace.setCurrentPosition(shipRace.getStartsPoints());
            currPos = shipRace.getCurrentPosition();
        }
        if (shipRace.getRaceType() == RaceType.WATER) {
            if (currPos != shipRace.getLastPointOfPart()) {
                Graphics2D graphics2D = (Graphics2D) g;
                AffineTransform tr = graphics2D.getTransform();
                tr.translate(currPos.x - 15, currPos.y - 15);
                tr.rotate(Math.atan2(shipRace.getLastPointOfPart().getY() - currPos.getY(),
                        shipRace.getLastPointOfPart().getX() - currPos.getX()));
                tr.translate(-50 / 2d, -50 / 2d);
                graphics2D.drawImage(shipRace.img, tr, null);

                tr.translate(-currPos.getX() + 50 / 2d,
                        -currPos.getY() + 50 / 2d);
            }
        }
    }


    public void tickForPlanes(Race race, float dt) {
        race.time++;
        if (race.getCurrentPosition() == null) {
            race.setCurrentPosition(race.getStartPoint());
        }
        var currentPosition = race.getCurrentPosition();
        var end = race.getEndPoint();
        var start = race.getStartPoint();
        int dx = (int) (end.getX() - start.getX());
        int dy = (int) (end.getY() - start.getY());
        if (dist(currentPosition.getX(), currentPosition.getY(), end.getX(), end.getY()) > 50)
            race.setCurrentPosition(
                    new Point((int) (race.getCurrentPosition().getX() + (dx / 100.0) * cos(race.getAngle())),
                            (int) (race.getCurrentPosition().getY() + (dy / 100.0) * sin(race.getAngle()))));
        if (race.time < race.totalTime) {
            race.setCurrentPosition(new Point(start.x + race.time * dx / race.totalTime, start.y + race.time * dy / race.totalTime));
        } else {

            if (race.infected) {
                    infectRegion(race);
            }
            Game.races.remove(race);
            ArrayList<Race> races = generatePlanesRaces();
            if (races.size() > 0) {
                Race newRace = races.get(new Random().nextInt(races.size()));
                Game.races.add(newRace);
            }

        }
    }

    public void tickForShips(ShipRace shipRace) {
        shipRace.time++;
        if (shipRace.getCurrentPosition() == null) {
            shipRace.setCurrentPosition(shipRace.getStartsPoints());
            shipRace.updateTotalTime();

        }
        Point currentPosition = (Point) shipRace.getCurrentPosition().clone();
        var end = shipRace.getLastPointOfPart();
        var start = shipRace.getStartsPoints();
        int dx = (int) (end.getX() - start.getX());
        int dy = (int) (end.getY() - start.getY());
        if (dist(currentPosition.getX(), currentPosition.getY(), end.getX(), end.getY()) > 20)
            shipRace.setCurrentPosition(
                    new Point((int) (shipRace.getCurrentPosition().getX() + (dx / 100.0) * cos(shipRace.getShipPosAngle())),
                            (int) (shipRace.getCurrentPosition().getY() + (dy / 100.0) * sin(shipRace.getShipPosAngle()))));
        if (shipRace.time < shipRace.totalTime) {
            shipRace.setCurrentPosition(new Point(start.x + shipRace.time * dx / shipRace.totalTime, start.y + shipRace.time * dy / shipRace.totalTime));
        } else {
            if (shipRace.getLastPointOfPart() != shipRace.getWhooleLastPoints()) {
                shipRace.nextPoints();
                shipRace.setCurrentPosition(null);
                shipRace.updateTotalTime();
                shipRace.time = 0;
            } else if (shipRace.getLastPointOfPart() == shipRace.getWhooleLastPoints()) {
                Game.shipRaces.remove(shipRace);
                List<ShipRace> shipRaces = generateShipRaces();
                if (shipRaces.size() > 0) {
                    shipRace.clean();
                    Collections.reverse(shipRace.way);
                    Game.shipRaces.add(shipRace);
                }

            }
        }

    }


    public static double dist(double a, double b, double c, double d) {
        return Math.sqrt(Math.pow(c - a, 2) + Math.pow(d - b, 2));
    }

}
