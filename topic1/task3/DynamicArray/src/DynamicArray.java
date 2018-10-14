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
        DynamicArray<Integer> sss = new DynamicArray<>();
        sss.add(5);
        sss.add(4);
        sss.add(2);
        System.out.printf(sss.toString());
    }

    private E[] data;

    private int size = 0;

    public DynamicArray() {
        this.data = (E[]) new Object[3];
    }

    @Override
    public boolean add(E e) {
        try {
            if (data.length < size) {
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
        return data.length;
    }

    @Override
    public Iterator<E> iterator() {
        return new DynamicArrayIterator<>(data);
    }

    @Override
    public String toString() {
        return Arrays.toString(data);
    }
}
