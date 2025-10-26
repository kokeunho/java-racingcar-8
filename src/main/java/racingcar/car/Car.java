package racingcar.car;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private final String name;
    private int position;
    private static final int RANDOM_NUM_MIN = 0;
    private static final int RANDOM_NUM_MAX = 9;
    private static final int MOVE_THRESHOLD = 4;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void move() {
        // 랜덤값이 0-9 중 4 이상인 값일 경우 전진
        if (Randoms.pickNumberInRange(RANDOM_NUM_MIN, RANDOM_NUM_MAX) >= MOVE_THRESHOLD) {
            this.position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
