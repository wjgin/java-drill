package io.java_drill.algorithm.tree.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class No1068 {
    /**
     * subtree 개념을 활용한 문제
     * 작은 문제 해결 -> 큰 문제 해결
     * leaf의 개수를 세는 문제
     * 자식의 부모는 자식의 결과를 더 하면 답을 구할 수 있다. -> dfs로 최종 자식의 결과를 확인
     * 깊이우선탐색으로 자식이 없다면 leaf 이므로 1 -> 자식의 탐색이 끝난 후 그 부모는 자식의 값을 모두 더 함
     */
    static int[] leafCnt;
    static ArrayList<Integer>[] tree;
    static int N, root, targetNode;

    static void input(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        try {
            N = Integer.parseInt(br.readLine());
            tree = new ArrayList[N];
            leafCnt = new int[N];
            for (int i = 0; i < N; i++) tree[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int parent = Integer.parseInt(st.nextToken());
                if (parent == -1) root = i;
                else tree[parent].add(i);
            }
            targetNode = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void dfs(int node, int parent) {
        if (tree[node].isEmpty()) leafCnt[node]++;
        for (int child : tree[node]){
            if (child == parent) continue;
            dfs(child, node);
            leafCnt[node] += leafCnt[child];
        }
    }

    static void pro(){
        for (int i = 0; i < N; i++) {
            if (tree[i].contains(targetNode)) tree[i].remove(tree[i].indexOf(targetNode));
        }
        if (root != targetNode) dfs(root, -1);
    }

    public static void main(String[] args) {
        input();
        pro();
        System.out.println(leafCnt[root]);
    }
}
