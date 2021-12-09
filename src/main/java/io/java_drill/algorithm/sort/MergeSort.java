package io.java_drill.algorithm.sort;

import java.util.ArrayList;

public class MergeSort {
    public ArrayList<Integer> splitAndMerge(ArrayList<Integer> list){

        if(list.size() <= 1) {
            return list;
        } else {
            int medium = list.size() / 2;

            // 재귀호출로 left와 right list는 이미 정렬된 상태
            ArrayList<Integer> leftList = splitAndMerge(new ArrayList<>(list.subList(0, medium)));
            ArrayList<Integer> rightList = splitAndMerge(new ArrayList<>(list.subList(medium, list.size())));

            return merge(leftList, rightList);
        }
    }

    public ArrayList<Integer> merge(ArrayList<Integer> leftList, ArrayList<Integer> rightList){
        ArrayList<Integer> mergedList = new ArrayList<>();
        // left, right list를 탐색할 pointer
        int leftPointer = 0;
        int rightPointer = 0;

        // 양쪽 리스트가 모두 정렬이 되지 않은 상태
        while(leftPointer < leftList.size() && rightPointer < rightList.size()) {
            // 작은 값을 먼저 mergedList에 추가 후 pointer 이동
            if (leftList.get(leftPointer) <= rightList.get(rightPointer)) {
                mergedList.add(leftList.get(leftPointer));
                leftPointer++;
            } else {
                mergedList.add(rightList.get(rightPointer));
                rightPointer++;
            }
        } // 해당 while이 끝나면, left rigth list 중 하나는 사라짐

        // left listrk 남아있는 경우(남아있지 않다면 동작하지 않음)
        while(leftPointer < leftList.size()){
            mergedList.add(leftList.get(leftPointer));
            leftPointer++;
        }
        // right list가 남아있는 경우,
        while (rightPointer < rightList.size()){
            mergedList.add(rightList.get(rightPointer));
            rightPointer++;
        }

        return mergedList;
    }

    public static void main(String[] args) {
        MergeSort ms = new MergeSort();

        ArrayList<Integer> testList = new ArrayList<>();
        for(int i = 0; i < 30; i ++) {
            testList.add((int)(Math.random()*50));
        }

        System.out.println(testList);
        System.out.println(ms.splitAndMerge(testList));
    }
}
