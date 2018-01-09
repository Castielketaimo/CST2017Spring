package ca.bcit.ass1.castielli_graganbirbahusun;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class InputActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button ASButton = (Button) findViewById(R.id.convertBtm);
        ASButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                SelectionExpert expert = new SelectionExpert();
                Spinner selectionsView = (Spinner) findViewById(R.id.selection);
                EditText inputView = (EditText) findViewById(R.id.input);
                String selectedItem = selectionsView.getSelectedItem().toString();
                String inputText = inputView.getText().toString();
                double input = Double.parseDouble(inputText);
                double output = expert.getOutput(selectedItem, input);
                Intent intent = new Intent(InputActivity.this, OutputActivity.class);
                intent.putExtra("output", output);
                intent.putExtra("selection", selectedItem);
                intent.putExtra("input", input);
                startActivity(intent);
            }
        });
    }




}
