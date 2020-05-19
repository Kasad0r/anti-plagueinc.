package org.kasad0r.researchs;

import org.kasad0r.Game;

public class PatientMonitoringResearch extends Research {
    {
        this.cost = 7;
        this.title = "Patient monitoring";
        this.isActive = true;
    }

    @Override
    public void activate() {
        super.isActive = false;
        Game.virus.oneCarrierInfect /= 1.5;
    }
}
