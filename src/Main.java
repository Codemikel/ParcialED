import javax.swing.*;
import java.util.Scanner;
import java.util.SortedMap;

public class Main {

    static int F;
    static int[] Matriz;
    static boolean s=false;

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
            int opcion=0;
            while(!s ){
                try {
                    opcion = Integer.parseInt(JOptionPane.showInputDialog("1) Cargar empleados\n2) Listar empleados\n3) Sueldo Mayor\n4) Ordenar Insercion\n5) Mostrar Ascendente\n6)Sueldo menor\n7) Salir\nDigite el número de la operación a realizar"));
                    switch (opcion) {
                        case 1:
                            cargar();
                            
                            break;
                        case 2:
                            listar();
                            break;
                        case 3:
                            sueldoMayor();
                            break;
                        case 4:
                            ordenaInsercion();
                            break;
                        case 5:
                            mostrarAscendente();
                            break;
                        case 6:
                            sueldoMenor();
                            break;
                        case 7:
                            s=true;
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "ERROR");
                    }
                }catch (Exception e){
                    JOptionPane.showMessageDialog(null, "Algo no está bien");
                }
            }
        }

    public static void mostrarAscendente(){
        for(int i=0; i<=F; i++){
            JOptionPane.showMessageDialog(null, Matriz[i]+" ");
        }

        System.out.println(" ");
    }

    public static void sueldoMenor(){
        int menor=0;
        for (int i = 0; i <= F; i++) {
            if (menor>Matriz[i]){
                menor=Matriz[i];
            }
        }
        JOptionPane.showMessageDialog(null, "El menor sueldo es de: "+menor);
    }

    public static void sueldoMayor(){
        int mayor=0;
        for (int i = 0; i < F; i++) {
                if (mayor<Matriz[i]){
                       mayor=Matriz[i];
                }
        }
        JOptionPane.showMessageDialog(null, "El mayor sueldo es de: "+mayor);
    }

    public static void listar() {
        String m="";
        for (int i = 0; i < F; i++) {
            m += "Empleado "+(i+1) +" $"+Matriz[i] + "\n";
        }
        JOptionPane.showMessageDialog(null, m);
    }

    public static void ordenaInsercion(){
        for(int i=0; i<F; i++){
            int posicion = i;
            int auxiliar = Matriz[i];
            while ((posicion > 1 && (Matriz[posicion-1]>auxiliar))){
                Matriz [posicion] = Matriz[posicion-1];
                posicion--;
            }
            Matriz [posicion] = auxiliar;
        }
    }

    public static void cargar() {
        F = Integer.parseInt(JOptionPane.showInputDialog("Introduzca la cantidad de empleados"));
        Matriz = new int[F];
        for (int i = 0; i < F; i++) {
            Matriz[i] = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduzca el sueldo del empleado " + (i+1)));
        }
    }


}
