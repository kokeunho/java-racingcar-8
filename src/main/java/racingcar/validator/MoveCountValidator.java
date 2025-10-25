package racingcar.validator;

public class MoveCountValidator implements Validator<Integer> {

    @Override
    public void validate(Integer input) {

        if (input < 1) {
            throw new IllegalArgumentException("이동 횟수는 1 이상이어야 합니다.");
        }
    }
}
