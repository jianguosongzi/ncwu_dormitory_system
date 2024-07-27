package xxx;

//管理员类
public class Admin {
    private int AdminID;
    private String Username;
    private String Email;
    private String Password;

    public Admin(int adminID, String username, String email, String password) {
        AdminID = adminID;
        Username = username;
        Email = email;
        Password = password;
    }

    public int getAdminID() {
        return AdminID;
    }

    public void setAdminID(int adminID) {
        AdminID = adminID;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
