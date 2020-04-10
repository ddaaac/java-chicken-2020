package domain.money;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ChickenDiscountTest {
    @Test
    void calculateAmount() {
        assertThat(new ChickenDiscount(11).calculateDiscountAmount(17000)).isEqualTo(7000);
    }
}