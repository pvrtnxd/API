import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = List.of(0, 1, 2, 4, 5, 6, 9, 3, 10, 7, 8);
        findMinMax(list.stream(), Integer::compareTo, (x, y) -> System.out.println("Минимальное число: " + x + "\nМаксимальное число: " + y));
        printNumber(list);
    }

    private static <T> void findMinMax(Stream<? extends T> stream, Comparator<? super T> order, BiConsumer<? super T, ? super T> minMaxConsumer) {
        List<? extends T> list = stream.sorted(order).collect(Collectors.toList());
        if (list.isEmpty()) {
            minMaxConsumer.accept(null, null);
        } else {
            minMaxConsumer.accept(list.get(0), list.get(list.size() - 1));
        }

    }

    private static void printNumber(List<Integer> list){
        System.out.println("Количество чётных чисел: " + list.stream()
                .filter(x -> x % 2 == 0)
                .peek(System.out::println)
                .count());
    }
}
