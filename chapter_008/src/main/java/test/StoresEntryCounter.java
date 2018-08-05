package test;

import java.util.ArrayList;
import java.util.List;

public class StoresEntryCounter {
    private static StoresEntryCounter inst;

    public static List<EntryCounter> list = new ArrayList<>();
    public StoresEntryCounter() {
        this.list = list;
    }
    public static List<EntryCounter> getList() {
        if(inst == null) {
            inst = new StoresEntryCounter();
        } return list;
    }
}

