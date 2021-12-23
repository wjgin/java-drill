package io.java_drill.algorithm.search.twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 */
public class BojNo16472 {

    static int N, kind = 0;
    static String A;
    static int cnt[];

    static void input(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            N = Integer.parseInt(br.readLine());
            A = br.readLine();
            cnt = new int[26]; // a = 97, z = 122 26개 이하

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void pro(){
       int len = A.length(), ans = 0;
        for(int R = 0, L = 0; R < len; R ++ ){
            // 오른쪽 하나 추가
            add(A.charAt(R));

            // kind가 N보다 크다면 L을 줄여줌
            while(kind > N){
                del(A.charAt(L++));
            }

            // 최대 길이 갱신
            ans = Math.max(ans, R - L + 1);
        }
        System.out.println(ans);
    }

    private static void del(char c) {
        cnt[c - 'a'] --;
        if(cnt[c - 'a'] == 0) kind --;  // 완전히 없어지면 종류를 하나 없앰
    }

    // 문자 추가
    private static void add(char c) {
        cnt[c - 'a']++; // char를 index 화 시키기
        if(cnt[c - 'a'] == 1) kind ++;  // 처음 추가된 것이라면 종류가 하나 늘어남
    }


    public static void main(String[] args) {
        input();
        pro();
    }
}
