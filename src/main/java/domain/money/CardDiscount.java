package domain.money;

public class CardDiscount implements DiscountPolicy {
    @Override
    public double calculateDiscountAmount(double amount) {
        return amount;
    }
}
