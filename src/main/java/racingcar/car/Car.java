package racingcar.car;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    // 차량 전진 테스트를 위한 메서드
    public void moveCarTest(int randomValue) {

        if (randomValue >= 4) {
            this.position++;
        }
    }

    public void moveCar() {

        // 랜덤값이 0-9 중 4 이상인 값일 경우 전진
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
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
