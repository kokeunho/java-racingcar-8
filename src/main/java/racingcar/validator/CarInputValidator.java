package racingcar.validator;

public class CarInputValidator implements Validator<String> {

    @Override
    public void validate(String input) {

        String[] cars = input.trim().split(",");

        // 1. 입력된 차량의 수가 2대 미만이면 예외
        if (cars.length < 2) {
            throw new IllegalArgumentException("차량은 2대 이상이어야 합니다.");
        }

        // 2. 입력된 차량명 중 1~5글자를 벗어나면 예외
        for (String car : cars) {
            car = car.trim();

            if (car.isEmpty() || car.length() > 5) {
                throw new IllegalArgumentException("차량명은 최소 1글자 최대 5글자여야 합니다.");
            }
        }
    }
}
