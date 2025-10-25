package racingcar.validator;

public class TryCountValidator implements Validator<String> {

    @Override
    public void validate(String input) {

        int tryCount;

        // 1. 시도 횟수가 정수가 아니라면 예외
        try {
            tryCount = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 정수여야 합니다.");
        }

        // 2. 시도 횟수가 1보다 작으면 예외
        if (tryCount < 1) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
    }
}
