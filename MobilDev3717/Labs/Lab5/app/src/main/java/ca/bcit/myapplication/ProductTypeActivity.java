package ca.bcit.myapplication;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ProductTypeActivity extends ListActivity {
    int foodCategory;

    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    foodCategory = (Integer) getIntent().getExtras().get("category");
    ArrayAdapter<Food> arrayAdapter = null;
    if(foodCategory == 0) {
        arrayAdapter = new ArrayAdapter<Food>(
                this, android.R.layout.simple_expandable_list_item_1, Food.fruits
        );
    } else if (foodCategory == 1) {
        arrayAdapter =new ArrayAdapter<Food>(
                this, android.R.layout.simple_expandable_list_item_1, Food.vegetables
        );
    } else if (foodCategory == 2) {
        arrayAdapter =new ArrayAdapter<Food>(
                this, android.R.layout.simple_expandable_list_item_1, Food.bakery
        );
    }

    ListView list = getListView();
    list.setAdapter(arrayAdapter);

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Intent i = new Intent(this, ProductDetailActivity.class);
        i.putExtra("index", (int) id);
        i.putExtra("category", foodCategory);
        startActivity(i);
    }
}
