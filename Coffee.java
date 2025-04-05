public class Coffee {

    // Attributes
    protected String name; // The name of the order
    protected int nCoffeeOunces; // The number of ounces of coffee needed
    protected int nSugarPackets; // The number of sugar packets needed
    protected int nCreams; // The number of "splashes" of cream needed

    /**
     * Constructor for a coffee order
     */
    public Coffee(String name, int nCoffeeOunces, int nSugarPackets, int nCreams) {
        this.name = name;
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
    }

    /**
     * Accessor for coffee order's name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Accessor for coffee order's size (ounces)
     */
    public int getOunces() {
        return this.nCoffeeOunces;
    }

    /**
     * Accessor for coffee order's sugar (packets)
     */
    public int getSugar() {
        return this.nSugarPackets;
    }

    /**
     * Accessor for coffee order's cream (splashes)
     */
    public int getCreams() {
        return this.nCreams;
    }    

    /**
     * toString of the full menu (only name included)
     */
    public String toString() {
        return getName();
    }   
}
