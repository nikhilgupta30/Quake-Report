package com.example.android.quakereport;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

/**
 * Created by nikhi on 10-01-2018.
 */

public class EarthquakeLoader extends AsyncTaskLoader<List<quake>> {

    private String urls;

    EarthquakeLoader(Context context,String urls){
        super(context);
        this.urls = urls;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<quake> loadInBackground() {
        if (urls == null) {
            return null;
        }

        List<quake> result = QueryUtils.fetchEarthquakeData(urls);
        return result;
    }
}
