package domain.table;

import domain.menu.Menu;
import domain.menu.OrderedMenus;

import java.util.*;

public class TableRepository {
    private static final List<Table> tables = new ArrayList<>();
    private static final Map<Table, OrderedMenus> orderedMenus = new HashMap<>();

    static {
        tables.add(new Table(1));
        tables.add(new Table(2));
        tables.add(new Table(3));
        tables.add(new Table(5));
        tables.add(new Table(6));
        tables.add(new Table(8));

        for (Table table : tables) {
            orderedMenus.put(table, OrderedMenus.empty());
        }
    }

    public static List<Table> tables() {
        return Collections.unmodifiableList(tables);
    }

    public static Table getTableBy(int number) {
        return tables().stream()
                .filter(table -> table.isTableOf(number))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당 번호에 해당되는 테이블이 없습니다."));
    }

    public static void updateTableMenu(Table table, Menu menu, int count) {
        OrderedMenus updatedMenus = orderedMenus.get(table).addMenu(menu, count);

        orderedMenus.put(table, updatedMenus);
    }

    public static OrderedMenus getOrderedMenusBy(int tableNumber) {
        Table table = getTableBy(tableNumber);
        return orderedMenus.get(table);
    }
}
