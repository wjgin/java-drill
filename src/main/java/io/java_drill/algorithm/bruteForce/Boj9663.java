package io.java_drill.algorithm.bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.invoke.CallSite;

/**
 * NQueen 문제
 * 숫자 N이 들어오면 N x N 체스판에 퀸이 놓일 수 있는 경우를 모두 탐색
 * 완전탐색으로 푼다면 O(N^N) 14^14 => 1억을 훨씬 초과 1<=N<=14  까지는 가능
 * 모든 걸 탐색하지 않고 특정 row에서 더 이상 성립가능하지 않다면 하위의 경우는 모두 탐색하지 않는다.
 */
public class Boj9663 {

    static void input(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            N = Integer.parseInt(br.readLine());
            selected = new int[N + 1];
            answer = 0;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void rec_func(int row){
        if(row == N + 1){   // 모든 탐색이 끝난 경우
            answer++;   // row가 N까지 모두 가능한 경우
        } else {
            for(int col = 1; col <= N; col++){  // 현재 row를 기준으로 모든 col을 탐색
                boolean valid = true;   // 현재 row, col이 가능한지 체크
                for(int pre_row = 1; pre_row < row; pre_row++){ // 현재 row 이전의 값들을 순서대로 비교
                    int pre_col = selected[pre_row];
                    if(pre_col == col){ // 같은 열에 있을 경우
                        valid = false;
                        break;
                    }
                    if(Math.abs(pre_row-row) == Math.abs(pre_col-col)){ // 기울이가 1인경우(대각선인 경우)
                        valid = false;
                        break;
                    }
                }
                if(valid) { // 이전 row을 탐색하여 현재 row, col에 퀸이 놓일 수 있을 경우
                    selected[row] = col;
                    rec_func(row+1);
                    selected[row] = 0;
                }
            }
        }

    }

    static int N, answer;   // N x N 체스판, 가능한 경우의 갯수
    static int[] selected;  // 선택된 열을 저장

    public static void main(String[] args) {
        input();  // 입력 받기
        rec_func(1);    // 1행 부터 시작
        System.out.println(answer);
    }
}
