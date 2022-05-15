package per.zqa.algorithm.dichotomy;

/**
 * 给某个数在有序数组中找到最左/最右的位置
 */
public class FindTheFarLeftOrRightByNumber {

    public static int nearestIndex(int[] arr, int value) {
        int L = 0; // 左下标
        int R = arr.length - 1; // 右下标
        int index = -1; // 位置下标
        // while判断了左右下标相等的情况，最后不需要再次判断下标是否指定数
        while (L <= R) {
            int mid = L + ((R -L) >> 1);
            /*
                当中间下标值大于或等于指定值 -> 位置下标切换为中间位置，去掉右半区
                否则去掉左半区
             */
            if (arr[mid] >= value) {
                index = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }

        return index;
    }

}
