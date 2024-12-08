import java.io.*;
import java.util.*;

public class dia7p2 {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(new BufferedInputStream(System.in))) {
            long contador = 0;
            while(in.hasNextLine()) {
                String[] strs = in.nextLine().split(":* +");
                long aim = Long.parseLong(strs[0]);
                int[] nums = new int[strs.length - 1];
                for(int i = 1; i < strs.length; i++) {
                    nums[i - 1] = Integer.parseInt(strs[i]);
                    //System.out.println(nums[i-1]);
                }
                if(nums.length == 1) {
                    if(nums[0] == aim) {
                        contador += aim;
                    }
                    System.out.println("pasó");
                }
                else if(searchPermutations(aim, nums[0], 1, nums)) {
                    //System.out.println(aim);
                    contador += aim;
                }
            }
            System.out.println(contador);
        } catch (Exception e) { // Captura siempre las excepciones
            e.printStackTrace();
            System.exit(1);
        }
    }

    static boolean searchPermutations(long aim, long count, int i, int[] nums) {
        if(i + 1 >= nums.length) {
            return ((count + nums[i] == aim) || (count * nums[i] == aim) || (Long.parseLong("" + count + nums[i]) == aim));
        }
        boolean posible = false;
        if(count * nums[i] <= aim) {
            posible = searchPermutations(aim, count * nums[i], i + 1, nums);
            if(posible) return true;
        }
        if((count + nums[i] <= aim)) {
            posible = searchPermutations(aim, count + nums[i], i + 1, nums);
            if(posible) return true;
        }
        long concatenacion = Long.parseLong("" + count + nums[i]);
        if(concatenacion <= aim) {
            posible = searchPermutations(aim, concatenacion, i + 1, nums);
            if(posible) return true;
        }

        return false;
    }
}