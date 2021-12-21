package io.java_drill.algorithm.search.twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 연속한, 부분수열 등 => 투 포인터 풀이를 고려
 */
public class BojNo1806 {

    static int N, S; // N최대 10만, S최대 10
    static int[] A;

    static void pro(){
        // 포인터의 초기값 설정
        int R = 0, sum = 0, ans = N + 1;
        // 이동하면서 최소 값을 찾음
        for(int L = 1; L <= N; L++){
            // 왼쪽 구간을 하나 이동
            sum -= A[L-1];
            // 현재 합이 S보다 작다면 R을 계속 이동
            while(R + 1 <= N && sum < S){
                sum += A[++R];
            }
            // 합이 S 이상이 되는 경우, 현재 연속한 수열이 더 짧다면 갱신
            if(sum >= S) {
                ans = Math.min(ans, R - L + 1);
            }
        }
        // 한번도 갱신하지 않았다면, 답은 0
        if(ans == N + 1) ans = 0;

        System.out.println(ans);

    }

    static void input() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        try {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            S = Integer.parseInt(st.nextToken());

            A = new int[N+1];
            st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= N; i++){
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
