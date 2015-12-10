package promotion;

import data.CartItem;
import data.Item;
import data.SecondHalfItem;

import java.util.List;

public class SecondHalfPromotion extends Promotion {
    private List<SecondHalfItem> secondHalfItemList;
    public SecondHalfPromotion(List<SecondHalfItem> secondHalfItemList){
        this.secondHalfItemList = secondHalfItemList;
    }

    @Override
    public double caculatePrice(List<Item> itemList, CartItem cartItem) {
        for (int i =0;i<secondHalfItemList.size();i++){
            if (secondHalfItemList.get(i).getName().equals(cartItem.getName())){
                int halfNum = cartItem.getNum()/2;
                CartItem halfItem = new CartItem(cartItem.getName(),halfNum);
                CartItem restItem = new CartItem(cartItem.getName(),cartItem.getNum()-halfNum);
                return super.caculatePrice(itemList,halfItem)*0.5+super.caculatePrice(itemList,restItem);
            }
        }
        return super.caculatePrice(itemList, cartItem);
    }
}
