package com.warship.test.pandora.bar;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author erp
 */
public class MainClass {

    public static void main(String[] args) {
        Comparator<PerSubTypeSortInfo> comparator = Comparator.comparing(PerSubTypeSortInfo::isMosaiced)
                .thenComparing(PerSubTypeSortInfo::getLevel)
                .thenComparing(PerSubTypeSortInfo::getPerType).reversed()
                .thenComparing(PerSubTypeSortInfo::getSubType);
        TreeSet<PerSubTypeSortInfo> sortType = new TreeSet<>(comparator);

        PerSubTypeSortInfo p1 = new PerSubTypeSortInfo(2, 1, 1, true);
        PerSubTypeSortInfo p3 = new PerSubTypeSortInfo(1, 1, 2, true);
        PerSubTypeSortInfo p2 = new PerSubTypeSortInfo(1, 1, 2, false);
        PerSubTypeSortInfo p4 = new PerSubTypeSortInfo(2, 1, 2, false);
        PerSubTypeSortInfo p5 = new PerSubTypeSortInfo(2, 3, 2, false);

        sortType.add(p1);
        sortType.add(p2);
        sortType.add(p3);
        sortType.add(p4);
        sortType.add(p5);
        sortType.forEach(System.out::println);

    }
}
