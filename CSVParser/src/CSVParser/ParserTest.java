package CSVParser;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 * A demo for CSV parser
 * Reference : https://commons.apache.org/proper/commons-csv/apidocs/org/apache/commons/csv/CSVParser.html
 *
 * Created by jacka on 3/24/2016.
 */
public class ParserTest {

    //Define CSV file header
    private static final String [] FILE_HEADER_MAPPING = {"User Name","First Name" , "Last Name" , "Display Name","Job Title",
            "Department" , "Office Number" , "Office Phone" ,"Mobile Phone" ,"Fax","Address","City","State or Province",
            "ZIP or Postal Code","Country or Region"};

    //Student attributes
    private static final String USER = "id";
    private static final String STUDENT_FNAME = "firstName";
    private static final String STUDENT_LNAME = "lastName";
    private static final String STUDENT_GENDER = "gender";
    private static final String STUDENT_AGE = "age";

    /* This is the main function */
    public static void main(String[] args) throws IOException {

        BufferedReader bfReader = new BufferedReader(new FileReader("dataSet\\Import_User_Sample_en.csv"));


        //Create the CSVFormat object with the header mapping
        CSVFormat csvFileFormat = CSVFormat.DEFAULT.withHeader(FILE_HEADER_MAPPING);

        CSVParser csvRecords = new CSVParser(bfReader, csvFileFormat);
        List<CSVRecord> recordList = csvRecords.getRecords();


        for (CSVRecord record : recordList) {
            String userName = record.get("User Name");
            String firstName = record.get("First Name");
            String lastName = record.get("Last Name");
            System.out.println("userName = " + userName + " , firstName = " + firstName
                    + " , lastName = " + lastName);
        }

    }

}
