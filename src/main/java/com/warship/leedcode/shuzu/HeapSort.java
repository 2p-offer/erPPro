package  com.warship.leedcode.shuzu;

public class HeapSort {
    public static void main(String[] args) {
        int[] array = {19, 38, 7, 36, 5, 5, 3, 2, 1, 0, 56};
//        int[] array = {2,4,1,6,5};

        System.out.println("排序前:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ",");
        }

        System.out.println();
        System.out.println("分割线---------------");

        heapSort_Self(array);

        System.out.println("排序后:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ",");
        }
    }

    public static void heapSort_Self(int[] target) {
        if (target == null || target.length == 0) {
            return;
        }
        buildHeap_self(target);
        dealHeap_self(target);
    }

    private static void buildHeap_self(int[] target) {
        int length = target.length;
        for (int i = length / 2; i >= 0; i--) {
            makeMaxHeap_self(target, length, i);
        }
    }

    private static void makeMaxHeap_self(int[] target, int length, int i) {
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        int maxIndex = i;
        if (left < length && target[left] > target[maxIndex]) {
            maxIndex = left;
        }
        if (right < length && target[right] > target[maxIndex]) {
            maxIndex = right;
        }
        if (maxIndex != i) {
            swap_self(target, i, maxIndex);
            makeMaxHeap_self(target, length, maxIndex);
        }


    }

    private static void swap_self(int[] target, int i, int j) {

        int tmp = target[i];
        target[i] = target[j];
        target[j] = tmp;
    }

    private static void dealHeap_self(int[] target) {
        for (int i = target.length - 1; i > 0; i--) {
            swap_self(target, i, 0);
            makeMaxHeap_self(target, i, 0);
        }
    }


    public static void heapSort(int[] array) {
        if (array == null || array.length == 1)
            return;

        buildMaxHeap(array); // 第一次排序，构建最大堆，只保证了堆顶元素是数组里最大的

        for (int i = array.length - 1; i >= 1; i--) {
            // 这个是什么意思呢？，经过上面的一些列操作，目前array[0]是当前数组里最大的元素，需要和末尾的元素交换
            // 然后，拿出最大的元素
            swap(array, 0, i);

            // 交换完后，下次遍历的时候，就应该跳过最后一个元素，也就是最大的那个值，然后开始重新构建最大堆
            // 堆的大小就减去1，然后从0的位置开始最大堆
            maxHeap(array, i, 0);
//            minHeap(array, i, 0);
        }
    }

    // 构建堆
    public static void buildMaxHeap(int[] array) {
        if (array == null || array.length == 1)
            return;

        // 堆的公式就是 int root = 2*i, int left = 2*i+1, int right = 2*i+2;
        int cursor = array.length / 2;
        for (int i = cursor; i >= 0; i--) { // 这样for循环下，就可以第一次排序完成
            maxHeap(array, array.length, i);
//            minHeap(array, array.length, i);
        }
    }

    // 最大堆
    public static void maxHeap(int[] array, int heapSize, int index) {
        int left = index * 2 + 1; // 左子节点
        int right = index * 2 + 2; // 右子节点
        int maxValue = index; // 暂时定在Index的位置就是最大值

        // 如果左子节点的值，比当前最大的值大，就把最大值的位置换成左子节点的位置
        if (left < heapSize && array[left] > array[maxValue]) {
            maxValue = left;
        }

        // 如果右子节点的值，比当前最大的值大，就把最大值的位置换成右子节点的位置
        if (right < heapSize && array[right] > array[maxValue]) {
            maxValue = right;
        }

        // 如果不相等，说明啊，这个子节点的值有比自己大的，位置发生了交换了位置
        if (maxValue != index) {
            swap(array, index, maxValue); // 就要交换位置元素

            // 交换完位置后还需要判断子节点是否打破了最大堆的性质。最大堆性质：两个子节点都比父节点小。
            maxHeap(array, heapSize, maxValue);
        }
    }

    // 最小堆
    public static void minHeap(int[] array, int heapSize, int index) {
        int left = index * 2 + 1; // 左子节点
        int right = index * 2 + 2; // 右子节点
        int maxValue = index; // 暂时定在Index的位置就是最小值

        // 如果左子节点的值，比当前最小的值小，就把最小值的位置换成左子节点的位置
        if (left < heapSize && array[left] < array[maxValue]) {
            maxValue = left;
        }

        //  如果右子节点的值，比当前最小的值小，就把最小值的位置换成左子节点的位置
        if (right < heapSize && array[right] < array[maxValue]) {
            maxValue = right;
        }

        // 如果不相等，说明啊，这个子节点的值有比自己小的，位置发生了交换了位置
        if (maxValue != index) {
            swap(array, index, maxValue); // 就要交换位置元素

            // 交换完位置后还需要判断子节点是否打破了最小堆的性质。最小性质：两个子节点都比父节点大。
            minHeap(array, heapSize, maxValue);
        }
    }

    // 数组元素交换
    public static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}

