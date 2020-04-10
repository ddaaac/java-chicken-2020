package domain.money;

import domain.menu.OrderedMenus;

public abstract class Discount implements DiscountPolicy {
    private final OrderedMenus orderedMenus;

    public Discount(OrderedMenus orderedMenus) {
        this.orderedMenus = orderedMenus;
    }

    @Override
    public double calculateDiscountAmount() {
        return calculateDiscountBy(orderedMenus);
    }

    abstract double calculateDiscountBy(OrderedMenus orderedMenus);
}
