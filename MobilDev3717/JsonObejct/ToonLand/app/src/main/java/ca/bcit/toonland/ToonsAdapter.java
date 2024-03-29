package ca.bcit.toonland;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by A00127241 on 2017-10-01.
 */

public class ToonsAdapter extends ArrayAdapter<Toon> {
    Context _context;
    public ToonsAdapter(Context context, ArrayList<Toon> toons) {
        super(context, 0, toons);
        _context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Activity activity = (Activity) _context;
         // Get the data item for this position
        Toon toon = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_row_layout, parent, false);
        }
        // Lookup view for data population
        TextView tvFirstName = (TextView) convertView.findViewById(R.id.firstName);
        TextView tvLastName = (TextView) convertView.findViewById(R.id.lastName);
        // Populate the data into the template view using the data object
        tvFirstName.setText(toon.getFirstName());
        tvLastName.setText(toon.getLastName());

        ImageView imgOnePhoto = (ImageView) convertView.findViewById(R.id.thumbImage);
        //DownloadImageTask dit = new DownloadImageTask(_context, imgOnePhoto);
        //dit.execute(toon.getPicture());
        if (toon.getPicture() != null) {
            new ImageDownloaderTask(imgOnePhoto).execute(toon.getPicture());
        }

        // Return the completed view to render on screen
        return convertView;
    }
}
