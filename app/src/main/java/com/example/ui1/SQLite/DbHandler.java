package com.example.ui1.SQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.example.ui1.Models.ContactModel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class DbHandler extends SQLiteOpenHelper {



    private static final int VERSION = 1;
    private static final String DB_NAME = "close_contacts";
    private static final String TABLE_NAME = "contacts";

    //Column names
    private static final String MAC_ADDRESS = "MAC_ADDRESS";
    private static final String CONTACT_STARTED = "CONTACT_STARTED";

    public DbHandler(@Nullable Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String table_create_query = "CREATE TABLE " + TABLE_NAME +
                " (" +
                MAC_ADDRESS + " TEXT," +
                CONTACT_STARTED + " DATE," +
                "PRIMARY KEY"+"(" + MAC_ADDRESS + "," + CONTACT_STARTED + ")"+
                ");";
        sqLiteDatabase.execSQL(table_create_query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String table_drop_query = "DROP TABLE IF EXISTS " + TABLE_NAME;
        sqLiteDatabase.execSQL(table_drop_query);
        onCreate(sqLiteDatabase);
    }

    public void addContactData(ContactModel contactModel) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(MAC_ADDRESS, contactModel.getMacAddress());
        LocalDate date = contactModel.getDate();
        contentValues.put(CONTACT_STARTED,date.toString());

        sqLiteDatabase.insert(TABLE_NAME, null, contentValues);
        sqLiteDatabase.close();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public List<ContactModel> getCloseContacts() {
        List<ContactModel> closeContacts = new ArrayList();
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;

        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                ContactModel contactModel = new ContactModel();
                contactModel.setMacAddress(cursor.getString(0));
                contactModel.setDate(LocalDate.parse("cursor.getString(1)"));

                closeContacts.add(contactModel);
            } while (cursor.moveToNext());
        }
        return closeContacts;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public int removeData() {

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyy-MM-dd");
        LocalDate now = LocalDate.now();
        LocalDate then = now.minusDays(14);

//        String query = "DELETE FROM " + TABLE_NAME + " WHERE " + CONTACT_STARTED +" < " + "'"+then.toString()+"'";
//        System.out.println(query);
//        sqLiteDatabase.execSQL(query);
        return sqLiteDatabase.delete(TABLE_NAME,CONTACT_STARTED+ "<?", new String[]{then.toString()});


    }
}
