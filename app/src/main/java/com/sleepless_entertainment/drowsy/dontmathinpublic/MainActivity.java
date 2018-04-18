package com.sleepless_entertainment.drowsy.dontmathinpublic;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView resultTextView;
    EditText percentageText;
    EditText numberText;
    Button calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        resultTextView = findViewById(R.id.resultTextView);
        percentageText = findViewById(R.id.percentageTextField);
        numberText = findViewById(R.id.numberTextField);
        calculateButton = findViewById(R.id.calculateButton);
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Add switch statement based on calculation type?
                if (percentageText.getText().toString().isEmpty() || numberText.getText().toString().isEmpty()) {
                    if (percentageText.getText().toString().isEmpty()) {
                        percentageText.setHint("You must enter percent");
                    }
                    if (numberText.getText().toString().isEmpty()) {
                        numberText.setHint("You must enter number");
                    }
                    return;
                }
                resultTextView.setText(doubleToString(onPercentOf(stringToDouble(percentageText.getText()), stringToDouble(numberText.getText()))));
            }
        });
    }

    private <T extends Object> double stringToDouble(T input) {
        return Double.parseDouble(input.toString());
    }

    private String doubleToString(double input) {
        return String.valueOf(input);
    }

    public double onPercentOf(double percent, double number) {
        return number * (percent / 100);
    }

    public double onPercentOff(double percent, double number) {
        return number - onPercentOf(percent, number);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        menu.add("Change Calculation Type");
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        else if (id == R.id.calc_type) {
//            Open calculation selection activity
            Dialog dialog = new Dialog(getApplicationContext());
            dialog.show();
        }

        return super.onOptionsItemSelected(item);
    }
}
