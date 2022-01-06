/**
 * Class truu tuong staff dinh nghia doi tuong la mot nhan vien cong ty
 * */
public abstract class Staff {
    private static int countStaff = 0;  //Dem tong so nhan vien cong ty
    private int id; //Id nhan vien
    private String name; //Ten nhan vien
    private int age; //Tuoi nhan vien
    private double coefficientsSalary; //He so luong
    private String dayStart; //Ngay bat dau lam
    private String department; //Bo phan lam viec
    private int vacationDay; //So ngay nghi

    /**
     * Phuong thuc khoi tao cho Staff
     *
     * @param name ten nhan vien
     * @param age tuoi nhan vien
     * @param coefficientsSalary he so luong
     * @param dayStart ngay bat dau lam viec
     * @param department ten bo phan lam viec
     * */
    public Staff(String name, int age, double coefficientsSalary, String dayStart, String department){
        countStaff++;
        this.id = countStaff; //Thiet lap id tu dong theo so nhan vien cong ty
        this.name = name;
        this.age = age;
        this.coefficientsSalary = coefficientsSalary;
        this.dayStart = dayStart;
        this.department = department;
        this.vacationDay = 12; //Thiet lap ngay nghi mac dinh la 12 ngay
    }

    /**
     * Phuong thuc truu tuong displayInformation hien thi thong tin nhan vien
     *
     * @param showSalary chon hien thi thong tin chung hay hien thi bang luong
     * */
    public abstract void displayInformation(boolean showSalary);

    /**
     * Phuong thuc getId lay Id nhan vien
     *
     * @return Gia tri int la Id nhan vien
     * */
    public int getId(){
        return this.id;
    }

    /**
     * Phuong thuc getName lay ten nhan vien
     *
     * @return Gia tri String la ten nhan vien
     * */
    public String getName(){
        return this.name;
    }

    /**
     * Phuong thuc getAge lay tuoi nhan vien
     *
     * @return Gia tri int la tuoi nhan vien
     * */
    public int getAge(){
        return this.age;
    }

    /**
     * Phuong thuc getCoefficientsSalary lay he so luong nhan vien
     *
     * @return Gia tri double la he so luong nhan vien
     * */
    public double getCoefficientsSalary(){
        return this.coefficientsSalary;
    }

    /**
     * Phuong thuc getDayStart lay ngay bat dau lam cua nhan vien
     *
     * @return Gia tri String la ngay bat dau lam cua nhan vien
     * */
    public String getDayStart(){
        return this.dayStart;
    }

    /**
     * Phuong thuc getDepartment lay bo phan cua nhan vien
     *
     * @return Gia tri String la bo phan cua nhan vien
     * */
    public String getDepartment(){
        return this.department;
    }

    /**
     * Phuong thuc getVacationDay lay so ngay nghi cua nhan vien
     *
     * @return Gia tri int la so ngay nghi cua nhan vien
     * */
    public int getVacationDay(){
        return this.vacationDay;
    }

    /**
     * Phuong thuc truu tuong getSalary lay luong cua nhan vien
     *
     * @return Gia tri double la luong cua nhan vien
     * */
    public abstract double getSalary();
}
