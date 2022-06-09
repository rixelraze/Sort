package com.company;

import java.util.Arrays;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        Integer[] arr = {2, 5, 2, 8, 5, 6, 8, 8};
        int n = arr.length;
        //Вызов функции для получения значения count
        int count = Sort.sortByFreq(arr, n);
        //Сортировка основного массива в порядке убывания
        Arrays.sort(arr, Collections.reverseOrder());
        //Печать элементов в порядке убывания
        Sort.printSortedArray(arr, count);
    }

}   

class Sort {
    // Функция, возвращающает индекс  до тех пор, пока все элементы массива не будут загружены
    static int sortByFreq(Integer[] arr, int n) {


        int maxElement = -1;
        //Находим максимальный элемент
        for (int i = 0; i < n; i++) {
            maxElement = Math.max(maxElement, arr[i]);
        }
        //Создаем частотный массив
        int[] freq = new int[maxElement + 1];

        // загружаем в массив соотвественные элементы из основного массива
        for (int i = 0; i < n; i++) {
            freq[arr[i]]++;
        }

        int count = 0;
        //Если частота элемента больше нуля, обновляем массив arr и увеличиваем count
        for (int i = 0; i <= maxElement; i++) {
            if (freq[i] > 0) {
                int value = 100000 - i;
                arr[count] = 100000 * freq[i] + value;
                count++;
            }
        }
        return count;
    }

    //Функция выводит отсортированный массив
    static void printSortedArray(Integer[] arr, int count) {

        for (int i = 0; i < count; i++) {

            int frequency = arr[i] / 100000; //0,00004

            int value = 100000 - (arr[i] % 100000);
            //Обход до частоты,нужна для вывода значения по индексу i

            for (int j = 0; j < frequency; j++) {
                System.out.print(value + " ");
            }
        }
    }
}//4 4 4 2 2 5 5 6 8

