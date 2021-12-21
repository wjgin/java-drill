package io.java_drill.algorithm.sort.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No1015 {

    static class num implements Comparable<num>{
        int value;
        int idx;

        @Override
        public int compareTo(num o) {
            return this.value - o.value;
        }
    }

    static void input(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        try {
            N = Integer.parseInt(br.readLine());
            nums = new num[N];
            answer = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i < N; i ++) {
                nums[i] = new num();
                nums[i].value = Integer.parseInt(st.nextToken());
                nums[i].idx = i;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void print(){
        sb = new StringBuilder();
        for(int i = 0; i < N; i ++) {
            answer[nums[i].idx] = i;
        }
        // System.out.println(sb.substring(1).toString());
        for (int i : answer) {
            sb.append(i).append(' ');
        }
        System.out.println(sb.toString());
    }

    static int N;
    static num[] nums;
    static int[] answer;
    static StringBuilder sb;

    public static void main(String[] args) {
        input();
        Arrays.sort(nums);
        print();

    }
}
