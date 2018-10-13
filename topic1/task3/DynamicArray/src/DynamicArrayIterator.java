import java.util.Iterator;

public class DynamicArrayIterator<E> implements Iterator<E> {

    private int index = 0;
    private E[] data;

    DynamicArrayIterator(E[] data){
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        return index < data.length;
    }

    @Override
    public E next() {
        return data[index++];
    }
}
