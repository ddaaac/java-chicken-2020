package domain.money;

import domain.menu.OrderedMenus;

public class CashDiscount extends Discount {
    private static final double DISCOUNT_PERCENT = 0.05;

    public CashDiscount(OrderedMenus orderedMenus) {
        super(orderedMenus);
    }

    @Override
    double calculateDiscountBy(OrderedMenus orderedMenus) {
        return orderedMenus.calculateTotalAmount() * (1 - DISCOUNT_PERCENT);
    }
}
