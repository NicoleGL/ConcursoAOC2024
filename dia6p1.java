import java.io.*;
import java.util.*;

public class dia6p1 {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(new BufferedInputStream(System.in))) {
            ArrayList<char[]> mapa = new ArrayList<>();
            long contador = 0;
            int i = 0;
            int guardiaX = 0;
            int guardiaY = 0;
            int direccionX = 0;
            int direccionY = -1;
            while(in.hasNextLine()) {
                String line = in.nextLine();
                if(line.contains("^")) {
                    guardiaY = i;
                    guardiaX = line.indexOf("^");
                }
                mapa.add(line.toCharArray());
                i++;
            }

            contador++;
            mapa.get(guardiaY)[guardiaX] = 'X';

            while(true) {
                //si vuelve al inicio o se sale del mapa: break
                if((guardiaY + direccionY >= mapa.size()) || (guardiaY + direccionY < 0) 
                    || (guardiaX + direccionX >= mapa.get(0).length) || (guardiaX + direccionX < 0)) {
                    break;
                }
                char sig = mapa.get(guardiaY+direccionY)[guardiaX+direccionX];
                if(sig != '#') {
                    if(sig == '.') {
                        mapa.get(guardiaY+direccionY)[guardiaX+direccionX] = 'X';
                        contador++;
                    }
                    guardiaX += direccionX;
                    guardiaY += direccionY;
                } else { //cambiamos direccion
                    if(direccionX == 0 && direccionY == -1) { //arriba->derecha
                        direccionX = 1;
                        direccionY = 0;
                    } 
                    else if(direccionX == 1 && direccionY == 0) { //derecha->abajo
                        direccionX = 0;
                        direccionY = 1;
                    }
                    else if(direccionX == 0 && direccionY == 1) { //abajo->izquierda
                        direccionX = -1;
                        direccionY = 0;
                    }
                    else { //izquierda->arriba
                        direccionX = 0;
                        direccionY = -1;
                    }
                }

            }

            for(int j = 0; j < mapa.size(); j++){
                System.out.println(new String(mapa.get(j)));
            }

            System.out.println(contador);
        } catch (Exception e) { // Captura siempre las excepciones
            e.printStackTrace();
            System.exit(1);
        }
    }
}