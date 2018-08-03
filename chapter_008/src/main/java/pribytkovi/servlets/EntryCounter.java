package pribytkovi.servlets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 *
 * @author user600_7
 */

public class EntryCounter implements Comparable<EntryCounter> {
//public int[][] mass = new int[2][arra.length];
    List <EntryCounter> list = new ArrayList<>();
    public Integer number;
    public Integer repitCounter;
    /**
     *
     * @param number
     * @param arra
     * @return
     */

    public EntryCounter() {
    }
    public List<EntryCounter> counter(int[] arra) {
        System.out.println(arra.length);
        for (int i = 0; i < arra.length; i++) {
            Integer k = 0;
            for (int j = 0; j < arra.length; j++) {
                if (arra[i] == arra[j])
                    k++;
            }
            System.out.println(arra[i] + " " + k);
            this.number = arra[i];
            this.repitCounter = k;
            EntryCounter entr = new EntryCounter();
            this.list.add(entr);
        }
        Collections.sort(list);
        return list;
    }
    @Override
    public int compareTo(EntryCounter t) {
        int res = this.repitCounter.compareTo(t.repitCounter);
        if (res == 0) {
            res = this.number.compareTo(t.number);
        }
        return res;
    }
    public static void main (String[] args) {
        int[] array = {6, 7, 1, 7, 1, 3, 2, 7, 3, 7, 7, 7};
        EntryCounter entr = new EntryCounter();
        entr.counter(array);
    }

}
