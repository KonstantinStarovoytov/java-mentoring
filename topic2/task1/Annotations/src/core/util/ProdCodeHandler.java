package core.util;

import core.ProdRunner;
import core.annotations.ProdCode;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class ProdCodeHandler {

    public static void runProdCode(ProdRunner prodRunner) {
        Class<?> prodCodeClass = null;
        try {
            prodCodeClass = Class.forName("core.ProdRunner");

            Arrays.asList(prodCodeClass.getDeclaredMethods()).forEach(method -> {
                if (method.isAnnotationPresent(ProdCode.class)) {

                    try {
                        method.invoke(prodRunner);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            });
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}
