package ca.bcit.myplanet;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    private SQLiteDatabase db;
    private Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView list_continents = (ListView) findViewById(R.id.list_continents);

        String[] continents = getContinents();

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, continents
        );

        list_continents.setAdapter(arrayAdapter);

        list_continents.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView tv = (TextView) view;
                String continent = tv.getText().toString();

                Intent intent = new Intent(MainActivity.this, CountryActivity.class);
                intent.putExtra("continent", continent);

                startActivity(intent);
            }
        });
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        cursor.close();
        db.close();
    }

    private String[] getContinents() {
        SQLiteOpenHelper helper = new MyPlanetDbHelper(this);
        String[] continents = null;
        try {
            db = helper.getReadableDatabase();
            cursor= db.rawQuery("select DISTINCT CONTINENT from COUNTRY", null);

            int count = cursor.getCount();
            continents = new String[count];

            if (cursor.moveToFirst()) {
                int ndx=0;
                do {
                    continents[ndx++] = cursor.getString(0);
                } while (cursor.moveToNext());
            }
        } catch (SQLiteException sqlex) {
            String msg = "[MainActivity / getContinents] DB unavailable";
            msg += "\n\n" + sqlex.toString();

            Toast t = Toast.makeText(this, msg, Toast.LENGTH_LONG);
            t.show();
        }

        return continents;
    }

}
