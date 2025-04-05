import java.util.ArrayList;

/* This is a stub for the Cafe class */
public class Cafe extends Building implements CafeRequirements {

    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory
    private ArrayList<Coffee> menu = new ArrayList<>();

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
            this.nCoffeeOunces =- size;
            this.nSugarPackets =- nSugarPackets;
            this.nCreams =- nCreams;
            this.nCups -= 1; // Since this is one order => ONE cup is needed
            System.out.println("One cup sold! :)");
    
    }

    public void sellCoffee(Coffee order) {
        if ((order.getOunces() > this.nCoffeeOunces) || (order.getSugar() > nSugarPackets) || (order.getCreams() > nCreams) || (this.nCups < 1)) {
            restock(order.getOunces(), order.getSugar(), order.getCreams(), 10); // Restock if any inventory is insufficient (hardcoding get 10 more cups)
            System.out.println("Restocking... Please hold!");
        }
        this.nCoffeeOunces =- order.getOunces();
        this.nSugarPackets =- order.getSugar();
        this.nCreams =- order.getCreams();
        this.nCups -= 1; // Since this is one order => ONE cup is needed
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
            restock(size, nSugarPackets, nCreams, nCups); // Restock if any inventory is insufficient
            System.out.println("Restocking... Please hold!");
        }
            this.nCoffeeOunces =- size;
            this.nSugarPackets =- nSugarPackets;
            this.nCreams =- nCreams;
            this.nCups -= nCups; // Since this is one order => ONE cup is needed
            System.out.println(nCups + " cups sold! :)");
            
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
        System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + sellCoffee(nCoffeeOunces, nSugarPackets, nCreams)\n + restock(nCoffeeOunces, nSugarPackets, nCreams, nCups)");
    }

    /**
     * Show Cafe menu
     * 
     */
    public void showMenu() {
        //for(int i = 1; i <= menu.size(); i++)               
        //    System.out.println(getName());
        //} 
        System.out.println("Our menu includes: " + menu.toString());
    }

    public static void main(String[] args) {
        Cafe campusCenterCafe = new Cafe("Campus Center Café", "100 Elm St", 2, 20, 20, 20, 20);
        campusCenterCafe.sellCoffee(12, 3, 3);
        campusCenterCafe.showOptions();
        Coffee americano = new Coffee("Americano", 3, 1, 0);
        Coffee tammietti = new Coffee("Tammietti", 3, 5, 1);
        campusCenterCafe.menu.add(americano);
        campusCenterCafe.menu.add(tammietti);
        campusCenterCafe.sellCoffee(americano);
        campusCenterCafe.sellCoffee(tammietti);
        campusCenterCafe.showMenu();
    }
    
}
