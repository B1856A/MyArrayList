package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest {

    @Test
    void addElement() {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        int i = 0;
        int startSize = myArrayList.size();
        while (i < 15){
            myArrayList.addElement(i);
            i++;
        }
        int endSize = myArrayList.size();
        assertEquals(startSize+15, endSize);
    }

    @Test
    void addElementParam() {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        int i = 0;
        while (i < 15){
            myArrayList.addElement(i);
            i++;
        }
        myArrayList.setElement(5,0);
        assertEquals(0, myArrayList.getElement(5));
    }

    @Test
    void getElement() {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        int givenInt = 99;
        myArrayList.addElement(givenInt);
        assertEquals(givenInt, myArrayList.getElement(0));
    }

    @Test
    void setElement() {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        int givenInt = 88;
        myArrayList.addElement(1);
        myArrayList.setElement(0, givenInt);
        assertEquals(givenInt, myArrayList.getElement(0));
    }

    @Test
    void deleteElement() {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        int i = 0;
        while (i < 15){
            myArrayList.addElement(i);
            i++;
        }
        int startSize = myArrayList.size();
        myArrayList.deleteElement(0);
        int endSize = myArrayList.size();
        assertEquals(startSize-1, endSize);
    }

    @Test
    void clear() {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        int i = 0;
        while (i < 15){
            myArrayList.addElement(i);
            i++;
        }
        myArrayList.clear();
        int endSize = myArrayList.size();
        assertEquals(0, endSize);
    }

    @Test
    void size() {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        int i = 0;
        int number = 3;
        while (i < number){
            myArrayList.addElement(i);
            i++;
        }
        assertEquals(number, myArrayList.size());
    }

    @Test
    void sort() {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        MyArrayList<Integer> expectedList = new MyArrayList<>();
        int i = 0;
        while (i < 15){
            expectedList.addElement(i);
            myArrayList.addElement(14-i);
            i++;
        }
        myArrayList.sort();
        assertArrayEquals(expectedList.getArray(), myArrayList.getArray());
    }

    @Test
    void getArray() {
        MyArrayList<Integer> myArrayList = new MyArrayList<>(5);
        myArrayList.addElement(1);
        myArrayList.addElement(2);
        myArrayList.addElement(3);
        myArrayList.addElement(4);
        myArrayList.addElement(5);
        Integer[] expectedList = new Integer[] {1, 2, 3, 4, 5};
        assertArrayEquals(expectedList, myArrayList.getArray());
    }
}