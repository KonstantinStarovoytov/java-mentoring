package main;

import core.ProdRunner;
import core.annotations.ProdCode;
import core.util.CodeSmellsHandler;
import core.util.ProdCodeHandler;
import core.util.ReflectionUtils;
import entity.Potato;
import entity.Product;
import entity.Tomato;

public class Main {
    public static void main(String args[]) {
        /*
        Instantiate all entity in client code via constructors
        */
        Tomato tomato = (Tomato) ReflectionUtils.addProduct(Tomato.class, 200);
        Product potato = (Potato) ReflectionUtils.addProduct("entity.Potato", 200);
        /*
        Fill private fields without setters
        */
        System.out.println(tomato.isReady());
        ReflectionUtils.setReady(tomato,true);
        System.out.println(tomato.isReady());
        /*
        Method reflection call
        */
        ReflectionUtils.executeMethod(potato,"prepare");
        /*
        Show object meta data via Reflection API
        */
        ReflectionUtils.showClassMetaData(tomato);
        /*
        Show code marked "ThisCodeSmells" annotation
        */
        CodeSmellsHandler.printVotes("entity.Tomato");
        /*
        Run method marked @ProdCode annotation
        */
        ProdCodeHandler.runProdCode(new ProdRunner());
    }
}
