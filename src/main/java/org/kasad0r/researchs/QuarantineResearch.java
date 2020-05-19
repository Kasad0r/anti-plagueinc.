package org.kasad0r.researchs;

import org.kasad0r.Game;

public class QuarantineResearch extends Research {
    {
        super.cost = 30;
        super.isActive = true;
    }

    @Override
    public void activate() {
        Game.virus.oneCarrierInfect -= Game.virus.oneCarrierInfect / 3;
        Game.virus.airPlaneInfect -= Game.virus.airPlaneInfect / 3;
        Game.virus.shipInfect -= Game.virus.shipInfect / 3;
        super.isActive=false;
    }
}
