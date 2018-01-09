package ca.bcit.ass1.spinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

public class InputActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    private ContinentExpert expert = new ContinentExpert();
    public void onClickConvert(View v) {
        TextView result = (TextView) findViewById(R.id.result);
        Spinner selections = (Spinner) findViewById(R.id.selection);
        EditText input = (EditText) findViewById(R.id.input);
        String selection = String.valueOf(selections.getSelectedItem());
        String inputValue = input.getText().toString();
        double amount = Double.parseDouble(inputValue);
        double results = expert.getInput(selection, amount);
        result.setText(String.format("%.2f", results));
    }

}
