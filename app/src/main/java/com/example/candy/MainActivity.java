package com.example.candy;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.display.DisplayManager;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private int[] candies = {
        R.drawable.bluecandy,
        R.drawable.greencandy,
        R.drawable.orangecandy,
        R.drawable.purplecandy,
        R.drawable.redcandy,
        R.drawable.yellowcandy
    };

    private int widthOfBlock;
    private int noOfBlock = 8;
    private int widthOfScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        widthOfScreen = displayMetrics.widthPixels;
        int heightScreen = displayMetrics.heightPixels;
        widthOfBlock = widthOfScreen/noOfBlock;
        createBoard();
    }

    private void createBoard() {
        GridLayout gridLayout = findViewById(R.id.board);
        gridLayout.setRowCount(noOfBlock);
        gridLayout.setColumnCount(noOfBlock);

        // board is square
        gridLayout.getLayoutParams().width = widthOfScreen;
        gridLayout.getLayoutParams().height = widthOfScreen;

        for(int i = 0;i<noOfBlock*noOfBlock; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setId(i);
            imageView.setLayoutParams(new
                    ViewGroup.LayoutParams(widthOfBlock, widthOfBlock));
            imageView.setMaxWidth(widthOfBlock);

            // random candy
            int randomCandy = (int) Math.floor(Math.random() * candies.length);
            imageView.setImageResource(candies[randomCandy]);
            gridLayout.addView(imageView);
        }
    }
}