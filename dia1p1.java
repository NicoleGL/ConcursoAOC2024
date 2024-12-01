import java.io.*;
import java.util.*;

public class dia1p1 {
        public static void main(String[] args) {
        try (Scanner in = new Scanner(new BufferedInputStream(System.in))) {
            PriorityQueue<Integer> colaA = new PriorityQueue<>();
            PriorityQueue<Integer> colaB = new PriorityQueue<>();
            long contador = 0;
            while(in.hasNextInt()) {
                colaA.add(in.nextInt());
                colaB.add(in.nextInt());
            }
            while(!colaA.isEmpty()) {
                contador += Math.abs(colaA.poll() - colaB.poll());
            }
            System.out.println(contador);
        } catch (Exception e) { // Captura siempre las excepciones
            e.printStackTrace();
            System.exit(1);
        }
    }
}