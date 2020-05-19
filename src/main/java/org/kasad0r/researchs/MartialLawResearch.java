package org.kasad0r.researchs;

import org.kasad0r.Game;

public class MartialLawResearch extends Research {
    {
        this.cost = 125;
        this.title = "Martial law";
        this.isActive=true;
    }

    @Override
    public void activate() {
        super.isActive=false;
        Game.virus.deathRate = 0.0001;
    }
}
