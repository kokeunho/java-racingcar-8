package racingcar.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.*;

class GameTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void 자동차_초기화_동작() {
        // given
        Game game = new Game("car1,car2", 5);

        // when
        List<String> winners = game.getWinners();

        // then
        // 게임 시작 전으로 모든 자동차 포지션 0으로 동점 우승
        assertThat(winners.size()).isEqualTo(2);
    }

    @Test
    void 자동차별_이동현황_출력() {
        // given
        Game game = new Game("car1,car2", 5);

        // when
        game.start();

        // then
        String output = outputStream.toString();
        assertThat(output).contains("실행 결과");
        assertThat(output).contains("car1");
        assertThat(output).contains("car2");
    }

    @Test
    void 지정_횟수만큼_라운드_진행() {
        // given
        Game game = new Game("car1,car2", 5);

        // when
        game.start();

        // then
        String output = outputStream.toString();
        int resultCount = output.split("car1 : ").length - 1;
        assertThat(resultCount).isEqualTo(5);
    }

    // car1만 두번 전진하고 car2는 정지해 있는 경우
    @Test
    void 게임_전체_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    // given
                    Game game = new Game("car1,car2", 2);

                    // when
                    game.start();

                    // then - 출력 검증
                    String output = outputStream.toString();
                    assertThat(output).contains("car1 : --");
                    assertThat(output).doesNotContain("car2 : -");

                    // then - 우승자 검증
                    assertThat(game.getWinners()).containsExactly("car1");
                },
                MOVING_FORWARD, STOP,
                MOVING_FORWARD, STOP
        );
    }
}