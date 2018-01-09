package ca.bcit.ass1.castielli_graganbirbahusun;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class OutputActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output);
        Bundle b = getIntent().getExtras();
        double output = b.getDouble("output");
        double input = b.getDouble("input");
        String selection = b.getString("selection");
        String outputString = Double.toString(output);
        String inputString = Double.toString(input);
        String outputText = inputString + " " + selection + " is " + outputString;
        TextView outputView = (TextView) findViewById(R.id.output);
        outputView.setText(outputText);
        Button back = (Button)  findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}
