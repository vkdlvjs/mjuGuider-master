package com.example.koopc.project.Schedule;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.koopc.project.DB.FeedReaderDbHelper;
import com.example.koopc.project.R;

public class ScheduleActivity extends AppCompatActivity {
    private SQLiteDatabase mDB;
    GridView GridSchedule;
    ScheduleAdapter adapter;
    int pos;
    Intent intent;
    private Cursor mCursor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.schedule_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId() ) {
            case R.id.addSubject:
                Intent intent = new Intent(ScheduleActivity.this, ScheduleAddActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        GridSchedule = (GridView)findViewById(R.id.schedule);

        intent = new Intent(this, ScheduleAddActivity.class);
        FeedReaderDbHelper mDbHelper = new FeedReaderDbHelper(this);
        mDB = mDbHelper.getWritableDatabase();
        mDbHelper.onCreate(mDB);
        adapter = new ScheduleAdapter(this);
        GridSchedule.setAdapter(adapter);
        mCursor = mDB.rawQuery("SELECT grid, permission  FROM class",null);
        GridSchedule.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                mCursor.moveToFirst();
                String permission = "1";
                if(mCursor !=null) {
                    do {
                        if (mCursor.getString(0).equals(String.valueOf(position))) {
                            permission = mCursor.getString(1);
                        }
                    } while (mCursor.moveToNext());
                }
                if(permission.equals("1")) {
                    Intent intent = new Intent(ScheduleActivity.this, ScheduleUpdateActivity.class);
                    intent.putExtra("gridPos", position);
                    startActivity(intent);
                }
                return true;}
        });
    }
}
