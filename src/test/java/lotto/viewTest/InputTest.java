package lotto.viewTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

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
    public void testPurchasePriceNotInThousands() {

        //given
        Integer wrongPrice = 13100;

        //when
        input.inputPurchasePrice();

        //then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> systemInputString(wrongPrice.toString()));
        assertThat(exception.getMessage()).isEqualTo("[ERROR] 1000원 단위로만 구매 가능합니다");
    }
    
    @Test
    @DisplayName("정수형 입력이 아닐때")
    public void testPurchasePriceNotInteger() {

        //given
        String wrongNumber = "1l230O0Oo"; //O는 알파벳 0은 숫자

        //when
        input.inputPurchasePrice();

        //then
        IllegalArgumentException exception =  assertThrows(IllegalArgumentException.class, () -> systemInputString(wrongNumber));
        assertThat(exception.getMessage()).isEqualTo("[ERROR] 숫자만 입력해주세요");
    }

    public static void systemInputString(String s){
        ByteArrayInputStream input = new ByteArrayInputStream(s.getBytes());
        System.setIn(input);
    }
}
