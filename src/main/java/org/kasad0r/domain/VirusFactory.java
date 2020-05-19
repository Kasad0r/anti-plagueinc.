package org.kasad0r.domain;

public class VirusFactory {
    private VirusFactory() {

    }

    public static Virus create(Difficulty difficulty) {
        var virus = new Virus();
        if (difficulty == Difficulty.EASY) {
            virus.mutationRate = 1.01;
            virus.oneCarrierInfect = 7;
            virus.shipInfect = 20;
            virus.airPlaneInfect = 20;
            virus.deathRate = 0.0010;
            virus.recovered = 0.0100;
        } else if (difficulty == Difficulty.MEDIUM) {
            virus.mutationRate = 1.11;
            virus.oneCarrierInfect = 10;
            virus.shipInfect = 30;
            virus.airPlaneInfect = 30;
            virus.deathRate = 0.0015;
            virus.recovered = 0.0100;
        } else if (difficulty == Difficulty.HARD) {
            virus.mutationRate = 1.21;
            virus.airPlaneInfect = 50;
            virus.shipInfect = 50;
            virus.oneCarrierInfect = 13;
            virus.deathRate = 0.0050;
            virus.recovered = 0.0100;
        }
        return virus;
    }
}
