package structure;

import io.java_drill.data_structure.HashTableChaining;
import org.junit.jupiter.api.Test;

public class HashTest {

    @Test
    public void chainingTest(){
        HashTableChaining htc = new HashTableChaining(20);

        htc.setData("Space", "1111");
        htc.setData("SpaceLee", "2222");
        htc.setData("SpaceKim", "3333");

        System.out.println(htc.getData("Space"));
        System.out.println(htc.getData("space"));
        System.out.println(htc.getData("SpaceKim"));
        System.out.println(htc.getData("SpaceLee"));
    }
}
