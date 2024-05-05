/**
 * The CrewMember class represents a crew member working for an airline.
 * It inherits properties from the Person class and adds specific attributes
 * such as crew member ID and salary.
 * Crew members are associated with an airline and can be added to its staff.
 * The class provides methods to retrieve crew member ID, salary,
 * and to print crew member details.
 */

 public class CrewMember extends Person {

    private Person person;
    public Airline airline;
    public int crewMemberId;
    private int salary;

    public CrewMember(int id, String firstName, String lastName, Airline airline, int crewMemberId, int salary) {
        super(id, firstName, lastName);
        airline.addStaff(this);   
        this.crewMemberId = crewMemberId;
        this.salary = salary;
    }

    public int getCrewMemberId(){
        return crewMemberId;
    }
    
    public int getSalary(){
        return salary;
    }

    public void printCrewMember() {
        System.out.println("Name: " + this.getFirstName() + " " + this.getLastName());
    }
    
}
