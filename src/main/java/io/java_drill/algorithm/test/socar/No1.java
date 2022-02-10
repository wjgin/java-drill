package io.java_drill.algorithm.test.socar;

import java.util.ArrayList;

public class No1 {
    public int solution(String s) {

        return 0;
    }
    public static int check(char c1, char c2, String s)
    {
        ArrayList<Integer> stack = new ArrayList<>();
        int result = 0;
        int idx = 0;

        for(int i = 0; i < s.length(); i ++){
            if (s.charAt(i) == c1)
            {
                stack.add(idx);
                idx++;
            }
            if (s.charAt(i) == c2) {
                stack.remove(stack.size() - 1);
                idx++;
            }
        }
        if (stack.size() != 0)
            result = idx - stack.remove(0) + 1;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(check('[', ']', "[]([]]){}"));
    }
}
