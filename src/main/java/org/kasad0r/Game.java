package org.kasad0r;

import org.kasad0r.domain.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import static org.kasad0r.Starter.HEIGHT;
import static org.kasad0r.Starter.WIDTH;

public class Game {
    public static Image world;
    private TransportController transportController;
    public static List<Race> races;
    public static Virus virus;
    public static LocalDate gameDate;
    public static long currentPoints;
    public static MapPointGenerator mapPointGenerator;
    public static List<ShipRace> shipRaces;
    public static Difficulty selectedDifficulty;
    public static EpidemicController epidemicController;

    public Game() {
        RegionData.init();

        virus = VirusFactory.create(Difficulty.EASY);
        ShipRaceWayMap.init();
        transportController = new TransportController();
        mapPointGenerator = new MapPointGenerator();
        races = transportController.generatePlanesRaces();
        shipRaces = transportController.generateShipRaces();
        gameDate = LocalDate.now();
        epidemicController = new EpidemicController();
        epidemicController.start();
        try {
            world = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("world-map.png"));
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    public void tick(float dt) {
        List<ShipRace> shipRaces = ShipRaceWayMap.shipRaces;
        for (int i = shipRaces.size() - 1; i >= 0; i--) {
            ShipRace shipRace = shipRaces.get(i);
            transportController.tickForShips(shipRace);
        }
        for (int i = races.size() - 1; i >= 0; i--) {
            Race race = races.get(i);
            transportController.tickForPlanes(race, 0);
        }
    }

    public void render(Graphics g) {
        g.drawImage(world, 0, 0, WIDTH, HEIGHT - 55, null);
        drawMapPoints(g);
        showAirPorts(g);
        showPorts(g);
        drawRegionStatistics(g);
        drawPlanes(g);
        drawShips(g);
        removeReces();
        removeShipRaces();

    }

    private void drawMapPoints(Graphics g) {
        List<MapPoint> pointsOnMap = MapPointGenerator.pointsOnMap;
        for (int i = pointsOnMap.size() - 1; i >= 0; i--) {
            MapPoint mapPoint = pointsOnMap.get(i);
            g.setColor(mapPoint.color);
            g.fillOval(mapPoint.point.x - 15, mapPoint.point.y - 15, 30, 30);
        }
    }

    private void drawPlanes(Graphics g) {
        for (var race : races) {
            transportController.renderPlane(race, g);
        }
    }

    private void drawShips(Graphics g) {
        for (var race : shipRaces) {
            transportController.renderShips(race, g);
        }
    }

    public static void checkMouse(MouseEvent e) {
        mapPointAdd(e);
    }

    private static void mapPointAdd(MouseEvent e) {
        boolean point = mapPointGenerator.checkPointByCoords(e.getX(), e.getY());
        if (point) {
            currentPoints++;
            currentPoints += Game.virus.mapPointBonus;
        }
    }

    private void drawRegionStatistics(Graphics g) {
        g.setFont(new Font("TimesRoman", Font.BOLD, 24));
        g.setColor(Color.WHITE);
        drawString(g, "population \n    " + RegionData.worldRegionsList.get(0).getPopulation(), 711, 420);
        drawString(g, "population \n    " + RegionData.worldRegionsList.get(4).getPopulation(), 260, 330);
        drawString(g, "population \n    " + RegionData.worldRegionsList.get(2).getPopulation(), 437, 560);
        drawString(g, "population \n    " + RegionData.worldRegionsList.get(1).getPopulation(), 1014, 293);
        g.setFont(new Font("TimesRoman", Font.BOLD, 16));
        drawString(g, "population \n    " + RegionData.worldRegionsList.get(3).getPopulation(), 1280, 650);
        drawString(g, "population: \n   " + RegionData.worldRegionsList.get(5).getPopulation(), 761, 315);
    }

    private void removeReces() {
        for (int i = races.size() - 1; i >= 0; i--) {
            if (races.get(i).getRegionTo().isClosedAirports() &&
                    races.get(i).getRegionFrom().isClosedAirports()) {
                races.remove(races.get(i));
            }
        }
    }

    private void removeShipRaces() {
        for (int i = shipRaces.size() - 1; i >= 0; i--) {
            if (races.size() == 0) {
                shipRaces.clear();
            }
        }
    }

    private void showPorts(Graphics g) {

        for (var region : RegionData.worldRegionsList) {
            for (var ports : region.getPortsCoords()) {
                g.drawImage(TransportController.portImage, ports.x, ports.y, null);
            }
        }
    }

    private void showAirPorts(Graphics g) {

        for (var region : RegionData.worldRegionsList) {
            for (var airportsCoord : region.getAirportsCoords()) {
                g.drawImage(TransportController.airPortImage, airportsCoord.x - 15, airportsCoord.y - 30, null);
            }
        }
    }

    private void drawString(Graphics g, String text, int x, int y) {
        for (var line : text.split("\n"))
            g.drawString(line, x, y += g.getFontMetrics().getHeight());
    }

}
