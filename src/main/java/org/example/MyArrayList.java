package org.example;

public class MyArrayList<T extends Comparable<T>> {

    private T[] list;
    private int size;
    private final int DEFAULT_CAPACITY = 10;

    /**
     * Конструктор, создает ArrayList с указанным размером
     * При переданном параметре размера меньше или равном 0 возвращает IllegalArgumentException
     * @param capacity - целочисленное значение определяющее размер создаваемого ArrayList
     */

    public MyArrayList(int capacity){
        if (capacity <= 0){
            throw new IllegalArgumentException("Capacity <= 0!");
        } else {
            list = (T[]) new Comparable[capacity];
        }
    }

    /**
     * Конструктор, создает ArrayList с размером равном 10
     */

    public MyArrayList(){
        list = (T[]) new Comparable[DEFAULT_CAPACITY];
    }

    /**
     * Метод добавляет новый элемент в конец ArrayList и увеличивает размер на 1
     * @param item - значение добавляемого элемента
     */

    public void addElement(T item){
        checkCapacity(size+1);
        list[size++] = item;
    }

    /**
     * Перегруженный метод addElement - добавляет новый элемент в указанную ячейку со сдвигом ячеек справа добавленного вправо
     * @param index - индекс ячейки в которую добавляется новый элемент
     * @param item - значение добавляемого элемента
     */

    public void addElement(int index, T item){
        checkCapacity(size+1);
        for (int i = size+1; i > index; i--){
            list[i] = list[i-1];
        }
        list[index] = item;
        size++;
    }

    private void checkCapacity(int capacity){
        int current = list.length;
        if (capacity > current){
            T[] newList = (T[]) new Comparable[current*2];
            System.arraycopy(list, 0, newList, 0, size);
            list = newList;
        }
    }

    /**
     * Метод "геттер" - возвращает значение ячейки по индексу
     * @param index - индекс ячейки значение которой необходимо получить
     * @return - значение ячейки с указанным индексом
     */

    public T getElement(int index){
        return list[index];
    }

    /**
     * Метод "сеттер" - заменяет значение в ячейке по индексу
     * @param index - индекс ячейки значение которой необходимо изменить
     * @param item - новое значение ячейки с указанным индексом
     */

    public void setElement(int index, T item){
        list[index] = item;
    }

    /**
     * Метод удаляющий элемент из ArrayList со сдвигом ячеек справа от удаляемого влево
     * @param index - индекс удаляемого элемента
     */

    public void deleteElement(int index){
        for (int i = index; i < size; i++){
            list[i] = list[i+1];
        }
        size--;
    }

    /**
     * Метод очищающий массив - заменяет значения во всех ячейках на "null" и присваивает размеру ArrayList 0
     */

    public void clear(){
        for (int i = 0; i < size; i++){
            list[i] = null;
        }
        size = 0;
    }

    /**
     * Метод возвращающий размер ArrayList - непустые ячейки
     * @return
     */

    public int size(){
        return size;
    }

    /**
     * Метод сортирующий ArrayList по возрастанию
     */

    public void sort(){
        quickSort(list,0,size-1);
    }

    private <T extends Comparable<T>> void quickSort(T[] array, int lowIndex, int highIndex){
        T pivot = array[lowIndex];
        int leftPointer = lowIndex;
        int rightPointer = highIndex;
        while (leftPointer<rightPointer){
            while(array[leftPointer].compareTo(pivot)<0){
                leftPointer++;
            }
            while(array[rightPointer].compareTo(pivot)>0){
                rightPointer--;
            }
            if (leftPointer<=rightPointer){
                T swap = array[leftPointer];
                array[leftPointer] = array[rightPointer];
                array[rightPointer] = swap;
                leftPointer++;
                rightPointer--;
            }
        }
        if (lowIndex < rightPointer) quickSort(array, lowIndex, rightPointer);
        if (highIndex > leftPointer) quickSort(array, leftPointer, highIndex);
    }

    /**
     * Метод возвращающий ArrayList в виде объекта
     * @return
     */

    public T[] getArray(){
        return list;
    }
}
