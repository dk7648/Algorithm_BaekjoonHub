import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> cards = new PriorityQueue<>();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            cards.add(Integer.parseInt(br.readLine()));
        }

        int count = 0;
        for (int i = 1; i < n; i++) {
            int newCard = cards.poll() + cards.poll();
            cards.add(newCard);
            count += newCard;
        }

        System.out.println(count);
    }
}