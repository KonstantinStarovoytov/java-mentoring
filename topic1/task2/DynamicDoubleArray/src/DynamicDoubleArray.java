public class DynamicDoubleArray {

    private Double[] data = new Double[10];

    private int size = 0;

    public DynamicDoubleArray() {
    }

    public DynamicDoubleArray(int baseCapacity) {
        this.data = new Double[baseCapacity];
    }

    public void add(Double val) {
        if (data.length < size) {
            Double[] temp = data;
            data = new Double[size * 2];
            System.arraycopy(temp, 0, data, 0, temp.length);
        }
        data[size] = val;
        size++;
    }

    public void remove(int index) {
        Double[] temp = data;
        data = new Double[temp.length-1];
        System.arraycopy(temp, 0, data, 0, index);
        int remainingElements = size - index - 1;
        System.arraycopy(temp, index + 1, data, index, remainingElements);
        size--;
    }

    public Double get(int index) {
        return data[index];
    }

    public int size() {
        return size;
    }
}
