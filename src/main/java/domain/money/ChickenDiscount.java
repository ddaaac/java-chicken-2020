package domain.money;

import domain.menu.OrderedMenus;

public class ChickenDiscount extends Discount {
    private static final int DISCOUNT_AMOUNT = 10000;
    private static final int DISCOUNT_UNIT = 10;

    public ChickenDiscount(OrderedMenus orderedMenus) {
        super(orderedMenus);
    }

    @Override
    double calculateDiscountBy(OrderedMenus orderedMenus) {
        return orderedMenus.calculateTotalAmount() -
                Math.floor(orderedMenus.calculateChickenCount() / DISCOUNT_UNIT) * DISCOUNT_AMOUNT;
    }
}
