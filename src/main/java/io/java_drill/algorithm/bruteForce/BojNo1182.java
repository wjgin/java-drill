package io.java_drill.algorithm.bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 부분 집합의 합이 S가 되는 경우
 * 재귀호출 완전탐색
 * 모든 숫자에 대해서 합에 포함시키거나 포함시키지 않거나(0 or 1) 최대 N개의 숫자
 * => 최대 2^20 => 1억 미만의 숫자 -> 1초 연산 가능
 */
public class BojNo1182 {


    static void input(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            S = Integer.parseInt(st.nextToken());
            nums = new int[N + 1];

            st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= N; i++){
                nums[i] = Integer.parseInt(st.nextToken());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void rec_func(int k, int val) {
        if(k == N + 1){
            if(val == S) answer ++; // 모든 탐색이 끝났을 때, 현재까지의 값이 S와 같다면, 정답 개수 추가
        } else {
            // 현재 선택된 값을 더하는 경우
            rec_func(k+1, val + nums[k]);   // 현재까지의 값에서 nums의 현재행을 더해서 재귀
            // 현재 선택된 값을 더하지 않는 경우
            rec_func(k+1, val); // 더하지 않는다면 그대로 재귀
        }
    }


    static int N, S, answer;
    static int[] nums;
    public static void main(String[] args) {
        input();    // N, S, num[]를 받음
        rec_func(1, 0); // nums 1행부터 시작, 초기 값은 0
        if(S == 0) answer--;    // 아무것도 선택하지 않을때 S = 0, 아무것도 선택하지 않는 경우는 부분집합 X 이므로 해당 경우 1개를 뺀다.
        System.out.println(answer);
    }
}
