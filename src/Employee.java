/**
 * Class Employee de tao doi tuong la mot nhan vien trong cong ty (khong phai quan ly)
 * */

public class Employee extends Staff implements ICalculator{
    private int overTime; //Thoi gian lam them
    private double salary; //Tong so tien luong

    /**
     * Phuong thuc khoi tao cho Employee
     *
     * @param name ten nhan vien
     * @param age tuoi nhan vien
     * @param coefficientsSalary he so luong
     * @param dayStart ngay bat dau lam viec
     * @param department ten bo phan lam viec
     * @param overTime thoi gian lam them
     * */
    public Employee(String name, int age, double coefficientsSalary, String dayStart, String department, int overTime){
        super(name, age, coefficientsSalary, dayStart, department);
        this.overTime = overTime;
        this.salary = calculateSalary();
    }

    /**
     * Phuong thuc displayInformation hien thi thong tin cua nhan vien (khong phai quan ly)
     *
     * @param showSalary chon hien thi thong tin chung hay hien thi bang luong
     * */
    @Override
    public void displayInformation(boolean showSalary){
        if(!showSalary) { //in cac thong tin chung cua nhan vien
            System.out.printf("%-30s%-30s%-30s%s\n","Id: " + getId(),"Ten: " + getName(), "Tuoi: " + getAge(),
                    "He so: " + getCoefficientsSalary());
            System.out.printf("%-30s%-30s%-30s%s\n", "Ngay vao lam: " + getDayStart(), "Bo phan: " + getDepartment(),
                    "Chuc danh: Khong", "So ngay nghi: " + getVacationDay());
        }
        else{ //in cac thong tin nhan vien lien quan den luong
            System.out.printf("%-10s%-30s%-20s%-30s%-30s%s\n", "Id: " + getId(), "Ten: " + getName(), "He so: " + getCoefficientsSalary(),
                    "Bo phan: " + getDepartment(), "Gio lam them: " + this.overTime, "Luong tong: " + (int)getSalary());
        }
    }

    /**
     * Phuong thuc calculateSalary tinh luong cho nhan vien (khong phai quan ly)
     *
     * @return Gia tri double la luong cua nhan vien (khong phai quan ly)
     * */
    @Override
    public double calculateSalary(){
        return getCoefficientsSalary() * 3000000 + this.overTime * 200000;
    }

    /**
     * Phuong thuc getSalary lay luong nhan vien (khong phai quan ly)
     *
     * @return Gia tri double la luong cua nhan vien (khong phai quan ly)
     * */
    @Override
    public double getSalary(){
        return this.salary;
    }
}
