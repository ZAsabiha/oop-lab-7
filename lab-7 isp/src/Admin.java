import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Admin extends User implements Readcsv, Updatecsv, Systemsettings, Writecsv {

    public Admin(String username, String emailaddress, int password, int userid, String usertype) {
        super(username, emailaddress, password, userid, usertype);
    }

    @Override
    public void modifysystemsetting() {
        System.out.println("Admin can modify system settings.");

        String setting = "Enable Logging: ON";
        System.out.println("System setting modified: " + setting);
    }

    @Override
    public void updatetocsv() {
        System.out.println("Admin can update entries in the CSV file.");

        String filePath = "admin.csv";
        String oldData = "OldUser,olduser@example.com,1234,3,regular";
        String newData = "UpdatedUser,updateduser@example.com,5678,3,admin";

        try {

            List<String> lines = Files.readAllLines(Paths.get(filePath));

            for (int i = 0; i < lines.size(); i++) {
                if (lines.get(i).equals(oldData)) {
                    lines.set(i, newData);
                    break;
                }
            }
            Files.write(Paths.get(filePath), lines);
            System.out.println("CSV file updated successfully.");
        } catch (IOException e) {
            System.out.println("Error updating the CSV file: " + e.getMessage());
        }
    }

    @Override
    public void readtocsv() {
        System.out.println("Admin can read the CSV file.");

        String filePath = "admin.csv";
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
    public void addorwritetocsv() {
        System.out.println("Admin can add or write to the CSV file.");

        String filePath = "admin.csv";
        String newData = "NewAdmin,newadmin@example.com,7890,4,admin";

        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.write(newData + "\n");
            System.out.println("Data written to the CSV file successfully.");
        } catch (IOException e) {
            System.out.println("Error writing to the CSV file: " + e.getMessage());
        }
    }
}
