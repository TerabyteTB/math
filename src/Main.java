import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        int n = 100;
        int[] numbers = IntStream.iterate(1, i -> i <= n, i -> i + 1)
                .boxed()
                .toList().stream()
                .mapToInt(Integer::intValue).toArray();

        List<List<Integer>> triangles = equalPnATriangles(validTriangles(numbers));
        System.out.println(Arrays.deepToString(triangles.toArray()));
    }

    public static List<List<Integer>> validTriangles(int[] numbers) {
        List<List<Integer>> validTriangles = new ArrayList<>();

        Arrays.sort(numbers);

        for (int i = 0; i < numbers.length - 2; i++) {
            for (int j = i + 1; j < numbers.length - 1; j++) {
                for (int k = j + 1; k < numbers.length; k++) {
                    int a = numbers[i];
                    int b = numbers[j];
                    int c = numbers[k];

                    if (isTriangle(a, b, c)) {
                        List<Integer> triangle = Arrays.asList(a, b, c);
                        validTriangles.add(triangle);
                    }
                }
            }
        }

        return validTriangles;
    }

    public static List<List<Integer>> equalPnATriangles(List<List<Integer>> triangles) {
        List<List<Integer>> result = new ArrayList<>();

        for (List<Integer> triangle : triangles) {
            if (triangle.size() == 3) {
                int a = triangle.get(0);
                int b = triangle.get(1);
                int c = triangle.get(2);

                if (isTriangle(a, b, c)) {
                    double perimeter = a + b + c;
                    double s = perimeter / 2.0;
                    double area = Math.sqrt(s * (s - a) * (s - b) * (s - c));

                    if (perimeter == area) {
                        result.add(triangle);
                    }
                }
            }
        }

        return result;
    }

    public static boolean isTriangle(int a, int b, int c) {
        return (a + b > c) && (a + c > b) && (b + c > a);
    }
}