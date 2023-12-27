package com.example.ekzamen;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
public class MainActivity2 extends AppCompatActivity {
    private ImageButton backButton;
    private ImageButton cameraButton;
    private TextView titleText;

    private TextView text1;
    private TextView text2;
    private TextView text3;
    private TextView text4;
    private TextView text5;
    private TextView text6;
    private Switch switch1;
    private Switch switch2;
    private Switch switch3;
    private CheckBox checkBox3;
    private CheckBox checkBox4;
    private CheckBox checkBox5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        backButton = findViewById(R.id.backButton);
        cameraButton = findViewById(R.id.cameraButton);
        titleText = findViewById(R.id.titleText);


        text1 = findViewById(R.id.text1);
        text2 = findViewById(R.id.text2);
        text3 = findViewById(R.id.text3);
        text4 = findViewById(R.id.text4);
        text5 = findViewById(R.id.text5);
        text6 = findViewById(R.id.text6);
        switch1 = findViewById(R.id.switch1);
        switch2 = findViewById(R.id.switch2);
        switch3 = findViewById(R.id.switch3);
        checkBox3 = findViewById(R.id.checkBox3);
        checkBox4 = findViewById(R.id.checkBox4);
        checkBox5 = findViewById(R.id.checkBox5);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the new activity here
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent);
            }
        });

        cameraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open camera mode here
                Intent intent = new Intent(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });


        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    text1.setBackgroundColor(Color.parseColor("#AFEEEE")); // paleTurquoise color
                } else {
                    text1.setBackgroundColor(Color.parseColor("#FFFFF0")); // Ivory color
                }
            }
        });

        switch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    text2.setBackgroundColor(Color.parseColor("#AFEEEE")); // paleTurquoise color
                } else {
                    text2.setBackgroundColor(Color.parseColor("#FFFFF0")); // Ivory color
                }
            }
        });

        switch3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    text3.setBackgroundColor(Color.parseColor("#AFEEEE")); // paleTurquoise color
                } else {
                    text3.setBackgroundColor(Color.parseColor("#FFFFF0")); // Ivory color
                }
            }
        });

        checkBox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    text4.setBackgroundColor(Color.parseColor("#AFEEEE")); // paleTurquoise color
                } else {
                    text4.setBackgroundColor(Color.parseColor("#FFFFF0")); // Ivory color
                }
            }
        });

        checkBox4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    text5.setBackgroundColor(Color.parseColor("#AFEEEE")); // paleTurquoise color
                } else {
                    text5.setBackgroundColor(Color.parseColor("#FFFFF0")); // Ivory color
                }
            }
        });

        checkBox5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    text6.setBackgroundColor(Color.parseColor("#AFEEEE")); // paleTurquoise color
                } else {
                    text6.setBackgroundColor(Color.parseColor("#FFFFF0")); // Ivory color
                }
            }
        });
        // Получаем логин из базы данных
        String login = getLoginFromDatabase();

        // Отображаем приветствие в заголовке
        titleText.setText("Добро пожаловать " + login + "!");
    }

    private String getLoginFromDatabase() {
        MyDatabaseHelper databaseHelper = new MyDatabaseHelper(this);
        SQLiteDatabase db = databaseHelper.getReadableDatabase();

        String[] projection = {MyDatabaseHelper.COLUMN_LOGIN};
        Cursor cursor = db.query(
                MyDatabaseHelper.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
        );

        String login = "";

        if (cursor.moveToFirst()) {
            int columnIndex = cursor.getColumnIndex(MyDatabaseHelper.COLUMN_LOGIN);
            if (columnIndex >= 0) {
                login = cursor.getString(columnIndex);
            }
        }

        cursor.close();
        db.close();

        return login;
    }
}