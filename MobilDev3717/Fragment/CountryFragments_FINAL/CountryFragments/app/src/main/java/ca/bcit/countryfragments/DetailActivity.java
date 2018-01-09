package ca.bcit.countryfragments;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        String countryName = getIntent().getStringExtra("countryName");

        CountryDetailFragment frag = (CountryDetailFragment) getSupportFragmentManager().findFragmentById(R.id.detail_frag);
        frag.setCountryName(countryName);
    }
}
