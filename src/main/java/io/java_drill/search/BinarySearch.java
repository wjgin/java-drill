package io.java_drill.search;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;

/**
 * 이진 탐색
 * 정렬된 배열이 필요함
 * 정렬된 배열에서 특정 값을 최소한의 횟수로 찾을 때 유리함 ex) 순서대로 나열된 음료의 병뚜껑에서 병뚜껑을 최소로 열면서 특정 숫자 찾기
 * O(logN)
 */
public class BinarySearch {
    public boolean sort(ArrayList<Integer> list, Integer target){
        if(list.size() == 1 && list.get(0) == target){
            return true;
        }if(list.size() == 1 && list.get(0) != target){
            return false;
        }

        int mid = list.size() / 2;
        if(list.get(mid) == target){
            return true;
        } else {
            if (target < list.get(mid)) {
                return sort(new ArrayList<>(list.subList(0, mid)), target);
            } else {
                return sort(new ArrayList<>(list.subList(mid, list.size())), target);
            }
        }
    }

    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();
        ArrayList<Integer> testList = new ArrayList<>();
        for(int i = 0; i < 20; i ++){
            testList.add((int) (Math.random() * 30));
        }
        System.out.println(testList);
        System.out.println(bs.sort(testList, 21));
    }
}
