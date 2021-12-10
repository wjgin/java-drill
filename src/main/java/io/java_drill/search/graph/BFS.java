package io.java_drill.search.graph;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * 너비 우선탐색 Breadth First Search
 * O(v+E) while문에서 모든 노드(vertex)와 간선(edge)를 거침
 */

public class BFS {
    public ArrayList<String> search(HashMap<String, ArrayList<String>> map, String start){
        ArrayList<String> vistied = new ArrayList<>();  // 방문한 노드 큐
        ArrayList<String> unVistied = new ArrayList<>();    // 방문하지 않은 노드 큐

        unVistied.add(start);   // 시작 지점을 추가

        while(!unVistied.isEmpty()){    // 모든 방문이 끝난다면 비어짐
            String vertex = unVistied.get(0);
            unVistied.remove(vertex);

            if(!vistied.contains(vertex)){  // 방문한적이 없다면 새로 추가
                vistied.add(vertex);
                unVistied.addAll(map.get(vertex));  // 하위 레벨의 방문할 노드 추가
            }
        }

        return vistied; // 반복문이 끝남 => 더 이상 방문할 곳이 없음
    }
}
