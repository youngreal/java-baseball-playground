import exception.DuplicatedNumberException;
import exception.NotOnlyNumberException;
import util.InputNumberValidation;
import util.Setup;
import view.InputView;
import view.ResultView;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean continued= true;
        Setup answer = new Setup();
        answer.generateNumber();

        do {
            InputView inputView = new InputView();
            Scanner sc = inputView.scanNumber();
            char[] inputChars = inputView.stringToCharArray(sc);

            ArrayList<Integer> inputArrayList;
            try {
                InputNumberValidation inputValidation = new InputNumberValidation(inputChars);
                inputArrayList = inputValidation.getInputNumber();
            } catch (DuplicatedNumberException | ArrayIndexOutOfBoundsException | NotOnlyNumberException e) {
                System.out.println(e.getMessage());
                continue;
            }

            Balls balls = new Balls(inputArrayList, answer.numAnswer);
            balls.calculateScore(balls);
            balls.printStrikeBallNothing();

            if (balls.isCorrectAnswer()) {
                ResultView resultView = new ResultView();
                continued = resultView.validationContinueGame(sc);
                answer.newGenerateNumber();
            }
        }while(continued);
    }
}
