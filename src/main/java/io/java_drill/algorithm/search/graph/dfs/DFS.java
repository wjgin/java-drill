package io.java_drill.algorithm.search.graph.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

/**
 * 깊이 우선 탐색 Depth First Search
 * 방문할 node를 stack에 담는다. => 자연스럽게 깊이 우선 탐색
 * Queue에 담는 BFS와 대조적
 * O(V+E)
 */
public class DFS {
    public ArrayList<String> dfs(HashMap<String, ArrayList<String>> map, String start){
        ArrayList<String> visited = new ArrayList<>();
        Stack<String> unvisted = new Stack<>();

        unvisted.push(start);

        while(!unvisted.isEmpty()){
            String node = unvisted.pop();

            if(!visited.contains(node)){
                visited.add(node);
                map.get(node).stream().forEach(item->{
                    unvisted.push(item);
                });
            }

        }

        return visited;
    }

    public static void main(String[] args) {
        DFS dfs = new DFS();

        HashMap<String, ArrayList<String>> graph = new HashMap<String, ArrayList<String>>();
        graph.put("A", new ArrayList<String>(Arrays.asList("B", "C")));
        graph.put("B", new ArrayList<String>(Arrays.asList("A", "D")));
        graph.put("C", new ArrayList<String>(Arrays.asList("A", "G", "H", "I")));
        graph.put("D", new ArrayList<String>(Arrays.asList("B", "E", "F")));
        graph.put("E", new ArrayList<String>(Arrays.asList("D")));
        graph.put("F", new ArrayList<String>(Arrays.asList("D")));
        graph.put("G", new ArrayList<String>(Arrays.asList("C")));
        graph.put("H", new ArrayList<String>(Arrays.asList("C")));
        graph.put("I", new ArrayList<String>(Arrays.asList("C", "J")));
        graph.put("J", new ArrayList<String>(Arrays.asList("I")));

        System.out.println(dfs.dfs(graph, "A"));
    }
}
