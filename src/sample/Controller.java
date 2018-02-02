package sample;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import java.text.NumberFormat;

public class Controller implements Initializable {
        NumberFormat formatCur = NumberFormat.getCurrencyInstance();


    @FXML
    public Button btnBuyApple;
    @FXML
    public Button btnBuyOrange;
    @FXML
    public Button btnBuyBanana;
    @FXML
    public Button btnBuyGrape;
    @FXML
    public Button btnSellApple;
    @FXML
    public Button btnSellOrange;
    @FXML
    public Button btnSellBanana;
    @FXML
    public Button btnSellGrape;
    @FXML
    public Text priceApple;
    @FXML
    public Text priceOrange;
    @FXML
    public Text priceBanana;
    @FXML
    public Text priceGrape;
    @FXML
    public Text boxApple;
    @FXML
    public Text boxOrange;
    @FXML
    public Text boxBanana;
    @FXML
    public Text boxGrape;
    @FXML
    public Text boxSellApple;
    @FXML
    public Text boxSellOrange;
    @FXML
    public Text boxSellBanana;
    @FXML
    public Text boxSellGrape;
    @FXML
    public Text cashOwned;
    @FXML
    public Text timer;
    public double playerCash = 100;
    int high = 999;
    int low = 50;
    Random diceRoll = new Random();
    int randomApple = diceRoll.nextInt((high - low)+ 1) + low;
    double randomAppleD=randomApple/100;

    int randomOrange = diceRoll.nextInt((high - low)+ 1) + low;
    double randomOrangeD=randomOrange/100;

    int randomBanana = diceRoll.nextInt((high - low)+ 1) + low;
    double randomBananaD=randomBanana/100;

    int randomGrape = diceRoll.nextInt((high - low)+ 1) + low;
    double randomGrapeD=randomGrape/100;

    private int counterApple = 0;
    private int counterOrange = 0;
    private int counterBanana = 0;
    private int counterGrape = 0;
    public int countTimer = 16;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        updateBoxes();
        setUpClock();
    }

    public void updateBoxes() {
        priceApple.setText("Price: " + formatCur.format(randomAppleD));
        priceOrange.setText("Price: " + formatCur.format(randomOrangeD));
        priceBanana.setText("Price: " + formatCur.format(randomBananaD));
        priceGrape.setText("Price: " + formatCur.format (randomGrapeD));
        boxApple.setText("Apples Owned: " + counterApple);
        boxOrange.setText("Oranges Owned: " + counterOrange);
        boxBanana.setText("Bananas Owned: " + counterBanana);
        boxGrape.setText("Grapes Owned: " + counterGrape);
        cashOwned.setText("Cash Available: " + formatCur.format(playerCash));
        //boxSellApple.setText("Averages: $" + (counterApple/playerCash));
    }

    public void clickBuyApple(ActionEvent actionEvent) {
        if (playerCash > randomAppleD) {
            playerCash = playerCash - randomAppleD;
            counterApple++;
            updateBoxes();
        }
    }

    public void clickBuyOrange(ActionEvent actionEvent) {
        if (playerCash > randomOrangeD){
            playerCash = playerCash - randomOrangeD;
            counterOrange++;
            updateBoxes();
        }
    }

    public void clickBuyBanana(ActionEvent actionEvent) {
        if (playerCash > randomBananaD) {
            playerCash = playerCash - randomBananaD;
            counterBanana++;
            updateBoxes();
        }
    }

    public void clickBuyGrape(ActionEvent actionEvent) {
        if (playerCash > randomGrapeD) {
            playerCash = playerCash - randomGrapeD;
            counterGrape++;
            updateBoxes();
        }
    }

    public void clickSellApple(ActionEvent actionEvent) {
        if (counterApple > 0) {
            playerCash = playerCash + randomAppleD;
            counterApple--;
            updateBoxes();
        }
    }

    public void clickSellOrange(ActionEvent actionEvent) {
        if (counterOrange > 0) {
            playerCash = playerCash + randomOrangeD;
            counterOrange--;
            updateBoxes();
        }
    }

    public void clickSellBanana(ActionEvent actionEvent) {
        if (counterBanana > 0) {
            playerCash = playerCash + randomBananaD;
            counterBanana--;
            updateBoxes();
        }
    }

    public void clickSellGrape(ActionEvent actionEvent) {
        if (counterGrape > 0) {
            playerCash = playerCash + randomGrapeD;
            counterGrape--;
            updateBoxes();
        }
    }

    public void setUpClock() {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                countTimer--;
                String stringTimer = String.valueOf(countTimer);
                timer.setText(stringTimer);
                if (countTimer == 0) {
                    countTimer = 16;
                    randomApple = diceRoll.nextInt((high - low)+ 1) + low;
                    randomAppleD=randomApple/100;
                    randomOrange = diceRoll.nextInt((high - low)+ 1) + low;
                    randomOrangeD=randomOrange/100;
                    randomBanana = diceRoll.nextInt((high - low)+ 1) + low;
                    randomBananaD=randomBanana/100;
                    randomGrape = diceRoll.nextInt((high - low)+ 1) + low;
                    randomGrapeD=randomGrape/100;
                    updateBoxes();
                }
            }
        };
        Timer timey = new Timer();
        timey.schedule(task, 1000L, 1000L);
    }
}






