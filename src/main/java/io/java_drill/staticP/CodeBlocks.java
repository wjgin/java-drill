package io.java_drill.staticP;

/**
 * static, 정적 변수
 * static은 main이 실행될때 먼저 실행된다. 또 애플리케이션 종료까지 공유해서 사용한다.
 */
public class CodeBlocks {
    private static String aField = "";  // 시작시 한번만 동작하며 게속 하나를 공유함
    private String bField = "";
    static {    // 시작때, 한번만 동작함
        aField += "A";
    }
    {   // 생성자로 인해서 새로운 bField에 null을 넣은 후 실행 된다.
        aField += "B";  // 지금까지 누적된 aField에 값을 더함
        bField += "B";  // 새로 만들어진 null인 bField에 추가함
    }
    public CodeBlocks() {   // 생성자 -> 해당 클래스의 모든 코드를 실행한 후 아래 내용을 실행함(필드 생성부터 하위 코드 실행(함수 제외)
        aField += "C";
        bField += "C";
    }

    public void append() {
        aField += "D";
        bField += "D";
    }
    public static void main(String[] argv) {
        System.out.println(aField);
        CodeBlocks cb = new CodeBlocks();
        System.out.println(aField);
        System.out.println(cb.bField);
        CodeBlocks cb2 = new CodeBlocks();
        System.out.println(aField);
        cb.append();
        System.out.println(aField);
        System.out.println(cb.bField);
    }
}