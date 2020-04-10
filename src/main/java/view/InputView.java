package view;

import domain.table.Table;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String newLine = System.lineSeparator();

    public static int inputCommandNumber() {
        String message = String.join("## 메인 화면" + newLine
                + "1 - 주문 등록" + newLine
                + "2 - 결제하기" + newLine
                + "3 - 프로그램 종료" + newLine + newLine
                + "## 원하는 기능을 선택하세요." + newLine);
        System.out.println(message);
        return nextInt();
    }

    public static int inputTableNumber() {
        System.out.println("## 주문할 테이블을 선택하세요.");
        return nextInt();
    }

    public static int inputMenuNumber() {
        System.out.println("## 등록할 메뉴를 선택하세요.");
        return nextInt();
    }

    public static int inputMenuCount() {
        System.out.println("## 메뉴의 수량을 입력하세요.");
        return nextInt();
    }

    public static int inputCashOrCard(Table table) {
        System.out.printf("%d번 테이블의 결제를 진행합니다.%s", table.getNumber(), newLine);
        System.out.println("신용카드는 1번, 현금 결제는 2번");
        return nextInt();
    }

    private static int nextInt() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return nextInt();
        }
    }
}
