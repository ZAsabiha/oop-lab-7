import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Regular extends User implements Readcsv, Viewcsv {

    private String usertype = "regular";

    public Regular(String username, String emailaddress, int password, int userid, String usertype) {
        super(username, emailaddress, password, userid, usertype);
    }

    @Override
    public void readtocsv() {
        System.out.println("Regular user can read the CSV file:");

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
        System.out.println("Regular user can view the CSV file:");

    }

    @Override
    public String getUsertype() {
        return usertype;
    }
}
