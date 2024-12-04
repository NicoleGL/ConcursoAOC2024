import java.io.*;
import java.util.*;
import java.util.regex.*;

public class dia3p2 {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(new BufferedInputStream(System.in))) {
            long contador = 0;
            Pattern pattern = Pattern.compile("mul\\([0-9][0-9]?[0-9]?,[0-9][0-9]?[0-9]?\\)|do\\(\\)|don't\\(\\)");
            boolean doo = true;
            while(in.hasNextLine()) {
                String str = in.nextLine();
                Matcher matcher = pattern.matcher(str);
                while(matcher.find()) {
                    int index = matcher.start();
                    if(str.charAt(index+2) == '(') { //do()
                        doo = true;
                    } else if(str.charAt(index+2) == 'n') { //don't()
                        doo = false;
                    } else if(doo) {
                        //System.out.println(str.substring(str.indexOf('(', index) + 1, str.indexOf(')', index)));
                        String[] nums = str.substring(str.indexOf('(', index) + 1, str.indexOf(')', index)).split("[^0-9]");
                        contador += Integer.parseInt(nums[0]) * Integer.parseInt(nums[1]);
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