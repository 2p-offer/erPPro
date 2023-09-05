package com.warship.test.leedcode.daily._21_05;

import java.util.List;

class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};

public class _5_01_GetImportance {
    int sum = 0;

    public int getImportance(List<Employee> employees, int id) {
        List<Integer> sub = null;
        for (Employee em : employees) {
            if (em.id == id) {
                sum += em.importance;
                sub = em.subordinates;
            }
        }
        if (sub == null || sub.isEmpty()) {
            return sum;
        }
        for (Employee em : employees) {
            if (sub.contains(em.id)) {
                getImportance(employees, em.id);
            }
        }
        return sum;
    }

    

}
