package org.kasad0r.researchs;

public abstract class Research {
    public String title;
    public String description;
    public int cost;
    public boolean isActive;

    public abstract void activate();
}
