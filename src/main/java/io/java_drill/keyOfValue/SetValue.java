package io.java_drill.keyOfValue;

/**
 * java는 늘 call by value
 * 일반타입 int, float, long의 복사 값 만들 인자로 넘기
 * 이외의 다른 타입은 모두 주소의 복사값을 넘겨줌(Class, String...)
 *
 * 인자로 받은 String의 값을 변경해도 변화가 없는 이유:
 * String의 주소값을 복사한 객체에 다른 문자열의 주소를 넣어줄 뿐이기 때문이다.
 *
 */
public class SetValue {
    public static void main(String[] args) {
        String strObject = "Hello";
        int intValue = 0;
        Float floatValue = new Float(1.0);
        setValue(strObject, intValue, floatValue);

        System.out.println(strObject + ", " + intValue + ", " + floatValue);
    }

    private static void setValue(String strValue, int intValue, Float floatValue) {
        strValue.replace('H', 'h');
        strValue += " world!";
        intValue = 99;
        floatValue.valueOf((float) 2.0);
        System.out.println("strValue in setValue= " + strValue);
    }
}
