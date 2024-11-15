import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FilterReader;
import java.util.ArrayList;

public class UserManager {
    private static final String USER_FILE ="User.csv";
    private static final String ADMIN_FILE = "Admin.csv";
    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<Admin> admins = new ArrayList<>();
    private User authenticatedUser = null;
    private static UserManager instance;
    private UserManager(){
    loadUser();
    loadAdmin();
    }
    public static UserManager getinstance(){
        if(instance==null){
            instance=new UserManager();
        }
        return instance;
    }
    private void loadUser(){

        try{
            BufferedReader reader = new BufferedReader(new FileReader(USER_FILE));
            String line=reader.readLine();
            while(line!=null){
                String parts[]=line.split(" ,");
                String username=parts[0].trim();
                String Emailaddress=parts[1].trim();
                int password = Integer.parseInt(parts[2].trim());
                int userid = Integer.parseInt(parts[3].trim());
                String usertype = parts[4].trim();

             User user;
                if ("Regular".equals(usertype)) {
                 user = new Regular(username, Emailaddress,userid, password,usertype);
             }
               else if ("power".equals(usertype)) {
                    user = new Power(username, Emailaddress,userid, password,usertype);
                }

             users.add(user);

            }

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }


private void loadAdmin(){

    try{
        BufferedReader reader = new BufferedReader(new FileReader(ADMIN_FILE));
        String line=reader.readLine();
        while(line!=null){
            String parts[]=line.split(" ,");
            String username=parts[0].trim();
            String Emailaddress=parts[1].trim();
            int password = Integer.parseInt(parts[2].trim());
            int userid = Integer.parseInt(parts[3].trim());
            String usertype = parts[4].trim();

            Admin admin;

                admin = new Admin(username, Emailaddress,userid, password,usertype);



            admins.add(admin);

        }

    }
    catch(Exception e){
        e.printStackTrace();
    }
}
    public boolean authenticate(String username, int password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                authenticatedUser = user;
                return true;
            }
        }
        for (Admin admin : admins) {
            if (admin.getUsername().equals(username) && admin.getPassword().equals(password)) {
                authenticatedUser = admin;
                return true;
            }
        }
        return false;
    }
    public void performFileOperation(String operation) {
        if (authenticatedUser == null) {
            System.out.println("No user authenticated.");
            return;
        }

        switch (operation) {
            case "view":
                System.out.println(authenticatedUser.getusertype() + " can view file contents.");
                break;
            case "add":
                if ("Admin".equals(authenticatedUser.getusertype()) || "Power".equals(authenticatedUser.getUserType())) {
                    System.out.println(authenticatedUser.getuserType() + " can add file contents.");
                } else {
                    System.out.println("Access denied. Only Admin and Power User can add contents.");
                }
                break;
            case "modify":
                if ("Admin".equals(authenticatedUser.getUserType())) {
                    System.out.println("Admin can modify file contents.");
                } else {
                    System.out.println("Access denied. Only Admin can modify contents.");
                }
                break;
            default:
                System.out.println("Unknown operation.");
        }
    }

    public void logout() {
        authenticatedUser = null;
    }

}
              }
