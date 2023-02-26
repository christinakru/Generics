package org.generics;

public class Ticket implements Comparable<Ticket> {
    private int ID;
    private int cost;
    private String IATAFrom;
    private String IATATo;
    private int flightTime; // in minutes

    public Ticket(int ID, int cost, String IATAFrom, String IATATo, int flightTime) {
        this.ID = ID;
        this.cost = cost;
        this.IATAFrom = IATAFrom;
        this.IATATo = IATATo;
        this.flightTime = flightTime;
    }

    public int getID() {
        return ID;
    }

    public int getCost() {
        return cost;
    }

    public String getIATAFrom() {
        return IATAFrom;
    }

    public String getIATATo() {
        return IATATo;
    }

    public int getFlightTime() {
        return flightTime;
    }

    @Override
    public int compareTo(Ticket o) {
        return Integer.compare(cost, o.cost);
    }
}
