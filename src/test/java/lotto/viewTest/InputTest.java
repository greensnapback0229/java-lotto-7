package lotto.viewTest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.io.ByteArrayInputStream;
import lotto.view.Input;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputTest {

    private Input input = new Input();

    @Test
    @DisplayName("1000원 단위로 정상 입력시")
    public void testPurchasePriceNormal() {

        //given
        Integer normalPrice = 13000;

        //when
        input.inputPurchasePrice();


        //then
        assertDoesNotThrow(() -> systemInputString(normalPrice.toString()));
    }

    @Test
    @DisplayName("1000원 단위로 입력이 아닐때")
    public void testPurchasePriceWrong() {

        //given
        Integer wrongPrice = 13100;

        //when
        input.inputPurchasePrice();

        //then
        assertDoesNotThrow(() -> systemInputString(wrongPrice.toString()));
    }

    public static void systemInputString(String s){
        ByteArrayInputStream input = new ByteArrayInputStream(s.getBytes());
        System.setIn(input);
    }
}
