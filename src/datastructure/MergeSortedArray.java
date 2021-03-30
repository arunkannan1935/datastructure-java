package datastructure;

import java.util.HashMap;

public class MergeSortedArray {

    public static void main(String args[]) {
        int[] nums1 = {3,2,20,1,1,3};
        int[] nums2 = {2, 3, 5};
        //new MergeSortedArray().printArray(new MergeSortedArray().merge(nums1, 3, nums2, 3));
        System.out.println(new MergeSortedArray().minOperations(nums1, 10));
    }

    public void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
    }

    public int minOperations(int[] nums, int x) {

        HashMap<Integer, Integer> firstHalf = new HashMap();
        HashMap<Integer, Integer> secondHalf = new HashMap();

        int n= nums.length;
        int firstSum = 0;
        int secondSum = 0;

        for(int i=0, j=n-1; i<n; i++, j--){
            int index = i+1;
            firstHalf.put(firstSum+nums[i], index);
            secondHalf.put(secondSum+nums[j], index);

            firstSum = firstSum+nums[i];
            secondSum = secondSum+nums[j];
        }
        int minValue = 100001;

        firstSum = 0;
        secondSum =0;
        for(int i=0, j=n-1; i<n; i++,j--){
            int index = i+1;
            firstSum = firstSum+nums[i];
            secondSum = secondSum+nums[j];
            if(secondHalf.containsKey(x-firstSum)){
                minValue= Math.min(minValue, index+secondHalf.get(x-firstSum));
            }

            if(firstHalf.containsKey(x-secondSum)){
                minValue= Math.min(minValue, index+firstHalf.get(x-secondSum));
            }


            if(firstSum == x || secondSum == x){
                minValue = Math.min(minValue, index);
            }
            System.out.println(index+","+ minValue);
        }
        return minValue > n ? -1 : minValue;

    }

    public int[] merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1, j = n-1, k=m+n-1;

        while (j>-1) {

            if (nums1[i] >= nums2[j]) {
                nums1[k--] = nums1[i--];
            }
                else {
                nums1[k--] = nums2[j--];
            }

            if (i<0) {
                while (j >= 0)
                    nums1[k--] = nums2[j--];

            }

        }
        return nums1;
    }

    private void swap(int[] nums1, int[] nums2, int i, int j) {
        int temp = nums1[i];
        nums1[i] = nums2[j];
        nums2[j] = temp;
    }
}
