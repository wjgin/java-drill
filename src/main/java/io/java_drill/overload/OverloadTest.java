package io.java_drill.overload;

public class OverloadTest {
    private String name;

    public void getName(){
    }

    // 동일한 인자로 리턴값이 다른 것은 오류
    //public void getName(int i){
    //}

    // final로 선언지 하위 클래스에서 오버로드할 수 없음 -> 하위에서 같은 함수를 정의하면 컴파일 에러
    final public String getName(int i){
        return name;
    }
}

