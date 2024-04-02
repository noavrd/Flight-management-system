public class CrewMember extends Person {

    private Person person;
    public SingleAirline airline;
    public int crewMemberId;
    private int salary;

    public CrewMember(int id, String firstName, String lastName, SingleAirline airline, int crewMemberId, int salary) {
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

    public Person getPerson(){
        return person;
    }
    
}
