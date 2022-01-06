import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class thuc thi chuong trinh quan ly nguon nhan luc Human Resources
 *
 * @author Tran Quang Duy FX11834
 * @since 02-10-2021
 *
 * */
public class HumanResources {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Staff> listStaff = new ArrayList<>(); //Danh sach nhan vien cong ty
        ArrayList<Department> listDepartment = new ArrayList<>(); //Danh sach bo phan cong ty
        String choice;

        displayChoice();
        choice = input.next();
        while (checkContinue(choice)){
            System.out.println("------------------------------------------------------");
            switch (choice){
                //Hien thi danh sach nhan vien hien co
                case "1": {
                    displayStaffById(listStaff);
                    break;
                }
                //Hien thi cac bo phan trong cong ty
                case "2": {
                    displayDepartment(listDepartment);
                    break;
                }
                //Hien thi danh sach nhan vien theo tung bo phan
                case "3": {
                    displayStaffByDepartment(listStaff);
                    break;
                }
                //Them nhan vien moi
                case "4": {
                    addStaff(listStaff, listDepartment, input);
                    break;
                }
                //Tim kiem nhan vien theo ten hoac ma nhan vien
                case "5": {
                    findStaff(listStaff, input);
                    break;
                }
                //Hien thi bang luong toan cong ty (giam dan)
                case "6": {
                    displaySalaryDes(listStaff);
                    break;
                }
                //Hien thi bang luong toan cong ty (tang dan)
                case "7": {
                    displaySalaryAs(listStaff);
                    break;
                }
            }
            System.out.println("------------------------------------------------------");
            displayChoice();
            choice = input.next();
        }
        System.out.println("Tam biet!!!");
    }

    /**
     * Phuong thuc displayChoice hien thi cac lua chon trong menu cua chuong trinh
     * */
    public static void displayChoice(){
        System.out.println("1. Hien thi danh sach nhan vien hien co trong cong ty");
        System.out.println("2. Hien thi cac bo phan trong cong ty");
        System.out.println("3. Hien thi danh sach nhan vien theo tung bo phan");
        System.out.println("4. Them nhan vien moi vao cong ty");
        System.out.println("5. Tim kiem thong tin nhan vien theo ten hoac ma nhan vien");
        System.out.println("6. Hien thi bang luong toan cong ty (giam dan)");
        System.out.println("7. Hien thi bang luong toan cong ty (tang dan)");
        System.out.print("Nhap vao so thu tu cua thao tac muon thuc hien: ");
    }

    /**
     * Phuong thuc checkContinue kiem tra xem nguoi dung co tiep tuc su dung chuong trinh khong
     *
     * @param choice Chuoi the hien lua chon cua nguoi dung nhap tu man hinh
     * @return Gia tri booolean la ket qua kiem tra, neu la true nghia la nguoi dung tiep tuc su dung
     * */
    public static boolean checkContinue(String choice){
        return (choice.equals("1") || choice.equals("2") || choice.equals("3") || choice.equals("4") ||
                choice.equals("5") || choice.equals("6") || choice.equals("7"));
    }

    /**
     * Phuong thuc displayStaffById hien thi danh sach nhan vien hien co trong cong ty
     * (hien thi theo Id, khi nguoi dung chon menu 1)
     *
     * @param listStaff Danh sach nhan vien trong cong ty
     * */
    public static void displayStaffById(ArrayList<Staff> listStaff){
        //Sap xep danh sach nhan vien theo Id tang dan
        listStaff.sort(new IdComparator());
        for(Staff st: listStaff) st.displayInformation(false);
    }

    /**
     * Phuong thuc displayDepartment hien thi danh sach cac bo phan hien co trong cong ty
     * (khi nguoi dung chon menu 2)
     *
     * @param listDepartment Danh sach bo phan trong cong ty
     * */
    public static void displayDepartment(ArrayList<Department> listDepartment){
        for(Department de: listDepartment) System.out.println(de.toString());
    }

    /**
     * Phuong thuc displayStaffByDepartment hien thi danh sach nhan vien hien co trong cong ty
     * (hien thi theo tung bo phan, khi nguoi dung chon menu 3)
     *
     * @param listStaff Danh sach nhan vien trong cong ty
     * */
    public static void displayStaffByDepartment(ArrayList<Staff> listStaff){
        //Sap xep danh sach nhan vien theo bo phan
        listStaff.sort(new DepartmentComparator());
        String dep = "";
        for (Staff st : listStaff) {
            String temp = st.getDepartment();
            if (!temp.equals(dep)){
                System.out.println("***** " + temp + " *****");
                dep = temp;
            }
            st.displayInformation(false);
        }
    }

    /**
     * Phuong thuc addStaff them nhan vien moi vao cong ty
     * (khi nguoi dung chon menu 4)
     *
     * @param listStaff Danh sach nhan vien trong cong ty
     * @param listDepartment Danh sach bo phan trong cong ty
     * @param input Scanner de nhap du lieu vao
     * */
    public static void addStaff(ArrayList<Staff> listStaff, ArrayList<Department> listDepartment, Scanner input){
        System.out.print("Ten: ");
        input.nextLine();
        String name = input.nextLine();
        System.out.print("Tuoi: ");
        int age = input.nextInt();
        System.out.print("He so luong: ");
        double coefficientsSalary = input.nextDouble();
        System.out.print("Ngay bat dau lam viec (dd-mm-yyyy): ");
        String dayStart = input.next();
        System.out.print("Bo phan lam viec: ");
        input.nextLine();
        String department = input.nextLine();

        System.out.print("Nhap \"1\" neu nguoi ban nhap la quan ly: ");
        String choice = input.nextLine();
        if(choice.equals("1")){
            System.out.print("Chuc danh: ");
            String title = input.nextLine();
            listStaff.add(new Manager(name, age, coefficientsSalary, dayStart, department, title));
        }
        else{
            System.out.print("So gio lam them: ");
            int overtime = input.nextInt();
            listStaff.add(new Employee(name, age, coefficientsSalary, dayStart, department, overtime));
        }

        //Kiem tra xem bo phan nay da ton tai hay chua
        int indexDepartment = -1;
        for(int i = 0; i < listDepartment.size(); i++){
            String temp = listDepartment.get(i).getNameDepartment();
            if(department.equals(temp)){
                indexDepartment = i;
                break;
            }
        }
        if(indexDepartment != -1){
            //Tang nhan vien len 1
            Department temp = listDepartment.get(indexDepartment);
            temp.setNumStaff();
            listDepartment.set(indexDepartment, temp);
        }
        else listDepartment.add(new Department(department));
    }

    /**
     * Phuong thuc findStaff tim kiem nhan vien theo Id hoac ten
     * (khi nguoi dung chon menu 5)
     *
     * @param listStaff Danh sach nhan vien trong cong ty
     * @param input Scanner de nhap du lieu vao
     * */
    public static void findStaff(ArrayList<Staff> listStaff, Scanner input){
        System.out.print("Nhap vao ma nhan vien hoac ten muon tim kiem: ");
        input.nextLine();
        String key = input.nextLine();
        boolean isFindOut = false;
        for(Staff st: listStaff){
            if(String.valueOf(st.getId()).equals(key) || st.getName().equalsIgnoreCase(key)) {
                st.displayInformation(false);
                isFindOut = true;
            }
        }
        if(!isFindOut) System.out.println("Khong tim thay nhan vien nao!");
    }

    /**
     * Phuong thuc displaySalaryDes hien thi danh sach nhan vien cong ty theo bang luong giam dan
     *
     * @param listStaff Danh sach nhan vien trong cong ty
     * */
    public static void displaySalaryDes(ArrayList<Staff> listStaff){
        //Sap xep nhan vien cong ty theo bang luong giam dan
        listStaff.sort(new SalaryDesComparator());
        for(Staff st: listStaff) st.displayInformation(true);
    }

    /**
     * Phuong thuc displaySalaryAs hien thi danh sach nhan vien cong ty theo bang luong tang dan
     *
     * @param listStaff Danh sach nhan vien trong cong ty
     * */
    public static void displaySalaryAs(ArrayList<Staff> listStaff){
        //Sap xep nhan vien cong ty theo bang luong tang dan
        listStaff.sort(new SalaryDesComparator());
        for(int i = listStaff.size() - 1; i >= 0; i--) listStaff.get(i).displayInformation(true);
    }
}
