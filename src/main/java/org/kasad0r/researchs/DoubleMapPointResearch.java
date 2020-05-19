package org.kasad0r.researchs;

import org.kasad0r.Game;

public class DoubleMapPointResearch extends Research {
    {
        super.cost = 35;
        super.isActive = true;
        super.title = "x2 points";
    }

    @Override
    public void activate() {
        super.isActive=false;
        Game.virus.mapPointBonus += 1;
    }
}
