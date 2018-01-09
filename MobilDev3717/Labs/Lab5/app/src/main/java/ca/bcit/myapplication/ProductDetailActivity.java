package ca.bcit.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ProductDetailActivity extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        int foodCategory = (Integer) getIntent().getExtras().get("category");
        int foodIndex = (Integer) getIntent().getExtras().get("index");
        Food food = null;

        if (foodCategory == 0) {
            food = Food.fruits[foodIndex];
        } else if (foodCategory == 1) {
            food = Food.vegetables[foodIndex];
        } else if (foodCategory == 2) {
            food = Food.bakery[foodIndex];
        }
        ImageView photo = (ImageView) findViewById(R.id.photo);
        photo.setImageResource(food.getImageResourceId());
        photo.setContentDescription(food.getName());

        TextView name = (TextView) findViewById(R.id.name);
        name.setText(food.getName());

        TextView desc = (TextView) findViewById(R.id.description);
        desc.setText("Category: " + food.getCategory()
            + "\n" + "Country of Origin: " + food.getCountryOfOrigin()
            + "\n" + "Unit Price: " + food.getUnit()
            + "\n" + "Price: " + food.getPrice());
    }
}
