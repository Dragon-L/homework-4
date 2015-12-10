import data.CartItem;
import data.DiscountItem;
import data.Item;
import data.SecondHalfItem;
import org.junit.Before;
import org.junit.Test;
import promotion.Caculate;
import promotion.DiscountPromotion;
import promotion.Promotion;
import promotion.SecondHalfPromotion;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PromotionTest {
    private List<Item> itemList = new ArrayList<Item>();
    private List<DiscountItem> discountItemList= new ArrayList<DiscountItem>();
    private List<SecondHalfItem> secondHalfItemList= new ArrayList<SecondHalfItem>();
    private CartItem cartItem;
    private Caculate caculate;

    @Before
    public void setUp() {
        itemList.add(new Item("ITEM01",40));
        discountItemList.add(new DiscountItem("ITEM01",75));
        secondHalfItemList.add(new SecondHalfItem("ITEM01"));
        cartItem = new CartItem("ITEM01",3);
        caculate = new Caculate();
    }

    @Test
    public void should_get_full_price_when_have_no_promotion() {
        double price = caculate.caculatePrice(itemList,cartItem);
        assertThat(price,is(200.0));
    }
    @Test
    public void should_get_discount_price_when_have_discount_promotion() {
        Promotion discountPromotion = new DiscountPromotion(discountItemList);
        discountPromotion.applyPromotion(caculate);
        double price = discountPromotion.caculatePrice(itemList,cartItem);
        assertThat(price,is(150.0));
    }
    @Test
    public void should_get_secondHalf_price_when_have_secondHalf_promotion() {
        Promotion secondHalfPromotion = new SecondHalfPromotion(secondHalfItemList);
        secondHalfPromotion.applyPromotion(caculate);
        double price = secondHalfPromotion.caculatePrice(itemList,cartItem);
        assertThat(price,is(100.0));
    }
    @Test
    public void should_get_double_promotion_price_when_have_discount_and_secondHalf_promotion() {
        Promotion discountPromotion = new DiscountPromotion(discountItemList);
        Promotion secondHalfPromotion = new SecondHalfPromotion(secondHalfItemList);
        discountPromotion.applyPromotion(caculate);
        secondHalfPromotion.applyPromotion(discountPromotion);
        double price = secondHalfPromotion.caculatePrice(itemList,cartItem);
        assertThat(price,is(75.0));
    }
}
