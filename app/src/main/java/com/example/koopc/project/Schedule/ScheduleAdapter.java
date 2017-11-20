package com.example.koopc.project.Schedule;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import com.example.koopc.project.DB.FeedReaderDbHelper;
import com.example.koopc.project.R;

/**
 * Created by vkdlv on 2017-11-20.
 */

public class ScheduleAdapter extends BaseAdapter {
    private SQLiteDatabase mDB;
    Cursor mCursor;
    Context mContext;
    int count = 54;
    int flag = 0;
    int timeflag = 0;

    String[] mWeekTitleIds ={
            "시간",
            "월",
            "화",
            "수",
            "목",
            "금"
    };
    String[] mTimeTitle=
            {
                    "1교시(9:00~ 9:50)",
                    "2교시(10:00~ 10:50)",
                    "3교시(11:00~ 11:50)",
                    "4교시(12:00~ 12:50)",
                    "5교시(13:00~ 13:50)",
                    "6교시(14:00~ 14:50)",
                    "7교시(15:00~ 15:50)",
                    "8교시(16:00~ 16:50)"
            };
    int[] colors =
            {
                    R.color.color0,
                    R.color.color1,
                    R.color.color2,
                    R.color.color3,
                    R.color.color4,
                    R.color.color5,
                    R.color.color6,
                    R.color.color7
            };
    ScheduleAdapter (Context context){
        mContext = context;
        FeedReaderDbHelper mDBHelper = new FeedReaderDbHelper(context);
        mDB = mDBHelper.getWritableDatabase();
        mDBHelper.onCreate(mDB);
        mCursor = mDB.rawQuery("SELECT * FROM class",null);

        if(mCursor.moveToFirst()) flag = 1;
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = null;

        if(convertView == null)
        {
            v = new TextView(mContext);
            v.setPadding(5,5,5,5);
            v.setBackgroundColor(Color.GRAY);
            v.setLayoutParams(new GridView.LayoutParams( 60,60 ));

        }else{
            if (position < 6) {
                v = new TextView(mContext);
                v.setPadding(5,5,5,5);
                ((TextView)v).setGravity(Gravity.CENTER);
                ((TextView)v).setText(mWeekTitleIds[position]);
                v.setBackgroundColor(Color.parseColor("#bfd5fc"));
                ((TextView) v).setHeight(250);
            }
            else if (position >= 6 && position < count && position % 6 != 0 ) {
                if(mCursor !=null){
                    if(flag == 1){
                        String s  = "";
                        v = new TextView(mContext);
                        ((TextView) v).setHeight(250);
                        ((TextView)v).setGravity(Gravity.CENTER);


                        s = s + mCursor.getString(2) ;
                        v.setBackgroundColor(Color.parseColor(mCursor.getString(5)));
                        ((TextView) v).setText(s);
                        if(mCursor.moveToNext()){
                            flag = 1;
                        }else flag = 0;
                    }else { // db 없으면 생성함.
                        v = new TextView(mContext);
                        ((TextView)v).setGravity(Gravity.CENTER);
                        ContentValues c = new ContentValues();
                        c.put("grid", position);
                        c.put("classname"," ");
                        c.put("location"," ");
                        c.put("color","#FFFFFF");
                        c.put("permission","0");
                        mDB.insert("class",null,c);
                        ((TextView)v).setText(" " );
                        v.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        ((TextView) v).setHeight(250);
                    }
                }
            }else if (position >= 6 && position < count && position % 6 == 0 ) {

                v = new TextView(mContext);
                v.setPadding(5,5,5,5);
                ((TextView)v).setGravity(Gravity.CENTER);
                ((TextView)v).setText(mTimeTitle[timeflag]);
                ((TextView)v).setBackgroundColor(Color.parseColor("#fcbfe3"));
                ((TextView) v).setHeight(250);
                if(timeflag < 7) {
                    timeflag = timeflag + 1;
                }

            }else {
                v = convertView;
            }
        }
        return v;
    }
}
