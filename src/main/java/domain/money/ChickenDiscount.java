package domain.money;

public class ChickenDiscount implements DiscountPolicy {
    private static final int DISCOUNT_AMOUNT = 10000;
    private static final int DISCOUNT_UNIT = 10;

    private int chickenCount;

    public ChickenDiscount(int chickenCount) {
        this.chickenCount = chickenCount;
    }

    @Override
    public double calculateDiscountAmount(double amount) {
        return amount - Math.floor(chickenCount / DISCOUNT_UNIT) * DISCOUNT_AMOUNT;
    }
}
