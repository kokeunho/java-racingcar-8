package racingcar.validator;

import java.util.HashSet;
import java.util.Set;

public class CarInputValidator implements Validator<String> {

    @Override
    public void validate(String input) {

        String[] cars = input.trim().split(",");

        // 1. 입력된 차량의 수가 2대 미만이면 예외
        if (cars.length < 2) {
            throw new IllegalArgumentException("차량은 2대 이상이어야 합니다.");
        }

        Set<String> uniqueNames = new HashSet<>();

        for (String car : cars) {
            car = car.trim();

            // 2. 중복된 차량명 있으면 예외
            if (!uniqueNames.add(car)) {
                throw new IllegalArgumentException("차량명은 중복될 수 없습니다.");
            }

            // 3. 글자 수가 0글자거나 5글자 초과 시 예외
            if (car.isEmpty() || car.length() > 5) {
                throw new IllegalArgumentException("차량명은 최소 1글자 최대 5글자여야 합니다.");
            }
        }
    }
}
