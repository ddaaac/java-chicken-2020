package domain.money;

public class CashDiscount implements DiscountPolicy {
    private static final double DISCOUNT_PERCENT = 0.05;

    @Override
    public double calculateDiscountAmount(double amount) {
        return amount * (1 - DISCOUNT_PERCENT);
    }
}
