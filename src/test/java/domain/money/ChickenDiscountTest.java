package domain.money;

import domain.menu.Category;
import domain.menu.Menu;
import domain.menu.OrderedMenus;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class ChickenDiscountTest {
    @Test
    void calculateAmount() {
        Menu firstChicken = new Menu(5, "간장치킨", Category.CHICKEN, 17_000);
        Menu secondChicken = new Menu(6, "순살치킨", Category.CHICKEN, 17_000);
        Menu beverage = new Menu(21, "콜라", Category.BEVERAGE, 1_000);

        Map<Menu, Integer> menus = new HashMap<>();
        menus.put(firstChicken, 10);
        menus.put(secondChicken, 4);
        menus.put(beverage, 3);
        OrderedMenus orderedMenus = new OrderedMenus(menus);

        assertThat(new ChickenDiscount(orderedMenus).calculateDiscountAmount()).isEqualTo(170000 + 68000 + 3000 - 10000);

    }
}