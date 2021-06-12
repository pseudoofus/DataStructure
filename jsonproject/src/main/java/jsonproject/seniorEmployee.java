
package jsonproject;

public class seniorEmployee extends Employee{
    
    private char grade;
    private Boolean promotion;

    public seniorEmployee(String name, String city, String department, String designation, char grade, Boolean promotion) { // fully parametered
        super(name, city, department, designation);
        this.grade = grade;
        this.promotion = promotion;
    }

    public seniorEmployee() { // default constructor
        super();
    }
    
    public char getGrade() {
        return grade;
    }

    public void setGrade(char grade) {
        this.grade = grade;
    }

    public Boolean getPromotion() {
        return promotion;
    }

    public void setPromotion(Boolean promotion) {
        this.promotion = promotion;
    }
    
    @Override
    public String toString() {
        return "SeniorEmployee{" + "name=" + super.getName() + 
                ", city=" + super.getCity() + ", department=" + super.getDepartment() + 
                ", designation=" + super.getDesignation() + "grade= " + grade + 
                "promotion= " + promotion + '}';
    }
}
