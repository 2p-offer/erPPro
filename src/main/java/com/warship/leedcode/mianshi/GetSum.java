package  com.warship.leedcode.mianshi;

public class GetSum {
    public static void main(String[] args) {
        int sum = 0;
        boolean flag = true;
        for (int i = 2; i <= 5; i++) {
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                sum += i * i;
            }
            flag = true;
        }
        System.out.println(sum);
    }

}
