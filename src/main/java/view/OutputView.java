package view;

import domain.menu.Menu;
import domain.menu.OrderedMenus;
import domain.table.Table;

import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String newLine = System.lineSeparator();
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "└ ─ ┘";

    public static void printTables(final List<Table> tables) {
        System.out.println("## 테이블 목록");
        final int size = tables.size();
        printLine(TOP_LINE, size);
        printTableNumbers(tables);
        printLine(BOTTOM_LINE, size);
    }

    public static void printMenus(final List<Menu> menus) {
        for (final Menu menu : menus) {
            System.out.println(menu);
        }
    }

    private static void printLine(final String line, final int count) {
        for (int index = 0; index < count; index++) {
            System.out.print(line);
        }
        System.out.println();
    }

    private static void printTableNumbers(final List<Table> tables) {
        for (final Table table : tables) {
            System.out.printf(TABLE_FORMAT, table);
        }
        System.out.println();
    }

    public static void printOrder(final OrderedMenus orderedMenus) {
        System.out.println("메뉴 수량 금액");
        for (Map.Entry<Menu, Integer> entry : orderedMenus.getOrderedMenus().entrySet()) {
            String name = entry.getKey().getName();
            String count = entry.getValue().toString();
            String price = Integer.toString(entry.getKey().getPrice());
            String message = String.join(" ", name, count, price);
            System.out.println(message);
        }
    }

    public static void printTotalAmount(double amount) {
        System.out.printf("%.2f원%s", amount, newLine);
    }
}
