package domain.menu;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OrderedMenusTest {
    private static final Menu menu = MenuRepository.menus().get(0);

    @Test
    void addMenu() {
        OrderedMenus orderedMenus = OrderedMenus.empty()
                .addMenu(menu, 10)
                .addMenu(menu, 10);

        Map<Menu, Integer> expected = new HashMap<>();
        expected.put(menu, 20);

        assertThat(orderedMenus).isEqualTo(new OrderedMenus(expected));
    }

    @Test
    void addMenuMoreThan99() {
        assertThatThrownBy(() -> {
            OrderedMenus.empty().addMenu(menu, 100);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("주문 수량의 합은 99를 넘어갈 수 없습니다.");
    }

    @ParameterizedTest
    @MethodSource("generateMenus")
    void isOrdered(Map<Menu, Integer> menus, boolean expected) {
        assertThat(new OrderedMenus(menus).isOrdered()).isEqualTo(expected);
    }

    static Stream<Arguments> generateMenus() {
        Map<Menu, Integer> notEmptyMenus = new HashMap<>();
        notEmptyMenus.put(menu, 10);

        return Stream.of(Arguments.of(new HashMap<>(), false),
                Arguments.of(notEmptyMenus, true));
    }

    @Test
    void calculateChickenCount() {
        Menu firstChicken = new Menu(5, "간장치킨", Category.CHICKEN, 17_000);
        Menu secondChicken = new Menu(6, "순살치킨", Category.CHICKEN, 17_000);
        Menu beverage = new Menu(21, "콜라", Category.BEVERAGE, 1_000);

        Map<Menu, Integer> menus = new HashMap<>();
        menus.put(firstChicken, 10);
        menus.put(secondChicken, 4);
        menus.put(beverage, 3);

        assertThat(new OrderedMenus(menus).calculateChickenCount()).isEqualTo(14);
    }

    @Test
    void calculateTotalAmount() {
        Menu firstChicken = new Menu(5, "간장치킨", Category.CHICKEN, 17_000);
        Menu secondChicken = new Menu(6, "순살치킨", Category.CHICKEN, 17_000);
        Menu beverage = new Menu(21, "콜라", Category.BEVERAGE, 1_000);

        Map<Menu, Integer> menus = new HashMap<>();
        menus.put(firstChicken, 10);
        menus.put(secondChicken, 4);
        menus.put(beverage, 3);

        assertThat(new OrderedMenus(menus).calculateTotalAmount()).isEqualTo(170000 + 68000 + 3000);
    }
}