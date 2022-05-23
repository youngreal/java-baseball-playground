import java.util.List;

/**
 * 입력숫자와, 정답숫자를 비교하여 스트라이크,볼,낫씽 여부를 계산하는클래스
 */
public class Balls {
    public static final int CORRECTANSWER = 3;
    private final List<Integer> inputNum;
    private int strikeCount =0;
    private int ballCount =0;
    private int nothing=0;
    private final List<Integer> numAnswer;

    public Balls(List<Integer> inputNum, List<Integer> numAnswer) {
        this.inputNum = inputNum;
        this.numAnswer = numAnswer;
    }

    public StrikeBallNothing checkScore(int position) {
        if (isStrike(position)) {
            this.strikeCount++;
            return StrikeBallNothing.STRIKE;
        }
        if (isBall(position)) {
            this.ballCount++;
            return StrikeBallNothing.BALL;
        }
            this.nothing++;
            return StrikeBallNothing.NOTHING;
    }

    public void calculateScore(Balls balls) {
        for (int i = 1; i < 4; i++) {
            balls.checkScore(i);
        }
    }

    public boolean isStrike(int position) {
        return isSameValueAndSamePosition(position);
    }

    private boolean isSameValueAndSamePosition(int position) {
        return this.numAnswer.get(position - 1).equals(this.inputNum.get(position - 1));
    }

    public boolean isBall(int position) {
        return numAnswer.contains(this.inputNum.get(position - 1));
    }

    public void printStrikeBallNothing() {
        existStrikePrintStrikeCount();
        if (existBallPrintBallCount()) return;
        existNothing();
    }

    private void existNothing() {
        if (this.nothing>2) {
            System.out.print("낫씽");
        }
    }

    private boolean existBallPrintBallCount() {
        if (this.ballCount > 0) {
            System.out.printf("%d볼 ",this.ballCount);
            return true;
        }
        return false;
    }

    private void existStrikePrintStrikeCount() {
        if (this.strikeCount > 0) {
            System.out.printf("%d스트라이크 ", this.strikeCount);
        }
    }

    public boolean isCorrectAnswer() {
        return this.strikeCount == CORRECTANSWER;
    }
}
