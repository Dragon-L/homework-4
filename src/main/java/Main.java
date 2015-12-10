import data.CartItem;
import data.DiscountItem;
import data.Item;
import data.SecondHalfItem;
import parse.*;

import java.io.File;
import java.util.List;

public class Main {
    public static void main(String[] args){
        Parse itemParse = new ItemListParse();
        Parse dicountParse = new DiscountParse();
        Parse secondHalfParse = new SecondHalfParse();
        Parse cartParse = new CartParse();

        List<Item> itemList = itemParse.parse(new File("src/main/resource/itemlist.txt"));
        List<DiscountItem> discountList =dicountParse.parse(new File("src/main/resource/discount_promotion.txt"));
        List<SecondHalfItem> secondHalfList =secondHalfParse.parse(new File("src/main/resource/second_half_price_promotion.txt"));
        List<CartItem> cartList =cartParse.parse(new File("src/main/resource/cart.txt"));

        PosMachine posMachine = new PosMachine(itemList);
        posMachine.setPromotion(discountList,secondHalfList);
        int price =(int) posMachine.getPrice(cartList);
        System.out.printf("折后价:%d",price);
    }
}
