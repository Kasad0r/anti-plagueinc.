package org.kasad0r.researchs;

import org.kasad0r.Game;

public class DeathResearch extends Research {
    {
        super.cost = 20;
        super.isActive = true;
    }

    @Override
    public void activate() {
        Game.virus.deathRate -= Game.virus.deathRate / 2;
        super.isActive=false;
    }
}
