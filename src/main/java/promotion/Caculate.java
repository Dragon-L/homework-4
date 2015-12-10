package promotion;

import data.CartItem;
import data.Item;

import java.util.List;

public class Caculate {          //用的装饰者模式，用promotion装饰Caculate
    public double caculatePrice(List<Item> itemList, CartItem cartItem){
        for (int i =0;i<itemList.size();i++){
            if (itemList.get(i).getName().equals(cartItem.getName())){
                return itemList.get(i).getPrice()*cartItem.getNum();
            }
        }
        return 0.0;
    }
}
