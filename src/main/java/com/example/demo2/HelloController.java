package com.example.demo2;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Random;

public class HelloController {
    //    @FXML
//    private Label text;
    @FXML
    private Label result;
    @FXML
    private Label message;
    @FXML
    private TextField money;

    @FXML
    protected void onQuitButtonClick() {
        message.setText("Przegrane: " + lost + " Wygrane: " + won);
    }

    public static final double profitMargin = 0.5;

    @FXML
    protected void onPullButtonClick() {
        double budget = Double.parseDouble(this.money.getText());
        lost += budget;
        double random1 = random.nextDouble();
        if (lost - won + budget * 3 > lost * profitMargin && random1 > 0.6) {
            result.setText(winAll(random));
            won += budget * 3;
            message.setText("Wygrałeś: " + budget * 3);
        } else if (lost - won + budget * 1.5 > lost * profitMargin && random1 > 0.3) {
            result.setText(winHalf(random));
            won += budget * 1.5;
            message.setText("Wygrałeś: " + budget * 1.5);
        } else {
            result.setText(lose(random));
            message.setText("Przegrałeś: " + budget);

        }
    }

    public static double lost = 0;
    public static double won = 0;
    public static final String[] images = {"🍒", "🍊", "🍋", "🍉", "🍇", "🍓"};
    public static Random random = new Random();

    public static String winAll(Random random) {
        int index = random.nextInt(6);
        return images[index].repeat(3);
    }

    public static String winHalf(Random random) {
        int index1 = random.nextInt(6);
        int index2 = random.nextInt(6);
        int index3 = random.nextInt(6);
        while (!(index1 == index2 || index2 == index3 || index1 == index3)) {
            index1 = random.nextInt(6);
            index2 = random.nextInt(6);
            index3 = random.nextInt(6);
        }
        return images[index1] + " " + images[index2] + " " + images[index3];
    }

    public static String lose(Random random) {
        int index1 = random.nextInt(6);
        int index2 = random.nextInt(6);
        int index3 = random.nextInt(6);
        while (index1 == index2 || index2 == index3 || index1 == index3) {
            index1 = random.nextInt(6);
            index2 = random.nextInt(6);
            index3 = random.nextInt(6);
        }
        return images[index1] + " " + images[index2] + " " + images[index3];
    }

}