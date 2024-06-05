package com.example.csi460midterm;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper {
    //static values for the "games" table
    private static final String DB_NAME = "gamesdb";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "games";
    private static final String ID_COL = "id";
    private static final String NAME_COL = "name";
    private static final String GENRE_COL = "genre";
    private static final String RATING_COL = "rating";
    private static final String DESCRIPTION_COL = "description";

    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //SQL Query to create the "games" table
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_COL + " TEXT,"
                + GENRE_COL + " TEXT,"
                + RATING_COL + " INTEGER,"
                + DESCRIPTION_COL + " TEXT)";

        db.execSQL(query);
    }

    public void addNewGame(String gameName, String gameGenre, int gameRating, String gameDescription) {
        //method to insert a new game into the database
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(NAME_COL, gameName);
        values.put(GENRE_COL, gameGenre);
        values.put(RATING_COL, gameRating);
        values.put(DESCRIPTION_COL, gameDescription);

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public ArrayList<VideoGameModal> readGames() {
        //method to read out all the games in the "games" table
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursorCourses = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        ArrayList<VideoGameModal> gameModalArrayList = new ArrayList<>();

        if (cursorCourses.moveToFirst()) {
            do {
                gameModalArrayList.add(new VideoGameModal(cursorCourses.getString(1),
                        cursorCourses.getString(2),
                        cursorCourses.getInt(3),
                        cursorCourses.getString(4)));
            } while (cursorCourses.moveToNext());
        }
        cursorCourses.close();
        return gameModalArrayList;
    }

    public void updateGame(String gameName, String gameGenre,
                             int gameRating, String gameDescription) {
        //method to update an existing game in the database by the game name

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(NAME_COL, gameName);
        values.put(GENRE_COL, gameGenre);
        values.put(RATING_COL, gameRating);
        values.put(DESCRIPTION_COL, gameDescription);

        db.update(TABLE_NAME, values, "name=?", new String[]{gameName});
        db.close();
    }

    public void deleteGame(String gameName) {
        //method to delete an existing game in the database by its name

        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABLE_NAME, "name=?", new String[]{gameName});
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
