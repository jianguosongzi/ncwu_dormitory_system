package xxx;

//教工类
public class Teacher {
    private int EmployeeID;
    private String Name;
    private String Password;
    private String Gender;
    private String Phone;

    public Teacher(int employeeID, String name, String password, String gender, String phone) {
        EmployeeID = employeeID;
        Name = name;
        Password = password;
        Gender = gender;
        Phone = phone;
    }

    public int getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(int employeeID) {
        EmployeeID = employeeID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }
}
