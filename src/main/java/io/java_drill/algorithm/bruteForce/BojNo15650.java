package io.java_drill.algorithm.bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 재귀 함수를 이용한 완전 탐색
 * 1과 N 사이의 자연수를 중복 가능하여 M개를 출력(1<=M<=N<=8)
 * 오름차순이여야 한다.
 * O(N C(combination) M) = 최대 8C4 = 70 -> 완전탐색 1초 가능
 */
public class BojNo15650 {

    static StringBuilder sb = new StringBuilder();

    static void input(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        try {
            st = new StringTokenizer(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        selected = new int[M + 1];
    }

    // 1부터 M까지의 자리에 1~N까지의 숫자를 넣는 방법(재귀적)
    static void rec_func(int k) {
        if(k == M + 1) {    // 탐색이 종료 모든 조건을 찾음
            for(int i=1; i<= M; i++){   // 0번 인자는 비워뒀으므로 1번 인덱스부터 답을 저장할 sb에 삽입
                sb.append(selected[i]).append(' '); // 선택된 배열 인자를 한 줄로 삽입
            }
            sb.append('\n');    // 다음 후보 리스트와 구분하기위해 개행
        } else {
            for(int i=selected[k-1] + 1; i<=N; i++){    // 오름차순을 위해서 이전 값 보다 하나 큰 것부터 시작
                selected[k] = i;
                rec_func(k+1);
                selected[k] = 0;
            }
        }
    }

    static int N, M;
    static int[] selected;

    public static void main(String[] args){
        input();
        rec_func(1);
        System.out.println(sb.toString());
    }
}