import java.io.*;
import java.util.*;

public class dia1p2 {
          public static void main(String[] args) {
        try (Scanner in = new Scanner(new BufferedInputStream(System.in))) {
            ArrayList<Integer> arr = new ArrayList<>();
            Map<Integer, Integer> map = new HashMap<>();
            long contador = 0;
            while(in.hasNextInt()) {
                arr.add(in.nextInt());
                int b = in.nextInt();
                if(map.containsKey(b)) {
                    map.put(b, map.get(b) + 1);
                } else {
                    map.put(b, 1);
                }
            }
            for(int i = 0; i < arr.size(); i++) {
                Integer ap = map.get(arr.get(i));
                if(ap != null) {
                    contador += ap*arr.get(i);
                }
            }
            System.out.println(contador);
        } catch (Exception e) { // Captura siempre las excepciones
            e.printStackTrace();
            System.exit(1);
        }
    }
}
