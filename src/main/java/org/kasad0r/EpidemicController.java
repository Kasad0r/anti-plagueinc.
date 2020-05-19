package org.kasad0r;

import org.kasad0r.domain.Race;
import org.kasad0r.domain.Region;
import org.kasad0r.domain.Virus;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class EpidemicController {
    public List<Region> worldRegionsList = RegionData.worldRegionsList;
    public static Virus virus = Game.virus;
    public static long currentProgressPoint;
    private static Timer timer = new Timer();

    public static void clean() {
        timer.cancel();
        timer.purge();
        currentProgressPoint = 0;
    }

    public void start() {
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                nearbyInRegionLife();
                Game.gameDate = Game.gameDate.plusDays(1);
                addStatistics();
            }
        }, 100, 700);
    }

    public void nearbyInRegionLife() {
        for (Region region : worldRegionsList) {
            if (region.getInfected() > 0) {
                //INFECT POPULATION
                long infected = region.getInfected();
                long updateInfected = infected + 2 + (infected * virus.oneCarrierInfect) / 80;

                region.setInfected(Math.min(updateInfected, region.getPopulation()));

                //RECOVER POPULATION
                long infectedForRecover = region.getInfected();
                double recovered = infectedForRecover * virus.recovered;
                if (infected > 20) {
                    recovered += 1;
                }
                region.setInfected(infectedForRecover - (long) recovered);
                region.setRecovered(region.getRecovered() + (long) recovered);
                if (region.getInfected() > region.getPopulation() * 0.10) {
                    region.setClosedAirports(true);
                }
                //DEATH POPULATION
                long infectedForDeath = region.getInfected();
                double deaths = (infectedForDeath * virus.deathRate) + 1;
                if (infectedForDeath == region.getPopulation()) {
                    deaths *= 1.3;
                }
                if (region.getPopulation() == 0) {
                    deaths = 0;
                }
                region.setInfected(infectedForDeath - (long) deaths);
                region.setPopulation(region.getPopulation() - (long) deaths);
                region.setDeaths(region.getDeaths() + (long) deaths);

                //  System.out.println(region.getPopulation() + " " + region.getInfected() + " " + (long)deaths +"   " + (long)recovered);
            }
        }
    }

    private void addStatistics() {
        long deaths = 0;
        long infected = 0;
        long population = 0;
        long recovered = 0;
        for (Region region : worldRegionsList) {
            population += region.getPopulation();
            infected += region.getInfected();
            deaths += region.getDeaths();
            recovered += region.getRecovered();
        }
        StatisticsBar.update(deaths, population, infected, recovered);

        long vaccineProgress = recovered / (250_000_000L - (Game.virus.vaccineReasearchBonus * 10_000_000));
        Game.currentPoints = Game.currentPoints + (vaccineProgress - currentProgressPoint) / 2;
        currentProgressPoint = vaccineProgress;
        StatisticsBar.vaccineProgressBar.setValue((int) vaccineProgress);
        if (infected == 0 || vaccineProgress == 100) {
            long v = (long) (population * 0.1 + recovered * 0.2 - deaths * 0.2);
            Starter.showEndGameDialog(v);
        }
        StatisticsBar.dialog.updateData();
    }


    public static boolean infectPlane(Region region) {
        if (region.isClosedAirports() || region.getInfected() == 0) {
            return false;
        } else if (region.getInfected() > 0) {
            double chance = (region.getInfected() + 0.0)
                    * virus.airPlaneInfect / (region.getPopulation() / 100);
            return chance > Math.random();
        }
        return false;
    }

    public static void infectRegion(Race race) {
        if (!race.getRegionTo().isClosedAirports())
            race.getRegionTo().setInfected(race.getRegionTo().getInfected() + virus.airPlaneInfect);

    }
}
