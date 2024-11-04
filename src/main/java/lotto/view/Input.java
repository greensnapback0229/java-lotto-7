package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Input {


    public Integer inputPurchasePrice(){

        String priceInput = Console.readLine();
        Integer purchasePrice;
        try{
            purchasePrice = Integer.parseInt(priceInput);
        }
        catch(NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 정수형만 입력해주세요");
        }

        if(purchasePrice % 1000 != 0 || purchasePrice <= 0){
            throw new IllegalArgumentException("[ERROR] 1000원 단위로만 구매 가능합니다");
        }

        return purchasePrice;
    }


    public List<Integer> inputWinNumbers(){
        List<Integer> winNumbers = new ArrayList<>();

        return winNumbers;
    }
}
