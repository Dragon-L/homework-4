package promotion;

import data.CartItem;
import data.DiscountItem;
import data.Item;

import java.util.List;

public class DiscountPromotion extends Promotion{
    private List<DiscountItem> discountItemList;
    public DiscountPromotion(List<DiscountItem> discountItemList){
        this.discountItemList = discountItemList;
    }

    @Override
    public double caculatePrice(List<Item> itemList, CartItem cartItem) {
        double disCount = 1.0;
        for (int i =0;i<discountItemList.size();i++){
            if (discountItemList.get(i).getName().equals(cartItem.getName())){
                double temp = discountItemList.get(i).getDiscount();
                disCount = temp/100;
            }
        }
        return super.caculatePrice(itemList, cartItem)*disCount;
    }
}
