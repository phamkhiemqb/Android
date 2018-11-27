package p.pklovestar.databasesqlite.Database;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import p.pklovestar.databasesqlite.Sinhvien;

public class TableSinhvien extends SQLiteOpenHelper {
    private static final String DB_NAME = "dbsinhvien";
    private static final String TABLE_NAME = "tbsinhvien";
    private static final String ID = "ID";
    private static final String NAME = "name";
    private static final String ADDRESS = "address";
    private static final String PHONE = "phone";
    private static int ver = 1;

    private Context context;

    private static final String SQLQuery = "CREATE TABLE "+TABLE_NAME+" ("+
            ID +" integer primary key, "+
            NAME + " TEXT, "+
            ADDRESS + " TEXT, "+
            PHONE + " TEXT)";





    public TableSinhvien(Context context) {
        super(context, DB_NAME,null,ver);
        this.context = context;




    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQLQuery);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void addSinhVien(Sinhvien sinhvien){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME, sinhvien.getName());
        values.put(ADDRESS, sinhvien.getAddress());
        values.put(PHONE, sinhvien.getPhone());
        db.insert(TABLE_NAME,null,values);
        db.close();
    }
}
