import java.util.ArrayList;

public class Checker {
    public static void main (String[] args) {
        DynamicDoubleArray dynamicDoubleArray = new DynamicDoubleArray();
        dynamicDoubleArray.add(1.0);
        dynamicDoubleArray.add(2.1);
        dynamicDoubleArray.add(3.6);
        System.out.println(dynamicDoubleArray.get(1));
        dynamicDoubleArray.remove(1);
        System.out.println(dynamicDoubleArray.get(1));
        System.out.println(dynamicDoubleArray.size());
        System.out.println(dynamicDoubleArray.toString());
    }
}
