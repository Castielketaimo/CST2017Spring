package ca.bcit.countryfragments;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity  implements CountryListListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        CountryDetailFragment frag = (CountryDetailFragment) getSupportFragmentManager().findFragmentById(R.id.detail_frag);
        frag.setCountryName("Mexico");
        */
    }

    @Override
    public void itemClicked(String countryName) {
        View fragmenyContainer = findViewById(R.id.fragment_container);
        if (fragmenyContainer != null) {
            CountryDetailFragment details = new CountryDetailFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            details.setCountryName(countryName.trim());
            ft.replace(R.id.fragment_container, details);
            ft.addToBackStack(null);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();
        } else {
            Intent i = new Intent(this, DetailActivity.class);
            i.putExtra("countryName", countryName.trim());
            startActivity(i);
        }
    }
}
