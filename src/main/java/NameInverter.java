import java.util.ArrayList;
import java.util.List;

public class NameInverter {
    public static final String WHITESPACE = "\\s+";
    public static final String HONORIFIC = "[Mm]rs?\\.";

    public String invert(String name) {
        List<String> names = splitNamesAndRemoveHonorific(name);
        return invertNames(names);
    }

    private String invertNames(List<String> names) {
        return switch (names.size()) {
            case 1 -> names.get(0);
            case 2 -> String.format("%s, %s", names.get(1), names.get(0));
            default -> String.format("%s, %s %s", names.get(1), names.get(0), names.get(2));
        };
    }

    private List<String> splitNamesAndRemoveHonorific(String name) {
        List<String> names = new ArrayList<>(List.of(name.trim().split(WHITESPACE)));
        if (names.get(0).matches(HONORIFIC)) {
            names.remove(0);
        }
        return names;
    }
}