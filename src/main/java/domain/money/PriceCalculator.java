package domain.money;

import domain.menu.OrderedMenus;

import java.util.ArrayList;
import java.util.List;

public class PriceCalculator {
    private final List<DiscountPolicy> discountPolicies;
    private final double amount;

    PriceCalculator(List<DiscountPolicy> discountPolicies, double amount) {
        this.discountPolicies = discountPolicies;
        this.amount = amount;
    }

    public static PriceCalculator from(OrderedMenus orderedMenus, boolean isCash) {
        validateOrdered(orderedMenus);

        List<DiscountPolicy> discountPolicies = new ArrayList<>();
        discountPolicies.add(new ChickenDiscount(orderedMenus.calculateChickenCount()));
        if (isCash) {
            discountPolicies.add(new CashDiscount());
        }

        return new PriceCalculator(discountPolicies, orderedMenus.calculateTotalAmount());
    }

    private static void validateOrdered(OrderedMenus orderedMenus) {
        if (!orderedMenus.isOrdered()) {
            throw new IllegalArgumentException("주문 내역이 없는 테이블입니다");
        }
    }

    public double calculatePrice() {
        double totalAmount = amount;
        for (DiscountPolicy discountPolicy : discountPolicies) {
            totalAmount = discountPolicy.calculateDiscountAmount(totalAmount);
        }
        return totalAmount;
    }
}
