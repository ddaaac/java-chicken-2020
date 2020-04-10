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
        List<DiscountPolicy> discountPolicies = new ArrayList<>();
        discountPolicies.add(new ChickenDiscount(orderedMenus.calculateChickenCount()));
        if (isCash) {
            discountPolicies.add(new CashDiscount());
        }

        return new PriceCalculator(discountPolicies, orderedMenus.calculateTotalAmount());
    }

    public double calculatePrice() {
        double totalAmount = amount;
        for (DiscountPolicy discountPolicy : discountPolicies) {
            totalAmount = discountPolicy.calculateDiscountAmount(totalAmount);
        }
        return totalAmount;
    }
}
