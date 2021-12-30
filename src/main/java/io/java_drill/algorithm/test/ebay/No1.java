package io.java_drill.algorithm.test.ebay;

public class No1 {
    /**
     * 입력 예시
     * [["MO 12:00 WE 14:30", "MO 12:00", "MO 15:00", "MO 18:00"],
     * ["TU 09:00", "TU 10:00", "TU 15:00", "TU 18:00"],
     * ["WE 09:00", "WE 12:00", "WE 15:00", "WE 18:00"],
     * ["TH 09:30", "TH 11:30", "TH 15:00", "TH 18:00"],
     * ["FR 15:00", "FR 15:00", "FR 15:00", "FR 15:00"]]
     *
     * int[5 mon~fr][18]
     *
     *
     */
    static String[][] schedule = new String[5][4];
    static String[] search;
    static int[] day_cnt = {4, 4, 4, 4};
    public void pro(){
        // 이중으로 겹치는 것을 제거
        for(int i = 0; i < 5; i ++){
            for(int j = 0; j < 4; j ++){
                String now = schedule[i][j];
                search = now.split(" ");
                if(search.length > 2){

                }
            }
        }
    }
}
