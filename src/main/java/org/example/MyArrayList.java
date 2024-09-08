package org.example;

public class MyArrayList<T extends Comparable<T>> {

    private T[] list;
    private int size;
    private final int DEFAULT_CAPACITY = 10;

    public MyArrayList(int capacity){
        if (capacity <= 0){
            throw new IllegalArgumentException("Capacity <= 0!");
        } else {
            list = (T[]) new Comparable[capacity];
        }
    }

    public MyArrayList(){
        list = (T[]) new Comparable[DEFAULT_CAPACITY];
    }

    public void addElement(T item){
        checkCapacity(size+1);
        list[size++] = item;
    }

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

    public T getElement(int index){
        return list[index];
    }

    public void setElement(int index, T item){
        list[index] = item;
    }

    public void deleteElement(int index){
        for (int i = index; i < size; i++){
            list[i] = list[i+1];
        }
        size--;
    }

    public void clear(){
        for (int i = 0; i < size; i++){
            list[i] = null;
        }
        size = 0;
    }

    public int size(){
        return size;
    }

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

    public T[] getArray(){
        return list;
    }
}
