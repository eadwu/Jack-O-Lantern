import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        String[][] faceFeatures = new String[22][44];
        JackOLantern thing = new JackOLantern(faceFeatures);

        thing.fill("@");

        // Carve out stem
        IntStream.range(0, 2).forEach(row -> {
            IntStream.range(0, 18).forEach(col -> thing.edit(" ", row, col));
            IntStream.range(21, faceFeatures[row].length).forEach(col -> thing.edit(" ", row, col));
        });

        IntStream.range(2, 4).forEach(row -> {
            IntStream.range(0, 19).forEach(col -> thing.edit(" ", row, col));
            IntStream.range(22, faceFeatures[row].length).forEach(col -> thing.edit(" ", row, col));
        });

        // Carve out pumpkin
        IntStream.range(0, 6).forEach(i -> {
            IntStream.range(0, 11 - i * 2).forEach(col -> {
                thing.edit(" ", 4 + i, col);
                thing.edit(" ", faceFeatures.length - i - 1, col);

                thing.edit(" ", 4 + i, faceFeatures[0].length - col - 1);
                thing.edit(" ", faceFeatures.length - i - 1, faceFeatures[0].length - col - 1);
            });
        });

        // Carve out eyes
        IntStream.range(0, 4).forEach(i -> {
            IntStream.range(0, i * 2 + 1).forEach(col -> {
                thing.edit(" ", 7 + i, 13 - i + col);
                thing.edit(" ", 7 + i, 30 - i + col);
            });
        });

        // Carve out nose
        IntStream.range(0, 3).forEach(i -> {
            double end = Math.pow(2, i + 1);

            IntStream.range(0, (int) end).forEach(col -> {
                thing.edit(" ", 10 + i, 21 - (int) Math.pow(2, i) + col);
            });
        });

        // Carve out mouth
        IntStream.range(0, 2).forEach(i -> {
            IntStream.range(0, i + 1).forEach(col -> {
                thing.edit(" ", 15 + i, 9 + col);
                thing.edit(" ", 15 + i, 34 - i + col);
            });
        });
        IntStream.range(0, 24).forEach(col -> {
            thing.edit(" ", 17, 10 + col);
        });

        System.out.println(thing.toString());
    }
}