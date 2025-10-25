package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.game.Game;
import racingcar.validator.CarInputValidator;
import racingcar.validator.TryCountValidator;

public class Application {
    public static void main(String[] args) {

        CarInputValidator carInputValidator = new CarInputValidator();
        TryCountValidator tryCountValidator = new TryCountValidator();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();
        carInputValidator.validate(carNames);

        System.out.println("시도할 횟수는 몇 회인가요?");
        String tryCount = Console.readLine();
        tryCountValidator.validate(tryCount);

        Game game = new Game(carNames, Integer.parseInt(tryCount));
        game.start();

        String result = String.join(",", game.getWinners());

        System.out.println("최종 우승자 : " + result);
    }
}
