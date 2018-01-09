package ca.bcit.myplanet;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CountryDetailsActivity extends Activity {
    private SQLiteDatabase db;
    private Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_details);

        // get the country from the intent
/*        int countryIndex = (Integer) getIntent().getExtras().get("index");
        Country country = Country.northAmericaCountries[countryIndex];*/

        String cntry = getIntent().getExtras().get("country").toString();
        Country country = getCountry(cntry);

        // Populate the country image
        ImageView photo = (ImageView) findViewById(R.id.photo);
        photo.setImageResource(country.getImageResourceId());
        photo.setContentDescription(country.getDescription());

        // Populate the country name
        TextView name = (TextView) findViewById(R.id.name);
        name.setText(country.getName());

        // populate the country description
        TextView desc = (TextView) findViewById(R.id.description);
        desc.setText(country.getDescription());

    }


    private Country getCountry(String cntry) {
        Country country = null;
        SQLiteOpenHelper helper = new MyPlanetDbHelper(this);
        try {
            SQLiteDatabase db = helper.getReadableDatabase();
            Cursor cursor = db.query("COUNTRY",
                    new String[] {"CONTINENT", "COUNTRY", "DESCRIPTION", "IMAGE_RESOURCE_ID"},
                    "COUNTRY = ?",
                    new String[] {cntry},
                    null, null, null);

            // move to the first record
            if (cursor.moveToFirst()) {
                // get the country details from the cursor
                country = new Country(
                        cursor.getString(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getInt(3)  );
            }
        } catch (SQLiteException sqlex) {
            String msg = "[CountryDetailsActivity/getCountry] DB unavailable";
            msg += "\n\n" + sqlex.toString();

            Toast t = Toast.makeText(this, msg, Toast.LENGTH_LONG);
            t.show();
        }

        return  country;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (cursor != null)
            cursor.close();
        if (db != null)
            db.close();
    }

}
