package core.util;

import core.annotations.ThisCodeSmells;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CodeSmellsHandler {
    public static void printVotes(String className) {
        StringBuilder info = new StringBuilder();
        Class<?> clazz = null;
        try {
            clazz = Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if (clazz.isAnnotationPresent(ThisCodeSmells.class))

            info.append(clazz.getAnnotation(ThisCodeSmells.class).reviewer())
                    .append(" think that class - ")
                    .append(clazz.getSimpleName())
                    .append(" smells\n");

        Map<String, List<Field>> fields = ReflectionUtils.getAllFields(new HashMap<>(),clazz);
        Map<String, List<Method>> methods = ReflectionUtils.getAllMethods(new HashMap<>(),clazz);
        fields.forEach((key, fieldsList) -> {
            for (Field field : fieldsList){
                if(field.isAnnotationPresent(ThisCodeSmells.class)){
                    info.append(field.getAnnotation(ThisCodeSmells.class).reviewer())
                            .append(" think that field - ")
                            .append(field.getName())
                            .append(" smells\n");
                }
            }
            for(Method method : methods.get(key)){
                if(method.isAnnotationPresent(ThisCodeSmells.class)){
                    info.append(method.getAnnotation(ThisCodeSmells.class).reviewer())
                            .append(" think that method - ")
                            .append(method.getName())
                            .append("() smells\n");
                }
            }
        });
        System.out.println(info.toString());
    }
}
