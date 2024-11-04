package lotto;

import java.io.ByteArrayInputStream;

public class TestUtil {

    public static void systemInputString(String s){
        ByteArrayInputStream input = new ByteArrayInputStream(s.getBytes());
        System.setIn(input);
    }
}
