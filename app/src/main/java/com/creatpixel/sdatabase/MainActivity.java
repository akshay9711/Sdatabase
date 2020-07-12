package com.creatpixel.sdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //6. Simple textview we set final result in this.
        TextView textView = findViewById(R.id.textView);
        //7. The class we created for database, We are creating object and setting context
        DataManager dataManager = new DataManager(this);
        //8. We created new sqlite db and getting readabledata from DataManager class
        //and setting this to our db
        SQLiteDatabase database = dataManager.getReadableDatabase();
        //9. With the help of Cursor class we are getting specific data from db
        //rawQuery is for getting raws
        Cursor cursor = database.rawQuery("SELECT GOALSNAME, NEEDS FROM GOALS", new String[]{});

        StringBuilder builder = new StringBuilder();
        //10. And if we want data from columns use cursor.getString(1)
        if(cursor != null){
            cursor.moveToFirst();
        }
        do{
             //11. Getting values from cursor until
             //all raws not end, and setting values in var
             String name = cursor.getString(0);
             String needs = cursor.getString(1);
             //12. settin variables in builder string.
             builder.append(name +" "+ needs+" and ");
        }while (cursor.moveToNext());
        //13. Finally!! we are settings all values into our textview, For showing in mobile screen
        textView.setText(builder);
    }
}