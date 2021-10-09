package com.example.clasejava;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class baseDatos extends SQLiteOpenHelper {
    private static final String NOMBRE_DB="bdproyecto.bd";
    private static final int VERSION_DB=1;
    private static final String TABLA_ESTUDIANTES="create table estudiantes(codigo text primary key,nombre text,carrera text)";

    public baseDatos(Context context){
        super(context, NOMBRE_DB, null,VERSION_DB);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLA_ESTUDIANTES);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF exists"+TABLA_ESTUDIANTES);
        db.execSQL(TABLA_ESTUDIANTES);

    }

    public void agregarEstudiantes(String codigo, String nombre, String carrera){
        SQLiteDatabase bd = getReadableDatabase();
        if (bd!=null)
        {
            bd.execSQL("INSERT INTO estudiantes VALUES ('"+codigo+"','"+nombre+"','"+carrera+"')");
            bd.close();
        }
    }
}
