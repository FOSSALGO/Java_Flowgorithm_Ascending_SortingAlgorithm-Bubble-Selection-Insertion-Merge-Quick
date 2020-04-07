package sorting;

import java.util.Vector;

public class Sorting {

    static Vector<Integer> inisialisasiVector() {
        Vector<Integer> vector = new Vector<>();
        vector.add(40);
        vector.add(2);
        vector.add(1);
        vector.add(43);
        vector.add(3);
        vector.add(65);
        vector.add(0);
        vector.add(-1);
        vector.add(68);
        vector.add(3);
        vector.add(42);
        vector.add(4);
        return vector;
    }

    static void cetak(Vector<Integer> vector) {
        System.out.print("[");
        for (int v : vector) {
            System.out.print(" " + v);
        }
        System.out.println(" ]");
    }

    static Vector<Integer> kloning(Vector<Integer> vector) {
        Vector<Integer> vectorBaru = null;
        if (vector != null) {
            vectorBaru = new Vector<>();
            for (int v : vector) {
                vectorBaru.add(v);
            }
        }
        return vectorBaru;
    }

    static void tukarNilai(Vector<Integer> vector, int indexA, int indexB) {
        if (indexA >= 0 && indexA < vector.size() && indexB >= 0 && indexB < vector.size() && indexA != indexB) {
            int A, B, C;
            A = vector.get(indexA);
            B = vector.get(indexB);
            C = A;
            A = B;
            B = C;
            vector.set(indexA, A);
            vector.set(indexB, B);
        }
    }

    static void bubbleSort(Vector<Integer> vector) {
        int n = vector.size();
        boolean adaPertukaran = true;
        do {
            adaPertukaran = false;
            for (int i = 1; i < n; i++) {
                if (vector.get(i - 1) > vector.get(i)) {
                    tukarNilai(vector, (i - 1), i);
                    adaPertukaran = true;
                }
            }
            n--;
        } while (adaPertukaran);
    }

    static void selectionSort(Vector<Integer> vector) {
        int n = vector.size();
        for (int i = 0; i < n - 1; i++) {
            int jMIN = i;
            for (int j = i + 1; j < n; j++) {
                if (vector.get(j) < vector.get(jMIN)) {
                    jMIN = j;
                }
            }
            if (jMIN != i) {
                tukarNilai(vector, i, jMIN);
            }
        }
    }

    static void insertionSort(Vector<Integer> vector) {
        int n = vector.size();
        int i = 1;
        int j;
        while (i < n) {
            int temp = vector.get(i);
            for (j = i; j > 0; j--) {
                if (temp < vector.get(j - 1)) {
                    vector.set(j, vector.get(j - 1));
                } else {
                    break;
                }
            }
            vector.set(j, temp);
            i++;
        }
    }

    static void merge(Vector<Integer> vector, Vector<Integer> vectorKiri, Vector<Integer> vectorKanan) {
        int i = 0, j = 0, k = 0;
        int sKiri = vectorKiri.size();
        int sKanan = vectorKanan.size();

        while (i < sKiri && j < sKanan) {
            if (vectorKiri.get(i) < vectorKanan.get(j)) {
                vector.set(k, vectorKiri.get(i));
                i++;
                k++;
            } else {
                vector.set(k, vectorKanan.get(j));
                j++;
                k++;
            }
        }

        while (i < sKiri) {
            vector.set(k, vectorKiri.get(i));
            i++;
            k++;
        }

        while (j < sKanan) {
            vector.set(k, vectorKanan.get(j));
            j++;
            k++;
        }
    }

    static void mergeSort(Vector<Integer> vector) {
        int n = vector.size();

        if (n < 2) {
            return;
        }

        int tengah = n / 2;

        Vector<Integer> vectorKiri = new Vector<>();
        Vector<Integer> vectorKanan = new Vector<>();

        for (int i = 0; i < tengah; i++) {
            vectorKiri.add(vector.get(i));
        }

        for (int i = tengah; i < n; i++) {
            vectorKanan.add(vector.get(i));
        }

        mergeSort(vectorKiri);
        mergeSort(vectorKanan);

        merge(vector, vectorKiri, vectorKanan);

    }
    
    static int partisi(Vector<Integer> vector, int low, int high){
        int pivot = vector.get(high);
        int i = low -1;
        for(int j=low;j<high;j++){
            if(vector.get(j)<pivot){
                i++;
                tukarNilai(vector, i, j);
            }
        }
        tukarNilai(vector, i+1, high);
        int index = i+1;
        return index;
    }
    
    static void quickSort(Vector<Integer> vector, int low, int high){
        if(low<high){
            int indexPartisi = partisi(vector, low, high);
            quickSort(vector, low, indexPartisi-1);
            quickSort(vector, indexPartisi+1, high);
        }
    }

    static public void main(String[] fosalgo) {
        Vector<Integer> data = inisialisasiVector();
        System.out.print("Original Data  : ");
        cetak(data);

        Vector<Integer> data1 = kloning(data);
        System.out.print("Original Data: ");
        cetak(data1);
        System.out.print("Bubble Sort  : ");
        bubbleSort(data1);
        cetak(data1);

        Vector<Integer> data2 = kloning(data);
        System.out.print("Original Data : ");
        cetak(data2);
        System.out.print("Selection Sort: ");
        selectionSort(data2);
        cetak(data2);

        Vector<Integer> data3 = kloning(data);
        System.out.print("Original Data : ");
        cetak(data3);
        System.out.print("Insertion Sort: ");
        insertionSort(data3);
        cetak(data3);

        Vector<Integer> data4 = kloning(data);
        System.out.print("Original Data : ");
        cetak(data4);
        System.out.print("Merge Sort    : ");
        mergeSort(data4);
        cetak(data4);

        Vector<Integer> data5 = kloning(data);
        System.out.print("Original Data : ");
        cetak(data5);
        System.out.print("Quick Sort    : ");
        quickSort(data5, 0, data5.size()-1);
        cetak(data5);

    }
}
