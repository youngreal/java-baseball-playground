package util;

import exception.DuplicatedNumberException;
import exception.NotOnlyNumberException;

import java.util.ArrayList;

/**
 * 입력받은 숫자에대해 길이,형식,중복에대한 Validation을 하는 클래스
 */
public class InputNumberValidation {
    public static final int CHARTOINT = 48;
    public static final int NUMBER_MIN = 0;
    public static final int NUMBER_MAX = 9;
    private final ArrayList<Integer> inputArrayList= new ArrayList<>();

    public InputNumberValidation(char[] inputChars) {
        validateNumber(inputChars);
    }

    private void validateNumber(char[] inputChars) {
        inputNumberLengthValidation(inputChars);
        inputOnlyNumberValidation(inputChars);
        inputNumberDuplicateValidation(inputChars);
    }

    private void inputNumberDuplicateValidation(char[] inputChars) {
        for (int inputArrayListPosition = 0; inputArrayListPosition < 3; inputArrayListPosition++) {
            inputNumberNotDuplicatedValidation(inputChars,inputArrayListPosition);
            addInputNumberToArrayList(inputChars[inputArrayListPosition]);
        }
    }

    private void inputOnlyNumberValidation(char[] inputChars) {
        for (int i = 0; i < inputChars.length; i++) {
            InputNotValidatedRangeNumberGenerateException(inputChars, i);
        }
    }

    private void InputNotValidatedRangeNumberGenerateException(char[] inputChars, int i) {
        if (isNotValidatedNumberRange(inputChars[i])) {
            throw new NotOnlyNumberException("숫자만 입력해주세요");
        }
    }

    private boolean isNotValidatedNumberRange(char inputChars) {
        return NUMBER_MIN > inputChars - CHARTOINT || inputChars - CHARTOINT > NUMBER_MAX;
    }

    private void addInputNumberToArrayList(char inputChars) {
        this.inputArrayList.add(inputChars -CHARTOINT);
    }

    private void inputNumberNotDuplicatedValidation(char[] inputChars, int i) {
        if(isDuplicated(inputChars[i])){
            throw new DuplicatedNumberException("중복없는 숫자를 입력해주세요");
        }
    }

    private void inputNumberLengthValidation(char[] chars) {
        if (chars.length!= 3) {
            throw new ArrayIndexOutOfBoundsException("세자리 수를 입력해주세요");
        }
    }

    private boolean isDuplicated(char inputChars) {
        return this.inputArrayList.contains(inputChars - CHARTOINT);
    }

    public ArrayList<Integer> getInputNumber() {
        return this.inputArrayList;
    }
}
