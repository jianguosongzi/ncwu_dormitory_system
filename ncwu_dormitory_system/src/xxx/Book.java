package xxx;

//预约记录类
public class Book {
    private int ReservationID;
    private int EmployeeID;
    private int DormitoryID;

    private int AdminID;
    private String OccupancyStatus;

    public Book(int reservationID, int employeeID, int dormitoryID, int adminID, String occupancyStatus) {
        ReservationID = reservationID;
        EmployeeID = employeeID;
        DormitoryID = dormitoryID;
        AdminID = adminID;
        OccupancyStatus = occupancyStatus;
    }

    public int getReservationID() {
        return ReservationID;
    }

    public void setReservationID(int reservationID) {
        ReservationID = reservationID;
    }

    public int getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(int employeeID) {
        EmployeeID = employeeID;
    }

    public int getDormitoryID() {
        return DormitoryID;
    }

    public void setDormitoryID(int dormitoryID) {
        DormitoryID = dormitoryID;
    }

    public int getAdminID() {
        return AdminID;
    }

    public void setAdminID(int adminID) {
        AdminID = adminID;
    }

    public String getOccupancyStatus() {
        return OccupancyStatus;
    }

    public void setOccupancyStatus(String occupancyStatus) {
        OccupancyStatus = occupancyStatus;
    }
}
