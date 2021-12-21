package io.java_drill.algorithm.sort.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No11652 {

    static void input(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            N = Integer.parseInt(br.readLine());
            nums = new long[N];
            for(int i =0; i< N; i ++) {
                nums[i] = Long.parseLong(br.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void pro(){
        // nums 배열 정렬
        Arrays.sort(nums);
        curCnt = 1;
        maxCnt = 1;
        answer = nums[0];
        for(int i = 1; i < N; i ++) {
            // 앞의 자리와 값이 같다면, 연속되는 숫자 curCnt 증가
            if(nums[i] == nums[i-1]) curCnt++;
            else curCnt = 1;

            // curCnt가 maxCnt보다 크다면, maxCnt, answer 갱신
            if(curCnt > maxCnt){
                maxCnt = curCnt;
                answer = nums[i];
            }

        }
    }

    static int N, curCnt, maxCnt;
    static long answer;
    static long[] nums;

    public static void main(String[] args) {
        input();
        pro();
        System.out.println(answer);
    }
}
