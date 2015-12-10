package parse;

import data.CartItem;

import java.util.regex.Pattern;

public class CartParse extends Parse {
    private final Pattern PATTERN = Pattern.compile("^(\\w+)(-(\\d+))*");

    @Override
    protected CartItem parseLine(String line) {
        if (line.contains("-")){
            return new CartItem(line.split("-")[0],Integer.parseInt(line.split("-")[1]));
        }
        else {
            return new CartItem(line,1);
        }
    }
    @Override
    protected void isStandard(String line) {
        if (!PATTERN.matcher(line).matches()){
            throw new IllegalArgumentException("invalid input format");
        }
    }
}
