package io.java_drill.algorithm.tree.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class No11725 {

    /**
     * 트리의 부모 찾기
     * 부모가 없는 tree가 주어진다.
     * 노드가 1을 root로 가정했을 떄, 트리의 모양이 재설정된다.
     * 이때, 각 노드들의 부모 노드를 순서대로 출력하라
     * N개의 노드가 주어짐, N-1개의 간선이 주어짐 ex) 1 2, 2 3, 3 6 ...
     */

    static StringBuilder sb = new StringBuilder();
    static int N;
    static ArrayList<Integer>[] tree;
    static int[] parentList;

    static void input(){
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            int x;
            int y;

            N = Integer.parseInt(br.readLine());
            parentList = new int[N + 1];
            tree = new ArrayList[N + 1];
            // 선언만 했던 ArrayList 배열의 초기화(null이 아니게한다.)
            for (int i = 1; i <= N; i++)
                tree[i] = new ArrayList<Integer>();
            for (int i = 1; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                tree[x].add(y);
                tree[y].add(x);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 탐색할 노드와 부모를 인자로 받아서 모든 부모 찾아내는 탐색
    static void dfs(int node, int parent){
        for (int child : tree[node]) {
            if (child == parent) continue;
            parentList[child] = node;
            dfs(child, node);
        }
    }

    // 문제를 해결하는 함수
    static void pro() {
        input();
        dfs(1, -1); // root가 될 1번 노드부터 탐색을하되 부모가 없으므로 -1을 두번째 인자로한다.
        for (int i = 2; i <= N; i++) {
            sb.append(parentList[i]).append('\n');
        }
        System.out.println(sb);
    }

    public static void main(String[] args) {
        pro();
    }
}
