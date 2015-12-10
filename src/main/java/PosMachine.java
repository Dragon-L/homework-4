import data.CartItem;
import data.DiscountItem;
import data.Item;
import data.SecondHalfItem;
import promotion.Caculate;
import promotion.DiscountPromotion;
import promotion.Promotion;
import promotion.SecondHalfPromotion;

import java.util.List;

public class PosMachine {
    private List<Item> itemList;
    private Caculate caculate;
    public  PosMachine(List<Item> itemList){
        this.itemList = itemList;
        caculate = new Caculate();
    }

    public void setPromotion(List<DiscountItem> discountItemList,List<SecondHalfItem> secondHalfItemList){
        Caculate temp = new Caculate();
        Promotion discountPromotion = new DiscountPromotion(discountItemList);
        Promotion secondHalfPromotion = new SecondHalfPromotion(secondHalfItemList);

        discountPromotion.applyPromotion(temp);
        secondHalfPromotion.applyPromotion(discountPromotion);
        caculate = secondHalfPromotion;
    }
    public double getPrice(List<CartItem> cartItemList){
        double total = 0.0;
        for (CartItem cartItem:cartItemList){
            total += caculate.caculatePrice(itemList,cartItem);
        }
        return total;
    }

}
