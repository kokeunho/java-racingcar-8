package racingcar.car;

import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.*;

class CarTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 차량_전진() {
        // given
        Car car = new Car("car1");

        // when & then
        assertRandomNumberInRangeTest(
                () -> {
                    car.move();
                    assertThat(car.getPosition()).isEqualTo(1);
                },
                MOVING_FORWARD
        );
    }

    @Test
    void 차량_정지() {
        // given
        Car car = new Car("car1");

        // when & then
        assertRandomNumberInRangeTest(
                () -> {
                    car.move();
                    assertThat(car.getPosition()).isEqualTo(0);
                },
                STOP
        );
    }

}