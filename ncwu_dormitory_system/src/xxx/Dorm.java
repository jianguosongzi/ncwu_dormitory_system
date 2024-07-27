package xxx;

//宿舍类
public class Dorm {
    private int DormitoryID;
    private String DormitoryType;
    private int Capacity;
    private String OccupancyStatus;
    private int AdminID;


    public Dorm(int DormitoryID, String DormitoryType, int Capacity,String OccupancyStatus,int AdminID) {
        this.DormitoryID = DormitoryID;
        this.DormitoryType = DormitoryType;
        this.Capacity =Capacity;
        this.OccupancyStatus=OccupancyStatus;
        this.AdminID=AdminID;

    }
    public Dorm()
    {

    }

    public String getOccupancyStatus() {
        return OccupancyStatus;
    }

    public void setOccupancyStatus(String occupancyStatus) {
        OccupancyStatus = occupancyStatus;
    }

    public int getAdminID() {
        return AdminID;
    }

    public void setAdminID(int adminID) {
        AdminID = adminID;
    }

    public int getCapacity(){return Capacity;}

    public void setDormitoryID(int dormitoryID) {
        this.DormitoryID = dormitoryID;
    }

    public void setDormitoryType(String dormitoryType) {
        this.DormitoryType = dormitoryType;
    }

    public void setCapacity(int capacity) {
        this.Capacity = capacity;
    }

    public int getDormitoryID() {
        return DormitoryID;
    }

    public String getDormitoryType() {
        return DormitoryType;
    }




}