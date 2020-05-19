package org.kasad0r;

import org.kasad0r.domain.MapPoint;
import org.kasad0r.domain.Region;

import java.awt.*;
import java.util.List;
import java.util.*;

public class MapPointGenerator {
    public static List<MapPoint> pointsOnMap;

    public boolean checkPointByCoords(int x, int y) {
        boolean res = false;
        for (MapPoint mapPoint : pointsOnMap) {
            if (TransportController.dist(x, y, mapPoint.point.x, mapPoint.point.y) <= 30) {
                pointsOnMap.remove(mapPoint);
                res = true;
                break;
            }
        }
        return res;
    }

    public MapPointGenerator() {
        pointsOnMap = new ArrayList<>();
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                generatePoints();
            }
        }, 0, 6500);
    }

    private void generatePoints() {
        if (pointsOnMap.size() > 10) {
            return;
        }
        final Random r = new Random();
        Region randRegion = RegionData.worldRegionsList
                .get(r.nextInt(RegionData.worldRegionsList.size()));

        Point randPoint = randRegion.getRegionFillCords()
                .get(r.nextInt(randRegion.getRegionFillCords().size()));
        if (pointsOnMap.stream().anyMatch(f -> f.point == randPoint)) {
            generatePoints();
            return;
        }
        pointsOnMap.add(new MapPoint(randPoint,
                new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256))));
    }
}
