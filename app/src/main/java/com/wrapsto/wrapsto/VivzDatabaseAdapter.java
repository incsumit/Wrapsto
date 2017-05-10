package com.wrapsto.wrapsto;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class VivzDatabaseAdapter {
    VivzHelper helper;

    public VivzDatabaseAdapter(Context context) {
        helper = new VivzHelper(context);
    }

    public long insertData(String Id, String name,String Quantity , String Type) {
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(VivzHelper.ID, Id);
        contentValues.put(VivzHelper.NAME, name);
        contentValues.put(VivzHelper.QUANTITY, Quantity);
        contentValues.put(VivzHelper.TYPE, Type);
        long id = db.insert(VivzHelper.Table_NAME, null, contentValues);
        return id;
    }

    static class VivzHelper extends SQLiteOpenHelper {


        private static final String DATABASE_NAME = "vivzhelper";
        private static final String Table_NAME = "VIVZTABLE";
        private static final int DATABASE_VERSION = 4;
        private static final String ID = "Id";
        private static final String NAME = "Name";
        private static final String QUANTITY = "Quantity";
        private static final String TYPE = "Type";
        private static final String CREATE_TABLE = "CREATE TABLE " + Table_NAME + "(" + ID + " VARCHAR(225)," + NAME + " VARCHAR(225)," + QUANTITY + " VARCHAR(225)," + TYPE + " VARCHAR(255));";
        private static final String DROP_TABLE = "DROP TABLE" + Table_NAME + "IF EXIST";
        private Context context;

        public VivzHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
            this.context = context;
            Message.message(context, "constructor created");
        }


        public VivzHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
            this.context = context;
        }


        @Override
        public void onCreate(SQLiteDatabase db) {
            try {
                Message.message(context, "oncreate called");
                db.execSQL(CREATE_TABLE);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldversion, int newversion) {
            try {
                Message.message(context, "onupgrade called");
                db.execSQL(DROP_TABLE);
                onCreate(db);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
