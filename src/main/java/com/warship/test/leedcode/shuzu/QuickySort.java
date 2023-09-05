package com.warship.test.leedcode.shuzu;

import java.util.Arrays;
import java.util.Random;

public class QuickySort {

    public static void quickSort_self(int[] nums) {
        sortHelper(nums, 0, nums.length - 1);

    }

    public static void sortHelper(int[] nums, int startIndex, int endIndex) {
        System.out.println("startIndex:" + startIndex + ",endIndex:" + endIndex + ".nums:" + Arrays.toString(nums));
        if (startIndex >= endIndex) {
            return;
        }
        int start = startIndex;
        int end = endIndex;
        int tmp = nums[startIndex];
        while (startIndex != endIndex) {
            while (startIndex < endIndex && nums[endIndex] >= tmp) {
                endIndex--;
            }

            while (startIndex < endIndex && nums[startIndex] <= tmp) {
                startIndex++;
            }
            if (startIndex < endIndex) {
                int t = nums[endIndex];
                nums[endIndex] = nums[startIndex];
                nums[startIndex] = t;
            }
        }
        nums[start] = nums[startIndex];
        nums[startIndex] = tmp;
        sortHelper(nums, start, startIndex - 1);
        sortHelper(nums, startIndex + 1, end);
    }


    //官方的 快排
    public int[] sortArray(int[] nums) {
        randomizedQuicksort(nums, 0, nums.length - 1);
        return nums;
    }

    public void randomizedQuicksort(int[] nums, int l, int r) {
        if (l < r) {
            int pos = randomizedPartition(nums, l, r);
            randomizedQuicksort(nums, l, pos - 1);
            randomizedQuicksort(nums, pos + 1, r);
        }
    }

    public int randomizedPartition(int[] nums, int l, int r) {
        int i = new Random().nextInt(r - l + 1) + l; // 随机选一个作为我们的主元
        swap(nums, r, i);
        return partition(nums, l, r);
    }

    public int partition(int[] nums, int l, int r) {
        int pivot = nums[r];
        int i = l - 1;
        for (int j = l; j <= r - 1; ++j) {
            if (nums[j] <= pivot) {
                i = i + 1;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, r);
        return i + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{5, 1, 1, 2, 0, 0};
        quickSort_self(nums);
        System.out.println(Arrays.toString(nums));
    }
}
