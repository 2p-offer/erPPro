package com.warship.test.leedcode.shuzu;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;


/**
 * 乱序输出 0-N
 */
public class Zero_Hundred {

    public static int[] showNums(int target) {
        int[] ans = new int[target + 1];
        Arrays.fill(ans, -1);
        Random random = new Random();
        for (int i = target; i >= 0; i--) {
            if(ans[i]!= -1){
                continue;
            }
            int randomInt = random.nextInt(i + 1);
            int indexInt = ans[randomInt] == -1 ? randomInt : ans[randomInt];
            System.out.println("arrays:"+Arrays.toString(ans)+",random:"+randomInt+",indexInt:"+indexInt);
//            if(randomInt == i && indexInt!= randomInt){
//                continue;
//            }
            ans[i] = indexInt;
            ans[randomInt] = i;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] ints = showNums(11);
        System.out.println(Arrays.toString(ints));
    }

}
