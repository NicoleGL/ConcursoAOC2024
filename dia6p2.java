import java.io.*;
import java.util.*;

public class dia6p2 {

    static int inicioX;
    static int inicioY;

    static boolean comprobarMapa(ArrayList<char[]> mapa, int obstaculoX, int obstaculoY) {
        int guardiaX = inicioX;
        int guardiaY = inicioY;
        int direccionX = 0;
        int direccionY = -1;
        int iteraciones = 0;
        //HashMap<String, String> recuerdos = new HashMap<>();
        while(true) {
            //si vuelve al inicio o se sale del mapa: break
            if((guardiaY + direccionY >= mapa.size()) || (guardiaY + direccionY < 0) 
                || (guardiaX + direccionX >= mapa.get(0).length) || (guardiaX + direccionX < 0)) {
                //System.out.println("false");
                break;
            }
            char sig = mapa.get(guardiaY+direccionY)[guardiaX+direccionX];
            if(sig == '#' || ((guardiaY+direccionY == obstaculoY) && (guardiaX+direccionX == obstaculoX))) { //cambiamos direccion
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
/*                 String rec = recuerdos.get("" + guardiaX + guardiaY);
                if(rec != null) {
                    if(rec.contains(""+direccionX+direccionY)) {
                        //System.out.println("tortilla");
                        return true;
                    } else {
                        recuerdos.put("" + guardiaX + guardiaY, rec+direccionX+direccionY);
                    }
                } else {
                    recuerdos.put("" + guardiaX + guardiaY, ""+direccionX+direccionY);
                } */
            } else {
                guardiaX += direccionX;
                guardiaY += direccionY;
            }
            iteraciones++;
            if(iteraciones >= 25000) {
                return true;
            }
        }
        return false;
    }   

    public static void main(String[] args) {
        try (Scanner in = new Scanner(new BufferedInputStream(System.in))) {
            ArrayList<char[]> mapa = new ArrayList<>();
            long contador = 0;
            int i = 0;
            int guardiaX = 0;
            int guardiaY = 0;
            int direccionX = 0;
            int direccionY = -1;
            HashSet<String> visitadas = new HashSet<>();
            while(in.hasNextLine()) {
                String line = in.nextLine();
                if(line.contains("^")) {
                    guardiaY = i;
                    inicioY = i;
                    guardiaX = line.indexOf("^");
                    inicioX = guardiaX;
                }
                mapa.add(line.toCharArray());
                i++;
            }
            while(true) {
                //si vuelve al inicio o se sale del mapa: break
                if((guardiaY + direccionY >= mapa.size()) || (guardiaY + direccionY < 0) 
                    || (guardiaX + direccionX >= mapa.get(0).length) || (guardiaX + direccionX < 0)) {
                    break;
                }
                char sig = mapa.get(guardiaY+direccionY)[guardiaX+direccionX];
                if(sig != '#') {
                    if(sig != '^') {
                        if(!visitadas.contains((guardiaX+direccionX) + "/" + (guardiaY+direccionY))) {
                            if(comprobarMapa(mapa, guardiaX+direccionX, guardiaY+direccionY)) {
                                contador++;
                            }
                            visitadas.add((guardiaX+direccionX) + "/" + (guardiaY+direccionY));
                        }
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

            System.out.println(contador);
        } catch (Exception e) { // Captura siempre las excepciones
            e.printStackTrace();
            System.exit(1);
        }
    }
}
