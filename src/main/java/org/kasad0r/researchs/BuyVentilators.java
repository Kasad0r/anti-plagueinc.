package org.kasad0r.researchs;

import org.kasad0r.Game;

public class BuyVentilators extends Research {
    {
        this.isActive = true;
        this.cost = 35;
        this.title = "Buy ventilators";
    }

    @Override
    public void activate() {
        super.isActive = false;
        Game.virus.deathRate /= 1.5;
        Game.virus.recovered += 0.0023;
    }
}
