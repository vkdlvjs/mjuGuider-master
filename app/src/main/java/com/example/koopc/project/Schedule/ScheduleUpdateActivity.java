package com.example.koopc.project.Schedule;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.koopc.project.DB.FeedReaderDbHelper;
import com.example.koopc.project.R;

import java.util.ArrayList;

public class ScheduleUpdateActivity extends AppCompatActivity {
    private SQLiteDatabase mDB;
    Cursor mCursor;
    ArrayList<String> set = new ArrayList<String>();
    String subjectName;
    int pos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_update);

        Intent intent = getIntent();
        pos = intent.getIntExtra("gridPos",pos);
        set.add(String.valueOf(pos));

    }

    @Override
    protected void onStart() {
        super.onStart();
        FeedReaderDbHelper mDBHelper = new FeedReaderDbHelper(this);
        mDB = mDBHelper.getWritableDatabase();
        mDBHelper.onCreate(mDB);
        mCursor = mDB.rawQuery("SELECT * FROM class WHERE grid="+pos+";",null);
        mCursor.moveToFirst();
        TextView tv;
        tv = (TextView)findViewById(R.id.info_subject_show);
        tv.setText(mCursor.getString(2));
        subjectName = tv.getText().toString();
        tv = (TextView)findViewById(R.id.info_professor_show);
        tv.setText(mCursor.getString(4));
        tv = (TextView)findViewById(R.id.info_classroom_show);
        tv.setText(mCursor.getString(3));

        findViewById(R.id.info_close).setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        findViewById(R.id.info_edit).setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ScheduleUpdateActivity.this, Add_SubjectActivity.class);

                intent.putExtra("subjectName",subjectName);
                intent.putExtra("setNum",1);
                startActivity(intent);
                finish();
            }
        });
        findViewById(R.id.info_delete).setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (subjectName.equals(" ")){
                    finish();
                }else{
                    ContentValues c = new ContentValues();
                    c.put("classname"," ");
                    c.put("professor"," ");
                    c.put("color", "#FFFFFF");
                    c.put("location"," ");
                    c.put("permission", "0");
                    mDB.update("class", c, "classname= '" + subjectName.toString()+"'", null);
                    finish();
                }

            }
        });
    }
}
