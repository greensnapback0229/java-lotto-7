package lotto.view;

import java.util.List;
import lotto.Lotto;

public class Output {

    public void printPurchasedLotto(List<Lotto> lottoList, Integer purchasePrice) {

        System.out.printf("%d개를 구매했습니다\n", purchasePrice / 1000);

        for (Lotto lotto : lottoList) {
            System.out.println(lotto.toString());
        }

    }
}
