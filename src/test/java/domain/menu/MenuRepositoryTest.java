package domain.menu;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MenuRepositoryTest {
    @Test
    void createSize() {
        assertThat(MenuRepository.menus()).hasSize(8);
    }

    @Test
    void getMenuByNumber() {
        assertThat(MenuRepository.getMenuBy(1))
                .isEqualTo(new Menu(1, "후라이드", Category.CHICKEN, 16_000));
    }

    @Test
    void invalidMenuNumber() {
        assertThatThrownBy(() -> {
            MenuRepository.getMenuBy(7);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("해당 번호에 해당되는 메뉴가 없습니다.");
    }
}