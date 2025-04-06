import java.util.ArrayList;

public class CampusMap {

    ArrayList<Building> buildings;

    /* Default constructor, initializes empty ArrayList */
    public CampusMap() {
        buildings = new ArrayList<Building>();
    }

    /**
     * Adds a Building to the map
     * @param b the Building to add
     */
    public void addBuilding(Building b) {
        System.out.println("Adding building...");
        buildings.add(b);
        System.out.println("-->Successfully added " + b.getName() + " to the map.");
    }

    /**
     * Removes a Building from the map
     * @param b the Building to remove
     * @return the removed Building
     */
    public Building removeBuilding(Building b) {
        System.out.println("Removing building...");
        buildings.remove(b);
        System.out.println("-->Successfully removed " + b.getName() + " to the map.");
        return b;
    }

    public String toString() {
        String mapString = "DIRECTORY of BUILDINGS";

        for (int i = 0; i < this.buildings.size(); i ++) {
            mapString += "\n  " + (i+1) + ". "+ this.buildings.get(i).getName() + " (" + this.buildings.get(i).getAddress() + ")";
        }
        return mapString;
    }

    public static void main(String[] args) {
        CampusMap myMap = new CampusMap();

        // Academic buildings
        myMap.addBuilding(new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Bass Hall", "4 Tyler Court Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Seelye Hall", "2 Seelye Drive", 3));
        myMap.addBuilding(new Building("Burton Hall", "46 College Ln", 3));
        myMap.addBuilding(new Building("Sabin-Reed Hall", "46 College Ln", 3));
        myMap.addBuilding(new Building("McConnell Hall", "2 Tyler Ct", 4));

        // Libraries
        Library neilson = new Library("Neilson", "7 Neilson Drive", 4, true);
        myMap.addBuilding(neilson);
        myMap.addBuilding(new Library("Alumnae Gym", "83 Green Street", 3, true));
        myMap.addBuilding(new Library("Josten Performing Arts Library" , "122 Green Street",3 , true));
        myMap.addBuilding(new Library("Hillyer Art Library", "20 Elm Street", 2, false));


        // Café's
        Cafe campusCenterCafe = new Cafe("Campus Center Café", "100 Elm St", 2, 20, 20, 20, 20);
        myMap.addBuilding(campusCenterCafe);
        Cafe compassCafe = new Cafe("Compass Café", "7 Neilson Drive", 4, 20, 20, 20, 20);
        myMap.addBuilding(compassCafe);
        System.out.println(myMap);

        // Houses
        House cutterHouse = new House("Cutter", "79 Elm St.", 3, true, true);
        House northropHouse = new House(5, true, false);
        myMap.addBuilding(cutterHouse);
        myMap.addBuilding(northropHouse);

        // Actions 

        // (1) Cafe
        System.out.println("-------------------");
        System.out.println("   CAFE TESTING");
        System.out.println("-------------------");
        campusCenterCafe.sellCoffee(12, 3, 3); // Original method sellCoffee()
    
        Coffee americano = new Coffee("Americano", 3, 1, 0);
        Coffee espresso = new Coffee("Espresso", 3, 0, 0);
        campusCenterCafe.menu.add(americano);
        campusCenterCafe.menu.add(espresso);

        campusCenterCafe.sellCoffee(americano); // Overloaded method (can sell coffee by order)
        campusCenterCafe.sellCoffee(espresso);

        campusCenterCafe.sellCoffee(americano, 3); // Overloaded method (can sell specified quantity of coffees by order)


        campusCenterCafe.showMenu();
        campusCenterCafe.showOptions(); 
        campusCenterCafe.enter();
        //campusCenterCafe.goUp(); // Returns a RuntimeException

        System.out.println("-------------------");
        System.out.println("CAFE TESTING - DONE");
        System.out.println("-------------------");

        // (2) Library
        System.out.println("-------------------");
        System.out.println("  LIBRARY TESTING");
        System.out.println("-------------------");
        
        neilson.addTitle("World of Wonders"); // Original method

        ArrayList<String> bookList = new ArrayList<>();
        
        bookList.add("Book1");
        bookList.add("Book2");
  
        neilson.addTitle(bookList); // Overloaded method (can add multiple books at once)
        neilson.printCollection();
  
        neilson.checkOut(bookList); // Overloaded method (can check out multiple books at once)
        neilson.printCollection();

        System.out.println("-------------------------");
        System.out.println("LIBRARY TESTING - DONE");
        System.out.println("-------------------------"); 
  
        // (3) House
        System.out.println("-------------------");
        System.out.println("  HOUSE TESTING");
        System.out.println("-------------------");

        Student ymmat = new Student("ymmat", "99xxxxxxx", 2029);
        cutterHouse.moveIn(ymmat); // Original method

        ArrayList<Student> classOf28 = new ArrayList<Student>();
        Student anak = new Student("Anak", 2028);
        Student aifos = new Student("Aifos", 2028);
        classOf28.add(anak);
        classOf28.add(aifos);
    
        cutterHouse.moveIn(classOf28); // Overloaded method (can move in multiple students)
        System.out.println(cutterHouse.getName() + " House has " + cutterHouse.nResidents() + " student residents."); // Output: 3

        cutterHouse.moveOut(classOf28); // Overloaded method (can move out multiple students)
        System.out.println(cutterHouse.getName() + " House has " + cutterHouse.nResidents() + " student residents.");; // Output 1

        System.out.println("-------------------------");
        System.out.println("  HOUSE TESTING - DONE");
        System.out.println("-------------------------"); 
    }
    
}
