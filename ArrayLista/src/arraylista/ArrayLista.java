package arraylista;

import java.util.Arrays;

/**
 *
 * @author nemanja
 * 
 */
public class ArrayLista {

    public static void main(String[] args) {
//        Lista
        int[] array = {12, 23, -22, 0, 43, 545, -4, -55, 43, 12, 0, -999, -87};
//        Sortiranje array liste
        Arrays.sort(array);
        System.out.println("Slozena lista: "+Arrays.toString(array));
//        Pravljenje dve array liste i smestanje brojeva koji su veci i manji od nule(nula je uracunata)
        int[] arrayP = new int[array.length];
        int[] arrayN = new int[array.length];
//        Za smestanje brojeva vecih od nule prolazi se kroz petlju i postavlja uslov
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0) {
                arrayP[i] = array[i];
            }

        }
//        Za smestanje brojeva manjih od nule prolazi se kroz petlju i postavlja uslov
        for (int j = 0; j < array.length; j++) {
            if (array[j] < 0) {
                arrayN[j] = array[j];
            }

        }
//        Inicijalizacija novih array listi i izbacivanje nula iz prethodnih listi pomocu lambde
        int[] poz = Arrays.stream(arrayP).filter(i -> i != 0).toArray();
        int[] neg = Arrays.stream(arrayN).filter(i -> i != 0).toArray();

        System.out.println("Pozitivni: "+Arrays.toString(poz));
        System.out.println("Negativni: "+Arrays.toString(neg));
//        Pronalazenje brojeva koji se ponavljaju u listi a pomocu dupCount pronalazimo koliko se ukupno brojeva ponavlja
        System.out.print("Brojevi koji se ponavljaju: ");
        int temp = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < (array.length - i); j++) {
                if (array[j - 1] > array[j]) {
                    temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }
            }
        }
        int numDup = 0;
        int dupCount = 0;
        int previous = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == previous) {
                numDup++;
                if (numDup == 1) {
                    dupCount++;
                    if (dupCount == 1) {
                        System.out.print(array[i]);
                    } else {
                        System.out.print(", " + array[i] + " ");
                    }
                }
            } else {
                previous = array[i];
                numDup = 0;
            }
        }
        System.out.println("\nUkupno brojeva koji se ponavljaju: "+dupCount);
    }

}
