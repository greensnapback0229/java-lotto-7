package lotto.view;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidation {

    public Set<Integer> validateWinNumbers(String winNumberInput) {
        List<String> splitList = validateSplit(winNumberInput);
        Set<Integer> winningNumbers = new HashSet<>();

        for (String number : splitList) {
            Integer validatedNumber = validateIsAvailableNumber(number, winningNumbers);
            winningNumbers.add(validatedNumber);
        }

        return winningNumbers;
    }

    private List<String> validateSplit(String input) {
        List<String> splitList = Arrays.stream(input.split(",")).toList();
        if (splitList.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개를 입력하세요.");
        }

        return splitList;
    }

    private Integer validateIsAvailableNumber(String input, Set<Integer> numberSet) {
        Integer number;
        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력하세요");
        }

        if (number <= 0 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 1-45까지의 숫자만 입력하세요");
        }

        if (numberSet.contains(number)) {
            throw new IllegalArgumentException("[ERROR] 같은 수는 1번만 입력하세요");
        }

        return number;
    }

}
