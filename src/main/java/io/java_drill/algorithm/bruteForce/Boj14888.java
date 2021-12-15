package io.java_drill.algorithm.bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

/**
 * 연산자 끼워 넣기
 * 1. 완전탐색 최대 8자리 순서를 바꾸는 것과 동일 => O(8!) -> 1초 안에 탐색이 가능함
 * 2. 숫자는 일정한 순서로 탐색, 연산자는 모든 경우를 탐색(재귀)
 *
 */
public class Boj14888 {

    // 입력
    static void input(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        try {
            N = Integer.parseInt(br.readLine());
            nums = new int[N+1];
            operators = new int[5]; // 연산자는 + - * /

            // 계산할 숫자 입력 및 배열 입력
            st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= N; i ++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }

            // 연산자 입력 및 배열에 추가
            st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= 4; i ++) {
                operators[i] = Integer.parseInt(st.nextToken());
            }

            max = Integer.MIN_VALUE;
            min = Integer.MAX_VALUE;

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static int calculate(int operator, int value, int num){
        if(operator == 1)   // +
            return value + num;
        else if(operator == 2)   // -
            return value - num;
        else if(operator == 3)   // *
            return value * num;
        else   // /
            return value / num;
    }

    static void rec_func(int k, int value) {
        if(k == N) {    // 마지막 자리는 더 이상 뒤에 연산할 값이 없으므로 종료되는 시점
            // 모든 경우가 끝, 현재 연산된 value와 최대, 최솟값을 비교
            max = Math.max(max, value);
            min = Math.min(min, value);
        } else {
            // 사용할 연산자 선택
            for(int cand = 1; cand <= 4; cand++) {
                if(operators[cand] >= 1){   // 아직 연산자의 사용횟수가 남아있다면
                    int operator = operators[cand];
                    operators[cand]--;    // 사용하면 지우기
                    int new_value = calculate(cand, value, nums[k+1]);  // 뒷 자리와 연산
                    rec_func(k+1, new_value);
                    operators[cand]++;
                }

            }
        }
    }



    static int N, value;
    static int max;
    static int min;
    static int[] nums, operators;

    public static void main(String[] args) {
        input();    //  입력 받기
        value = nums[1];
        rec_func(1, value);
        System.out.println(max + " " + min);
    }
}
