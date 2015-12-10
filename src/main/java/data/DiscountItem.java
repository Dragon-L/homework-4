package data;

public class DiscountItem {
    private String name;
    private int discount;

    public DiscountItem(String name, int discount) {
        this.name = name;
        this.discount = discount;
    }
    public String getName() {
        return name;
    }
    public Integer getDiscount() {
        return discount;
    }
}
