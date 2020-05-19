package org.kasad0r.researchs;

import org.kasad0r.Game;

public class VaccineResearch extends Research {
    {
        super.isActive = true;
        super.cost = 25;
    }
    @Override
    public void activate() {
        Game.virus.vaccineReasearchBonus = 2;
        super.isActive=false;
    }
}
