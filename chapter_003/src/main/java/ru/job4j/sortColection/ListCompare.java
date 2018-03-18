package ru.job4j.sortColection;

import java.util.*;

public class ListCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int r = 0;
        int x = left.toCharArray().length;
        int y = right.toCharArray().length;
        for (int i = 0; i < (x < y ? x : y); i++) {
            if (left.toCharArray()[i] < right.toCharArray()[i]) {
                r = -1;
                break;
            } else if(left.toCharArray()[i] > right.toCharArray()[i]) {
                r = 1;
                break;
            } else {
                if (x < y) {
                    r = -1;
                } else if (x > y) {
                    r = 1;
                } else {r = 0;}
            }
        } return r;
    }
}
