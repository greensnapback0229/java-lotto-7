package lotto.controller;

import java.util.List;
import java.util.Set;
import lotto.Lotto;
import lotto.service.LottoService;
import lotto.view.Input;
import lotto.view.Output;

public class LottoController {

    private final Input input = new Input();
    private final Output output = new Output();
    private final LottoService lottoService = new LottoService();

    public void letsLotto() {
        Integer purchasePrice = input.inputPurchasePrice();
        List<Lotto> buyLottoList = lottoService.buyLotto(purchasePrice);
        output.printPurchasedLotto(buyLottoList, purchasePrice);

        Set<Integer> winNumbers = input.inputWinNumbers();
        winNumbers = input.inputBonus(winNumbers);


    }
}
