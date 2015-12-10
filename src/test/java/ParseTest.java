import data.CartItem;
import data.DiscountItem;
import data.Item;
import data.SecondHalfItem;
import parse.*;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ParseTest {
    private Parse parse;
    private File file;

    @Test
    public void should_get_right_data_when_parse_itemlist() {
        file = new File("src/main/resource/itemlist.txt");
        parse = new ItemListParse();
        List<Item> itemList = parse.parse(file);

        assertThat(itemList.get(0).getName(),is("ITEM000001"));
        assertThat(itemList.get(0).getPrice(),is(40));
        assertThat(itemList.get(1).getName(),is("ITEM000003"));
        assertThat(itemList.get(1).getPrice(),is(50));
        assertThat(itemList.get(2).getName(),is("ITEM000005"));
        assertThat(itemList.get(2).getPrice(),is(60));

    }
    @Test
    public void should_get_right_data_when_parse_discount() {
        file = new File("src/main/resource/discount_promotion.txt");
        parse = new DiscountParse();
        List<DiscountItem> discountList = parse.parse(file);

        assertThat(discountList.get(0).getName(),is("ITEM000001"));
        assertThat(discountList.get(0).getDiscount(),is(75));
        assertThat(discountList.get(1).getName(),is("ITEM000005"));
        assertThat(discountList.get(1).getDiscount(),is(90));
    }
    @Test
    public void should_get_right_data_when_parse_second_half() {
        file = new File("src/main/resource/second_half_price_promotion.txt");
        parse = new SecondHalfParse();
        List<SecondHalfItem> secondHalfList = parse.parse(file);

        assertThat(secondHalfList.get(0).getName(),is("ITEM000001"));
        assertThat(secondHalfList.get(1).getName(),is("ITEM000003"));
    }
    @Test
    public void should_get_right_data_when_parse_cart() {
        file = new File("src/main/resource/cart.txt");
        parse = new CartParse();
        List<CartItem> cartList = parse.parse(file);

        assertThat(cartList.get(0).getName(),is("ITEM000001"));
        assertThat(cartList.get(0).getNum(),is(3));
        assertThat(cartList.get(1).getName(),is("ITEM000003"));
        assertThat(cartList.get(1).getNum(),is(2));
        assertThat(cartList.get(2).getName(),is("ITEM000005"));
        assertThat(cartList.get(2).getNum(),is(2));
    }
}
