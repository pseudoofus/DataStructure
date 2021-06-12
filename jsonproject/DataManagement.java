
package jsonproject;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataManagement {
    
    // a method for reading data from JSON to POJO
    public EmployeeList readAllData(){
        
        EmployeeList empList = new EmployeeList();
        
        try {
            // readerFor is to specify what class are we expecting
            empList = new ObjectMapper().readerFor(EmployeeList.class).readValue(new File("target/Employees.json"));
            
        } catch (IOException ex) { // io exception if there is no mentioned file 
            Logger.getLogger(DataManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return empList; // will return the list of employees and store it in an object of EmployeeList
    }
    
    // a method to write data from POJO to JSON
    public void writeAllData(EmployeeList e) throws IOException{ // io exception thrown 1st time
        ObjectMapper objectMapper = new ObjectMapper();
        
        // writerWithDefaultPrettyPrinter is to write json files with indents to be more readable/ reformat 
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File("target/Employees.json"), e);
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
