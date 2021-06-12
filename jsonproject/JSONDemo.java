
package jsonproject;

import java.io.IOException;
import java.util.ArrayList;

public class JSONDemo {

    public static void main(String[] args) throws IOException { // io exception thrown 2nd time
        Employee employee1= new Employee("Zariff", "KL", "Enterprise Application", "Project Manager");
        Employee employee2= new Employee("Zariff", "KL", "Enterprise Application", "Project Manager");
        Employee employee3= new Employee("Zariff", "KL", "Enterprise Application", "Project Manager");
        Employee employee4= new Employee("Zariff", "KL", "Enterprise Application", "Project Manager");
        
        // creating a new object of EmployeeList class 
        EmployeeList employeeList1 = new EmployeeList();
        
        // creating an ArrayList consists of 4 new employee
        // note that json file cannot be appended, if there is new element of arrayList that want to add,
        // have to overwrite previous ones
        ArrayList<Employee> List1 = new ArrayList();
        List1.add(employee1);
        List1.add(employee2);
        List1.add(employee3);
        List1.add(employee4);
        
        // generating a senior employee objects 
        seniorEmployee seniorEmployee1= new seniorEmployee("Zariff", "KL", "Enterprise Application", "Project Manager",'A', true);
        
        // adding senior employee to the list 
        List1.add(seniorEmployee1);
        
        // use object of EmployeeList class to use the ArrayList created, 4 new employee
        employeeList1.setEmpList(List1);
        
        // an object of DataManagement class for the usage of read and write values
        DataManagement dm1 = new DataManagement();
        
        // writing data of employeeList1 to json object
        dm1.writeAllData(employeeList1);
        
        // reading data of employeeList1 and store it in employeeList2
        EmployeeList employeeList2 = new EmployeeList();
        employeeList2 = dm1.readAllData();
        
        System.out.println("The list read from json file is: " + employeeList2.getEmpList().toString());
        
        // can read specific field of car
        // say want to retrieve the profile of the second employee
        System.out.println("The second employee is: " + employeeList2.getEmpList().get(1)); // get the second element of employeeList2
                
        // serializationEmployee(employee1);
        
        
    } 
   
}
