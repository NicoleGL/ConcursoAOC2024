import java.io.*;
import java.util.*;

public class dia2p1 {
          public static void main(String[] args) {
        try (Scanner in = new Scanner(new BufferedInputStream(System.in))) {
            int contador = 0;
            while(in.hasNextLine()) {
                String[] strs = in.nextLine().split(" ");
                int[] arr = new int[strs.length];
                boolean seCumple = true;
                boolean descendente = false;
                for(int i = 0; i < strs.length && seCumple; i++) {
                    arr[i] = Integer.parseInt(strs[i]);
                    if(i == 1) {
                        descendente = (arr[i] - arr[i-1]) < 0;
                    }
                    if(i > 0) {
                        seCumple = Math.abs(arr[i] - arr[i-1]) <= 3;
                        if(seCumple) {
                            seCumple = (descendente)? (arr[i] - arr[i-1]) < 0 : (arr[i] - arr[i-1]) > 0;
                        }
                    }
                }
                if(seCumple)
                    contador++;
            }
            System.out.println(contador);
        } catch (Exception e) { // Captura siempre las excepciones
            e.printStackTrace();
            System.exit(1);
        }
    }
}
