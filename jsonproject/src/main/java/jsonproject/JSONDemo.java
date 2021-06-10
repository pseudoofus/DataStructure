
package jsonproject;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
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
        ArrayList<Employee> List1 = new ArrayList();
        List1.add(employee1);
        List1.add(employee2);
        List1.add(employee3);
        List1.add(employee4);
        
        // use object of EmployeeList class to use the ArrayList created 4 new employee
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
   
    public static boolean serializationEmployee(Employee emp){
        try{
            // creating object of ObjectMapper class
            ObjectMapper objectMapper = new ObjectMapper();
        
            // want to change Employee object to JSON object/ serialize Employee object
            objectMapper.writeValue(new File("target/emp.json"), emp);
        }catch(final IOException e ){
            // handling exception
        }
        // serialization will return true if successful
        return true;
    }
    
    public static boolean deserializationEmployee(){
        // retrieving json object to store in a java variable (deserialization)
        try{
            // creating object of ObjectMapper class
            ObjectMapper objectMapper = new ObjectMapper();
            
            // store json as a string variable
            String employeeJson = "{\"name\":\"John\",\"city\":\"KL\",\"department\":\"Enterprise Application\",\"designation\":\"Project Manager\"}";
            
            // reading the string variable and convert it to a Java object
            Employee emp =  objectMapper.readValue(employeeJson, Employee.class); // data input src = the string variable , java type value type = class or type
        }catch(final IOException e ){
            // handling exception
        }
        // will return true if successful
        return true;
    }
    
    public static boolean toTxtEmployee(){
        
        try{
            // creating object of ObjectMapper class
            ObjectMapper objectMapper = new ObjectMapper();
            
            String employeeJson = "{\"name\":\"John\",\"city\":\"KL\",\"department\":\"Enterprise Application\",\"designation\":\"Project Manager\"}";
            
            // we want to retrieve some fields from json, json node
            JsonNode jsonNode = objectMapper.readTree(employeeJson);
            // read tree read the json objec/string, then creating json struccture
            
            String empName = jsonNode.get("name").asText();
            String empCity = jsonNode.get("city").asText();
            String empDept = jsonNode.get("department").asText();
            String empDesig = jsonNode.get("designation").asText();
            
            objectMapper.writeValue(new File("target/employeNode.txt"), empName + "," + empCity+ "," + empDept+ "," +empDesig);
        }catch(final IOException e ){
            // handling exception
        }
        // will return true if successfull convertiing to .txt file
        return true;
    }
}
