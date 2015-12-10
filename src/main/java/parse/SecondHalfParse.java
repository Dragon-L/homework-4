package parse;

import data.SecondHalfItem;

import java.util.regex.Pattern;

public class SecondHalfParse extends Parse {
    private final Pattern PATTERN = Pattern.compile("^(\\w+)$");


    @Override
    protected SecondHalfItem parseLine(String line) {
        return new SecondHalfItem(line);
    }

    @Override
    protected void isStandard(String line) {
        if (!PATTERN.matcher(line).matches()){
            throw new IllegalArgumentException("invalid input format");
        }
    }
}
