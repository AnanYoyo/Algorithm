package per.zqa.algorithm.tools.comparator;

import java.util.Arrays;

public class Original {

    public static void main(String[] args) {
        int testTime = 5000000;
        int maxSize = 100; // 随机数组长度0-100
        int maxValue = 100; // 值-100-100
        boolean isSucceed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = Arrays.copyOf(arr1, arr1.length);
            if (Arrays.compare(arr1, arr2) != 0) {
                isSucceed = false;
                break;
            }
        }
        System.out.println(isSucceed? "Nice!": "Failed!");
    }

    /**
     *
     * @param arr 数组1
     * @param maxSize 随机数组长度
     * @param maxValue 随机数组大小
     * @param testTime 测试次数
     */
    public void algorithmComparator(int[] arr, int maxSize, int maxValue, int testTime) {
        boolean isSucceed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = Arrays.copyOf(arr1, arr1.length);
            if (Arrays.compare(arr1, arr2) != 0) {
                isSucceed = false;
                break;
            }
        }
        System.out.println(isSucceed? "Nice!": "Failed!");
    }

    /**
     * 生成随机数组
     * @param maxSize 数组最大长度
     * @param maxValue 数组值范围
     * @return
     */
    private static int[] generateRandomArray(int maxSize, int maxValue) {
        /*
            Math.random() -> 返回[0,1)间所有小数，等概率返回一个 -> 计算机0-1小数是有穷尽的
            Math.random() * N -> 返回[0,N)间所有小数，等概率返回一个
            (int) (Math.random() * N) -> 返回[0,N-1]间所有整数，等概率返回一个
         */
        // 返回[0,(maxSize+1) -1]间所有整数，等概率返回一个
        int[] arr = new int[(int) (Math.random() * (maxSize + 1))];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) ((maxValue + 1) * Math.random());
        }
        return arr;
    }

}
