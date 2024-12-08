import java.io.BufferedInputStream;
import java.util.*;

public class dia5p1 {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(new BufferedInputStream(System.in))) {
            HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
            long contador = 0;
            while(in.hasNextLine()) {
                String str = in.nextLine();
                if(!str.contains("|")) {
                    break;
                }
                String[] arr = str.split("\\|");
                int a = Integer.parseInt(arr[0]);
                int b = Integer.parseInt(arr[1]);
                if(map.containsKey(b)) {
                    HashSet<Integer> sett = map.get(b);
                    sett.add(a);
                } else {
                    HashSet<Integer> sett = new HashSet<>();
                    sett.add(a);
                    map.put(b, sett);
                }
            }
            while(in.hasNextLine()) {
                boolean posible = true;
                String str = in.nextLine();
                String[] arr = str.split(",");
                int[] nums = new int[arr.length];
                for(int i = 0; i < arr.length && posible; i++) {
                    nums[i] = Integer.parseInt(arr[i]);
                    for(int j = 0; j < i; j++) {
                        if(map.containsKey(nums[j])) {
                            HashSet<Integer> sett = map.get(nums[j]);
                            if(sett.contains(nums[i])) {
                                posible = false;
                                break;
                            }
                        }
                    }
                }
                if(posible) {
                    contador += nums[nums.length / 2];
                }
            }
            
            System.out.println(contador);
        } catch (Exception e) { // Captura siempre las excepciones
            e.printStackTrace();
            System.exit(1);
        }
    }
}
