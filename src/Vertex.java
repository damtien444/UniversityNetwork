import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Vertex {

    public int ori;
    public int des;

    public String name;
    public int weight;

    public Vertex(int ori, int des) {
        this.ori = ori;
        this.des = des;
    }

    public Vertex(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public Vertex(String s){
        Pattern pattern = Pattern.compile("([A-Z][0-9]*)");
        Matcher matcher = pattern.matcher(s);
        matcher.find();
        this.name = matcher.group();
        pattern = Pattern.compile("(\\b\\d+)");
        matcher = pattern.matcher(s);
        matcher.find();
        this.weight = Integer.parseInt(matcher.group());
    }


}
