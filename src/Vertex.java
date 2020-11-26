import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Vertex {
    String name;
    int weight;


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


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
