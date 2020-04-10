package domain.table;

import domain.menu.Menu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class TableRepository {
    private static final List<Table> tables = new ArrayList<>();

    static {
        tables.add(new Table(1));
        tables.add(new Table(2));
        tables.add(new Table(3));
        tables.add(new Table(5));
        tables.add(new Table(6));
        tables.add(new Table(8));
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

    public static Table updateTableBy(int number, Menu menu, int count) {
        int index = IntStream.range(0, tables.size())
                .filter(i -> tables.get(i).isTableOf(number))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당 번호에 해당되는 테이블이 없습니다."));

        Table updated = tables.get(index).addMenu(menu, count);
        tables.set(index, updated);

        return updated;
    }
}
