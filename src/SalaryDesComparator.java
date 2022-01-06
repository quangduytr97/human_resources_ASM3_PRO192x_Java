import java.util.Comparator;

/**
 * Class SalaryDesComparator de so sanh nhan vien theo tien luong
 * */
public class SalaryDesComparator implements Comparator<Staff> {
    /**
     * Phuong thuc compare de so sanh
     *
     * @param s1 nhan vien 1
     * @param s2 nhan vien 2
     * @return Gia tri int la ket qua so sanh
     * */
    public int compare(Staff s1, Staff s2) {
        if (s1.getSalary() == s2.getSalary()) return 0;
        else if (s1.getSalary() < s2.getSalary()) return 1;
        else return -1;
    }
}
