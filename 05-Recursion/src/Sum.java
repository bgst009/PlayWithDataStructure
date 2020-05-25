import java.util.Arrays;

/**
 * @author yin_zhong_en
 * @version 1.0.0
 * @ClassName Sum.java
 * @createTime 2020年05月25日 19:54:00
 */
public class Sum {
    public static int sum(int[] arr) {
        return sum(arr, 0);
    }

    /**
     * 计算arr[l...n)这个区间内所有数字的和
     *
     * @param arr 数组
     * @param l   左边界
     * @return 和
     */
    private static int sum(int[] arr, int l) {
        /**
         * 判断左边界死否达到数组长度
         */
        if (l == arr.length) {
            return 0;
        }

        /**
         * 求和
         */
        return arr[l] + sum(arr, l + 1);
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0,};
        System.out.println(sum(array));
    }
}
