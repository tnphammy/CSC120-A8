import java.util.ArrayList;

/* This is a stub for the Cafe class */
public class Cafe extends Building implements CafeRequirements {

    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory
    protected ArrayList<Coffee> menu = new ArrayList<>(); // List of all available coffee orders (named)

    /**
     * Constructor for the 'Cafe' class.
     * Initializes 'Cafe' Object with information from 'Building' class ('Cafe' is a type of 'Building')
     * Also has its own attributes above.
     *
     * @param name
     * @param address
     * @param nFloors
     * @param nCoffeeOunces
     * @param nSugarPackets
     * @param nCreams
     * @param nCups
     */
    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        super(name, address, nFloors);
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
        this.menu = new ArrayList<Coffee>();
        System.out.println("You have built a cafe: ☕");
    }

    /**     
     * Decreases inventory depending on order.
     * 
     * @param size The number of ounces of the order
     * @param nSugarPackets The number of sugar packets needed
     * @param nCreams the number of cream pods needed
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams) {
        if ((this.nCoffeeOunces < size) || (this.nSugarPackets < nSugarPackets) || (this.nCreams < nCreams) || (this.nCups < 1)) {
            restock(size, nSugarPackets, nCreams, nCups); // Restock if any inventory is insufficient
            System.out.println("Restocking... Please hold!");
        }
            this.nCoffeeOunces -= size;
            this.nSugarPackets -= nSugarPackets;
            this.nCreams -= nCreams;
            this.nCups -= 1; 
            System.out.println("One cup sold! :)");
    
    }

    /**
     * Sell one coffee by order (name, e.g: "Americano").
     * Decreases inventory depending on order.
     * 
     * @param order The coffee style 
     */
    public void sellCoffee(Coffee order) {
        if ((order.getOunces() > this.nCoffeeOunces) || (order.getSugar() > this.nSugarPackets) || (order.getCreams() > this.nCreams) || (this.nCups < 1)) {
            restock(order.getOunces(), order.getSugar(), order.getCreams(), 10); // Restock if any inventory is insufficient (hardcoding get 10 more cups)
            System.out.println("Restocking... Please hold!");
        }
        this.nCoffeeOunces -= order.getOunces();
        this.nSugarPackets -= order.getSugar();
        this.nCreams -= order.getCreams();
        this.nCups -= 1; 
        System.out.println("One "+ order.getName()+ " sold! :)");        

    }


    /** 
     * Sell multiple coffee cups    
     * Decreases inventory depending on order.
     * 
     * @param size The number of ounces of the order (per cup)
     * @param nSugarPackets The number of sugar packets needed (per cup) 
     * @param nCreams the number of cream pods needed (per cup)
     */
    public void sellCoffees(int size, int nSugarPackets, int nCreams, int nCups) {
        if ((this.nCoffeeOunces < size) || (this.nSugarPackets < nSugarPackets) || (this.nCreams < nCreams) || (this.nCups < 1)) {
            restock(size, nSugarPackets, nCreams, 10); // Restock if any inventory is insufficient (hardcoding 10 cups)
            System.out.println("Restocking... Please hold!");
        }
            this.nCoffeeOunces -= size;
            this.nSugarPackets -= nSugarPackets;
            this.nCreams -= nCreams;
            this.nCups -= nCups; 
            System.out.println(nCups + " cups sold! :)");
            
    }

    /**
     * Sell multiple coffee cups by order (name, e.g: "Americano").
     * Decreases inventory depending on order.
     * 
     * @param order The coffee style 
     */
    public void sellCoffees(Coffee order, int numCups) {
        if ((order.getOunces() > this.nCoffeeOunces) || (order.getSugar() > this.nSugarPackets) || (order.getCreams() > this.nCreams) || (numCups > this.nCups)) {
            restock(order.getOunces(), order.getSugar(), order.getCreams(), 10); // Restock if any inventory is insufficient (hardcoding get 10 more cups)
            System.out.println("Restocking... Please hold!");
        }
        this.nCoffeeOunces -= order.getOunces();
        this.nSugarPackets -= order.getSugar();
        this.nCreams -= order.getCreams();
        this.nCups -= numCups; 
        System.out.println(numCups+ " " + order.getName()+ "'s sold! :)");        

    }

    /**
     * Restock out of stock items within the inventory.
     * 
     * @param nCoffeeOunces
     * @param nSugarPackets
     * @param nCreams
     * @param nCups
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
    }

    /**
     * Show available actions for the user
     */
    public void showOptions() { // Overriding from Building because the user cannot move up or down.
        System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + sellCoffee()\n + sellCoffees()\n + restock(nCoffeeOunces, nSugarPackets, nCreams, nCups)\n + showMenu()");
    }

    /**
     * Show Cafe menu
     * 
     */
    public void showMenu() {
        //for(int i = 1; i <= menu.size(); i++)               
        //    System.out.println(getName());
        //} 
        System.out.println("The menu includes: " + menu.toString());
    }

    public void goToFloor(int floorNum) {
        if (this.activeFloor == -1) {
            throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
        }
        throw new RuntimeException("You are not permitted to move beyond this floor. ");
    }

    public void goUp() {
        if (this.activeFloor == -1) {
            throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
        }
        throw new RuntimeException("You are not permitted to move beyond this floor. ");
    }

    public void goDown() {
        if (this.activeFloor == -1) {
            throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
        }
        throw new RuntimeException("You are not permitted to move beyond this floor. ");
    }

    public static void main(String[] args) {
        Cafe campusCenterCafe = new Cafe("Campus Center Café", "100 Elm St", 2, 20, 20, 20, 20);
        campusCenterCafe.sellCoffee(12, 3, 3);
    }
    
}
