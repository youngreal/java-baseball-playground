package util;

import java.util.ArrayList;
import java.util.List;

/**
 * 서로다른 세자리수를 생성하고 저장해주는 클래스
 */
public class Setup {
    public List<Integer> numAnswer = new ArrayList<>();

    public void generateNumber() {
        int numAnswerPosition=0;
        generateNumberNotDuplicate(numAnswerPosition);
    }

    public void newGenerateNumber() {
        this.numAnswer.clear();
        generateNumber();
    }

    private void generateNumberNotDuplicate(int position) {
        int beforeNumber;
        while (numAnswer.size() < 3) {
            beforeNumber = (int)(Math.random() * 10);
            position = addAnswerAndNextPosition(position, beforeNumber);
        }
    }

    private int addAnswerAndNextPosition(int position, int beforeNumber) {
        if(isNotDuplicate(beforeNumber)){
            numAnswer.add(position, beforeNumber);
            position +=1;
        }
        return position;
    }

    private boolean isNotDuplicate(int beforeNumber) {
        return !numAnswer.contains(beforeNumber);
    }
}
