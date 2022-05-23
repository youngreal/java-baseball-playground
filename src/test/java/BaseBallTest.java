import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.Setup;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

class BaseBallTest {

    Setup setup= new Setup();
    Balls balls;
    ArrayList<Integer> inputNum = new ArrayList<>();

    @BeforeEach
    void setup() {
        setup.numAnswer.add(2);
        setup.numAnswer.add(7);
        setup.numAnswer.add(5);
    }

    @Test
    @DisplayName("3볼")
    void threeBall() {
        inputNum.add(0,7);
        inputNum.add(1,2);
        inputNum.add(2,7);
        inputBall();
        assertThat(balls.checkScore(1)).isEqualTo(StrikeBallNothing.BALL);
        assertThat(balls.checkScore(2)).isEqualTo(StrikeBallNothing.BALL);
        assertThat(balls.checkScore(3)).isEqualTo(StrikeBallNothing.BALL);
    }

    @Test
    @DisplayName("3스트라이크")
    void Strike() {
        inputNum.add(0,2);
        inputNum.add(1,7);
        inputNum.add(2,5);
        inputBall();
        assertThat(balls.checkScore(1)).isEqualTo(StrikeBallNothing.STRIKE);
        assertThat(balls.checkScore(2)).isEqualTo(StrikeBallNothing.STRIKE);
        assertThat(balls.checkScore(3)).isEqualTo(StrikeBallNothing.STRIKE);
    }

    @Test
    @DisplayName("낫싱")
    void Nothing() {
        inputNum.add(0,1);
        inputNum.add(1,3);
        inputNum.add(2,3);
        inputBall();
        assertThat(balls.checkScore(1)).isEqualTo(StrikeBallNothing.NOTHING);
        assertThat(balls.checkScore(2)).isEqualTo(StrikeBallNothing.NOTHING);
        assertThat(balls.checkScore(3)).isEqualTo(StrikeBallNothing.NOTHING);
    }

    @Test
    @DisplayName("1스트라이크1볼")
    void StrikeAndBall() {
        inputNum.add(0,1);
        inputNum.add(1,7);
        inputNum.add(2,2);
        inputBall();
        assertThat(balls.checkScore(1)).isEqualTo(StrikeBallNothing.NOTHING);
        assertThat(balls.checkScore(2)).isEqualTo(StrikeBallNothing.STRIKE);
        assertThat(balls.checkScore(3)).isEqualTo(StrikeBallNothing.BALL);
    }

    private void inputBall() {
        balls = new Balls(inputNum, setup.numAnswer);
    }
}
