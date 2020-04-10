package domain.money;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CashDiscountTest {
    @Test
    void calculateAmount() {
        assertThat(new CashDiscount().calculateDiscountAmount(17000)).isEqualTo(17000 * 0.95);
    }
}