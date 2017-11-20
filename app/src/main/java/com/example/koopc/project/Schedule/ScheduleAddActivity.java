package com.example.koopc.project.Schedule;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import com.example.koopc.project.DB.FeedReaderDbHelper;
import com.example.koopc.project.R;

import java.util.ArrayList;

public class ScheduleAddActivity extends AppCompatActivity {
    private SQLiteDatabase mDB;
    GridView GridSchedule;
    ScheduleAdapter adapter;
    ArrayList<String> set = new ArrayList<String>();
    int setNum = 0;
    Cursor mCursor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_add);

    }

    @Override
    protected void onStart() {
        super.onStart();
        GridSchedule = (GridView)findViewById(R.id.schedule);

        FeedReaderDbHelper mDbHelper = new FeedReaderDbHelper(this);
        mDB = mDbHelper.getWritableDatabase();
        mDbHelper.onCreate(mDB);
        adapter = new ScheduleAdapter(this);
        mCursor = mDB.rawQuery("SELECT grid, permission  FROM class",null);
        GridSchedule.setAdapter(adapter);
        GridSchedule.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mCursor.moveToFirst();
                String permission = "1";
                if(mCursor !=null){
                    do {
                        if(mCursor.getString(0).equals(String.valueOf(position))){
                            permission = mCursor.getString(1);
                        }
                    }while(mCursor.moveToNext());
                    if(permission.equals("0")){
                        if(set.contains(String.valueOf(position))) {
                            set.remove(String.valueOf(position));
                            TextView tv = (TextView)view;
                            tv.setBackgroundColor(Color.parseColor("#FFFFFF"));
                            setNum = setNum - 1;
                        }else{
                            TextView tv = (TextView)view;
                            tv.setBackgroundColor(Color.parseColor("#BC8F8F"));
                            set.add(String.valueOf(position));
                            setNum = setNum + 1;
                        }
                    }
                }
            }
        });

        findViewById(R.id.cancle_btn).setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ScheduleAddActivity.this, ScheduleActivity.class);
                startActivity(intent);
                finish();
            }
        });
        findViewById(R.id.add_btn).setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentSubActivity = new Intent(ScheduleAddActivity.this,Add_SubjectActivity.class);
                intentSubActivity.putStringArrayListExtra("positionSet",set);
                intentSubActivity.putExtra("setNum",setNum);
                startActivity(intentSubActivity);
                finish();
            }
        });
    }
}
