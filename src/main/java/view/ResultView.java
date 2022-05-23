package view;

import java.util.Scanner;

/**
 * 결과를 출력해주는 클래스
 */
public class ResultView {
    boolean continued=false;

    public ResultView() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
    }

    public boolean inputIsContinue(Scanner sc) {
        int newInt = sc.nextInt();
        if (newInt==1) {
            return true;
        }
        if (newInt==2) {
            return false;
        }
            throw new IllegalArgumentException("1또는 2를 입력해주세요");
    }

    public boolean validationContinueGame(Scanner sc) {
        while (continueGame()) {
            if (continueInputNumberValidation(sc)) continue;
            return this.continued;
        }
        return true;
    }

    private boolean continueGame() {
        return !this.continued;
    }

    private boolean continueInputNumberValidation(Scanner sc) {
        try {
            this.continued = inputIsContinue(sc);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return true;
        }
        return false;
    }
}
