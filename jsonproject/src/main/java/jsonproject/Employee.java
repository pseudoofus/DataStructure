
package jsonproject;

public class Employee {
    
    private String name;
    private String city;
    private String department;
    private String designation;
    
    public Employee(){
    }

    public Employee(String name, String city, String department, String designation) {
        this.name = name;
        this.city = city;
        this.department = department;
        this.designation = designation;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getDepartment() {
        return department;
    }

    public String getDesignation() {
        return designation;
    }

    @Override
    public String toString() {
        return "Employee{" + "name=" + name + ", city=" + city + ", department=" + department + ", designation=" + designation + '}';
    }
    
    
    
}
