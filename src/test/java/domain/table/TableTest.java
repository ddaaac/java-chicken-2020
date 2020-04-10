package domain.table;

import domain.menu.Menu;
import domain.menu.MenuRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TableTest {
    @Test
    void create() {
        assertThat(new Table(1)).isInstanceOf(Table.class);
    }

    @Test
    void addMenu() {
        Map<Menu, Integer> expected = new HashMap<>();
        expected.put(MenuRepository.menus().get(0), 20);

        Table table = new Table(1)
                .addMenu(MenuRepository.menus().get(0), 10)
                .addMenu(MenuRepository.menus().get(0), 10);

        assertThat(table).isEqualTo(new Table(1, expected));
    }

    @Test
    void addMenuMoreThan99() {
        assertThatThrownBy(() -> {
            new Table(1).addMenu(MenuRepository.menus().get(0), 100);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("주문 수량의 합은 99를 넘어갈 수 없습니다.");
    }

    @ParameterizedTest
    @MethodSource("generateMenus")
    void isOrdered(Map<Menu, Integer> menus, boolean expected) {
        assertThat(new Table(1, menus).isOrdered()).isEqualTo(expected);
    }

    static Stream<Arguments> generateMenus() {
        Map<Menu, Integer> notEmptyMenus = new HashMap<>();
        notEmptyMenus.put(MenuRepository.menus().get(0), 10);

        return Stream.of(Arguments.of(new HashMap<>(), true),
                Arguments.of(notEmptyMenus, false));
    }
}