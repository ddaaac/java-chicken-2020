package domain.money;

import domain.menu.OrderedMenus;

public class CardDiscount extends Discount {
    public CardDiscount(OrderedMenus orderedMenus) {
        super(orderedMenus);
    }

    @Override
    double calculateDiscountBy(OrderedMenus orderedMenus) {
        return orderedMenus.calculateTotalAmount();
    }
}
