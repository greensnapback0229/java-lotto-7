package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;

public class LottoService {

    public List<Lotto> buyLotto(Integer purchasePrice) {
        Integer countToBuy = purchasePrice / 1000;

        List<Lotto> lottoList = new ArrayList<>();

        for (int count = 0; count < countToBuy; count++) {
            lottoList.add(makeNewLotto());
        }

        return lottoList;
    }

    /*public List<Lotto> winners(List<Lotto> buyLottoList, Set<Integer> winNumbers) {
        for (Lotto lotto : buyLottoList) {

        }
    }*/


    private Lotto makeNewLotto() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);

        return new Lotto(lottoNumbers);
    }
}