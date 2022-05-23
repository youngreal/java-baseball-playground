import exception.DuplicatedNumberException;
import exception.NotOnlyNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.InputNumberValidation;

import static org.junit.jupiter.api.Assertions.assertThrows;

class BallValidationTest {

    @Test
    @DisplayName("2자리수를 입력한다 : 예외")
    void twoNumberInputTest() {
        String ex = "45";
        char[] chars = stringToCharArray(ex);
        assertThrows(ArrayIndexOutOfBoundsException.class, () ->{
            InputNumberValidation inputValidation = new InputNumberValidation(chars);
        });
    }

    @Test
    @DisplayName("4자리수를 입력한다 : 예외")
    void fourNumberInputTest() {
        String ex = "1237";
        char[] chars = stringToCharArray(ex);
        assertThrows(ArrayIndexOutOfBoundsException.class, () ->{
            InputNumberValidation inputValidation = new InputNumberValidation(chars);
        });
    }

    @Test
    @DisplayName("서로 다른 세자리수만 입력해야한다")
    void DuplicateInputTest() {
        String ex = "111";
        char[] chars = stringToCharArray(ex);
        assertThrows(DuplicatedNumberException.class, () ->{
            InputNumberValidation inputValidation = new InputNumberValidation(chars);
        });
    }

    @Test
    @DisplayName("0~9사이 숫자만 입력해야한다(특수문자 입력): 예외")
    void SpecialCharInputTest() {
        String ex = "!@#";
        char[] chars = stringToCharArray(ex);
        assertThrows(NotOnlyNumberException.class, () ->{
            InputNumberValidation inputValidation = new InputNumberValidation(chars);
        });
    }

    @Test
    @DisplayName("0~9사이 숫자만 입력해야한다(공백 입력): 예외")
    void blankInputTest() {
        String ex = "   ";
        char[] chars = stringToCharArray(ex);
        assertThrows(NotOnlyNumberException.class, () ->{
            InputNumberValidation inputValidation = new InputNumberValidation(chars);
        });
    }

    private char[] stringToCharArray(String ex) {
        return ex.toCharArray();
    }
}
