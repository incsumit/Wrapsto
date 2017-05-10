package com.wrapsto.wrapsto;


import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseManipulator {

    private static final String DATABASE_NAME = "wrpaso_dataBase";
    private static final int DATABASE_VERSION = 11;
    private static final String TABLE_NAME = "VIVZTABLE";
    private static final String ID = "Id";
    private static final String NAME = "Name";
    private static final String QUANTITY = "Quantity";
    private static Context context;

    OpenHelper openHelper;
    ContentValues al;
    ContentValues exception;
    static SQLiteDatabase db;

    public DatabaseManipulator(Context context)
    {
        DatabaseManipulator.context = context;
        openHelper = new OpenHelper(DatabaseManipulator.context);
        DatabaseManipulator.db = openHelper.getWritableDatabase();

    }

    public void saveItems(Intent intent)
    {
        al = new ContentValues();
        al = putvalues(intent,al);
        db.insert(TABLE_NAME, null, al);



    }

    public void updateItem(Intent intent,String  title)
    {
        al = new ContentValues();
        al = putvalues(intent,al);
        db.update(TABLE_NAME, al, NAME+" = '"+ title + "'", null);


    }




    public ContentValues putvalues(Intent intent, ContentValues al){


        al.put("Name",intent.getStringExtra("Name"));
        al.put("Quantity",intent.getStringExtra("Quantity"));

        return al;
    }

    public Cursor fetchenableItems()
    {

        int count = 00;
        return db.query(TABLE_NAME, null,  "Quantity != ?", new String[] { "00" }, null, null, null);

    }





    private static class OpenHelper extends SQLiteOpenHelper {

        OpenHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db)
        {

            db.execSQL("CREATE TABLE " + TABLE_NAME + " (Id INTEGER PRIMARY KEY AUTOINCREMENT, Name TEXT, Quantity TEXT)");

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
        {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

            onCreate(db);
        }
    }

    public void close()
    {
        openHelper.close();
        db.close();

    }

}



