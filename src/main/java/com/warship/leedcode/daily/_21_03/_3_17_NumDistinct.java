package  com.warship.leedcode.daily._21_03;

/**
 * 115. 不同的子序列
 */
public class _3_17_NumDistinct {

    public static int numDistinct(String s, String t) {
        char[] schars = s.toCharArray();
        char[] tchars = t.toCharArray();
        return getDistinctFromIndex(s.toCharArray(), t.toCharArray(), 0, 0, 0);

    }


    /**
     * @param schars s数据源
     * @param tchars t数据源
     * @param sindex s开始索引
     * @param tindex t开始索引
     * @param sum    结果总数
     * @return
     */
    public static int getDistinctFromIndex(char[] schars,
                                           char[] tchars,
                                           int sindex,
                                           int tindex,
                                           int sum) {
//      if(schars.length - sindex < tchars.length - tindex) {
//         return sum;
//      }
        for (int x = sindex; x < schars.length; x++) {
            //当以第一个字符为起点:

            //说明tchars已经被遍历完了,出口，开始往外套
            if (tindex == tchars.length - 1) {
                for (int i = x; i < schars.length; i++) {
                    if (schars[i] == tchars[tindex]) {
                        sum++;
                    }
                }
                return sum;
            }

            if (schars[x] == tchars[tindex]) {
                sum = getDistinctFromIndex(schars, tchars, x + 1, tindex + 1, sum);
            }
        }
        return sum;
    }


    public static void main(String[] args) {

        String s = "adbdadeecadeadeccaeaabdabdbcdabddddabcaaadbabaaedeeddeaeebcdeabcaaaeeaeeabcddcebddebeebedaecccbdcbcedbdaeaedcdebeecdaaedaacadbdccabddaddacdddc";
        String t = "bcddceeeebecbc";
//700531452
//        int numDistinct = numDistinct("babgbag", "bag");
        int numDistinct = numDistinct(s, t);
//        int numDistinct = numDistinct("babaagg", "bag");

//        int numDistinct = numDistinct("bbgg", "bg");
        System.out.println(numDistinct);

    }
}
