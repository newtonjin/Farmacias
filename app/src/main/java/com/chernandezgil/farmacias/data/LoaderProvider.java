package com.chernandezgil.farmacias.data;

import android.content.Context;


import android.database.Cursor;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;

import com.chernandezgil.farmacias.data.source.local.DbContract;

/**
 * Created by Carlos on 03/08/2016.
 */
public class LoaderProvider  {

    private Context mContext;
    private String[] projectionSuggestion = new String[]{DbContract.FarmaciasEntity._ID,
            DbContract.FarmaciasEntity.NAME,
            DbContract.FarmaciasEntity.ADDRESS,
            DbContract.FarmaciasEntity.LOCALITY,
            DbContract.FarmaciasEntity.PROVINCE};

    public LoaderProvider(Context context){
        mContext=context;
    }
    public Loader<Cursor> getPharmacies(){

        return new CursorLoader(mContext,
                DbContract.FarmaciasEntity.CONTENT_URI,
                null,
                null,
                null,
                null) ;
    }

    public  Loader<Cursor> getPharmaciesByName(String name) {
        return new CursorLoader(mContext,
                DbContract.FarmaciasEntity.buildFarmaciasUriByName(name),
                null,
                DbContract.FarmaciasEntity.NAME + " like ?",
                new String[]{"%"+ name + "%"},
                DbContract.FarmaciasEntity.NAME + " ASC LIMIT 50"
                );
    }


//    public  Loader<Cursor> getPharmaciesByName(String name) {
//        return new CursorLoader(mContext,
//                DbContract.FarmaciasEntity.buildFarmaciasUriByName(name),
//                projectionSuggestion,
//                DbContract.FarmaciasEntity.NAME + " like ?",
//                new String[]{"%"+ name + "%"},
//                DbContract.FarmaciasEntity.NAME + " ASC LIMIT 50"
//        );
//    }
}
