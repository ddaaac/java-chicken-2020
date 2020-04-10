package domain.money;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CardDiscountTest {
    @Test
    void calculateAmount() {
        assertThat(new CardDiscount().calculateDiscountAmount(10000)).isEqualTo(10000);
    }
}