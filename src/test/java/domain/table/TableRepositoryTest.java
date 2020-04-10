package domain.table;

import domain.menu.Menu;
import domain.menu.MenuRepository;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TableRepositoryTest {
    @Test
    void createSize() {
        assertThat(TableRepository.tables()).hasSize(6);
    }

    @Test
    void getTable() {
        assertThat(TableRepository.tables().get(0))
                .isEqualTo(new Table(1));
    }

    @Test
    void getTableInvalidNumber() {
        assertThatThrownBy(() -> {
            TableRepository.getTableBy(10);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("해당 번호에 해당되는 테이블이 없습니다.");
    }

    @Test
    void updateTable() {
        Map<Menu, Integer> expected = new HashMap<>();
        expected.put(MenuRepository.menus().get(0), 20);

        Table table = new Table(1, expected);

        assertThat(TableRepository.updateTableBy(1, MenuRepository.menus().get(0), 20))
                .isEqualTo(table);
    }

    @Test
    void updateTableInvalidNumber() {
        assertThatThrownBy(() -> {
            TableRepository.updateTableBy(10, MenuRepository.menus().get(0), 20);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("해당 번호에 해당되는 테이블이 없습니다.");
    }
}