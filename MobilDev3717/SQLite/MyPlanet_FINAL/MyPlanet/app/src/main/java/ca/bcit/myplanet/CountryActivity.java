package ca.bcit.myplanet;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class CountryActivity extends ListActivity {
    private SQLiteDatabase db;
    private Cursor cursor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

/*
        ArrayAdapter<Country> arrayAdapter = new ArrayAdapter<Country>(
                this, android.R.layout.simple_list_item_1, Country.northAmericaCountries
        );

        ListView listCountries = getListView();
        listCountries.setAdapter(arrayAdapter);
*/

// get the continent from the intent
        String continent = getIntent().getExtras().get("continent").toString();

        SQLiteOpenHelper helper = new MyPlanetDbHelper(this);
        try {
            db = helper.getReadableDatabase();
            cursor = db.query("COUNTRY",
                    new String[] {"_id", "COUNTRY"},
                    "CONTINENT = ?",
                    new String[] {continent},
                    null, null, null);

            SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
                    android.R.layout.simple_list_item_1,
                    cursor,
                    new String[] {"COUNTRY"},
                    new int[] {android.R.id.text1});

            ListView listCountries = getListView();
            listCountries.setAdapter(adapter);
        } catch (SQLiteException sqlex) {
            String msg = "[CountryActivity / onCreate] DB unavailable";
            msg += "\n\n" + sqlex.toString();
            Toast t = Toast.makeText(this, msg, Toast.LENGTH_LONG);
            t.show();
        }

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        TextView tv = (TextView) v;
        String country = tv.getText().toString();

        Intent i = new Intent(this, CountryDetailsActivity.class);
        i.putExtra("country", country);
        startActivity(i);    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        cursor.close();
        db.close();
    }

}
