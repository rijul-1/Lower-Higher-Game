package com.example.lower_higher_game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Random random = new Random();
        final int[] random_number = {random.nextInt(100) + 1};

        TextView number = findViewById(R.id.number_guessed);
        Button guess_button = (Button) findViewById(R.id.guess_button);
        Button restart_button = (Button) findViewById(R.id.restart_button);


        restart_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                random_number[0] = random.nextInt(100)+1;
                number.setText("");
                Toast.makeText(MainActivity.this,"Game Restarted" ,Toast.LENGTH_SHORT).show();
            }
        });

        guess_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num = Integer.parseInt(number.getText().toString());
                if(num> random_number[0]){
                    Toast.makeText(MainActivity.this,"Lower",Toast.LENGTH_SHORT).show();
                }
                else if(num < random_number[0]){
                    Toast.makeText(MainActivity.this , "Higher" ,Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this , "Number Matched",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


}