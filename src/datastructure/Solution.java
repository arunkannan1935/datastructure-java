package datastructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
    public static void main(String args[]) {
        int[] var = {1,5,0,4,1,3};
        System.out.println("Answer: " + new Solution().increasingTriplet(var));
    }

    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3)
            return false;

        for (int i = 2; i < nums.length; i++) {
            System.out.println(findTriplet(nums, i - 2, i - 1, i));
            if (findTriplet(nums, i - 2, i - 1, i)) {
                return true;
            }
        }
        return false;

    }

    boolean result = false;

    public boolean findTriplet(int[] nums, int i, int j, int k) {

        if (k < nums.length) {

            if (nums[i] < nums[j]) {
                if (nums[j] < nums[k]) {
                    result = true;
                } else {
                    findTriplet(nums, i, j, k + 1);
                }
            } else {
                System.out.println("Here"+i+""+k);
                findTriplet(nums, i, k, k + 1);
            }
        }
        return result;
    }


    class BIT {
        int[] bit;
        int size;

        public BIT() {
            bit = new int[100001];
            int size = 0;
        }

        public void insert(int x) {
            while (x < 100001) {
                bit[x] += 1;
                x += (x & -x);
            }
            size += 1;
        }

        public int count(int x) {
            int cnt = 0;
            while (x > 0) {
                cnt += bit[x];
                x -= (x & -x);

            }
            System.out.println("X value" + cnt);
            return cnt;
        }
    }

    public int createSortedArray(int[] instructions) {
        int n = instructions.length;
        int mod = 1000000000 + 7;

        BIT tree = new BIT();
        long cost = 0;
        for (int i = 0; i < n; i++) {
            int less = tree.count(instructions[i] - 1);
            System.out.println("less" + less);
            int greater = tree.size - tree.count(instructions[i]);
            System.out.println("greater" + greater);

            cost += Math.min(less, greater);
            System.out.println("Cost" + cost);
            tree.insert(instructions[i]);
        }

        return (int) (cost % mod);
    }

   /* public int createSortedArray(int[] instructions) {
        return count(instructions, 0, instructions.length - 1);
    }*/

    public int count(int[] instructions, int left, int right) {
        int count = 0;
        List<Integer> tempArray = new ArrayList();
        tempArray.add(instructions[0]);
        for (int i = 1; i < instructions.length; i++) {
            tempArray.add(instructions[i]);
            //printArray(tempArray);
            System.out.print("\n");
            int position = i;
            int cost = 0;
            Collections.sort(tempArray);
            for (int j = 0; j < tempArray.size(); j++) {
                if (tempArray.get(j) == instructions[i]) {
                    cost = i - (j);
                    position = tempArray.indexOf(instructions[i]);
                }
            }
            //printArray(tempArray);
            System.out.print("\n");
            System.out.println(position + " " + cost + " " + Math.min(cost, position));
            count = count + (Math.min(cost, position));
        }
        return count;
    }

    public void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public void printArray(List<Integer> array) {
        for (int arr : array) {
            System.out.print(arr);
        }
        // System.out.println("\n");
    }
}