package ca.bcit.countryfragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class CountryDetailFragment extends Fragment {
    private String countryName;

    public CountryDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState !=null) {
            countryName = savedInstanceState.getString("countryName");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_country_detail, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        View v = getView();
        if (v != null) {
            Country country = Country.getCountryByContinentAndName("North America", countryName);

            TextView name = (TextView)v.findViewById(R.id.name);
            name.setText(country.getName());

            TextView desc = (TextView)v.findViewById(R.id.description);
            desc.setText(country.getDescription());

        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putString("countryName", countryName);
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

}
