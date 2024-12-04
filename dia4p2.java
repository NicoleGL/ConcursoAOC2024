import java.io.*;
import java.util.*;

public class dia4p2 {
public static void main(String[] args) {
        try (Scanner in = new Scanner(new BufferedInputStream(System.in))) {
            ArrayList<String> arr = new ArrayList<>();
            long contador = 0;
            while(in.hasNextLine()) {
                arr.add(in.nextLine());
            }

            for(int i = 0; i < arr.size(); i++) {
                String str = arr.get(i);
                for(int j = 0; j < str.length(); j++) {
                    if(str.charAt(j) == 'A') {
                        if(j > 0 && j+1 < str.length() && i > 0 && i+1 < arr.size()) {
                            //Ms a la izquierda
                            if(arr.get(i-1).charAt(j-1) == 'M' && arr.get(i+1).charAt(j-1) == 'M' && arr.get(i-1).charAt(j+1) == 'S' && arr.get(i+1).charAt(j+1) == 'S') {
                                contador++;
                            }
                            //Ms arriba
                            else if(arr.get(i-1).charAt(j-1) == 'M' && arr.get(i+1).charAt(j-1) == 'S' && arr.get(i-1).charAt(j+1) == 'M' && arr.get(i+1).charAt(j+1) == 'S') {
                                contador++;
                            }
                            //Ms abajo
                            else if(arr.get(i-1).charAt(j-1) == 'S' && arr.get(i+1).charAt(j-1) == 'M' && arr.get(i-1).charAt(j+1) == 'S' && arr.get(i+1).charAt(j+1) == 'M') {
                                contador++;
                            }
                            //Ms a la derecha
                            else if(arr.get(i-1).charAt(j-1) == 'S' && arr.get(i+1).charAt(j-1) == 'S' && arr.get(i-1).charAt(j+1) == 'M' && arr.get(i+1).charAt(j+1) == 'M') {
                                contador++;
                            }
                        }
                    }
                }
            }

            System.out.println(contador);
        } catch (Exception e) { // Captura siempre las excepciones
            e.printStackTrace();
            System.exit(1);
        }
    }
}
