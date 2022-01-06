import java.util.Comparator;

/**
 * Class DepartmentComparator de so sanh nhan vien theo thuoc tinh bo phan
 * */
public class DepartmentComparator implements Comparator<Staff> {
    /**
     * Phuong thuc compare de so sanh
     *
     * @param s1 nhan vien 1
     * @param s2 nhan vien 2
     * @return Gia tri int la ket qua so sanh
     * */
    public int compare(Staff s1, Staff s2) {
        return s1.getDepartment().compareTo(s2.getDepartment());
    }
}
