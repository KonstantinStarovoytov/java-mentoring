import java.util.Arrays;
import java.util.Iterator;

public class DynamicArray<E> implements DynamicArrayBehavior<E> {
    public static void main(String[] args) {
        DynamicArray<String> dynamicArray = new DynamicArray<>();
        dynamicArray.add("first");
        dynamicArray.add("second");
        dynamicArray.add("third");
        System.out.println(dynamicArray.get(1));
        System.out.println(dynamicArray.toString());
        System.out.println(dynamicArray.size());
        dynamicArray.delete(1);
        System.out.println(dynamicArray.get(1));
        System.out.println(dynamicArray.size());
        DynamicArray<Integer> dynamicArray2 = new DynamicArray<>();
        dynamicArray2.add(5);
        dynamicArray2.add(4);
        dynamicArray2.add(2);
        dynamicArray2.add(11);
        System.out.println(dynamicArray2.toString());
        System.out.println(dynamicArray2.size());
    }

    private E[] data;

    private int size = 0;

    public DynamicArray() {
        this.data = (E[]) new Object[3];
    }

    @Override
    public boolean add(E e) {
        try {
            if (data.length <= size) {
                E[] temp = data;
                data = (E[]) new Object[size * 2];
                System.arraycopy(temp, 0, data, 0, temp.length);
            }
            data[size] = e;
            size++;
            return true;
        } catch (ClassCastException exception) {
            exception.printStackTrace();
        }
        return false;
    }

    @Override
    public void delete(int index) {
        try {
            E[] temp = data;
            data = (E[])new Object[temp.length - 1];
            System.arraycopy(temp, 0, data, 0, index);
            int remainingElements = size - index - 1;
            System.arraycopy(temp, index + 1, data, index, remainingElements);

        } catch (ClassCastException exception){
            exception.printStackTrace();
        }
        size--;
    }

    @Override
    public E get(int index) {
        return data[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return new DynamicArrayIterator<>(data);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("[");
        for (int i = 0; i < size; i++) {
            s.append(data[i]);
            s.append(", ");
        }
        s.replace(s.length()-2,s.length(),"]");
        return s.toString();
    }
}
