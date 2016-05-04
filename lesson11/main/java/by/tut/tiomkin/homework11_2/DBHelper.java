package by.tut.tiomkin.homework11_2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper{

    private static final String TAG = DBHelper.class.getSimpleName();
    private static final String DATABASE_NAME = "users";
    private static final int DATABASE_VERSION = 1;


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(TAG, "onCreate()");
        db.execSQL("CREATE TABLE users (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d(TAG, "onUpgrade() old version = " + oldVersion + " new version = " + newVersion);

    }

    public void save(int id, String name) {

        Log.d(TAG, "save()");

        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("id", id);
        if(!isExist(id)) {
            // добавление
            db.insert(DATABASE_NAME, null, values);
        } else if (isExist(id)){
            db.update(DATABASE_NAME, values, "id=?", new String[]{String.valueOf(id)});
        }
        db.insert(DATABASE_NAME, null, values);

        db.close();
    }

    private boolean isExist(int id) {
        Log.d(TAG, "isExist()");


        int dbId = id;

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query("users", null, null, null, null, null, null);

        if (cursor.moveToFirst()) {

            do {

                Log.d(TAG, "getUser() do");

                id = cursor.getInt(0);

                if (id == dbId) {
                    return true;
                }

            } while (cursor.moveToNext());

        }
        return false;
    }

    public ArrayList<User> getAllUsers() {
        Log.d(TAG, "getUser()");

        SQLiteDatabase db = getReadableDatabase();
        ArrayList<User> users = new ArrayList<>();

        Cursor cursor = db.query(DATABASE_NAME, null, null, null, null, null, null);

        if(cursor.moveToFirst()) {

            Log.d(TAG, "moveToFirst()");

            int id;
            String name = null;

            do {

                Log.d(TAG, "getUsers() do");

                id = cursor.getInt(0);
                name = cursor.getString(cursor.getColumnIndex("name"));
                User user = new User();
                user.setId(id);
                user.setName(name);
                users.add(user);

            } while (cursor.moveToNext());

            db.close();

            return users;

        } else {
            Log.d(TAG, "no()");
            db.close();
            return null;
        }
    }

}
