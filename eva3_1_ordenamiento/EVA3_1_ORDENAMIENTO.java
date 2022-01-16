
package eva3_1_ordenamiento;

import static java.util.Arrays.sort;

public class EVA3_1_ORDENAMIENTO {
    
    public static void main(String[] args) {
        
        int[] aiDatos = new int[100000];
        int[] aiCopiaSele = new int[aiDatos.length];
        int[] aiCopiaInse = new int[aiDatos.length];
        int[] aiCopiaBubble = new int[aiDatos.length];
        int[] aiCopiaQuicki = new int[aiDatos.length];
        int[] aiCopiaSort = new int[aiDatos.length];
        
        long iniT, finT;
        
        /*aiDatos[0] = 23;
        aiDatos[01] = 78;
        aiDatos[02] = 45;
        aiDatos[03] = 8;
        aiDatos[04] = 32;
        aiDatos[05] = 56;*/
        llenar(aiDatos);
        
        System.out.println("Arreglo a ordenar");
        // imprimir(aiDatos);
        
        System.out.println("\nProbando selectionSort");
        duplicar(aiDatos, aiCopiaSele);
        iniT = System.nanoTime();
        selectionSort(aiCopiaSele);
        finT = System.nanoTime();
        // imprimir(aiCopiaSele);
        System.out.println("Tiempo en ordenar: " + (finT - iniT));
        
        System.out.println("\nProbando insertionSort");
        duplicar(aiDatos, aiCopiaInse);
        iniT = System.nanoTime();
        insertionSort(aiCopiaInse);
        finT = System.nanoTime();
        // imprimir(aiCopiaInse);
        System.out.println("Tiempo en ordenar: " + (finT - iniT));
        
        System.out.println("\nProbando bubbleSort");
        duplicar(aiDatos, aiCopiaBubble);
        iniT = System.nanoTime();
        bubbleSort(aiCopiaBubble);
        finT = System.nanoTime();
        // imprimir(aiCopiaBubble);
        System.out.println("Tiempo en ordenar: " + (finT - iniT));
        
        System.out.println("\nProbando quickSort");
        duplicar(aiDatos, aiCopiaQuicki);
        iniT = System.nanoTime();
        quickSort(aiCopiaQuicki);
        finT = System.nanoTime();
        // imprimir(aiCopiaQuicki);
        System.out.println("Tiempo en ordenar: " + (finT - iniT));
        
        System.out.println("\nProbando javSort");
        duplicar(aiDatos, aiCopiaSort);
        iniT = System.nanoTime();
        sort(aiCopiaSort);
        finT = System.nanoTime();
        // imprimir(aiCopiaSort);
        System.out.println("Tiempo en ordenar: " + (finT - iniT));
        
    }

    private static void llenar(int[] datos) {
        for (int i = 0; i < datos.length; i++) {
            datos[i] = (int)(Math.random()*datos.length);
        }
    }
    
    public static void duplicar (int [] datos, int [] copiar){
        for (int i = 0; i < datos.length; i++) {
            copiar[i] = datos[i];
        }
    }
    
    public static void imprimir(int[] datos) {
        for (int i = 0; i < datos.length; i++) {
            System.out.print("[" + datos[i] + "]");
        }
        System.out.println();
    }
    
    public static void selectionSort(int [] datos){
        for (int i = 0; i < datos.length; i++) {
            int iMin = i;
            for (int j = i; j < datos.length; j++) {
                if(datos[j] < datos[iMin]){
                    iMin = j;
                }
            }
            if (i != iMin) {
                int iTemp = datos[i];
                datos[i] = datos[iMin];
                datos[iMin] = iTemp;
            }
            
            
        }
    }
    
    public static void insertionSort(int [] datos){
        for (int i = 1; i < datos.length; i++) {
            int temp = datos[i];
            int insP = i; 
            
            for (int prev = i - 1; prev >= 0; prev--) {
                if(datos[prev] > temp){
                    datos[insP] = datos[prev];
                    insP--;
                }else{
                    break;
                }
            }
            datos[insP] = temp;
        }
    }
    
    public static void bubbleSort(int [] datos){
        for (int i = 0; i < datos.length; i++/*Ah mira, si es posible esto jaja*/) {
            for (int j = 0; j < datos.length - 1; j++) {
                if(datos[j] > datos[j + 1]){
                    int temp = datos[j];
                    datos[j] = datos[j + 1];
                    datos[j + 1] = temp;
                }
            }
        }
    }
    
    public static void quickSort (int [] datos){
        quickSortRecu(datos, 0, (datos.length - 1) );
    }

    private static void quickSortRecu(int[] datos, int ini, int fin) {
        int iPivote;
        int tooBig;
        int tooSmall;
        
        boolean stopBig = false;
        boolean stopSmall = false;
        
        int tama = fin - ini + 1;
        if (tama > 1) {
            iPivote = ini;
            tooBig = ini +1;
            tooSmall = fin;
            
            for (int i = ini + 1; i <= fin; i++) {
                if( (datos[tooBig] <= datos[iPivote]) && (!stopBig) ){
                    tooBig++;
                }else{
                    stopBig = true;
                }
                
                if ( (datos[tooSmall] >= datos[iPivote]) && (!stopSmall) ) {
                    tooSmall--;
                }else{
                    stopSmall = true;
                }
                
                if(stopBig && stopSmall){
                    if(tooBig < tooSmall){
                        int temp = datos[tooBig];
                        datos[tooBig] = datos[tooSmall];
                        datos[tooSmall] = temp;
                        stopBig = false;
                        stopSmall = false;
                    }else{
                        break;
                    }
                }
            }
            int temp = datos[iPivote];
            datos[iPivote] = datos[tooSmall];
            datos[tooSmall] = temp;
            iPivote = tooSmall;

            quickSortRecu(datos, ini, (iPivote - 1) );

            quickSortRecu(datos, (iPivote + 1), fin);
        }
    }
    
    
}
