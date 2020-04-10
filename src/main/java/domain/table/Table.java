package domain.table;

import domain.menu.Menu;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Table {
    private final int number;
    private final Map<Menu, Integer> orderedMenus;

    Table(int number, Map<Menu, Integer> orderedMenus) {
        this.number = number;
        this.orderedMenus = orderedMenus;
    }

    public Table(final int number) {
        this(number, new HashMap<>());
    }

    public boolean isTableOf(int number) {
        return this.number == number;
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
