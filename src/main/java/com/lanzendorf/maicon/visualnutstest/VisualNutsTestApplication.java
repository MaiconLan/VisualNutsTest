package com.lanzendorf.maicon.visualnutstest;

import com.lanzendorf.maicon.visualnutstest.firstexercise.FirstExercise;
import com.lanzendorf.maicon.visualnutstest.secondeexercise.SecondExercise;
import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@AllArgsConstructor
public class VisualNutsTestApplication {

    private final FirstExercise firstExercise;
    private final SecondExercise secondExercise;

    public static void main(String[] args) {
        SpringApplication.run(VisualNutsTestApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void executeExercises() {
        firstExercise.execute(1, 100);
        secondExercise.execute();
    }

}
