package io.java_drill.algorithm.sort.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 정렬
 * compareTo -> return 이 음수이면 오름차순, 양수이면 내림차순이다.(뺄셈의 앞에 인자가 항상 앞에 오게 한다.)
 * String 메소드의 compareTo는 문자를 사전순으로 정렬한다.
 */
public class No10825 {

    static void print(){
        Arrays.sort(list);  // 정렬기준에 따라서 정렬 O(NlogN)
        sb = new StringBuilder();

        for(int i = 0; i < N; i ++) {
            sb.append(list[i].name).append('\n');
        }
        System.out.println(sb.toString());
    }

    static void input(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        try {
            N = Integer.parseInt(br.readLine());
            list = new stu[N];

            for(int i = 0; i < N; i ++){
                st = new StringTokenizer(br.readLine());
                name = st.nextToken();
                kor = Integer.parseInt(st.nextToken());
                eng = Integer.parseInt(st.nextToken());
                math = Integer.parseInt(st.nextToken());
                list[i] = new stu(name, kor, eng, math);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static class stu implements Comparable<stu>{
        String name;
        int kor, eng, math;

        public stu(String name, int kor, int eng, int math) {
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.math = math;
        }

        @Override
        public int compareTo(stu o) {
           // 국어점수가 다르다면 국어점수 내림차순
           if(this.kor != o.kor) return o.kor - this.kor;
           // 국어점수가 같다면 영어점수가 오름차순
           if(this.eng != o.eng) return this.eng - o.eng;
           // 국어점수와 영어점수가 같다면 수학점수 내림차순
           if(this.math != o.math) return o.math - this.math;
           // 모든 점수가 같다면 이름순으로 정렬
           else return name.compareTo(o.name);  // 반대로 비교하면 사전반대 순(아스키코드 내림차순
        }
    }

    static int N, kor, eng, math;
    static String name;
    static StringBuilder sb;
    static stu[] list;

    public static void main(String[] args) {
        input();
        print();
    }
}
