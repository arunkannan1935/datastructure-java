package datastructure;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LeetCode {
        public static String countAndSay(int n) {

            LinkedList<Integer> prevSeq = new LinkedList<Integer>();
            prevSeq.add(1);
            // Using -1 as the delimiter
            prevSeq.add(-1);
            System.out.println(prevSeq.get(0));
            List<Integer> finalSeq = nextSequence(n, prevSeq);
            StringBuffer seqStr = new StringBuffer();
            for (Integer digit : finalSeq) {
                System.out.println("-->"+digit);
                seqStr.append(String.valueOf(digit));
            }
            return seqStr.toString();
        }

        protected static LinkedList<Integer> nextSequence(int n, LinkedList<Integer> prevSeq) {
            if (n <= 1) {
                // remove the delimiter before return
                prevSeq.pollLast();
                return prevSeq;
            }

            LinkedList<Integer> nextSeq = new LinkedList<Integer>();
            Integer prevDigit = null;
            Integer digitCnt = 0;
            for (Integer digit : prevSeq) {
                if (prevDigit == null) {
                    prevDigit = digit;
                    digitCnt += 1;
                } else if (digit == prevDigit) {
                    // in the middle of the sub-sequence
                    digitCnt += 1;
                } else {
                    // end of a sub-sequence
                    nextSeq.add(digitCnt);
                    nextSeq.add(prevDigit);
                    // reset for the next sub-sequence
                    prevDigit = digit;
                    digitCnt = 1;
                }
            }

            // add the delimiter for the next recursion
            nextSeq.add(-1);
            return nextSequence(n - 1, nextSeq);
        }
    public static int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap();
        String s = new String();
        if(map.get(1) == n)
        for(int i=0; i<n; i++){
            for(int j=1;j<n;j++) {
                if (nums[i]+nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }
    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
    }
    public static void main(String args[]) {
        int[] var = {3,2,5,9};
        int target = 7;

//        printArray(twoSum(var, target));
        System.out.println("Answer: "+countAndSay(2));
    }
}
