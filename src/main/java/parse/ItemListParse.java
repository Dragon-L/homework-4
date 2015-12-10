package parse;

import data.Item;

import java.util.regex.Pattern;

public class ItemListParse extends Parse<Item>{
    private final Pattern PATTERN =Pattern.compile("^(\\w+):(\\d+)$");


    @Override
    protected Item parseLine(String line) {
        return new Item(line.split(":")[0],Integer.parseInt(line.split(":")[1]));
    }

    @Override
    protected void isStandard(String line) {
        if (!PATTERN.matcher(line).matches()){
            throw new IllegalArgumentException("invalid input format");
        }
    }
}
