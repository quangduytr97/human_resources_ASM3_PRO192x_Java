import java.util.Comparator;

/**
 * Class IdComparator de so sanh nhan vien theo thuoc tinh Id
 * */
public class IdComparator implements Comparator<Staff> {
    /**
     * Phuong thuc compare de so sanh
     *
     * @param s1 nhan vien 1
     * @param s2 nhan vien 2
     * @return Gia tri int la ket qua so sanh
     * */
    public int compare(Staff s1, Staff s2) {
        if (s1.getId() == s2.getId()) return 0;
        else if (s1.getId() > s2.getId()) return 1;
        else return -1;
    }
}
