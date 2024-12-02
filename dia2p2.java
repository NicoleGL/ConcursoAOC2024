import java.io.*;
import java.util.*;

public class dia2p2 {
          public static void main(String[] args) {
        try (Scanner in = new Scanner(new BufferedInputStream(System.in))) {
            int contador = 0;
            while(in.hasNextLine()) {
                String[] strs = in.nextLine().split(" ");
                ArrayList<Integer> arr = new ArrayList<>();
                boolean seCumple = true;
                boolean descendente = false;
                for(int i = 0; i < strs.length && seCumple; i++)
                    arr.add(Integer.parseInt(strs[i]));
                for(int i = 0; i+1 < arr.size() && seCumple; i++) {
                    if(i == 0) {
                        descendente = (arr.get(i+1) - arr.get(i)) < 0;
                    }
                    seCumple = (Math.abs(arr.get(i+1) - arr.get(i)) <= 3) && ((descendente)? (arr.get(i+1) - arr.get(i)) < 0 : (arr.get(i+1) - arr.get(i)) > 0);
                    if(!seCumple) {
                        if(i == 1) {
                            int a = arr.remove(0);
                            seCumple = esSeguro(arr);
                            if(!seCumple) {
                                arr.set(0, a);
                            }
                            seCumple = esSeguro(arr);
                            break;
                        } else {
                            int a = arr.remove(i);
                            seCumple = esSeguro(arr);
                            if(!seCumple) {
                                arr.set(i, a);
                            }
                            seCumple = esSeguro(arr);
                            break;
                        }
                    }
                }
                /* if(seCumple) {
                    contador++;
                    System.out.println("Seguro");
                } else {
                    System.out.println("No seguro");
                } */
                if(seCumple)
                    contador++;
            }
            System.out.println(contador);
        } catch (Exception e) { // Captura siempre las excepciones
            e.printStackTrace();
            System.exit(1);
        }

        
    }

    static boolean esSeguro(ArrayList<Integer> arr) {
        boolean seCumple = true;
        boolean descendente = false;
        for(int i = 0; i < arr.size() && seCumple; i++) {
            if(i == 1) {
                descendente = (arr.get(i) - arr.get(i-1)) < 0;
            }
            if(i > 0) {
                seCumple = (Math.abs(arr.get(i) - arr.get(i-1)) <= 3) && ((descendente)? (arr.get(i) - arr.get(i-1)) < 0 : (arr.get(i) - arr.get(i-1)) > 0);
            }
        }
        return seCumple;
    }
}
