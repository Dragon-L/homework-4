package data;

public class CartItem {
    private String name;
    private Integer num;

    public CartItem(String name,Integer num){
        this.name = name;
        this.num = num;
    }
    public String getName() {
        return name;
    }
    public Integer getNum() {
        return num;
    }
}
