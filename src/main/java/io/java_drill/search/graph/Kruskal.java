package io.java_drill.search.graph;

import java.util.*;

/**
 * 최소 신장 트리(minimum spanning tree) 크루스칼 알고리즘
 * union find 알고리즘 이용 => 루트 노드가 같다면 이미 연결된 노드이다.
 * union by rank 알고리즘 이용 => 노드가 연결된 트리의 높이를 랭크로 다룸.
 * path compression 이용 => 루트 노드를 한번에 찾기 위한 기법. 한번 거쳐간 루트를 갱신(부모의 부모를 자신의 루트로 갱신 => 루트가 같아짐)
 *
 */
public class Kruskal {
    Map<String, String> parentNode = new HashMap<>();   // 부모 노드를 저장
    Map<String, Integer> rank = new HashMap<>();    // 노드의 랭크를 저장

    // 간선 객체
    public static class Edge implements Comparable<Edge> {
        int weight; // 연결된 노드들의 가중치
        String nodeS;   // 연결된 2개의 노드 중 하나
        String nodeE;   // 연결된 2개의 노드 중 하나

        // 생성자
        public Edge(int weight, String nodeS, String nodeE){
            this.weight = weight;
            this.nodeS = nodeS;
            this.nodeE = nodeE;
        }
        @Override
        public int compareTo(Edge o) {
            return this.weight = o.weight;  // 가중치로 오름차순
        }
    }

    /**
     * union find 알고리즘
     */
    // find: 루트 노드를 찾아내는 함수
    public String find(String node) {
        // parh compression 기법을 이용(루트를 같게 만듦)
        if(parentNode.get(node) != node) {  // 부모가 자신과 같지 않다면, 루트가 아님
            parentNode.put(node, find(node));   // 재귀를 통해 부모의 부모로 갱신 => 루트 노드가 같아짐
        }
        return parentNode.get(node);    // 최종 부모 노드는 루트
    }

    // union: 간선을 연결
    public void union(String nodeS, String nodeE){
        String rootS = find(nodeS);
        String rootE = find(nodeE);

        // union by rank 기법을 이용
        if(rank.get(rootS) > rank.get(rootE)){ // 랭크가 높은 곳에 낮은 랭크를 연결
            parentNode.put(rootE, rootS);
        } else {
            parentNode.put(rootS, rootE);   // 랭크가 같다면, 한쪽의 랭크를 올리고 연결
            rank.put(rootE, rank.get(rootE) + 1);
        }
    }

    // 초기화
    public void init(String node) {
        parentNode.put(node, node); // 부모가 자신인 노드는 루트
        rank.put(node, 0);  // 초기 랭크는 0
    }

    public ArrayList<Edge> kruskalFunc(ArrayList<String> vetices, ArrayList<Edge> edgeds) {
        ArrayList<Edge> list = new ArrayList<>();

        // 초기화
        for(String item : vetices) {
            init(item);
        }

        // 정렬
        Collections.sort(edgeds);

        // 간선 연결
        for(Edge edge : edgeds) {
            if(find(edge.nodeS) != find(edge.nodeE)) {  // 루트 노드가 다르다면 서클형성을 하지않음
                union(edge.nodeS, edge.nodeE);  // 간선을 채택해서 노드를 연결
                list.add(edge); // 채택한 간선을 결과에 담기
            }
        }

        return list;
    }

    // 테스트 코드
    public static void main(String[] args) {
        Kruskal ks = new Kruskal();
        ArrayList<String> vetices = new ArrayList<String>(Arrays.asList("A", "B", "C", "D", "E", "F", "G"));
        ArrayList<Edge> edges = new ArrayList<Edge>();
        edges.add(new Edge(7, "A", "B"));
        edges.add(new Edge(5, "A", "D"));
        edges.add(new Edge(7, "B", "A"));
        edges.add(new Edge(8, "B", "C"));
        edges.add(new Edge(9, "B", "D"));
        edges.add(new Edge(7, "B", "E"));
        edges.add(new Edge(8, "C", "B"));
        edges.add(new Edge(5, "C", "E"));
        edges.add(new Edge(5, "D", "A"));
        edges.add(new Edge(9, "D", "B"));
        edges.add(new Edge(7, "D", "E"));
        edges.add(new Edge(6, "D", "F"));
        edges.add(new Edge(7, "E", "B"));
        edges.add(new Edge(5, "E", "C"));
        edges.add(new Edge(7, "E", "D"));
        edges.add(new Edge(8, "E", "F"));
        edges.add(new Edge(9, "E", "G"));
        edges.add(new Edge(6, "F", "D"));
        edges.add(new Edge(8, "F", "E"));
        edges.add(new Edge(11, "F", "G"));
        edges.add(new Edge(9, "G", "E"));
        edges.add(new Edge(11, "G", "F"));

        System.out.println(ks.kruskalFunc(vetices, edges));
    }
}
