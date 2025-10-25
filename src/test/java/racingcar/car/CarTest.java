package racingcar.car;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CarTest {

    @Test
    void 차량_전진() {

        // given
        Car car = new Car("car1");

        // when
        car.moveCarTest(4);

        // then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 차량_정지() {

        // given
        Car car = new Car("car1");

        // when
        car.moveCarTest(3);

        // then
        assertThat(car.getPosition()).isEqualTo(0);
    }

}