import java.util.Arrays;
import java.util.stream.Collectors;

public class JackOLantern {
    private String[][] faceFeatures;

    public JackOLantern(String[][] faceFeatures) {
        this.faceFeatures = faceFeatures;
    }

    public void edit(String replace, int row, int column) {
        this.faceFeatures[row][column] = replace;
    }

    public void fill(String str) {
        for (int i = 0; i < this.faceFeatures.length; i++)
            Arrays.fill(this.faceFeatures[i], str);
    }

    @Override
    public String toString() {
        return Arrays.stream(this.faceFeatures).map(v -> {
            return Arrays.stream(v).collect(Collectors.joining());
        }).collect(Collectors.joining("\n"));
    }
}