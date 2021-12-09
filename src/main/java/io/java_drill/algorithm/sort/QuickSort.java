package io.java_drill.algorithm.sort;

import java.util.ArrayList;

public class QuickSort {
    public ArrayList<Integer> sort(ArrayList<Integer> list) {
        if(list.size() <= 1){
            return list;
        } else {
            ArrayList<Integer> left = new ArrayList<>();    // pivot보다 작은 값을 담을 list
            ArrayList<Integer> right = new ArrayList<>();   // pivot보다 큰 값을 담을 list
            Integer pivot = list.get(0);    // 기준이 될 값

            // 전체를 탐색하면 left와 right에 담음
            for(int i = 1; i < list.size(); i ++) {
                if(list.get(i) < pivot){
                    left.add(list.get(i));
                } else {
                    right.add(list.get(i));
                }
            }

            ArrayList<Integer> sortedList = new ArrayList<>();
            sortedList.addAll(this.sort(left)); // 재귀를 이용해 정렬된 데이터를 가져와 추가
            sortedList.add(pivot);
            sortedList.addAll(this.sort(right));

            return sortedList;
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> testList = new ArrayList<>();
        QuickSort qs = new QuickSort();
        for (int i = 0; i < 30; i++) {
            testList.add((int)(Math.random()*30));
        }
        System.out.println(testList);
        System.out.println(qs.sort(testList));

    }
}
