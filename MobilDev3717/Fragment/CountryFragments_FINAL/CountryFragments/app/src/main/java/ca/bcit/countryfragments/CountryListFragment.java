package ca.bcit.countryfragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class CountryListFragment extends ListFragment {
    private CountryListListener listener;

    public CountryListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        String[] names = new String[Country.northAmericaCountries.length];
        for (int i=0; i<names.length; i++) {
            names[i] = Country.northAmericaCountries[i].getName();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                inflater.getContext(), android.R.layout.simple_expandable_list_item_1, names
        );
        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
     }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.listener = (CountryListListener) getActivity();
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        if (listener != null) {
            listener.itemClicked(Country.northAmericaCountries[(int) id].getName());
        }
    }
}
