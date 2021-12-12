package io.java_drill.algorithm.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;


public class ComparatorSort{

    public void knapsackFunc(Integer[][] objectList, double capacity) {
        double totalValue = 0.0;
        double fraction = 0.0;

        Arrays.sort(objectList, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] objectItem1, Integer[] objectItem2) {
                return (objectItem2[1] / objectItem2[0]) - (objectItem1[1] / objectItem1[0]);
            }
        });

        for (int index = 0; index < objectList.length; index++) {
            if ( (capacity - (double)objectList[index][0]) > 0 ) {
                capacity -= (double)objectList[index][0];
                totalValue += (double)objectList[index][1];
                System.out.println("무게:" + objectList[index][0] + ", 가치:" + objectList[index][1]);
            } else {
                fraction = capacity / (double)objectList[index][0];
                totalValue += (double)objectList[index][1] * fraction;
                System.out.println("무게:" + objectList[index][0] + ", 가치:" + objectList[index][1] + ", 비율:" + fraction);
                break;
            }
        }
        System.out.println("총 담을 수 있는 가치:" + totalValue);
    }

    public static void main(String[] args) {
        ComparatorSort cs = new ComparatorSort();
    }

}
