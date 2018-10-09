package ua.study.list;

public class ArrayList implements List {

    Object[] array;
    int size;

    private int initSize = 6;

    public ArrayList(){
        array = new Object[initSize];
    }

    @Override
    public void add(Object value) {
        // size of newArray = array.length * 1.5
        if (size == array.length) {
            Object[] newData = new Object[(int) (size * 1.5)];
            System.arraycopy(array,0,newData,0,array.length);
            array = newData;
        }
        array[size] = value;
        size++;
    }

    @Override
    public void add(Object value, int index) {
//        Object[] newArray = new Object[]
        System.arraycopy(array,index,array,index+1,size - index + 1);
        array[index] = value;
    }

    @Override
    public Object remove(int index) {
        Object result = array[index-1];
        System.arraycopy(array, index - 1 + 1, array, index - 1, size - (index - 1));
        array[size] = null;
        size--;
        return result;
    }

    @Override
    public Object get(int index) {
        return array[index];
    }

    @Override
    public Object set(Object value, int index) {
        Object result = array[index];
        array[index] = value;
        return array[index];
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object value) {
        for (int i = 0; i < size; i++) {
            if(array[i].equals(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(Object value) {
        for (int i = 0; i < size; i++) {
            if(array[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object value) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if(array[i].equals(value)) {
                index = i;
            }
        }
        return index;
    }

    public String toString(){
        String result = "[";
        for(int i=0; i < size; i++) {
            result += array[i];
            if(i < size - 1) {
                result += ",";
            }
        }
        result += "]";
        return result;
    }
}