package io.java_drill.algorithm.search.binary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BojNo2470 {


    static int N, v1, v2;
    static int min = Integer.MAX_VALUE;
    static int[] arr;

    public static void main(String[] args) {
        // 입력 받기
        input();
        // 배열을 오름차순 정리
        Arrays.sort(arr, 1, N+1);
        // 이분탐색
        for(int i = 1; i <= N; i ++) {
            int result = binary_search(i+1, N, -arr[i], arr);
            // target(-arr[i])와 가장 가까운 값은 arr[result] 혹은 arr[result-1]일 것이다.
            if(result <= N && Math.abs(arr[i] + arr[result]) < min){
                min = Math.abs(arr[i] + arr[result]);
                v1 = arr[i];
                v2 = arr[result];
            }
            if(i < result - 1 && Math.abs(arr[i] + arr[result-1]) < min){
                min = Math.abs(arr[i] + arr[result-1]);
                v1 = arr[i];
                v2 = arr[result-1];
            }
        }
        // 출력
        System.out.println(v1 + " " + v2);
    }

    private static int binary_search(int L, int R, int target, int[]arr) {
        // [L...R]의 배열 중 target보다 큰 수 중 가장 왼쪽
        int result = R+1;   // 만약, target보다 큰 수가 없다면 가장 맨끝보다 하나 큰 index를 결과로 가져감
        // target에 가장 가까운 값 찾기
        int mid;
        while(L <= R){
            mid = (R+L) / 2;
            if(arr[mid] >= target){
                R = mid - 1;
                result = mid;
            } else {
                L = mid + 1;
            }
        }
        return result;
    }

    private static void input() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        try {
            N = Integer.parseInt(br.readLine());
            arr = new int[N+1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
