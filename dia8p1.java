import java.io.*;
import java.util.*;

public class dia8p1 {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(new BufferedInputStream(System.in))) {
            HashSet<List<Integer>> antinodos = new HashSet<>();
            HashMap<Character, ArrayList<int[]>> posiciones = new HashMap<>();
            int nLinea = 0;
            int tamLinea = 0;
            while(in.hasNextLine()) {
                String line = in.nextLine();
                tamLinea = line.length();
                for(int i = 0; i < tamLinea; i++) {
                    if(line.charAt(i) != '.' && line.charAt(i) != '\n') {
                        ArrayList<int[]> arr;
                        if(posiciones.containsKey(line.charAt(i))) {
                            arr = posiciones.get(line.charAt(i));
                        } else {
                            arr = new ArrayList<>();
                            posiciones.put(line.charAt(i), arr);
                        }
                        arr.add(new int[]{nLinea, i});
                    }
                }
                nLinea++;
            }
            for(ArrayList<int[]> frecuencia : posiciones.values()) {
                int coordX;
                int coordY;
                for(int i = 0; i < frecuencia.size() - 1; i++) {
                    int[] posA = frecuencia.get(i);
                    for(int j = i + 1; j < frecuencia.size(); j++) {
                        int[] posB = frecuencia.get(j);
                        // A - B
                        coordX = (posA[0] - posB[0]) + posA[0];
                        coordY = (posA[1] - posB[1]) + posA[1];
                        if((coordX >= 0) && (coordX < nLinea) && (coordY >= 0) && (coordY < tamLinea)) {
                            List<Integer> nums = new ArrayList<>();
                            nums.add(coordX);
                            nums.add(coordY);
                            antinodos.add(nums);
                        }
                        // B - A
                        coordX = (posB[0] - posA[0]) + posB[0];
                        coordY = (posB[1] - posA[1]) + posB[1];
                        if((coordX >= 0) && (coordX < nLinea) && (coordY >= 0) && (coordY < tamLinea)) {
                            List<Integer> nums = new ArrayList<>();
                            nums.add(coordX);
                            nums.add(coordY);
                            antinodos.add(nums);
                        }
                    }
                }
            }

            /* for(int[] arr : antinodos) {
                System.out.println("(" + arr[0] + "," + arr[1] + ")");
            } */
            System.out.println(antinodos.size());
        } catch (Exception e) { // Captura siempre las excepciones
            e.printStackTrace();
            System.exit(1);
        }
    }
}