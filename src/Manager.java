/**
 * Class Manager de tao doi tuong la mot quan ly
 * */
public class Manager extends Staff implements ICalculator{
    private String title; //Chuc danh
    private double salary; //Tong so tien luong

    /**
     * Phuong thuc khoi tao cho Manager
     *
     * @param name ten nhan vien
     * @param age tuoi nhan vien
     * @param coefficientsSalary he so luong
     * @param dayStart ngay bat dau lam viec
     * @param department ten bo phan lam viec
     * @param title chuc vu
     * */
    public Manager(String name, int age, double coefficientsSalary, String dayStart, String department, String title){
        super(name, age, coefficientsSalary, dayStart, department);
        this.title = title;
        this.salary = calculateSalary();
    }

    /**
     * Phuong thuc displayInformation hien thi thong tin cua quan ly
     *
     * @param showSalary chon hien thi thong tin chung hay hien thi bang luong
     * */
    @Override
    public void displayInformation(boolean showSalary){
        if(!showSalary) { //in cac thong tin chung cua nhan vien
            System.out.printf("%-30s%-30s%-30s%s\n","Id: " + getId(),"Ten: " + getName(), "Tuoi: " + getAge(),
                    "He so: " + getCoefficientsSalary());
            System.out.printf("%-30s%-30s%-30s%s\n", "Ngay vao lam: " + getDayStart(), "Bo phan: " + getDepartment(),
                    "Chuc danh: " + this.title, "So ngay nghi: " + getVacationDay());
        }
        else{ //in cac thong tin nhan vien lien quan den luong
            System.out.printf("%-10s%-30s%-20s%-30s%-30s%s\n", "Id: " + getId(), "Ten: " + getName(), "He so: " + getCoefficientsSalary(),
                    "Bo phan: " + getDepartment(), "Chuc danh: " + this.title, "Luong tong: " + (int)getSalary());
        }
    }

    /**
     * Phuong thuc calculateSalary tinh luong cho quan ly
     *
     * @return Gia tri double la luong cua quan ly
     * */
    @Override
    public double calculateSalary(){
        double res = getCoefficientsSalary() * 5000000;
        if(this.title.equals("Business Leader")) res += 8000000;
        if(this.title.equals("Project Leader")) res += 5000000;
        if(this.title.equals("Technical Leader")) res += 6000000;
        return res;
    }

    /**
     * Phuong thuc getSalary lay luong cua quan ly
     *
     * @return Gia tri double la luong cua quan ly
     * */
    @Override
    public double getSalary(){
        return this.salary;
    }
}
