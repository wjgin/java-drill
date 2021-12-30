package io.java_drill.algorithm.test.ebay;

import java.util.*;

public class No2 {
    /**
     * Stones 배열이 들어오면 행위를 통해서 하나의 돌맹이가 k가 되는 경우 최소 가짓수
     * 행위: 선택한 인덱스의 돌 숫자는 + 나머지는 -
     * 결과: 선택한 인덱스의 순서 중 가장 큰 숫자 ex) {1, 3, 2}의 경우 "202"가 가장 크다
     *      ㄴ 인덱스 2 -> 0 -> 2 순서로 행위를 한다는 의미
     */

    static int[] stones = {1, 3, 2};
    static int[] stone = {1, 3, 2};
    static int k;
    static int len = stone.length;
    static ArrayList<String> ans_list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();


    public static boolean check(){
        int non_zero_cnt = 0;
        int num = -1;
        for(int i = 0; i < len; i++){
            if(stone[i] != 0) {
                num = stone[i];
                non_zero_cnt++;
            }
            if(non_zero_cnt > 1) return false;
        }
        if(num != k) return false;
        return true;
    }

    public static boolean possible(){
        for(int x : stone){
            if(x == 0) return false;
        }
        return true;
    }

    public static void action(int n) {
        for (int i = 0; i < len; i++) {
            // 자기 자신이면 추가
            if (i == n) stone[i]++;
            else stone[i]--;
        }
        sb.append(n);
    }
    public static void reset() {
        sb = new StringBuilder();
        stone = stones;
    }

        public static void dfs(int n){
        // 만약 가능하면 행위
        if(possible()) {
            action(n);
            // for 문으로 다시 탐색
            for(int i = 0; i < len; i++) {
                dfs(i);
            }
        }
        else {
            // 찾는 값이 맞다면 정답 리스트에 추가
            if(check()) ans_list.add(sb.toString());
            reset();
            return;
        }
    }

    public static void pro(){
        ans_list.add("-1");
        for(int i =0; i < len; i ++){
            stone = new int[]{1, 3, 2};
            dfs(i);
        }
        Collections.sort(ans_list);
        System.out.println(ans_list.get(ans_list.size()-1));
        System.out.println(Arrays.asList(ans_list));
    }

    public static void main(String[] args) {
        pro();
    }
}
