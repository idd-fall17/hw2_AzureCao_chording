package com.example.androidthings.myproject;

import com.google.android.things.pio.Gpio;
/**
 * Template for IDD Fall 2017 HW2 (text entry device)
 * Created by bjoern on 9/5/17.
 */

public class Hw2TemplateApp extends SimplePicoPro {
    int one, two, four, eight, sixteen, sum;
    String output;

    @Override
    public void setup() {
        //set two GPIOs to input
        pinMode(GPIO_39,Gpio.DIRECTION_IN);
        setEdgeTrigger(GPIO_39,Gpio.EDGE_BOTH);

        pinMode(GPIO_128,Gpio.DIRECTION_IN);
        setEdgeTrigger(GPIO_128,Gpio.EDGE_BOTH);

        pinMode(GPIO_172,Gpio.DIRECTION_IN);
        setEdgeTrigger(GPIO_172,Gpio.EDGE_BOTH);

        pinMode(GPIO_173,Gpio.DIRECTION_IN);
        setEdgeTrigger(GPIO_173,Gpio.EDGE_BOTH);

        pinMode(GPIO_174,Gpio.DIRECTION_IN);
        setEdgeTrigger(GPIO_174,Gpio.EDGE_BOTH);

        pinMode(GPIO_175,Gpio.DIRECTION_IN);
        setEdgeTrigger(GPIO_175,Gpio.EDGE_BOTH);
    }

    @Override
    public void loop() {
//        nothing to do here
        boolean button1state = digitalRead(GPIO_128);
        boolean button2state = digitalRead(GPIO_39);
        boolean button4state = digitalRead(GPIO_172);
        boolean button8state = digitalRead(GPIO_173);
        boolean button16state = digitalRead(GPIO_174);
        boolean buttonState = digitalRead(GPIO_175);
        if (button1state == LOW){
            one = 1;
        }
        if (button2state == LOW){
            two = 1;
        }
        if (button4state == LOW){
            four = 1;
        }
        if (button8state == LOW){
            eight = 1;
        }
        if (button16state == LOW){
            sixteen = 1;
        }
        if (buttonState == LOW){
            sum = one * 1 + two * 2 + four * 4 + eight * 8 + sixteen * 16;
            if (sum == 0) {
//                output = "";
                printStringToScreen("");
            } else if (sum == 27){
//                output = String.valueOf((char) (sum + 5));
                printCharacterToScreen(' ');
            } else {
                output = String.valueOf((char) (sum + 96));
                printStringToScreen(output);
            }

            one = 0;
            two = 0;
            four = 0;
            eight = 0;
            sixteen = 0;
        }
    }


    @Override
    void digitalEdgeEvent(Gpio pin, boolean value) {
//        int one = 0;
//        int two = 0;
//        int four = 0;
//        int eight = 0;
//        int sixteen = 0;
//        int sum = 0;
//        System.out.println("digitalEdgeEvent"+pin+", "+value);
        // when 128 goes from LOW to HIGH
        // this is on button button release for pull-up resistors
//        if (pin == GPIO_128 && value == HIGH) {
//            printCharacterToScreen(' ');
////            one = 1;
//        }
//        //when 39 goes from HIGH to HIGH
    }




}
