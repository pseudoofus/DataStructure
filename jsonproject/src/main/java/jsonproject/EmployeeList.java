
package jsonproject;

import java.util.ArrayList;
import java.util.List;

public class EmployeeList {
    
    private List<Employee> empList = new ArrayList<>();
    
    public EmployeeList(){
        this.empList = new ArrayList();
    }

    // constructor that is used when passed a List as a parameter
    public EmployeeList(List<Employee> empList) {
        super();
        this.empList = empList;
    }

    // getter
    public List<Employee> getEmpList() {
        return empList;
    }

    // setter
    public void setEmpList(List<Employee> empList) {
        this.empList = empList;
    }

    @Override
    public String toString() {
        return "EmployeeList{" + "empList=" + empList + '}';
    }
    
    
}
