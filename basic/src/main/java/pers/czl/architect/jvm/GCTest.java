package pers.czl.architect.jvm;

import java.util.ArrayList;
import java.util.List;

public class GCTest {
    public static void main(String[] args) throws InterruptedException {
        List<GCTest> list = new ArrayList<>();
        for(;;) {
            list.add(new GCTest());
            Thread.sleep(100);
        }
    }
}
