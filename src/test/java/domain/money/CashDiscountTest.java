package domain.money;

import domain.menu.Category;
import domain.menu.Menu;
import domain.menu.OrderedMenus;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class CashDiscountTest {
    @Test
    void calculateAmount() {
        Map<Menu, Integer> menus = new HashMap<>();
        menus.put(new Menu(5, "간장치킨", Category.CHICKEN, 17_000), 1);
        OrderedMenus orderedMenus = new OrderedMenus(menus);

        assertThat(new CashDiscount(orderedMenus).calculateDiscountAmount()).isEqualTo(17000 * 0.95);
    }
}