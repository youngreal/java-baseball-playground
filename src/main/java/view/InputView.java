package view;

import java.util.Scanner;

/**
 * 숫자를 입력받고 형변환후 반환해주는 클래스
 */
public class InputView {
    public Scanner scanNumber() {
        System.out.println("숫자를 입력해주세요 : ");
       return new Scanner(System.in);
    }

    public  char[] stringToCharArray(Scanner sc) {
        return sc.nextLine().toCharArray();
    }
}
