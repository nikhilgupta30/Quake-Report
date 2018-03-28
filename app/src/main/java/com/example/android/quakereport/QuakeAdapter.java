package com.example.android.quakereport;

import android.graphics.drawable.GradientDrawable;
import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by nikhi on 31-12-2017.
 */

public class QuakeAdapter extends ArrayAdapter<quake> {

    public QuakeAdapter(Activity context, ArrayList<quake> quakes){
        super(context,0,quakes);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        final quake currQuake = getItem(position);

        // magnitude
        TextView mag = (TextView) listItemView.findViewById(R.id.magnitude);
        mag.setText(currQuake.getMag()+"");

        GradientDrawable magnitudeCircle = (GradientDrawable) listItemView.findViewById(R.id.magnitude).getBackground();
        int magnitudeColor = getMagnitudeColor((int)currQuake.getMag());

        magnitudeCircle.setColor(magnitudeColor);

        //place and location
        TextView place = (TextView) listItemView.findViewById(R.id.place);
        TextView location = (TextView) listItemView.findViewById(R.id.location);

        String fullplace = currQuake.getPlace();
        char first = fullplace.charAt(0);
        if(Character.isDigit(first)){
            int index = fullplace.indexOf("of");
            location.setText(fullplace.substring(0,index+2));
            place.setText(fullplace.substring(index+3));
        }
        else{
            location.setText("Near the");
            place.setText(fullplace);
        }

        //place.setText(currQuake.getPlace());


        //date and time
        Date dateObject = new Date(currQuake.getDate());

        TextView date = (TextView) listItemView.findViewById(R.id.date);
        String formattedDate = formatDate(dateObject);
        date.setText(formattedDate);

        TextView timeView = (TextView) listItemView.findViewById(R.id.time);
        String formattedTime = formatTime(dateObject);
        timeView.setText(formattedTime);

        return listItemView;

    }

    private int getMagnitudeColor(int mag){

        switch(mag){

            case 0: return ContextCompat.getColor(getContext(), R.color.magnitude1);

            case 1: return ContextCompat.getColor(getContext(), R.color.magnitude1);

            case 2: return ContextCompat.getColor(getContext(), R.color.magnitude2);

            case 3: return ContextCompat.getColor(getContext(), R.color.magnitude3);

            case 4: return ContextCompat.getColor(getContext(), R.color.magnitude4);

            case 5: return ContextCompat.getColor(getContext(), R.color.magnitude5);

            case 6: return ContextCompat.getColor(getContext(), R.color.magnitude6);

            case 7: return ContextCompat.getColor(getContext(), R.color.magnitude7);

            case 8: return ContextCompat.getColor(getContext(), R.color.magnitude8);

            case 9: return ContextCompat.getColor(getContext(), R.color.magnitude9);

            default: return ContextCompat.getColor(getContext(), R.color.magnitude10plus);

        }

    }

    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }

}
