package domain.table;

import domain.menu.Menu;

import java.util.HashMap;
import java.util.Map;

public class Table {
    private final int number;
    private final Map<Menu, Integer> orderedMenus;

    private Table(int number, Map<Menu, Integer> orderedMenus) {
        this.number = number;
        this.orderedMenus = orderedMenus;
    }

    public Table(final int number) {
        this(number, new HashMap<>());
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
