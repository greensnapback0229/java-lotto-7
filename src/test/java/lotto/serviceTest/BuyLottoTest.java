package lotto.serviceTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import lotto.Lotto;
import lotto.service.LottoService;
import org.junit.jupiter.api.Test;

public class BuyLottoTest {

    private final LottoService service = new LottoService();

    @Test
    public void testBuyLotto() {
        //given
        Integer purchasePrice = 8000;

        //when
        List<Lotto> lottoList = service.buyLotto(purchasePrice);

        //then
        for (Lotto lotto : lottoList) {
            assertThat(lotto.getLotto().size()).isEqualTo(6);
        }
        assertThat(lottoList.size()).isEqualTo(8);
    }
}
