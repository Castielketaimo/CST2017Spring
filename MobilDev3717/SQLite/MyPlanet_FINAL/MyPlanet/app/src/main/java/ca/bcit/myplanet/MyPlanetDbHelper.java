package ca.bcit.myplanet;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by A00127241 on 2017-10-19.
 */

public class MyPlanetDbHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "MyPlanet.sqlite";
    private static final int DB_VERSION = 2;
    private Context context;

    public MyPlanetDbHelper(Context context) {
        // The 3'rd parameter (null) is an advanced feature relating to cursors
        super(context, DB_NAME, null, DB_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        updateMyDatabase(sqLiteDatabase, 0, DB_VERSION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        updateMyDatabase(sqLiteDatabase, i, i1);
    }

    private void updateMyDatabase(SQLiteDatabase db, int oldVersion, int newVersion) {
        try {
            if (oldVersion < 1) {
                db.execSQL(getCreateCountryTableSql());
                for (Country c : northAmericaCountries) {
                    insertCountry(db, c);
                }
            }
            if (oldVersion < 2)
                db.execSQL("ALTER TABLE COUNTRY ADD COLUMN POPULATION NUMERIC;");
        } catch (SQLException sqle) {
            String msg = "[MyPlanetDbHelper / updateMyDatabase/insertCountry] DB unavailable";
            msg += "\n\n" + sqle.toString();
            Toast t = Toast.makeText(context, msg, Toast.LENGTH_LONG);
            t.show();
        }
    }

    private String getCreateCountryTableSql() {
        String sql = "";
        sql += "CREATE TABLE COUNTRY (";
        sql += "_id INTEGER PRIMARY KEY AUTOINCREMENT, ";
        sql += "CONTINENT TEXT, ";
        sql += "COUNTRY TEXT, ";
        sql += "DESCRIPTION TEXT, ";
        sql += "IMAGE_RESOURCE_ID INTEGER);";

        return sql;
    }

    private void insertCountry(SQLiteDatabase db, Country country) {
        ContentValues values = new ContentValues();
        values.put("CONTINENT", country.getContinent());
        values.put("COUNTRY", country.getName());
        values.put("DESCRIPTION", country.getDescription());
        values.put("IMAGE_RESOURCE_ID", country.getImageResourceId());

        db.insert("COUNTRY", null, values);
    }

    private static final Country[] northAmericaCountries = {
            new Country("North America", "Canada", "Canada is a country in the northern part of North America. Its ten provinces and three territories extend from the Atlantic to the Pacific and northward into the Arctic Ocean, covering 9.98 million square kilometres (3.85 million square miles), making it the world's second-largest country by total area and the fourth-largest country by land area. Canada's southern border with the United States is the world's longest bi-national land border. The majority of the country has a cold or severely cold winter climate, but southerly areas are warm in summer. Canada is sparsely populated, the majority of its land territory being dominated by forest and tundra and the Rocky Mountains. It is highly urbanized with 82 per cent of the 35.15 million people concentrated in large and medium-sized cities, many near the southern border. Its capital is Ottawa, and its largest metropolitan areas are Toronto, Montreal and Vancouver.", R.drawable.canada),
            new Country("North America", "USA", "The United States of America (USA), commonly known as the United States (U.S.) or America is a federal republic composed of 50 states, a federal district, five major self-governing territories, and various possessions. Forty-eight states and the federal district are contiguous and located in North America between Canada and Mexico. The state of Alaska is in the northwest corner of North America, bordered by Canada to the east and across the Bering Strait from Russia to the west. The state of Hawaii is an archipelago in the mid-Pacific Ocean. The U.S. territories are scattered about the Pacific Ocean and the Caribbean Sea, stretching across nine official time zones. The extremely diverse geography, climate and wildlife of the United States make it one of the world's 17 megadiverse countries.", R.drawable.usa),
            new Country("North America", "Mexico", "Mexico , officially the United Mexican States (Spanish: Estados Unidos Mexicanos,  listen (help·info)), is a federal republic in the southern portion of North America. It is bordered to the north by the United States; to the south and west by the Pacific Ocean; to the southeast by Guatemala, Belize, and the Caribbean Sea; and to the east by the Gulf of Mexico. Covering almost two million square kilometers (over 760,000 sq mi),Mexico is the sixth largest country in the Americas by total area and the 13th largest independent nation in the world.\n" +
                    "With an estimated population of over 120 million, Mexico is the eleventh most populous country and the most populous Spanish-speaking country in the world while being the second most populous country in Latin America. Mexico is a federation comprising 31 states and a special federal entity that is also its capital and most populous city. Other metropolises include Guadalajara, León, Monterrey, Puebla, Toluca, and Tijuana.", R.drawable.mexico),
            new Country("Africa", "Djibouti", "Djibouti, officially the Republic of Djibouti, is a country located in the Horn of Africa. It is bordered by Eritrea in the north, Ethiopia in the west and south, and Somalia in the southeast. The remainder of the border is formed by the Red Sea and the Gulf of Aden at the east. Djibouti occupies a total area of just 23,200 km2 (8,958 sq mi).", R.drawable.djibouti),
            new Country("Africa", "Botswana", "Botswana, is a landlocked country located in Southern Africa. The citizens refer to themselves as Batswana (singular: Motswana).Formerly the British protectorate of Bechuanaland, Botswana adopted its new name after becoming independent within the Commonwealth on 30 September 1966. Since then, it has maintained a strong tradition of stable representative democracy, with a consistent record of uninterrupted democratic elections and the best perceived corruption ranking in Africa for the last four years.", R.drawable.botswana),
    };

}

