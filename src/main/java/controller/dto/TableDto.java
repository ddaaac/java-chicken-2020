package controller.dto;

import domain.menu.OrderedMenus;
import domain.table.Table;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

public class TableDto {
    private final int number;
    private final boolean isOrdered;

    private TableDto(int number, boolean isOrdered) {
        this.number = number;
        this.isOrdered = isOrdered;
    }

    public static List<TableDto> list(Map<Table, OrderedMenus> tableToMenu) {
        return tableToMenu.entrySet()
                .stream()
                .map(entry -> new TableDto(entry.getKey().getNumber(), entry.getValue().isOrdered()))
                .collect(toList());
    }

    public int getNumber() {
        return number;
    }

    public boolean isOrdered() {
        return isOrdered;
    }
}
