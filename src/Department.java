/**
 * Class Department de tao doi tuong la mot bo phan trong cong ty
 * */
public class Department {
    private static int countDepartment = 0; //Dem so bo phan
    private int idDepartment; //Ma bo phan
    private String nameDepartment; //Ten bo phan
    private int numStaff; //Tong so nhan vien

    /**
     * Phuong thuc Department khoi tao
     *
     * @param nameDepartment ten bo phan moi
     * */
    public Department(String nameDepartment){
        countDepartment++;
        this.idDepartment = countDepartment;
        this.nameDepartment = nameDepartment;
        this.numStaff = 1;
    }

    /**
     * Phuong thuc toString hien thi cac thong tin ve bo phan
     *
     * @return Gia tri String la chuoi ghi thong tin cua bo phan
     * */
    public String toString(){
        return String.format("%-40s%-40s%s","Ma bo phan: " + this.idDepartment, "Ten bo phan: "
                + this.nameDepartment, "So nhan vien: " + this.numStaff);
    }

    /**
     * Phuong thuc getNameDepartment lay ten bo phan
     *
     * @return Gia tri String la ten bo phan
     * */
    public String getNameDepartment(){
        return this.nameDepartment;
    }

    /**
     * Phuong thuc setNumStaff tang so nhan vien cua bo phan them 1
     * */
    public void setNumStaff(){
        this.numStaff++;
    }
}
