
package eva3_1_ordenamiento;

public class EVA3_1_ORDENAMIENTO {
    
    public static void main(String[] args) {
        
        int[] aiDatos = new int[6];
        int[] aiCopiaSele = new int[aiDatos.length];
        int[] aiCopiaInse = new int[aiDatos.length];
        int[] aiCopiaBubble = new int[aiDatos.length];
        long iniT, finT;
        
        /*aiDatos[0] = 23;
        aiDatos[01] = 78;
        aiDatos[02] = 45;
        aiDatos[03] = 8;
        aiDatos[04] = 32;
        aiDatos[05] = 56;*/
        llenar(aiDatos);
        
        System.out.println("Arreglo a ordenar");
        imprimir(aiDatos);
        duplicar(aiDatos, aiCopiaSele);
        duplicar(aiDatos, aiCopiaInse);
        duplicar(aiDatos, aiCopiaBubble);
        
        System.out.println("\nProbando selectionSort");
        iniT = System.nanoTime();
        selectionSort(aiCopiaSele);
        finT = System.nanoTime();
        imprimir(aiCopiaSele);
        System.out.println("Tiempo en ordenar: " + (finT - iniT));
        
        System.out.println("\nProbando insertionSort");
        iniT = System.nanoTime();
        insertionSort(aiCopiaInse);
        finT = System.nanoTime();
        imprimir(aiCopiaInse);
        System.out.println("Tiempo en ordenar: " + (finT - iniT));
        
        System.out.println("\nProbando bubbleSort");
        iniT = System.nanoTime();
        bubbleSort(aiCopiaBubble);
        finT = System.nanoTime();
        imprimir(aiCopiaBubble);
        System.out.println("Tiempo en ordenar: " + (finT - iniT));
        
    }

    private static void llenar(int[] datos) {
        for (int i = 0; i < datos.length; i++) {
            datos[i] = (int)(Math.random()*100);
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
}
