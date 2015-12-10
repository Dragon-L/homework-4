package parse;

import data.Item;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Parse<T> {

    public List<T> parse(File file){
        Scanner scan = null;
        try {
            scan = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        List<T> parseList = new ArrayList<T>();

        while (scan.hasNext()){
            String line = scan.nextLine();
            isStandard(line);
            parseList.add(parseLine(line));
        }
        return parseList;
    }
    protected abstract void isStandard(String line);
    protected abstract T parseLine(String line);
}
