
public class QuickSort{
    public static void quickSort(Comparable[] numberList, int left, int right) {
        //1. Elegir el pivote
        Comparable pivote = numberList[left];
        //2. Los elementos > al pivote van a su right, los < al pivote su left

        //- i para controlar los elementos a la left del pivote
        //- j para controlar los elementos a la right del pivote
        int i = left;
        int j = right;
        Comparable auxIntercambio;

        while (i < j) {
            //mientras que el elemento numberList[i] sea menor o igual al pivote
            //se aumenta el valor de i
            //cuando este loop se detenga, el elemento en numberList[i]
            //es mayor a pivote y deberá ir a su right
            while (numberList[i].compareTo(pivote) <= 0  && i < j) {
                i++;
            }
            //mientras que el elemento numberList[j] sea mayor al pivote
            //se desminuye el valor de j
            //cuando este loop se detenga, el elemento en numberList[j]
            //es menor o igual a pivote y deberá ir a su left
            while (numberList[j].compareTo(pivote) > 0) {
                j--;
            }
            //siempre y cuando i sea menor a j, se hace un cambio de los elementos
            //puesto que el elemento en numberList[i] debe ir a la right
            //y numberList[j] a la left
            if (i < j) {
                //nota: auxIntercambio podría estar declarada aquí ya que NO tiene otro alcance
                auxIntercambio = numberList[i];
                numberList[i] = numberList[j];
                numberList[j] = auxIntercambio;
            }
        }
        //Por los ciclos anteriores, j llegó a una posición donde su elemento (i.e. numberList[j])
        //es menor o igual al pivote, actualizamos entonces la posición del pivote, mandando numberList[j]
        //a la ubicación del pivote y viceversa (el pivote a la posicion numberList[j])
        numberList[left] = numberList[j];
        numberList[j] = pivote;
        //3. Para A1 y A2, aplicar el mismo proceso.
        if (left < j - 1) {
            //quicksort aplicado a A1
            quickSort(numberList, left, j - 1);
        }
        if (j + 1 < right) {
            //quicksort aplicado a A2
            quickSort(numberList, j + 1, right);
        }

        //código extraído de: https://es.stackoverflow.com/questions/7836/c%C3%B3mo-funciona-el-algoritmo-de-quicksort
    }
}
