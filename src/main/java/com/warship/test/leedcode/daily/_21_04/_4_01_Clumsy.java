package com.warship.test.leedcode.daily._21_04;

import java.util.Stack;

public class _4_01_Clumsy {
    public static int clumsy(int N) {
        Stack<Integer> container = new Stack<Integer>();
        container.push(N--);
        int tmp = 1;
        while (N > 0) {
            switch (tmp) {
                case 1:
                    container.push(container.pop() * N);
                    break;
                case 2:
                    container.push(container.pop() / N);
                    break;
                case 3:
                    container.push(N);
                    break;
                case 4:
                    container.push(-N);
                    tmp = 0 ;
            }
            tmp++;
            N--;
        }
        tmp = 0;
        while(!container.isEmpty()){
            tmp += container.pop();
        }


        return tmp;
    }

    public static void main(String[] args) {
        int clumsy = clumsy(7);

        System.out.println(clumsy);
    }
}
