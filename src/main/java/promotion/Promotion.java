package promotion;

import data.CartItem;
import data.Item;

import java.util.List;

public class Promotion extends Caculate{
    protected Caculate compotent;

    public void applyPromotion(Caculate compotent){
        this.compotent = compotent;
    }

    @Override
    public double caculatePrice(List<Item> itemList, CartItem cartItem) {
        return compotent.caculatePrice(itemList, cartItem);
    }
}
