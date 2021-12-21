package io.java_drill.algorithm.search.binary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * C개의 공유기를 N개의 집에 설치할때 최대 D는? 재귀를 통하면 O(N^2)
 * parametric search 매개변수를 D로 놨을때, C를 만족하는지 확인하는 것이 더 효율적인가?  O(NlogD) D의 최대값(10억) => N * 32
 */
public class BojNo2110 {

    static int N, C;
    static int[] A;

    static boolean determinate(int D){
        // 탐욕 방법으로 가장 맨 위치부터 공유기를 설치하면서 확인한다.
        int cnt = 1, last = A[1];   // 맨 앞 공유기는 항상 설치
        for(int i = 2; i <= N; i ++){
            if(A[i] - last >= D){
                cnt ++;
                last = A[i];
            }
        }
        return cnt >= C;    // 주어진 조건인 C이상 설치 가능하다면 true를 리턴
    }

    static void pro(){
        // 탐색의 편리성을 위해서 오름차순 정렬한다.
        Arrays.sort(A, 1, N + 1);
        int L = 0, R = 1000000000, ans = 0;
        // 이분탐색과 결정으로 해당 조건의 최대값을 찾아본다.
        while(L <= R){
            int mid = (L + R) / 2;
            if(determinate(mid)){
                ans = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        System.out.println(ans);
    }

    private static void intput() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        try {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            A = new int[N + 1];
            for(int i = 1; i <= N; i ++){
                A[i] = Integer.parseInt(br.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        intput();
        pro();
    }
}
