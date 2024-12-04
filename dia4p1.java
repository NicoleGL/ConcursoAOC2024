import java.io.*;
import java.util.*;

public class dia4p1 {
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
                    if(str.charAt(j) == 'X') {
                        //Horizontal del derecho: XMAS
                        if(j+3 < str.length()) {
                            if(str.substring(j, j+4).equals("XMAS")) {
                                contador++;
                            }
                        }
                        //Horizontal del reves: SAMX
                        if(j >= 3) {
                            if(str.substring(j-3, j+1).equals("SAMX")) {
                                contador++;
                            }
                        }
                        //Vertical derecho
                        if(i+3 < arr.size()) {
                            if(arr.get(i+1).charAt(j) == 'M' && arr.get(i+2).charAt(j) == 'A' && arr.get(i+3).charAt(j) == 'S') {
                                contador++;
                            }
                        }
                        //Vertical del revés
                        if(i >= 3) {
                            if(arr.get(i-1).charAt(j) == 'M' && arr.get(i-2).charAt(j) == 'A' && arr.get(i-3).charAt(j) == 'S') {
                                contador++;
                            }
                        }
                        //Diagonal abajo derecha
                        if(j+3 < str.length() && i+3 < arr.size()) {
                            if(arr.get(i+1).charAt(j+1) == 'M' && arr.get(i+2).charAt(j+2) == 'A' && arr.get(i+3).charAt(j+3) == 'S') {
                                contador++;
                            }
                        }
                        //Diagonal abajo izquierda
                        if(j >= 3 && i+3 < arr.size()) {
                            if(arr.get(i+1).charAt(j-1) == 'M' && arr.get(i+2).charAt(j-2) == 'A' && arr.get(i+3).charAt(j-3) == 'S') {
                                contador++;
                            }
                        }
                        //Diagonal arriba derecha
                        if(j+3 < str.length() && i >= 3) {
                            if(arr.get(i-1).charAt(j+1) == 'M' && arr.get(i-2).charAt(j+2) == 'A' && arr.get(i-3).charAt(j+3) == 'S') {
                                contador++;
                            }
                        }
                        //Diagonal arriba izquierda
                        if(j >= 3 && i >= 3) {
                            if(arr.get(i-1).charAt(j-1) == 'M' && arr.get(i-2).charAt(j-2) == 'A' && arr.get(i-3).charAt(j-3) == 'S') {
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
