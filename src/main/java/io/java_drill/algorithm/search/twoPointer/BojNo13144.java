package io.java_drill.algorithm.search.twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 연속한 한 개 이상의 수 => 투 포인터를 고려
 * 풀이
 * 1. 특정부분에서 연속한 부분을 뽑았을때, 중복되는 부분이 없다면, 연속한 부분 수열의 개수는 해당 길이와 같다.
 * 2. 투 포인터로 이동하면서 이미 존재하는 값인지 확인하는 방법은 count 배열을 이용한다.
 */
public class BojNo13144 {
    static int N;
    static int[] A;
    static int[] cnt = new int[100001];

    static void pro(){
        // 초기값
        int R = 0;
        long ans = 0;
        // L은 1부터 시작해서 끝까지 탐색
        for(int L = 1; L <= N; L ++) {
            // R + 1이 존재하지 않는다면 count 배열을 체크하며 R을 최대한 이동
            while (R + 1 <=N && cnt[A[R+1]] == 0){
                cnt[A[++R]] = 1;
            }
            // 연속된 수열의 개수를 더하기
            ans += (R-L+1);
            // 현재 L을 제외한다.
            cnt[A[L]] = 0;
        }
        System.out.println(ans);
    }

    static void input(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        try {
            N = Integer.parseInt(br.readLine());

            A = new int[N+1];
            st = new StringTokenizer(br.readLine());

            for(int i = 1; i <=N; i++){
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
