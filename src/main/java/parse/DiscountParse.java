package parse;

import data.DiscountItem;
import data.Item;

import java.util.regex.Pattern;

public class DiscountParse extends Parse {
    private final Pattern PATTERN =Pattern.compile("^(\\w+):(\\d+)$");


    @Override
    protected DiscountItem parseLine(String line) {
        return new DiscountItem(line.split(":")[0],Integer.parseInt(line.split(":")[1]));
    }

    @Override
    protected void isStandard(String line) {
        if (!PATTERN.matcher(line).matches()){
            throw new IllegalArgumentException("invalid input format");
        }
    }
}
