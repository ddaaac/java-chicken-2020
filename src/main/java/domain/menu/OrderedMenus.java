package domain.menu;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class OrderedMenus {
    private static final int MAX_MENU_COUNT = 99;

    private final Map<Menu, Integer> orderedMenus;

    public OrderedMenus(Map<Menu, Integer> orderedMenus) {
        this.orderedMenus = orderedMenus;
    }

    public static OrderedMenus empty() {
        return new OrderedMenus(new HashMap<>());
    }

    public OrderedMenus addMenu(Menu menu, int count) {
        Map<Menu, Integer> orderedMenus = new HashMap<>(this.orderedMenus);
        int totalCount = count;

        if (orderedMenus.containsKey(menu)) {
            int originalCount = orderedMenus.get(menu);
            totalCount += originalCount;
        }

        validateMenuCount(totalCount);

        orderedMenus.put(menu, totalCount);
        return new OrderedMenus(orderedMenus);
    }

    private void validateMenuCount(int totalCount) {
        if (totalCount > MAX_MENU_COUNT) {
            throw new IllegalArgumentException("주문 수량의 합은 99를 넘어갈 수 없습니다.");
        }
    }

    public boolean isOrdered() {
        return orderedMenus.isEmpty();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderedMenus that = (OrderedMenus) o;
        return Objects.equals(orderedMenus, that.orderedMenus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderedMenus);
    }
}
