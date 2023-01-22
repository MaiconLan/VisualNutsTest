package com.lanzendorf.maicon.visualnutstest.firstexercise;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.stream.Stream;

@Component
@Log4j2
public class FirstExercise {

    public void execute(Integer from, Integer to) {
        Assert.notNull(from, "'from' should not be null");
        Assert.notNull(to, "'to' should not be null");

        alert("---------------------Exercise 1---------------------");

        Stream.iterate(from, n -> n + 1)
                .limit(to)
                .forEach(this::printVisualNuts);
    }

    private void printVisualNuts(int current) {
        print(getPrintingValue(current));
    }

    protected String getPrintingValue(int current) {
        final boolean isVisual = isVisual(current);
        final boolean isNuts = isNuts(current);

        if (isVisual && isNuts) {
            return "Visual Nuts";
        } else if (isVisual) {
            return "Visual";
        } else if (isNuts) {
            return "Nuts";
        } else {
            return String.valueOf(current);
        }
    }

    protected boolean isVisual(int current) {
        return mod(current, 3, 0);
    }

    protected boolean isNuts(int current) {
        return mod(current, 5, 0);
    }

    protected boolean mod(int current, int mod, double leaves) {
        return current % mod == leaves;
    }

    private void print(String content) {
        log.info(content);
    }

    private void alert(String content) {
        log.warn(content);
    }
}
