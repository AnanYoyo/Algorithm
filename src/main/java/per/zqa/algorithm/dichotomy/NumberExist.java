package per.zqa.algorithm.dichotomy;

/**
 * 判断一个数是否存在
 */
public class NumberExist {

    /**
     * 给出一个数判断是否存在于有序数组
     * @param sortedArr 有序数组
     * @param num 指定数
     * @return
     */
    public static boolean exist(int[] sortedArr, int num) {
        if (sortedArr == null || sortedArr.length == 0) {
            return false;
        }
        int L = 0; // 左下标
        int R = sortedArr.length - 1; // 右下标
        int mid = 0; // 中间位置
        // L与R 至少是两个不相同的数
        while (L < R) {
            /*
                (R + L) / 2 = R/2 + L/2 = L + (R/2 - L/2)
                ----直接 R+L 会产生int溢出问题,先减后加防止溢出---
                (R - L) / 2 = (R - L) >> 1 最快是加减位移运算
             */
            mid = L + ((R - L) >> 1);
            /*
                当指定数等于中间数 -> 直接返回
                当中间数大于指定数 -> 去掉右半区 -> 右下标缩小到中间下标且中间下标数值不为指定数 -> R = mid - 1
                当中间数小于指定数 -> 去掉左半区 -> 左下标扩大到中间下标且中间下标数值不为指定数 -> L = mid + 1
                L    mid    R
                L   R
                        L   R
             */
            if (sortedArr[mid] == num) {
                return true;
            } else if (sortedArr[mid] > num) {
                R = mid - 1;
            } else if (sortedArr[mid] < num) {
                L = mid + 1;
            }
        }
        // 当L与R相同时,需要验一下该下标是否指定数
        return sortedArr[L] == num;
    }

}
