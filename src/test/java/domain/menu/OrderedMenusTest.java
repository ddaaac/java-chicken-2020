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
    @Test
    void addMenu() {
        OrderedMenus orderedMenus = OrderedMenus.empty()
                .addMenu(MenuRepository.menus().get(0), 10)
                .addMenu(MenuRepository.menus().get(0), 10);

        Map<Menu, Integer> expected = new HashMap<>();
        expected.put(MenuRepository.menus().get(0), 20);

        assertThat(orderedMenus).isEqualTo(new OrderedMenus(expected));
    }

    @Test
    void addMenuMoreThan99() {
        assertThatThrownBy(() -> {
            OrderedMenus.empty().addMenu(MenuRepository.menus().get(0), 100);
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
        notEmptyMenus.put(MenuRepository.menus().get(0), 10);

        return Stream.of(Arguments.of(new HashMap<>(), true),
                Arguments.of(notEmptyMenus, false));
    }
}