package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoSystem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.controller.InputController.*;
import static lotto.controller.InputValidatorController.*;
import static lotto.view.OutputView.*;

public class LottoSystemController {

    public static void startLottoSystem() {
        LottoSystem lottoSystem = buyLotto();
        printBuyLotto(lottoSystem);

        enterLotto();
    }

    private static void enterLotto() {
        enterLottoNumber();
        enterLottoBonusNumber();
    }

    private static int enterLottoBonusNumber() {
        String lottoBonusNumber = inputLottoBonusNumber();
        inputLottoBonusNumberValidate(lottoBonusNumber);

        return Integer.parseInt(lottoBonusNumber);
    }

    private static List<Integer> enterLottoNumber() {
        String lottoNumbers = inputLottoNumber();
        inputLottoNumberValidate(lottoNumbers);

        return parseStringToList(lottoNumbers);
    }

    private static List<Integer> parseStringToList(String lottoNumbers) {
        List<Integer> lottos = new ArrayList<>();

        String[] lottoNumber = lottoNumbers.split(",");
        for (int i = 0; i < lottoNumber.length; i++) {
            lottos.add(Integer.parseInt(lottoNumber[i]));
        }

        Collections.sort(lottos);

        return lottos;
    }

    private static LottoSystem buyLotto() {
        String money = inputMoney();
        inputMoneyValidate(money);

        return new LottoSystem(Integer.parseInt(money));
    }

    private static void printBuyLotto(LottoSystem lottoSystem) {
        printLottoCnt(lottoSystem.getPurchaseLottoCount());

        for (Lotto lotto : lottoSystem.getPurchaseLottos()) {
            printLottoNumbers(lotto);
        }
    }
}
