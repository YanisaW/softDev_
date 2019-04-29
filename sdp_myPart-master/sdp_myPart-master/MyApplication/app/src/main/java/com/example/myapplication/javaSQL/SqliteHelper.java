package com.example.myapplication.javaSQL;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class SqliteHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "appDB";
    private static final int VERSION = 1;
    private static String DB_PATH;
    private static SQLiteDatabase DATABASE;
    private static String TOTAL_PATH;
    private  String TABLE_NAME = "MRT_TABLE";
    private  Context CONTEXT;


    public SqliteHelper(Context context, String table_name) {
        super(context, DB_NAME, null, VERSION);
        this.CONTEXT = context;
        this.TABLE_NAME =table_name;
        this.DB_PATH = "/data/data/" + context.getPackageName() + "/databases/";
        this.TOTAL_PATH = this.DB_PATH+this.DB_NAME;
        Log.d(table_name, "SqliteHelper Create ");
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
    }

    private boolean checkDataBase() {
        SQLiteDatabase checkDB = null;
        try {
            checkDB = SQLiteDatabase.openDatabase(this.TOTAL_PATH, null, SQLiteDatabase.OPEN_READONLY);
            Log.d("Report","Database is already exist!");
        } catch (SQLiteException e) {
            Log.d("myTag", e.getMessage());
        }
        if (checkDB != null) {
            checkDB.close();
            return true;
        }
        return false;
    }

    private void copyDB() throws IOException {
        InputStream inputStream = this.CONTEXT.getAssets().open(this.DB_NAME);
        String outFileName = this.TOTAL_PATH;
        OutputStream outputStream = new FileOutputStream(outFileName);
        byte[] buffer = new byte[1024];
        int length;
        while ((length = inputStream.read(buffer)) > 0) {
            outputStream.write(buffer, 0, length);
        }
        outputStream.flush();
        outputStream.close();
        inputStream.close();
    }

    public void openDB() throws SQLException {
        this.DATABASE = SQLiteDatabase.openDatabase(this.TOTAL_PATH, null, SQLiteDatabase.OPEN_READONLY);
    }

    public void createDB() throws IOException {
        boolean hasNoDB = !this.checkDataBase();
        if (hasNoDB) {
            this.getReadableDatabase();
            try {
                this.copyDB();
            } catch (IOException e) {
                throw new Error("Error Copying Database");
            }
        }
    }

    @Override
    public synchronized void close() {
        if (this.DATABASE != null) {
            this.DATABASE.close();
        }
        super.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        if (newVersion >= oldVersion) {
            try {
                this.copyDB();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public Cursor queryWithSQL(String sql, String[] bindArgs) {
        SQLiteDatabase db = getReadableDatabase();
        return db.rawQuery(sql, bindArgs);
    }

    public Cursor getTable() {
//        Log.d("getTable", "executed");
//        String x = "__";
//        if (!checkDataBase()) {
//            x = x + "NOOOOO";
//        } else {
//            x = x + "OKKKKK";
//        }
//        Log.d("isDbNull", x);

        return this.DATABASE.query(this.TABLE_NAME, null, null, null, null, null, null);

    }
//
    public Cursor getList() {   //bug
        return this.DATABASE.rawQuery("SELECT * FROM " + this.TABLE_NAME, null);
    }


}