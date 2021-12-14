package io.java_drill.algorithm.bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 재귀 함수를 이용한 완전 탐색
 * 1과 N 사이의 자연수를 중복 가능하여 M개를 출력(1<=M<=N<=8)
 * 내림차순이면 안된다.
 * O(8^8) = 약 1600만보단 작은 수 -> 완전탐색 1초 가능
 */
public class BojNo15652 {

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
            int start = selected[k-1];
            if(start == 0) start = 1;   // 시작지점이라면 초기값인 0이므로 1로 변환
            for(int i=start; i<=N; i++){    // 내림차순이 안되기 위해서 본인보다 같거나 큰 수를 뒤에 사용
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
