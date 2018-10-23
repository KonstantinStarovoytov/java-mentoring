package core.util;

import entity.Product;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReflectionUtils {

    public static Object addProduct (Class productClassPath, double weight) {
        Object product = null;
        try {
            Constructor<?> con = null;

            con = productClassPath.getConstructor(double.class);

            product = con.newInstance(weight);

        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return product;
    }

    public static Object addProduct (String productClassPath, double weight) {
        Object product = null;
        try {
            Class<?> productClass = Class.forName(productClassPath);
            Constructor<?> con = productClass.getConstructor(double.class);
            product = con.newInstance(weight);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return product;
    }

    public static <T extends Product> void setReady (T product, boolean value) {

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


    static Map<String, List<Field>> getAllFields (Map<String, List<Field>> fields, Class<?> type) {
        fields.put(type.getSimpleName(), Arrays.asList(type.getDeclaredFields()));

        if (type.getSuperclass() != Object.class) {
            getAllFields(fields, type.getSuperclass());
        }
        return fields;
    }

    static Map<String, List<Method>> getAllMethods (Map<String, List<Method>> methods, Class<?> type) {
        methods.put(type.getSimpleName(), Arrays.asList(type.getDeclaredMethods()));

        if (type.getSuperclass() != Object.class) {
            getAllMethods(methods, type.getSuperclass());
        }
        return methods;
    }

    static Map<String, List<Annotation>> getAllAnnotations (Map<String, List<Annotation>> annotation, Class<?> type) {
        annotation.put(type.getSimpleName(), Arrays.asList(type.getDeclaredAnnotations()));

        if (type.getSuperclass() != Object.class) {
            getAllAnnotations(annotation, type.getSuperclass());
        }
        return annotation;
    }

    static Map<String, List<Constructor>> getAllContructors (Map<String, List<Constructor>> constructor, Class<?> type) {
        constructor.put(type.getSimpleName(), Arrays.asList(type.getDeclaredConstructors()));

        if (type.getSuperclass() != Object.class) {
            getAllContructors(constructor, type.getSuperclass());
        }
        return constructor;
    }


    public static void executeMethod (Object object, String methodName) {
        Map<String, List<Method>> objectMethods = getAllMethods(new HashMap<>(), object.getClass());
        objectMethods.forEach((key, methods) -> {
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

    public static <T extends Product> void showClassMetaData (T product) {
        System.out.println(product.getName() + " - meta data:");
        Map<String, List<Field>> fields = getAllFields(new HashMap<>(), product.getClass());
        Map<String, List<Method>> methods = getAllMethods(new HashMap<>(), product.getClass());
        Map<String, List<Constructor>> constructors = getAllContructors(new HashMap<>(), product.getClass());
        Map<String, List<Annotation>> annotations = getAllAnnotations(new HashMap<>(), product.getClass());
        StringBuilder metaData = new StringBuilder();
        fields.forEach((className, fieldsList) -> {
            metaData.append("\n");
            if (!className.equals(product.getClass().getSimpleName())) metaData.append("Parent class - ");

            metaData.append(className).append("\n\n");
            if (fieldsList.isEmpty()) {
                metaData.append("This class has no fields\n");
            } else {
                metaData.append("Field list: \n");
                fieldsList.forEach(field -> metaData.append(Modifier.toString(field.getModifiers()))
                                                    .append(" ")
                                                    .append(field.getType().getSimpleName())
                                                    .append(" ")
                                                    .append(field.getName())
                                                    .append("\n"));
            }
            if (methods.get(className).isEmpty()) {
                metaData.append("This class has no methods\n");
            } else {
                metaData.append("\nMethods list: \n");
                methods.get(className)
                       .forEach(method -> metaData.append(Modifier.toString(method.getModifiers()))
                                                  .append(" ")
                                                  .append(method.getName())
                                                  .append("()\n"));
            }
            if (constructors.get(className).isEmpty()) {
                metaData.append("This class has no constructors\n");
            } else {
                metaData.append("\nConstructors list: \n");
                constructors.get(className).forEach(constructor -> {
                    metaData.append(Modifier.toString(constructor.getModifiers())).append(" ").append(className).append("(");
                    Arrays.asList(constructor.getParameters())
                          .forEach(parameter -> metaData.append(parameter.getParameterizedType().getTypeName().split("\\.")[
                                                                parameter.getParameterizedType().getTypeName().split("\\.")
                                                                        .length -1])
                                                        .append(" ")
                                                        .append(parameter.getName())
                                                        .append(", "));
                    metaData.replace(metaData.length() - 2, metaData.length(), ")\n");
                });
            }
            if (annotations.get(className).isEmpty()) {
                metaData.append("This class has no annotations\n");
            } else {
                metaData.append("\nAnnotations list:\n");
                annotations.get(className)
                           .forEach(annotation -> metaData.append("@").append(annotation.annotationType().getSimpleName()).append("\n"));
            }
        });
        System.out.println(metaData.toString());
    }
}

