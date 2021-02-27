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
        String firstName = names.get(0);
        if (names.size() == 1) {
            return firstName;
        }
        String lastName = names.get(1);
        StringBuilder titles = new StringBuilder();
        while (names.size() > 2) {
            titles.append(names.get(2)).append(" ");
            names.remove(2);
        }
        return String.format("%s, %s %s", lastName, firstName, titles).trim();
    }

    private List<String> splitNamesAndRemoveHonorific(String name) {
        List<String> names = new ArrayList<>(List.of(name.trim().split(WHITESPACE)));
        if (names.get(0).matches(HONORIFIC)) {
            names.remove(0);
        }
        return names;
    }
}