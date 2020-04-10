package domain.table;

import domain.menu.Menu;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Table {
    private static final int MAX_MENU_COUNT = 99;

    private final int number;
    private final Map<Menu, Integer> orderedMenus;

    Table(int number, Map<Menu, Integer> orderedMenus) {
        this.number = number;
        this.orderedMenus = orderedMenus;
    }

    public Table(final int number) {
        this(number, new HashMap<>());
    }

    Table addMenu(Menu menu, int count) {
        Map<Menu, Integer> orderedMenus = new HashMap<>(this.orderedMenus);
        int totalCount = count;

        if (orderedMenus.containsKey(menu)) {
            int originalCount = orderedMenus.get(menu);
            totalCount += originalCount;
        }

        validateMenuCount(totalCount);

        orderedMenus.put(menu, totalCount);

        return new Table(number, orderedMenus);
    }

    public boolean isOrdered() {
        return orderedMenus.isEmpty();
    }

    public boolean isTableOf(int number) {
        return this.number == number;
    }

    private void validateMenuCount(int totalCount) {
        if (totalCount > MAX_MENU_COUNT) {
            throw new IllegalArgumentException("주문 수량의 합은 99를 넘어갈 수 없습니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Table table = (Table) o;
        return number == table.number &&
                Objects.equals(orderedMenus, table.orderedMenus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, orderedMenus);
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
