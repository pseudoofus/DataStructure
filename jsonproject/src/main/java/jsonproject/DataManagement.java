
package jsonproject;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataManagement {
    
    // a method for reading data from JSON to POJO
    public EmployeeList readAllData(){
        
        EmployeeList el = new EmployeeList();
        
        try {
            // readerFor is to specify what class are we expecting
            el = new ObjectMapper().readerFor(EmployeeList.class).readValue(new File("target/Employees.json"));
        } catch (IOException ex) { // io exception if there is no mentioned file 
            Logger.getLogger(DataManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return el; // will return the list of employees and store it in an object of EmployeeList
    }
    
    // a method to write data from POJO to JSON
    public void writeAllData(EmployeeList e) throws IOException{ // io exception thrown 1st time
        ObjectMapper om = new ObjectMapper();
        
        // writerWithDefaultPrettyPrinter is to write json files with indents to be more readable/ reformat 
        om.writerWithDefaultPrettyPrinter().writeValue(new File("target/Employees.json"), e);
    }
}
