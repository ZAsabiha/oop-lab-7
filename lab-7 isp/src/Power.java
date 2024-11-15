import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

public class Power extends User implements Readcsv, Writecsv, Viewcsv {

 private String usertype = "power";

 public Power(String username, String emailaddress, int password, int userid, String usertype) {
  super(username, emailaddress, password, userid, usertype);
 }

 @Override
 public void readtocsv() {
  System.out.println("Power user can read the CSV file:");

  String filePath = "user.csv";
  try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
   String line;
   while ((line = reader.readLine()) != null) {
    System.out.println(line);
   }
  } catch (IOException e) {
   System.out.println("Error reading the CSV file: " + e.getMessage());
  }
 }

 @Override
 public void viewtocsv() {
  System.out.println("Power user can view the CSV file:");

  String filePath = "user.csv";
  try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
   System.out.println("Displaying CSV content:");
   String line;
   while ((line = reader.readLine()) != null) {
    System.out.println(line);
   }
  } catch (IOException e) {
   System.out.println("Error viewing the CSV file: " + e.getMessage());
  }
 }

 @Override
 public void addorwritetocsv() {
  System.out.println("Power user can add or write to the CSV file:");

  String filePath = "user.csv";
  String newData = "NewUser,newuser@example.com,7890,3,power";

  try (FileWriter writer = new FileWriter(filePath, true)) {
   writer.write(newData + "\n");
   System.out.println("Data written to the CSV file successfully.");
  } catch (IOException e) {
   System.out.println("Error writing to the CSV file: " + e.getMessage());
  }
 }
}
