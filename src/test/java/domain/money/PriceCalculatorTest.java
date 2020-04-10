package domain.money;

import domain.menu.Category;
import domain.menu.Menu;
import domain.menu.OrderedMenus;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PriceCalculatorTest {
    @Test
    void calculatePrice() {
        List<DiscountPolicy> discountPolicies = Arrays.asList(
                new ChickenDiscount(20),
                new CashDiscount()
        );
        assertThat(new PriceCalculator(discountPolicies, 30000).calculatePrice())
                .isEqualTo(9500);
    }

    @Test
    void from() {
        Menu firstChicken = new Menu(5, "간장치킨", Category.CHICKEN, 17_000);
        Menu secondChicken = new Menu(6, "순살치킨", Category.CHICKEN, 17_000);
        Menu beverage = new Menu(21, "콜라", Category.BEVERAGE, 1_000);

        Map<Menu, Integer> menus = new HashMap<>();
        menus.put(firstChicken, 10);
        menus.put(secondChicken, 4);
        menus.put(beverage, 3);
        OrderedMenus orderedMenus = new OrderedMenus(menus);

        PriceCalculator priceCalculator = PriceCalculator.from(orderedMenus, true);
        assertThat(priceCalculator.calculatePrice())
                .isEqualTo((17000 * 14 + 3000 - 10000) * 0.95);
    }

    @Test
    void fromNotOrderedTable() {
        OrderedMenus orderedMenus = new OrderedMenus(new HashMap<>());
        assertThatThrownBy(() -> {
            PriceCalculator.from(orderedMenus, true);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("주문 내역이 없는 테이블입니다");
    }
}