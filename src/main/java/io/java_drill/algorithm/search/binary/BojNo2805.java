package io.java_drill.algorithm.search.binary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * parametric search 결정 문제
 * 전개와 결과를 뒤집기
 * 원래: M의 결과를 얻기 위한 최대 H 값은?
 * 뒤집기: H를 0~최댓값부터 확인했을 때, M을 만족하는가?
 * 주의사항: 뒤집기의 결과가 오름차순 혹은 내림차순으로 정렬됨을 만족해야함
 * 더 효과적인 풀이가 될 것인가? -> 이분탐색할 경우 O(logM)으로 더 효과적 이때 M은 M의 최대 값
 * 결정을 확인하는 경우는 N개의 나무를 확인해야하므로 N, N에 대한 이분탐색을 모두 하므로 => O(NlogM)
 *
 */
public class BojNo2805 {

    static int N, M;
    static int[] A;

    static boolean determinate(int H){
        long sum = 0;   // 중간 저장 값은 int의 범위를 벗어날 수 있다.
        for(int i = 1 ; i <= N; i ++) {
            if(A[i] > H) sum += A[i] - H;
        }
        return sum >= M;    // 자른 총 합이 M 이상이면 true
    }

    static void pro(){
        int L = 0, R = 2000000000, ans = 0;
        // 가상의 H 배열 [L...R] 사이에 정답이 존재한다. [11111000] 가장 마지막 1을 찾아내는 과정
        // 이분 탐색과 determinate로 만족하는지 확인한다.
        while(L <= R){
            int mid = (L + R) / 2;
            if(determinate(mid)){
                ans = mid;
                L = (int) (mid + 1);
            } else {
                R = mid - 1;
            }
        }
        System.out.println(ans);
    }

    static void input() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        try {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            A = new int[N+1];

            st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= N; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        input();
        pro();
    }

}
