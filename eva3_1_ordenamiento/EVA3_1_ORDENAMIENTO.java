/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eva3_1_ordenamiento;

/**
 *
 * @author zotzo
 */
public class EVA3_1_ORDENAMIENTO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] aiDatos = new int[10];
        
        llenar(aiDatos);
        
        imprimir(aiDatos);
    }

    private static void llenar(int[] datos) {
        for (int i = 0; i < datos.length; i++) {
            datos[i] = (int)(Math.random()*100);
        }
    }

    private static void imprimir(int[] datos) {
        for (int i = 0; i < datos.length; i++) {
            System.out.print("[" + datos[i] + "]");
        }
        System.out.println();
    }
    
    public static void selectionSort(int [] datos){
        int min = 0, posMin = 0;
        for (int i = 1; i < datos.length; i++) {
            for (int j = 0; j < ( datos.length - 1 ); j++) {
                if(datos[i] < datos[j]){
                    
                }
            }
        }
    }
}
