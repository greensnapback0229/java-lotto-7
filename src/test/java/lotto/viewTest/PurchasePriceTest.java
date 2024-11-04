package lotto.viewTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import lotto.TestUtil;
import lotto.view.Input;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PurchasePriceTest {

    private Input input = new Input();

    @Test
    @DisplayName("1000원 단위로 정상 입력시")
    public void testPurchasePriceNormal() {

        //given
        Integer normalPrice = 13000;

        //when
        TestUtil.systemInputString(normalPrice.toString());

        //then
        assertDoesNotThrow(() -> input.inputPurchasePrice());
    }

    @Test
    @DisplayName("1000원 단위로 입력이 아닐때")
    public void testPurchasePriceNotInThousands() {

        //given
        Integer wrongPrice = 13100;

        //when
        TestUtil.systemInputString(wrongPrice.toString());

        //then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> input.inputPurchasePrice());
        assertThat(exception.getMessage()).isEqualTo("[ERROR] 1000원 단위로만 구매 가능합니다");
    }

    @Test
    @DisplayName("정수형 입력이 아닐때")
    public void testPurchasePriceNotInteger() {

        //given
        String wrongNumber = "1l230O0Oo"; //O는 알파벳 0은 숫자

        //when
        TestUtil.systemInputString(wrongNumber);

        //then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> input.inputPurchasePrice());
        assertThat(exception.getMessage()).isEqualTo("[ERROR] 정수형만 입력해주세요");
    }
}
