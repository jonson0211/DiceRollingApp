package com.example.dicerollingapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

        public static final Random RANDOM = new Random();
        private ImageView diceOne;
        private ImageView diceTwo;
        private TextView numOne, numTwo, finalNum, plusSign, equalsSign;
        private Button rollButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


         diceOne = (ImageView) findViewById(R.id.diceOne);
         diceTwo = (ImageView) findViewById(R.id.diceTwo);
         numOne = (TextView) findViewById(R.id.numOne);
         numOne.setText("(Result 1)");
         numTwo = (TextView) findViewById(R.id.numTwo);
         numTwo.setText("(Result 2)");
         finalNum = (TextView) findViewById(R.id.finalNum);
         finalNum.setText("(Sum)");
         plusSign = (TextView) findViewById(R.id.plusSign);
         equalsSign = (TextView) findViewById(R.id.equalsSign);
         rollButton = (Button) findViewById(R.id.rollButton);

        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int value1 = randomDiceValue();
                int value2 = randomDiceValue();
                int value3 = value1 + value2;

                int rollResultOne = getResources().getIdentifier("dice"+value1, "drawable", "com.example.dicerollingapp");
                int rollResultTwo = getResources().getIdentifier("dice"+value2, "drawable", "com.example.dicerollingapp");

                diceOne.setImageResource(rollResultOne);
                diceTwo.setImageResource(rollResultTwo);
                numOne.setText(String.valueOf(value1));
                numTwo.setText(String.valueOf(value2));
                finalNum.setText(String.valueOf(value3));
            }
        });
    }

    public static int randomDiceValue(){
        return RANDOM.nextInt(6) + 1;
    }
}

