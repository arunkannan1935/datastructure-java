package datastructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagram {
    public static void main(String args[]) {
        String[] input = new String[]{"eat", "tea","tan","ate","nat","bat","abt"};
        System.out.println("Answer: " + new GroupAnagram().groupAnagrams(input));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList();
        boolean[] resBool = new boolean[strs.length];
        for (int i = 0; i < strs.length; i++) {
            if (!resBool[i]) {
                String str = strs[i];
                List<String> res = new ArrayList();
                Map<Character, Integer> map = new HashMap();
                for (char chrStr : str.toCharArray()) {
                    map.put(chrStr, map.getOrDefault(chrStr, 0) + 1);
                }
                resBool[i] = true;
                res.add(strs[i]);
                addRestArray(strs, i, map, res, resBool);

                if (res.size() > 0) {
                    result.add(res);
                }
            }
        }
        return result;
    }

    public void addRestArray(String[] strs, int i, Map<Character, Integer> map, List<String> res,
                                     boolean[] resBool) {
        printList(res);
        for (int j = i + 1; j < strs.length; j++) {
            boolean found = false;
             if(!resBool[j] ){
            String nextString = strs[j];
            Map<Character, Integer> copy = map;
            for (int k = 0; k < nextString.length(); k++) {
                if (copy.containsKey(nextString.charAt(k))) {
                    copy.put(nextString.charAt(k), copy.get(nextString.charAt(k)) - 1);
                } else {
                    break;
                }
                if (k +1 == nextString.length()) {
                    found = true;
                }
            }
            if (found) {
                resBool[j] = true;
                res.add(nextString);
            }
        }
         }
    }

    public void printList(List<String> list) {
        for (String str : list) {
            System.out.print(str + " ");
        }
    }
}
