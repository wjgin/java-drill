package io.java_drill.algorithm.sort.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No15970 {

    static class node implements Comparable<node>{
        public int x;
        public int y;

        @Override
        public int compareTo(node o) {
            return this.y - o.y;
        }
    }

    static void input(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        try {
            N = Integer.parseInt(br.readLine());
            nodes = new node[N];
            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                nodes[i] = new node();
                nodes[i].x = Integer.parseInt(st.nextToken());
                nodes[i].y = Integer.parseInt(st.nextToken());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void pro(){
        // nodes 를 색깔별로 정렬
        Arrays.sort(nodes);
        int value;
        // 맨 왼쪽의 값 더하기
        if(nodes[0].y == nodes[1].y) answer += Math.abs(nodes[0].x - nodes[1].x);

        if(N >=3){
            for(int i =1; i < N - 1; i ++) {
                // 노드가 왼쪽 끝인 경우, 오른쪽과의 차이를 더함
                if (nodes[i].y != nodes[i - 1].y && nodes[i].y == nodes[i + 1].y) {
                    value = Math.abs(nodes[i].x - nodes[i + 1].x);
                    answer += value;
                    continue;
                }
                // 노드가 중간인 경우 양쪽 중 차이가 더 작은 것을 더함
                if (nodes[i].y == nodes[i - 1].y && nodes[i].y == nodes[i + 1].y) {
                    value = Math.abs(nodes[i].x - nodes[i + 1].x);
                    value = Math.min(value, Math.abs(nodes[i].x - nodes[i - 1].x));
                    answer += value;
                    continue;
                }
                // 노드가 오른쪽 끝인 경우, 왼쪽과의 차이를 더함
                if (nodes[i].y == nodes[i - 1].y && nodes[i].y != nodes[i + 1].y) {
                    value = Math.abs(nodes[i].x - nodes[i - 1].x);
                    answer += value;
                }
            }
        }

        // 맨 끝 노드의 값 더하기
        if(nodes[N-1].y == nodes[N-2].y) answer += Math.abs(nodes[N-1].x - nodes[N-2].x);
        // 최종 답 출력
        System.out.println(answer);
    }



    static int N, x, y, answer;
    static node[] nodes;

    public static void main(String[] args) {
        input();
        pro();
    }
}
