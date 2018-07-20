package com.lfoliveira.lasalle.exampleexam5;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private String[][] slotValues = new String[3][3];
    private String[] lettersValues = new String[]{"A","K","J","Q"};
    int[] tvIds = new int[]{
            R.id.tv0,
            R.id.tv1,
            R.id.tv2,
            R.id.tv3,
            R.id.tv4,
            R.id.tv5,
            R.id.tv6,
            R.id.tv7,
            R.id.tv8
    };
    int[] colorIds = new int[]{R.color.colorRed,
            R.color.colorGreen,
            R.color.colorBrown,
            R.color.colorBlue
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnGo = findViewById(R.id.btnGo);
        btnGo.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {

        for (int id: tvIds){
            TextView textView = findViewById(id);
            textView.setText(lettersValues[changeColorTextView(randomValues(),textView)]);
        }



        for (int i = 0; i < 3; i++) {

            TextView textView = findViewById(tvIds[i]);

            String description = textView.getContentDescription().toString();
            //  Log.d("indices", description);
            String[] indices = description.split(",");
            int x = Integer.parseInt(indices[0]);
            int y = Integer.parseInt(indices[1]);


            String slotValue = textView.getText().toString();
            slotValues[x][y] = slotValue;



                if (slotValue == slotValues[i][0] &&
                        slotValue == slotValues[i][1] &&
                        slotValue == slotValues[i][2]) {

                    Log.d("deu 1", slotValue);
                    break;
                }

                if (slotValue == slotValues[0][i] &&
                        slotValue == slotValues[1][i] &&
                        slotValue == slotValues[2][i]) {
                    Log.d("deu 2", slotValue);
                    break;
                }
            }


    }



    private int changeColorTextView(int randomNumber, TextView textView){

        textView.setTextColor(ContextCompat.getColor(this, colorIds[randomNumber]));

        return randomNumber;
    }


    private int randomValues(){
        Random random = new Random();
        return random.nextInt(4);
    }
}
