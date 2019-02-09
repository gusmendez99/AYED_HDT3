
public class QuickSort{
    public static void quickSort(Comparable[] vector, int izquierda, int derecha) {
        //1. Elegir el pivote
        Comparable pivote = vector[izquierda];
        //2. Los elementos > al pivote van a su derecha, los < a su izquierda
        //esta parte de la implementación es el corazón del ordenamiento
        //se utilizan variables auxiliares:
        //- i para controlar los elementos a la izquierda del pivote
        //- j para controlar los elementos a la derecha del pivote
        int i = izquierda;
        int j = derecha;
        //esta variable debería tener un alcance menor pero se respeta la implementación
        Comparable auxIntercambio;
        //mientras que deban evaluarse los elementos en el arreglo
        //para ubicar al nuevo pivote
        while (i < j) {
            //mientras que el elemento vector[i] sea menor o igual al pivote
            //se aumenta el valor de i
            //cuando este loop se detenga, el elemento en vector[i]
            //es mayor a pivote y deberá ir a su derecha
            while (vector[i].compareTo(pivote) <= 0  && i < j) {
                i++;
            }
            //mientras que el elemento vector[j] sea mayor al pivote
            //se desminuye el valor de j
            //cuando este loop se detenga, el elemento en vector[j]
            //es menor o igual a pivote y deberá ir a su izquierda
            while (vector[j].compareTo(pivote) > 0) {
                j--;
            }
            //siempre y cuando i sea menor a j, se hace un cambio de los elementos
            //puesto que el elemento en vector[i] debe ir a la derecha
            //y vector[j] a la izquierda
            if (i < j) {
                //nota: auxIntercambio podría estar declarada aquí ya que NO tiene otro alcance
                auxIntercambio = vector[i];
                vector[i] = vector[j];
                vector[j] = auxIntercambio;
            }
        }
        //Por los ciclos anteriores, j llegó a una posición donde su elemento (i.e. vector[j])
        //es menor o igual al pivote, actualizamos entonces la posición del pivote, mandando vector[j]
        //a la ubicación del pivote y viceversa (el pivote a la posicion vector[j])
        vector[izquierda] = vector[j];
        vector[j] = pivote;
        //3. Para A1 y A2, aplicar el mismo proceso.
        if (izquierda < j - 1) {
            //quicksort aplicado a A1
            quickSort(vector, izquierda, j - 1);
        }
        if (j + 1 < derecha) {
            //quicksort aplicado a A2
            quickSort(vector, j + 1, derecha);
        }
    }
}
