package io.java_drill.algorithm.search.binary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BojNo7795 {



    static int T, N, M;
    static int L, R, mid, result, answer;
    static int[]A, B;
    static int[] list;

    static StringBuilder st = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) {
        try {
            T = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(int i = 1; i <=T; i++) {
            answer = 0;
            // 값 입력 받기
            input();
            // 탐색
            find();
            // 출력
            System.out.println(answer);
        }
    }

    private static void find() {
        // B배열 정렬시키기
        Arrays.sort(B, 1, M+1);
        for(int x : A) {
            // 이진 탐색
            answer += binary_search(B, 1, B.length - 1, x);
        }
    }

    private static int binary_search(int[] arr, int L, int R, int target) {
        result = 0;
        while(L <= R) {
             mid = (R+L) / 2;
             if(arr[mid] < target){
                 result = mid;
                 L = mid + 1;
             } else {
                 R = mid - 1;
             }
         }
         return result;
    }

    private static void input() {
        StringTokenizer st;

        try {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            A = new int[N+1];
            B = new int[M+1];

            // A 배열 입력 받기
            st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= N; i ++){
                A[i] = Integer.parseInt(st.nextToken());
            }

            // B 배열 입력 받기
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= M; j ++){
                B[j] = Integer.parseInt(st.nextToken());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
