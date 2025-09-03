package Sept5.num2;

public class Intern extends Employee{
    private String school;

    public Intern(String name, double salary, String school){
        super(name, salary);
        this.school = school;
    }

    @Override
    public String getDetails(){
        return super.getDetails() + ", School: " + school;
    }
}
