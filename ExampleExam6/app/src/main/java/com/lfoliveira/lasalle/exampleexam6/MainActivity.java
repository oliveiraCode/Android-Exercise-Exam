package com.lfoliveira.lasalle.exampleexam6;

import android.content.ClipData;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnLongClickListener, View.OnDragListener {

    int valueSelected;
    String colorSelected;
    boolean isColorSelected;

    int[] btnColors = new int[] {
            R.id.btnBlack,
            R.id.btnRed
    };
    int[] btnIds = new int[] {
            R.id.btn1,
            R.id.btn2,
            R.id.btn3,
            R.id.btn4,
            R.id.btn5,
            R.id.btn6,
            R.id.btn7,
            R.id.btn8,
            R.id.btn9,
            R.id.btnToken
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();

        Button btnRoll = findViewById(R.id.btnRoll);
        btnRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView textViewRoll = findViewById(R.id.textViewRoll);
                textViewRoll.setText(String.valueOf(randomValues()));

                if (isColorSelected){
                    checkIfColorIsCorrect(textViewRoll);
                } else {
                    checkIfNumberIsCorrect(Integer.valueOf(textViewRoll.getText().toString()));
                }

            }
        });

        Button btnToken = findViewById(R.id.btnToken);
        btnToken.setOnLongClickListener(this);
        btnToken.setOnDragListener(this);

    }

    @Override
    public boolean onLongClick(View view) {
        float textSize = 35;
        ClipData data = ClipData.newPlainText("textSize",String.valueOf(textSize));
        view.startDrag(data, new View.DragShadowBuilder(view), null, 0);
        return true;
    }



    @Override
    public boolean onDrag(View view, DragEvent dragEvent) {
       // Log.d("drag","drag" + dragEvent.getAction());

        if (dragEvent.getAction() == DragEvent.ACTION_DROP) {


            for (int id: btnColors){
                Button button = findViewById(id);
                if (id == view.getId()){
                    button.setText("X");
                    colorSelected = button.getContentDescription().toString();
                    isColorSelected = true;
                    button.setTextSize(Float.valueOf(dragEvent.getClipData().getItemAt(0).getText().toString()));
                } else {
                    button.setText("");
                }
            }

            for(int id: btnIds){
                Button button = findViewById(id);
                button.setTextSize(25);
                if (id == view.getId()){
                    button.setTextSize(Float.valueOf(dragEvent.getClipData().getItemAt(0).getText().toString()));
                    valueSelected = Integer.valueOf(button.getText().toString());
                    isColorSelected = false;
                }
            }


        }

        return true;
    }

    private void checkIfColorIsCorrect(TextView textViewRoll) {

        TextView textViewScore = findViewById(R.id.textViewScore);
        String colorRoll;

        if (Integer.valueOf(textViewRoll.getText().toString()) % 2 == 0){
            colorRoll = "black";
        } else {
            colorRoll = "red";
        }


        if (colorRoll.equals(colorSelected.toString())){
            textViewScore.setText(String.valueOf(Integer.valueOf(textViewScore.getText().toString())+100));
        } else {
            textViewScore.setText(String.valueOf(Integer.valueOf(textViewScore.getText().toString())-10));
        }

    }

    private void checkIfNumberIsCorrect(int numberRoll){

        TextView textViewScore = findViewById(R.id.textViewScore);

        if (valueSelected == numberRoll) {
            textViewScore.setText(String.valueOf(Integer.valueOf(textViewScore.getText().toString())+100));
        } else {
            textViewScore.setText(String.valueOf(Integer.valueOf(textViewScore.getText().toString())-10));
        }
    }

    private void initialize() {
        for(int id: btnIds){
            Button button = findViewById(id);
            button.setOnDragListener(this);
        }

        for(int id: btnColors){
            Button button = findViewById(id);
            button.setOnDragListener(this);
        }
    }

    private int randomValues(){
        Random random = new Random();
        return (random.nextInt(8))+1;
    }

}
