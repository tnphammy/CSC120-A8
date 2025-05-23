import java.util.ArrayList;
import java.util.Hashtable;

/* This is a stub for the Library class */
public class Library extends Building implements LibraryRequirements{
  private Hashtable<String, Boolean> collection;
  private boolean hasElevator;

    /**
     * Constructor for the Library class
     * Initialize 'Library' Object with information from the 'Building' (as a 'Library' is a type of 'Building')
     * In addition, has its hash table.
     * 
     * @param name The name of the 'Library'
     * @param address The 'Library' address
     * @param nFloors The number of floors of the 'Library'
     */
    public Library(String name, String address, int nFloors, boolean hasElevator) {
      super(name, address, nFloors);
      this.collection = new Hashtable<String, Boolean>(); 
      this.hasElevator = hasElevator;
      System.out.println("You have built a library: 📖");
    }

    /* Default constructor */
    public Library() {
      this("<Name Unknown>", "<Address Unknown>", 3, true);
    }

    /* Overloaded constructor with name and address */
    public Library(String name, String address) {
      this(name, address, 3, true); // Call full constructor with hard-coded # floors and elevator
      this.name = name;
      this.address = address;
    }

    /* Overloaded constructor with nFloors and hasElevator */
    public Library(int nFloor, boolean hasElevator) {
      this("<Name Unknown", "<Address Unknown>", nFloor, hasElevator);
    }

    /**
     * Add a title to the collection
     * 
     * @param title Title of the book
     */
    public void addTitle(String title) {
      if(containsTitle(title)){
        throw new RuntimeException(title +" is already in the collection. Try again with a new book.");
      }
      else {
        this.collection.put(title, true);
      }

    }

    /**
     * Add multiple titles to the collection
     * 
     * @param bookList List of book names to be added
     */
    public void addTitle(ArrayList<String> bookList) {
      for (int i = 0; i <= (bookList.size()-1); i++) {
        if(containsTitle(bookList.get(i)) == true ){ // Get the book title at the i index
          throw new RuntimeException(bookList.get(i) +" is already in the collection. Try again with a new book.");
        }
        else {
          this.collection.put(bookList.get(i), true);
        }
      }
    }
  
    /**
     * Remove a book from the collection
     * 
     * @param title The title of the book
     * @return The title of the book (that was removed)
     */
    public String removeTitle(String title) {
      if(containsTitle(title)) {
        this.collection.remove(title);
        return title;
      }
      else {
        throw new RuntimeException(title + " does NOT exist within the collection, and thus cannot be removed.");
      }
    }

    /**
     * Check out a book from library collection
     * 
     * @param title The title of the book getting checked out
     */
    public void checkOut(String title) {
      if(containsTitle(title)) {
        if(!isAvailable(title)) {
          throw new RuntimeException(title + " has already been checked out by someone else. Please come back another time.");
        }
        this.collection.replace(title, false);
        System.out.println(title + " is checked out. Have fun reading!");
      }
      else {
        throw new RuntimeException(title + " is NOT within the collection, and thus cannot be checked out. Please try again with a new book.");
      }
    }

    /**
     * Check multiple books from library collection
     * 
     * @param bookList List of book names to be checked out
     */
    public void checkOut(ArrayList<String> bookList) {
      for(int i = 0; i <= (bookList.size()- 1); i++) {
        if(containsTitle(bookList.get(i))) {
          if(!isAvailable(bookList.get(i))) {
            throw new RuntimeException(bookList.get(i) + " has already been checked out by someone else. Please come back another time.");
          }
          this.collection.replace(bookList.get(i), false);
          System.out.println(bookList.get(i) + " is checked out. Have fun reading!");
        }
        else {
          throw new RuntimeException(bookList.get(i) + " is NOT within the collection, and thus cannot be checked out. Please try again with a new book.");
        }
      }
    }

    /**
     * Returns a borrowed (previously checked out) book
     * 
     * @param title The title of the book being returned
     */
    public void returnBook(String title) {
      if(containsTitle(title)) {
        // Check if the book was borrowed
        
        if(isAvailable(title) == false) { 
          // Then return the book
          this.collection.replace(title,true); 
        }
        else {
          throw new RuntimeException(title + " was NOT previously checked out, and thus cannot be returned.");
        }
      }
      else {
        throw new RuntimeException(title + " does NOT exist within our collection, and thus cannot be returned.");
      }
    }

    /**
     * Check if a book exists within the library's collection.
     * 
     * @param title The title of the book.
     * @return true/false
     */
    public boolean containsTitle(String title) {
      if(this.collection.containsKey(title)) {
        return true;
      }
      else {
        return false;
      }
      
    }

    /**
     * Check if a book is available
     * 
     * @param title The title of the book
     * @return true/false
     */
    public boolean isAvailable(String title) {
      if(this.collection.get(title)) {
        return true;
      }
      else {
        return false;
      }
    }

    /**
     * Prints out the entire collection in an easy-to-read way (including checkout status)
     * 
     */
    public void printCollection() {
      System.out.println(this.collection.toString());
    }

  /**
   * Show available actions for the user
   */
  public void showOptions() {
    if (hasElevator) {
      super.showOptions(); // Show FULL options
    } 
    else {
      System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()");
      // Does not contain option goToFloor() - Runtime Exception in goToFloor() below if they try to.
    }
  }  

  /**
   * Moves user to any floor of the 'Library' using an elevator (if the 'House' has one)
   * 
   * @param floorNum The floor number the user wants to go to.
   */
  public void goToFloor(int floorNum) {
    if (hasElevator) {
      super.goToFloor(floorNum);
    }
    else {
      throw new RuntimeException(this.getName() + " Library does NOT have an elevator. \n Try manually moving to that floor instead.");
    }
  }


    public static void main(String[] args) {
      Library neilson = new Library("Neilson", "7 Neilson Drive", 4, true);
      String wow = new String("World of Wonders");
      neilson.addTitle("Gut Check");
      neilson.addTitle(wow);
      neilson.checkOut(wow);
      
      ArrayList<String> bookList = new ArrayList<>();
      bookList.add("Book1");
      bookList.add("Book2");

      neilson.addTitle(bookList);
      neilson.printCollection();

      neilson.checkOut(bookList);
      neilson.printCollection();

      
    }
  
  }