package org.kasad0r.researchs;

import org.kasad0r.Game;

public class RecoverResearch extends Research {
    {
        super.cost = 24;
        super.isActive = true;
    }

    @Override
    public void activate() {
        Game.virus.recovered += 0.01;
        super.isActive=false;
    }
}
