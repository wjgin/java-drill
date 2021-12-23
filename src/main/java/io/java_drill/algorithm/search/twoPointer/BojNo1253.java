package io.java_drill.algorithm.search.twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 아이디어
 * 정렬된 배열에서 배열에서 두 값을 더했을 때, 특정 값을 찾는 경우
 * 가장 작은 것과 큰 것을 더해서 타겟과 비교한다.
 * 두 값의 합이 타겟보다 큰 경우(가장 큰 것과 가장 작은 것을 더했다) 가장 큰 값에 어느것을 더해도 타겟보다 크다 => R--
 * 반대로 타겟보다 작다면 가장 작은 값에 어느값을 더 해도 타겟보다 작다 => L++
 */
public class BojNo1253 {
    static int N;
    static int[] A;

    static void input(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        try {
            N = Integer.parseInt(br.readLine());
            A = new int[N + 1];

            st = new StringTokenizer(br.readLine());
            for(int i = 1; i <=N; i++){
                A[i] = Integer.parseInt(st.nextToken());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static boolean check(int targetIndex){
        int L = 1, R = N;
        int target = A[targetIndex];
        while(L < R){
            // 타겟 자신을 비교하면 안되기에 타겟 인덱스와 동일하면 L 혹은 R을 이동
            if(L == targetIndex) L ++;
            else if(R == targetIndex) R --;
            else {
                if(A[L] + A[R] == target) return true;
                if(A[L] + A[R] > target) R--;
                else L ++;
            }
        }
        return false;
    }

    static void pro(){
        int ans = 0;
        // 배열을 정렬
        Arrays.sort(A, 1, N + 1);
        // 배열의 특정 값이(타겟 값) 두개의 합이 존재하는지 확인
        for(int i =1; i <=N; i++){
            int target = A[i];
            if(check(i)) ans++;    // 존재한다면 카운트
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        input();
        pro();
    }

}
