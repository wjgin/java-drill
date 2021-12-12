package io.java_drill.search;

import java.util.*;

/**
 * 다익스트라 알고리즘 구현
 * O(E * logE)
 * 최악의 경우 모든 간선을 탐색 * 우선순위 큐(힙 정렬 logE)
 */
public class DijstraPath {

    public static class Node implements Comparable<Node> {  // 연결된 노드
        String vertex;  // 연결 노드의 이름
        int weight; // 가중치

        // 노드 생성자
        public Node(String vertex, int weight){
            this.vertex = vertex;
            this.weight = weight;
        }
        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;  // 가중치에 따른 오름차순 정렬(우선순위 큐의 기준도 됨)
        }
    }

    public Map<String, Integer> dijkstraFunc(Map<String, ArrayList<Node>> map, String start) {
        PriorityQueue<Node> pq = new PriorityQueue<>(); // min heap 구조의 우선순위 큐 생성
        Map<String, Integer> result = new HashMap<>();    // 시작 지점이 최종적으로 모든 정점과 연결된 최종 가중치를 저장할 변수
        Node pqNode;    // 우선순위 큐에 들어갈 노드
        ArrayList<Node> nodeList;   // 우선순위 큐에서 선택된 노드들과 연결된 노드들을 담을 배열

        // 초기화(시작점과 연결된 정점들의 가중치 적용)
        for(String key : map.keySet()){
            result.put(key, Integer.MAX_VALUE);   // 모두 최대치로 초기화
        }
        result.put(start, 0); // 자기 자신과의 거리는 0으로 초기화
        pq.add(new Node(start, 0)); // 자기 자신을 첫 우선순위 큐에 대입

        while(!pq.isEmpty()){   // 큐가 비어질 때까지 반복함

            pqNode = pq.poll(); // 우선 순위의 인자 추출(여기선 min 값)

            if(result.get(pqNode.vertex) < pqNode.weight){  // 새로 선택된 node보다 이미 더 적은 가중치라면 패스
                continue;
            }

            nodeList = map.get(pqNode.vertex); // 새로 선택한 node의 가중치가 현재보다 더 적다면 연결된 정점들과의 가중치를 비교
            for(Node searchNode : nodeList) {
                int newWeight = searchNode.weight + pqNode.weight;
                if(newWeight < result.get(searchNode.vertex)){  // 새로운 경로의 가중치가 더 적다면 갱신
                    result.put(searchNode.vertex, newWeight);
                    pq.add(new Node(searchNode.vertex, newWeight)); // 우선순위 큐에 추가
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Map<String, ArrayList<Node>> graph = new HashMap<String, ArrayList<Node>>();
        graph.put("A", new ArrayList<Node>(Arrays.asList(new Node("B", 8), new Node("C", 1), new Node("D", 2))));
        graph.put("B", new ArrayList<Node>());
        graph.put("C", new ArrayList<Node>(Arrays.asList(new Node("B", 5), new Node("D", 2))));
        graph.put("D", new ArrayList<Node>(Arrays.asList(new Node("E", 3), new Node("F", 5))));
        graph.put("E", new ArrayList<Node>(Arrays.asList(new Node("F", 1))));
        graph.put("F", new ArrayList<Node>(Arrays.asList(new Node("A", 5))));

        DijstraPath dp = new DijstraPath();
        System.out.println(dp.dijkstraFunc(graph, "A"));
    }
}
