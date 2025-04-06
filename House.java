import java.util.ArrayList;

/* This is a stub for the House class */
public class House extends Building implements HouseRequirements {
  private ArrayList<Student> residents; // The <Student> tells Java what kind of data we plan to store IN the ArrayList
  private boolean hasDiningRoom;
  private boolean hasElevator;

  /**
   * Constructor for the House class
   * Initialize House Object with information from the Building (as a House is a type of Building)
   * In addition, has its own ArrayList of residents.
   * 
   * @param name The name of the 'House'
   * @param address The 'House' address
   * @param nFloors The number of floors of the 'House'
   */
  public House(String name, String address, int nFloors, boolean hasDiningRoom, boolean hasElevator) {
    super(name, address, nFloors);
    this.hasDiningRoom = hasDiningRoom;
    this.hasElevator = hasElevator; 
    this.residents = new ArrayList<Student>();
    System.out.println("You have built a house: 🏠");
  }

  /* Default constructor 
  * (no elevator/dining hall)
  */
  public House() {
    this("<Name Unknown>", "<Address Unknown>", 1, false, false);
  }

  /* Overloaded constructor with nFloor, hasElevator, and hasDiningRoom only */
  public House(int nFloors, boolean hasElevator, boolean hasDiningRoom) {
    this("<Name Unknown>", "Address Unknown", nFloors, hasElevator, hasDiningRoom);
  }

  /**
   * Check whether this 'House' has a dining room
   * 
   * @return true/false 
   */
  public boolean hasDiningRoom() {
    return hasDiningRoom;
  }

  /**
   * Check whether this 'House' has an elevator room
   * 
   * @return true/false 
   */
  public boolean hasElevator() {
    return hasElevator;
  }

  /**
   * Return number of residents in this House
   * 
   * @return The number of residents
   */
  public int nResidents() {
    int count = this.residents.size();
    return count;
  }

  /**
   * Move in a student
   * 
   * @param s The student's name
   */
  public void moveIn(Student s) {
    if(this.residents.contains(s)) { // Student s is a resident of this 'House'=> CANNOT be added.
      String message = s.getName() + "already lives here.";
      throw new RuntimeException(message);
    } 
    else {
      this.residents.add(s);
    }
  }

  /**
   * Move in multiple students
   * 
   * @param students The students' names
   */
  public void moveIn(ArrayList<Student> students) {
    for(int i = 0; i <= (students.size() -1 ); i++) { // Loop through each student
      if(this.residents.contains(students.get(i))) { // Student s is a resident of this 'House'=> CANNOT be added.
      String message = students.get(i).getName() + "already lives here.";
      throw new RuntimeException(message);
      } 
      else {
      this.residents.add(students.get(i));
      }
    }
  }

  /**
   * Move out a student
   * 
   * @param s The student's name
   * @return The student's name (who has now moved out)
   */
  public Student moveOut(Student s) {
    if(this.residents.contains(s)) { // Student is resident of 'House' => CAN be removed.
      this.residents.remove(s);
      return s;
    }
    else {
      String message = s.getName() + "does NOT live here";
      throw new RuntimeException(message);
    }
  }

  /**
   * Move out students
   * 
   * @param students The student's name
   * @return The students' name (who have now moved out)
   */
  public void moveOut(ArrayList<Student> students) {
    for(int i = 0; i <= (students.size() - 1); i++) {
      if(this.residents.contains(students.get(i))) { // Student is resident of 'House' => CAN be removed.
      this.residents.remove(students.get(i));
      String message = students.get(i).getName() + " has moved out successfully";
      System.out.println(message);
    }
    else {
      String message = students.get(i).getName() + "does NOT live here";
      throw new RuntimeException(message);
    }    
    }
  }

  /**
   * Check whether this student is a resident of this 'House'
   * 
   * @param s The student's name
   * @return true/false
   */
  public boolean isResident(Student s) {
    if(this.residents.contains(s)){
      return true;
    }
    else {
      return false;
    }
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
   * Moves user to any floor of the 'House' using an elevator (if the 'House' has one)
   * 
   * @param floorNum The floor number the user wants to go to.
   */
  public void goToFloor(int floorNum) {
    if (hasElevator) {
      super.goToFloor(floorNum);
    }
    else {
      throw new RuntimeException(this.getName() + " House does NOT have an elevator. \n Try manually moving to that floor instead. ");
    }
  }



  public static void main(String[] args) {
    House Cutter = new House("Cutter", "79 Elm St.", 3, true, true);
    Student tammy = new Student("Tammy", "991472193", 2028);
    Cutter.moveIn(tammy);
    // Cutter.enter();
    // Cutter.goToFloor(3);

    // House northrop = new House(5, true, false);
    // northrop.enter();
    // northrop.goToFloor(5);
    ArrayList<Student> classOf28 = new ArrayList<Student>();
    Student anak = new Student("Anak", 2028);
    Student aifos = new Student("Aifos", 2028);
    classOf28.add(anak);
    classOf28.add(aifos);

    Cutter.moveIn(classOf28);

    System.out.println(Cutter.nResidents());

    Cutter.moveOut(classOf28);
    System.out.println(Cutter.nResidents());
    

    


  }

}