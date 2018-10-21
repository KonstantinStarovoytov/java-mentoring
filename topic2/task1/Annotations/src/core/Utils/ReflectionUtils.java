package core.Utils;

import objects.Product;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.*;

public class ReflectionUtils {

    public static Object addProduct(Class productClass, double weight) {
        Object product = null;
        try {
            Class<?> productClas = Class.forName(productClass.getName());

            Constructor<?> con = null;

            con = productClass.getConstructor(double.class);

            product = con.newInstance(weight);

        } catch (InstantiationException |
                IllegalAccessException |
                InvocationTargetException |
                ClassNotFoundException |
                NoSuchMethodException e) {
            e.printStackTrace();
        }
        return product;
    }

    public static <T extends Product> void setReady(T product, boolean value) {

        Map<String, List<Field>> fields = getAllFields(new HashMap<>(), product.getClass());
        fields.forEach((className, fieldsList) -> {
            for (Field field : fieldsList) {
                if (field.getName().equals("isReady")) {
                    field.setAccessible(true);
                    try {
                        field.setBoolean(product, value);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }


    static Map<String, List<Field>> getAllFields(Map<String, List<Field>> fields, Class<?> type) {
        fields.put(type.getSimpleName(), Arrays.asList(type.getDeclaredFields()));

        if (type.getSuperclass() != Object.class) {
            getAllFields(fields, type.getSuperclass());
        }
        return fields;
    }

    static Map<String, List<Method>> getAllMethods(Map<String, List<Method>> methods, Class<?> type) {
        methods.put(type.getSimpleName(),Arrays.asList(type.getDeclaredMethods()));

        if (type.getSuperclass() != Object.class) {
            getAllMethods(methods, type.getSuperclass());
        }
        return methods;
    }

    static Map<String, List<Annotation>> getAllAnnotations(Map<String, List<Annotation>> annotation, Class<?> type) {
        annotation.put(type.getSimpleName(),Arrays.asList(type.getDeclaredAnnotations()));

        if (type.getSuperclass() != Object.class) {
            getAllAnnotations(annotation, type.getSuperclass());
        }
        return annotation;
    }

    static Map<String, List<Constructor>> getAllContructors(Map<String, List<Constructor>> constructor, Class<?> type) {
        constructor.put(type.getSimpleName(),Arrays.asList(type.getDeclaredConstructors()));

        if (type.getSuperclass() != Object.class) {
            getAllContructors(constructor, type.getSuperclass());
        }
        return constructor;
    }



    public static void executeMethod(Object object,String methodName){
        Map<String, List<Method>> objectMethods = getAllMethods(new HashMap<>(),object.getClass());
        objectMethods.forEach((key,methods) -> {
            methods.forEach(method -> {
                if (method.getName().equals(methodName)) {
                    try {
                        method.invoke(object);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            });

        });
    }

    public static <T extends Product> void showClassMetaData(T product) {
        System.out.println(product.getName() + " - meta data:");
        Map<String, List<Field>> fields = getAllFields(new HashMap<>(), product.getClass());
        Map<String, List<Method>> methods = getAllMethods(new HashMap<>(), product.getClass());
        StringBuilder metaData = new StringBuilder();
        fields.forEach((className, fieldsList) -> {
            metaData.append("\n");
            if (!className.equals(product.getClass().getSimpleName()))
                metaData.append("Parent class - ");

            metaData.append(className).append("\n\n");
            if (fieldsList.isEmpty()) {
                metaData.append("This class has no fields\n");
            } else {
                metaData.append("Field list: \n");
                fieldsList.forEach(field -> metaData.append(field.getType().getSimpleName()).append(" ").append(field.getName()).append("\n"));
            }
            if (methods.get(className).isEmpty()) {
                metaData.append("This class has no methods\n");
            } else {
                metaData.append("\nMethods list: \n");
                methods.get(className).forEach(method -> metaData.append(method.getName()).append("()\n"));
            }
        });
        System.out.println(metaData.toString());
    }

}

