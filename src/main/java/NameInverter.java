import java.util.ArrayList;
import java.util.List;

public class NameInverter {
    public String invert(String name) {
        List<String> names = splitNames(name);
        if(names.size() == 1) {
            return names.get(0);
        }
        return String.format("%s, %s", names.get(1), names.get(0));
    }

    private ArrayList<String> splitNames(String name) {
        return new ArrayList<>(List.of(name.trim().split("\\s+")));
    }
}
