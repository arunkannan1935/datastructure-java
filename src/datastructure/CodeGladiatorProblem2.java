package datastructure;
/*
 * Enter your code here. Read input from STDIN. Print your output to STDOUT.
 * Your class should be named CandidateCode.
 */

import java.io.*;
import java.util.*;

public class CodeGladiatorProblem2 {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        String virusSequence = sc.nextLine();
        int noOfPeople = Integer.valueOf(sc.nextLine());
        String[] virusArray = new String[noOfPeople];
        for (int i = 0; i < noOfPeople; i++) {
            virusArray[i] = sc.nextLine();
        }

        for (int j = 0; j < virusArray.length; j++) {
            String result = testSequence(virusArray[j], virusSequence);
            System.out.println(result);
        }
    }

    public static String testSequence(String virus, String sequence) {
//        if(virus.length() == 0 || sequence.length() ==0){
//            return "NEGATIVE";
//        }

        int i = 0, j = 0;
        while (i < sequence.length() && j < virus.length()) {
            if (sequence.charAt(i) == virus.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
            }
        }
        if (i == sequence.length() && j != virus.length()) {
            return "NEGATIVE";
        } else {
            return "POSITIVE";
        }
    }
}
