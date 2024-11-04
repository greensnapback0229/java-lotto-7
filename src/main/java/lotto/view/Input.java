package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashSet;
import java.util.Set;

public class Input {


    private final InputValidation inputValidation = new InputValidation();

    public Integer inputPurchasePrice() {

        System.out.println("구입금액을 입력해 주세요.");

        String priceInput = Console.readLine();
        Integer purchasePrice;
        try {
            purchasePrice = Integer.parseInt(priceInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 정수형만 입력해주세요");
        }

        if (purchasePrice % 1000 != 0 || purchasePrice <= 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로만 구매 가능합니다");
        }

        return purchasePrice;
    }


    public Set<Integer> inputWinNumbers() {

        System.out.println("당첨 번호를 입력해 주세요.");

        Set<Integer> winNumbers = new HashSet<>();
        String input = Console.readLine();

        try {
            winNumbers = inputValidation.validateWinNumbers(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            inputWinNumbers();
        }

        return winNumbers;
    }

    public Set<Integer> inputBonus(Set<Integer> winNumbers) {

        System.out.println("보너스 번호를 입력해 주세요.");
        Integer bonus;
        String input = Console.readLine();

        try {
            bonus = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            inputBonus(winNumbers);
            throw new IllegalArgumentException("[ERROR] 숫자를 입력");
        }

        winNumbers.add(bonus);

        return winNumbers;
    }
}
