package org.kasad0r.researchs;

import org.kasad0r.Game;

public class ExperimentalVaccineTesting extends Research {
    {
        this.cost = 5;
        this.description = "More deaths, faster vaccine";
        this.title = "Experimental vaccine";
        super.isActive=true;
    }

    @Override
    public void activate() {

        super.isActive=false;
        Game.virus.deathRate += 0.002;
        Game.virus.vaccineReasearchBonus += 1;
    }
}
