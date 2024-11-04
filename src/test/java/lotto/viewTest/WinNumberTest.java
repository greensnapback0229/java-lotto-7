package lotto.viewTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Set;
import lotto.TestUtil;
import lotto.view.Input;
import org.junit.jupiter.api.Test;

public class WinNumberTest {

    private Input input = new Input();

    @Test
    public void testNormalWinNumber() {

        //given
        String normalInput = "1,2,3,4,5,6";
        Set<Integer> normalList = Set.of(1, 2, 3, 4, 5, 6);

        //when
        TestUtil.systemInputString(normalInput);

        //then
        Set<Integer> resultList = assertDoesNotThrow(() -> this.input.inputWinNumbers());
        assertThat(normalList).isEqualTo(resultList);
    }

    @Test
    public void testNotInRangeWinNumber() {

        //given
        String notInRange = "1000,2,3,4,5,6";

        //when
        TestUtil.systemInputString(notInRange);

        //then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> input.inputWinNumbers());
        assertThat(exception.getMessage()).isEqualTo("[ERROR] 로또 번호는 1-45입니다");
    }

    @Test
    public void testInvalidWinNumber() {
        //given
        String notNumber = "1,2,3,i,j,k";

        //when
        TestUtil.systemInputString(notNumber);

        //then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> input.inputWinNumbers());
        assertThat(exception.getMessage()).isEqualTo("[ERROR] 로또 번호는 1-45입니다");
    }
}
