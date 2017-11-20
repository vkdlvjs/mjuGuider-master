package com.example.koopc.project.Schedule;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ToggleButton;

import com.example.koopc.project.DB.FeedReaderDbHelper;
import com.example.koopc.project.R;

import java.util.ArrayList;

public class Add_SubjectActivity extends AppCompatActivity {
    private int tb1,tb2,tb3,tb4,tb5,tb6,tb7,tb8,tb9,tb10;
    String classColor = "#febfbf";
    private SQLiteDatabase mDB;
    Cursor mCursor;
    ArrayList<String> set = null;
    int setNum;
    String subjectName = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__subject);
        Intent intent = this.getIntent();

        if(intent.getStringArrayListExtra("positionSet")!=null){
            set = intent.getStringArrayListExtra("positionSet");
        }
        if(intent.getStringExtra("subjectName")!=null){
            subjectName = intent.getStringExtra("subjectName");
        }
        setNum = intent.getIntExtra("setNum",setNum);
        FeedReaderDbHelper mDBHelper = new FeedReaderDbHelper(this);
        mDB = mDBHelper.getWritableDatabase();

        // 닫기 눌렀을 때
        findViewById(R.id.class_add_cancle).setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });


        // 추가 눌렀을 때
        findViewById(R.id.class_add_ok).setOnClickListener( new Button.OnClickListener() {
            public void onClick(View v) {

                String className;
                String classNumber;
                String professor;

                EditText editText1 ;

                editText1 = (EditText)findViewById(R.id.class_add_classname_show);
                className = editText1.getText().toString();

                editText1 = (EditText)findViewById(R.id.class_add_classnumber_show);
                classNumber = editText1.getText().toString();

                editText1 = (EditText)findViewById(R.id.class_add_professor_show) ;
                professor = editText1.getText().toString();

                ContentValues c = new ContentValues();
                c.put("classname",className);
                c.put("location",classNumber);
                c.put("professor",professor);
                c.put("color",classColor);
                c.put("permission","1");
                if(subjectName!=null){
                    mDB.update("class", c, "classname= '" + subjectName.toString()+"'", null);
                }else if( set!=null){
                    for(int i = 0; i < setNum; i++){

                        mDB.update("class" ,c, "grid= '" + set.get(i)+"'", null);
                    }
                }

                finish();
            }
        });

        ((ToggleButton)findViewById(R.id.color_button1)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.color.col1d);
                    classColor = "#febfbf";
                    ((ToggleButton)findViewById(R.id.color_button2)).setBackgroundResource(R.color.col2);
                    ((ToggleButton)findViewById(R.id.color_button3)).setBackgroundResource(R.color.col3);
                    ((ToggleButton)findViewById(R.id.color_button4)).setBackgroundResource(R.color.col4);
                    ((ToggleButton)findViewById(R.id.color_button5)).setBackgroundResource(R.color.col5);
                    ((ToggleButton)findViewById(R.id.color_button6)).setBackgroundResource(R.color.col6);
                    ((ToggleButton)findViewById(R.id.color_button7)).setBackgroundResource(R.color.col7);
                    ((ToggleButton)findViewById(R.id.color_button8)).setBackgroundResource(R.color.col8);
                    ((ToggleButton)findViewById(R.id.color_button9)).setBackgroundResource(R.color.col9);
                    ((ToggleButton)findViewById(R.id.color_button10)).setBackgroundResource(R.color.col10);
                    tb1=0;
                    tb2=1;
                    tb3=1;
                    tb4=1;
                    tb5=1;
                    tb6=1;
                    tb7=1;
                    tb8=1;
                    tb9=1;
                    tb10=1;

                }
                else if(tb1==1)
                {
                    buttonView.setBackgroundResource(R.color.col1d);
                    classColor = "#febfbf";
                    ((ToggleButton)findViewById(R.id.color_button2)).setBackgroundResource(R.color.col2);
                    ((ToggleButton)findViewById(R.id.color_button3)).setBackgroundResource(R.color.col3);
                    ((ToggleButton)findViewById(R.id.color_button4)).setBackgroundResource(R.color.col4);
                    ((ToggleButton)findViewById(R.id.color_button5)).setBackgroundResource(R.color.col5);
                    ((ToggleButton)findViewById(R.id.color_button6)).setBackgroundResource(R.color.col6);
                    ((ToggleButton)findViewById(R.id.color_button7)).setBackgroundResource(R.color.col7);
                    ((ToggleButton)findViewById(R.id.color_button8)).setBackgroundResource(R.color.col8);
                    ((ToggleButton)findViewById(R.id.color_button9)).setBackgroundResource(R.color.col9);
                    ((ToggleButton)findViewById(R.id.color_button10)).setBackgroundResource(R.color.col10);
                    tb1=0;
                    tb2=1;
                    tb3=1;
                    tb4=1;
                    tb5=1;
                    tb6=1;
                    tb7=1;
                    tb8=1;
                    tb9=1;
                    tb10=1;
                }
                else
                {
                    buttonView.setBackgroundResource(R.color.col1);
                    classColor = "#febfbf";
                }
            }
        });


        ((ToggleButton)findViewById(R.id.color_button2)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.color.col2d);
                    classColor = "#fde5c0";
                    ((ToggleButton)findViewById(R.id.color_button1)).setBackgroundResource(R.color.col1);
                    ((ToggleButton)findViewById(R.id.color_button3)).setBackgroundResource(R.color.col3);
                    ((ToggleButton)findViewById(R.id.color_button4)).setBackgroundResource(R.color.col4);
                    ((ToggleButton)findViewById(R.id.color_button5)).setBackgroundResource(R.color.col5);
                    ((ToggleButton)findViewById(R.id.color_button6)).setBackgroundResource(R.color.col6);
                    ((ToggleButton)findViewById(R.id.color_button7)).setBackgroundResource(R.color.col7);
                    ((ToggleButton)findViewById(R.id.color_button8)).setBackgroundResource(R.color.col8);
                    ((ToggleButton)findViewById(R.id.color_button9)).setBackgroundResource(R.color.col9);
                    ((ToggleButton)findViewById(R.id.color_button10)).setBackgroundResource(R.color.col10);
                    tb1=1;
                    tb2=0;
                    tb3=1;
                    tb4=1;
                    tb5=1;
                    tb6=1;
                    tb7=1;
                    tb8=1;
                    tb9=1;
                    tb10=1;

                }
                else if(tb2==1)
                {
                    buttonView.setBackgroundResource(R.color.col2d);
                    classColor = "#fde5c0";
                    ((ToggleButton)findViewById(R.id.color_button1)).setBackgroundResource(R.color.col1);
                    ((ToggleButton)findViewById(R.id.color_button3)).setBackgroundResource(R.color.col3);
                    ((ToggleButton)findViewById(R.id.color_button4)).setBackgroundResource(R.color.col4);
                    ((ToggleButton)findViewById(R.id.color_button5)).setBackgroundResource(R.color.col5);
                    ((ToggleButton)findViewById(R.id.color_button6)).setBackgroundResource(R.color.col6);
                    ((ToggleButton)findViewById(R.id.color_button7)).setBackgroundResource(R.color.col7);
                    ((ToggleButton)findViewById(R.id.color_button8)).setBackgroundResource(R.color.col8);
                    ((ToggleButton)findViewById(R.id.color_button9)).setBackgroundResource(R.color.col9);
                    ((ToggleButton)findViewById(R.id.color_button10)).setBackgroundResource(R.color.col10);
                    tb1=1;
                    tb2=0;
                    tb3=1;
                    tb4=1;
                    tb5=1;
                    tb6=1;
                    tb7=1;
                    tb8=1;
                    tb9=1;
                    tb10=1;
                }  else {
                    buttonView.setBackgroundResource(R.color.col2);
                    classColor = "#fde5c0";
                }
            }
        });

        ((ToggleButton)findViewById(R.id.color_button3)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.color.col3d);
                    classColor = "#effdc0";
                    ((ToggleButton)findViewById(R.id.color_button2)).setBackgroundResource(R.color.col2);
                    ((ToggleButton)findViewById(R.id.color_button1)).setBackgroundResource(R.color.col1);
                    ((ToggleButton)findViewById(R.id.color_button4)).setBackgroundResource(R.color.col4);
                    ((ToggleButton)findViewById(R.id.color_button5)).setBackgroundResource(R.color.col5);
                    ((ToggleButton)findViewById(R.id.color_button6)).setBackgroundResource(R.color.col6);
                    ((ToggleButton)findViewById(R.id.color_button7)).setBackgroundResource(R.color.col7);
                    ((ToggleButton)findViewById(R.id.color_button8)).setBackgroundResource(R.color.col8);
                    ((ToggleButton)findViewById(R.id.color_button9)).setBackgroundResource(R.color.col9);
                    ((ToggleButton)findViewById(R.id.color_button10)).setBackgroundResource(R.color.col10);
                    tb1=1;
                    tb2=1;
                    tb3=0;
                    tb4=1;
                    tb5=1;
                    tb6=1;
                    tb7=1;
                    tb8=1;
                    tb9=1;
                    tb10=1;

                }
                else if(tb3==1)
                {
                    buttonView.setBackgroundResource(R.color.col3d);
                    classColor = "#effdc0";
                    ((ToggleButton)findViewById(R.id.color_button2)).setBackgroundResource(R.color.col2);
                    ((ToggleButton)findViewById(R.id.color_button1)).setBackgroundResource(R.color.col1);
                    ((ToggleButton)findViewById(R.id.color_button4)).setBackgroundResource(R.color.col4);
                    ((ToggleButton)findViewById(R.id.color_button5)).setBackgroundResource(R.color.col5);
                    ((ToggleButton)findViewById(R.id.color_button6)).setBackgroundResource(R.color.col6);
                    ((ToggleButton)findViewById(R.id.color_button7)).setBackgroundResource(R.color.col7);
                    ((ToggleButton)findViewById(R.id.color_button8)).setBackgroundResource(R.color.col8);
                    ((ToggleButton)findViewById(R.id.color_button9)).setBackgroundResource(R.color.col9);
                    ((ToggleButton)findViewById(R.id.color_button10)).setBackgroundResource(R.color.col10);
                    tb1=1;
                    tb2=1;
                    tb3=0;
                    tb4=1;
                    tb5=1;
                    tb6=1;
                    tb7=1;
                    tb8=1;
                    tb9=1;
                    tb10=1;
                }  else {
                    buttonView.setBackgroundResource(R.color.col3);
                    classColor = "#effdc0";
                }
            }
        });

        ((ToggleButton)findViewById(R.id.color_button4)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.color.col4d);
                    classColor = "#cafdc0";
                    ((ToggleButton)findViewById(R.id.color_button2)).setBackgroundResource(R.color.col2);
                    ((ToggleButton)findViewById(R.id.color_button3)).setBackgroundResource(R.color.col3);
                    ((ToggleButton)findViewById(R.id.color_button1)).setBackgroundResource(R.color.col1);
                    ((ToggleButton)findViewById(R.id.color_button5)).setBackgroundResource(R.color.col5);
                    ((ToggleButton)findViewById(R.id.color_button6)).setBackgroundResource(R.color.col6);
                    ((ToggleButton)findViewById(R.id.color_button7)).setBackgroundResource(R.color.col7);
                    ((ToggleButton)findViewById(R.id.color_button8)).setBackgroundResource(R.color.col8);
                    ((ToggleButton)findViewById(R.id.color_button9)).setBackgroundResource(R.color.col9);
                    ((ToggleButton)findViewById(R.id.color_button10)).setBackgroundResource(R.color.col10);
                    tb1=1;
                    tb2=1;
                    tb3=1;
                    tb4=0;
                    tb5=1;
                    tb6=1;
                    tb7=1;
                    tb8=1;
                    tb9=1;
                    tb10=1;

                }
                else if(tb4==1)
                {
                    buttonView.setBackgroundResource(R.color.col4d);
                    classColor = "#cafdc0";
                    ((ToggleButton)findViewById(R.id.color_button2)).setBackgroundResource(R.color.col2);
                    ((ToggleButton)findViewById(R.id.color_button3)).setBackgroundResource(R.color.col3);
                    ((ToggleButton)findViewById(R.id.color_button1)).setBackgroundResource(R.color.col1);
                    ((ToggleButton)findViewById(R.id.color_button5)).setBackgroundResource(R.color.col5);
                    ((ToggleButton)findViewById(R.id.color_button6)).setBackgroundResource(R.color.col6);
                    ((ToggleButton)findViewById(R.id.color_button7)).setBackgroundResource(R.color.col7);
                    ((ToggleButton)findViewById(R.id.color_button8)).setBackgroundResource(R.color.col8);
                    ((ToggleButton)findViewById(R.id.color_button9)).setBackgroundResource(R.color.col9);
                    ((ToggleButton)findViewById(R.id.color_button10)).setBackgroundResource(R.color.col10);
                    tb1=1;
                    tb2=1;
                    tb3=1;
                    tb4=0;
                    tb5=1;
                    tb6=1;
                    tb7=1;
                    tb8=1;
                    tb9=1;
                    tb10=1;
                } else {
                    buttonView.setBackgroundResource(R.color.col4);
                    classColor = "#cafdc0";
                }
            }
        });

        ((ToggleButton)findViewById(R.id.color_button5)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.color.col5d);
                    classColor = "#bffdd7";
                    ((ToggleButton)findViewById(R.id.color_button2)).setBackgroundResource(R.color.col2);
                    ((ToggleButton)findViewById(R.id.color_button3)).setBackgroundResource(R.color.col3);
                    ((ToggleButton)findViewById(R.id.color_button4)).setBackgroundResource(R.color.col4);
                    ((ToggleButton)findViewById(R.id.color_button1)).setBackgroundResource(R.color.col1);
                    ((ToggleButton)findViewById(R.id.color_button6)).setBackgroundResource(R.color.col6);
                    ((ToggleButton)findViewById(R.id.color_button7)).setBackgroundResource(R.color.col7);
                    ((ToggleButton)findViewById(R.id.color_button8)).setBackgroundResource(R.color.col8);
                    ((ToggleButton)findViewById(R.id.color_button9)).setBackgroundResource(R.color.col9);
                    ((ToggleButton)findViewById(R.id.color_button10)).setBackgroundResource(R.color.col10);
                    tb1=1;
                    tb2=1;
                    tb3=1;
                    tb4=1;
                    tb5=0;
                    tb6=1;
                    tb7=1;
                    tb8=1;
                    tb9=1;
                    tb10=1;

                }
                else if(tb5==1)
                {
                    buttonView.setBackgroundResource(R.color.col5d);
                    classColor = "#bffdd7";
                    ((ToggleButton)findViewById(R.id.color_button2)).setBackgroundResource(R.color.col2);
                    ((ToggleButton)findViewById(R.id.color_button3)).setBackgroundResource(R.color.col3);
                    ((ToggleButton)findViewById(R.id.color_button4)).setBackgroundResource(R.color.col4);
                    ((ToggleButton)findViewById(R.id.color_button1)).setBackgroundResource(R.color.col1);
                    ((ToggleButton)findViewById(R.id.color_button6)).setBackgroundResource(R.color.col6);
                    ((ToggleButton)findViewById(R.id.color_button7)).setBackgroundResource(R.color.col7);
                    ((ToggleButton)findViewById(R.id.color_button8)).setBackgroundResource(R.color.col8);
                    ((ToggleButton)findViewById(R.id.color_button9)).setBackgroundResource(R.color.col9);
                    ((ToggleButton)findViewById(R.id.color_button10)).setBackgroundResource(R.color.col10);
                    tb1=1;
                    tb2=1;
                    tb3=1;
                    tb4=1;
                    tb5=0;
                    tb6=1;
                    tb7=1;
                    tb8=1;
                    tb9=1;
                    tb10=1;
                }  else {
                    buttonView.setBackgroundResource(R.color.col5);
                    classColor = "#bffdd7";
                }
            }
        });

        ((ToggleButton)findViewById(R.id.color_button6)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.color.col6d);
                    classColor = "#bffbfc";
                    ((ToggleButton)findViewById(R.id.color_button2)).setBackgroundResource(R.color.col2);
                    ((ToggleButton)findViewById(R.id.color_button3)).setBackgroundResource(R.color.col3);
                    ((ToggleButton)findViewById(R.id.color_button4)).setBackgroundResource(R.color.col4);
                    ((ToggleButton)findViewById(R.id.color_button5)).setBackgroundResource(R.color.col5);
                    ((ToggleButton)findViewById(R.id.color_button1)).setBackgroundResource(R.color.col1);
                    ((ToggleButton)findViewById(R.id.color_button7)).setBackgroundResource(R.color.col7);
                    ((ToggleButton)findViewById(R.id.color_button8)).setBackgroundResource(R.color.col8);
                    ((ToggleButton)findViewById(R.id.color_button9)).setBackgroundResource(R.color.col9);
                    ((ToggleButton)findViewById(R.id.color_button10)).setBackgroundResource(R.color.col10);
                    tb1=1;
                    tb2=1;
                    tb3=1;
                    tb4=1;
                    tb5=1;
                    tb6=0;
                    tb7=1;
                    tb8=1;
                    tb9=1;
                    tb10=1;

                }
                else if(tb6==1)
                {
                    buttonView.setBackgroundResource(R.color.col6d);
                    classColor = "#bffbfc";
                    ((ToggleButton)findViewById(R.id.color_button2)).setBackgroundResource(R.color.col2);
                    ((ToggleButton)findViewById(R.id.color_button3)).setBackgroundResource(R.color.col3);
                    ((ToggleButton)findViewById(R.id.color_button4)).setBackgroundResource(R.color.col4);
                    ((ToggleButton)findViewById(R.id.color_button5)).setBackgroundResource(R.color.col5);
                    ((ToggleButton)findViewById(R.id.color_button1)).setBackgroundResource(R.color.col1);
                    ((ToggleButton)findViewById(R.id.color_button7)).setBackgroundResource(R.color.col7);
                    ((ToggleButton)findViewById(R.id.color_button8)).setBackgroundResource(R.color.col8);
                    ((ToggleButton)findViewById(R.id.color_button9)).setBackgroundResource(R.color.col9);
                    ((ToggleButton)findViewById(R.id.color_button10)).setBackgroundResource(R.color.col10);
                    tb1=1;
                    tb2=1;
                    tb3=1;
                    tb4=1;
                    tb5=1;
                    tb6=0;
                    tb7=1;
                    tb8=1;
                    tb9=1;
                    tb10=1;
                }  else {
                    buttonView.setBackgroundResource(R.color.col6);
                    classColor = "#bffbfc";
                }
            }
        });

        ((ToggleButton)findViewById(R.id.color_button7)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.color.col7d);
                    classColor = "#bfd5fc";
                    ((ToggleButton)findViewById(R.id.color_button2)).setBackgroundResource(R.color.col2);
                    ((ToggleButton)findViewById(R.id.color_button3)).setBackgroundResource(R.color.col3);
                    ((ToggleButton)findViewById(R.id.color_button4)).setBackgroundResource(R.color.col4);
                    ((ToggleButton)findViewById(R.id.color_button5)).setBackgroundResource(R.color.col5);
                    ((ToggleButton)findViewById(R.id.color_button6)).setBackgroundResource(R.color.col6);
                    ((ToggleButton)findViewById(R.id.color_button1)).setBackgroundResource(R.color.col1);
                    ((ToggleButton)findViewById(R.id.color_button8)).setBackgroundResource(R.color.col8);
                    ((ToggleButton)findViewById(R.id.color_button9)).setBackgroundResource(R.color.col9);
                    ((ToggleButton)findViewById(R.id.color_button10)).setBackgroundResource(R.color.col10);
                    tb1=1;
                    tb2=1;
                    tb3=1;
                    tb4=1;
                    tb5=1;
                    tb6=1;
                    tb7=0;
                    tb8=1;
                    tb9=1;
                    tb10=1;

                }
                else if(tb7==1)
                {
                    buttonView.setBackgroundResource(R.color.col7d);
                    classColor = "#bfd5fc";
                    ((ToggleButton)findViewById(R.id.color_button2)).setBackgroundResource(R.color.col2);
                    ((ToggleButton)findViewById(R.id.color_button3)).setBackgroundResource(R.color.col3);
                    ((ToggleButton)findViewById(R.id.color_button4)).setBackgroundResource(R.color.col4);
                    ((ToggleButton)findViewById(R.id.color_button5)).setBackgroundResource(R.color.col5);
                    ((ToggleButton)findViewById(R.id.color_button6)).setBackgroundResource(R.color.col6);
                    ((ToggleButton)findViewById(R.id.color_button1)).setBackgroundResource(R.color.col1);
                    ((ToggleButton)findViewById(R.id.color_button8)).setBackgroundResource(R.color.col8);
                    ((ToggleButton)findViewById(R.id.color_button9)).setBackgroundResource(R.color.col9);
                    ((ToggleButton)findViewById(R.id.color_button10)).setBackgroundResource(R.color.col10);
                    tb1=1;
                    tb2=1;
                    tb3=1;
                    tb4=1;
                    tb5=1;
                    tb6=1;
                    tb7=0;
                    tb8=1;
                    tb9=1;
                    tb10=1;
                }  else {
                    buttonView.setBackgroundResource(R.color.col7);
                    classColor = "#bfd5fc";
                }
            }
        });

        ((ToggleButton)findViewById(R.id.color_button8)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.color.col8d);
                    classColor = "#cabffc";
                    ((ToggleButton)findViewById(R.id.color_button2)).setBackgroundResource(R.color.col2);
                    ((ToggleButton)findViewById(R.id.color_button3)).setBackgroundResource(R.color.col3);
                    ((ToggleButton)findViewById(R.id.color_button4)).setBackgroundResource(R.color.col4);
                    ((ToggleButton)findViewById(R.id.color_button5)).setBackgroundResource(R.color.col5);
                    ((ToggleButton)findViewById(R.id.color_button6)).setBackgroundResource(R.color.col6);
                    ((ToggleButton)findViewById(R.id.color_button7)).setBackgroundResource(R.color.col7);
                    ((ToggleButton)findViewById(R.id.color_button1)).setBackgroundResource(R.color.col1);
                    ((ToggleButton)findViewById(R.id.color_button9)).setBackgroundResource(R.color.col9);
                    ((ToggleButton)findViewById(R.id.color_button10)).setBackgroundResource(R.color.col10);
                    tb1=1;
                    tb2=1;
                    tb3=1;
                    tb4=1;
                    tb5=1;
                    tb6=1;
                    tb7=1;
                    tb8=0;
                    tb9=1;
                    tb10=1;

                }
                else if(tb8==1)
                {
                    buttonView.setBackgroundResource(R.color.col8d);
                    classColor = "#cabffc";
                    ((ToggleButton)findViewById(R.id.color_button2)).setBackgroundResource(R.color.col2);
                    ((ToggleButton)findViewById(R.id.color_button3)).setBackgroundResource(R.color.col3);
                    ((ToggleButton)findViewById(R.id.color_button4)).setBackgroundResource(R.color.col4);
                    ((ToggleButton)findViewById(R.id.color_button5)).setBackgroundResource(R.color.col5);
                    ((ToggleButton)findViewById(R.id.color_button6)).setBackgroundResource(R.color.col6);
                    ((ToggleButton)findViewById(R.id.color_button7)).setBackgroundResource(R.color.col7);
                    ((ToggleButton)findViewById(R.id.color_button1)).setBackgroundResource(R.color.col1);
                    ((ToggleButton)findViewById(R.id.color_button9)).setBackgroundResource(R.color.col9);
                    ((ToggleButton)findViewById(R.id.color_button10)).setBackgroundResource(R.color.col10);
                    tb1=1;
                    tb2=1;
                    tb3=1;
                    tb4=1;
                    tb5=1;
                    tb6=1;
                    tb7=1;
                    tb8=0;
                    tb9=1;
                    tb10=1;
                }  else {
                    buttonView.setBackgroundResource(R.color.col8);
                    classColor = "#cabffc";
                }
            }
        });

        ((ToggleButton)findViewById(R.id.color_button9)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.color.col9d);
                    classColor = "#f1bffc";
                    ((ToggleButton)findViewById(R.id.color_button2)).setBackgroundResource(R.color.col2);
                    ((ToggleButton)findViewById(R.id.color_button3)).setBackgroundResource(R.color.col3);
                    ((ToggleButton)findViewById(R.id.color_button4)).setBackgroundResource(R.color.col4);
                    ((ToggleButton)findViewById(R.id.color_button5)).setBackgroundResource(R.color.col5);
                    ((ToggleButton)findViewById(R.id.color_button6)).setBackgroundResource(R.color.col6);
                    ((ToggleButton)findViewById(R.id.color_button7)).setBackgroundResource(R.color.col7);
                    ((ToggleButton)findViewById(R.id.color_button8)).setBackgroundResource(R.color.col8);
                    ((ToggleButton)findViewById(R.id.color_button1)).setBackgroundResource(R.color.col1);
                    ((ToggleButton)findViewById(R.id.color_button10)).setBackgroundResource(R.color.col10);
                    tb1=1;
                    tb2=1;
                    tb3=1;
                    tb4=1;
                    tb5=1;
                    tb6=1;
                    tb7=1;
                    tb8=1;
                    tb9=9;
                    tb10=1;

                }
                else if(tb9==1)
                {
                    buttonView.setBackgroundResource(R.color.col9d);
                    classColor = "#f1bffc";
                    ((ToggleButton)findViewById(R.id.color_button2)).setBackgroundResource(R.color.col2);
                    ((ToggleButton)findViewById(R.id.color_button3)).setBackgroundResource(R.color.col3);
                    ((ToggleButton)findViewById(R.id.color_button4)).setBackgroundResource(R.color.col4);
                    ((ToggleButton)findViewById(R.id.color_button5)).setBackgroundResource(R.color.col5);
                    ((ToggleButton)findViewById(R.id.color_button6)).setBackgroundResource(R.color.col6);
                    ((ToggleButton)findViewById(R.id.color_button7)).setBackgroundResource(R.color.col7);
                    ((ToggleButton)findViewById(R.id.color_button8)).setBackgroundResource(R.color.col8);
                    ((ToggleButton)findViewById(R.id.color_button1)).setBackgroundResource(R.color.col1);
                    ((ToggleButton)findViewById(R.id.color_button10)).setBackgroundResource(R.color.col10);
                    tb1=1;
                    tb2=1;
                    tb3=1;
                    tb4=1;
                    tb5=1;
                    tb6=1;
                    tb7=1;
                    tb8=1;
                    tb9=0;
                    tb10=1;
                }  else {
                    buttonView.setBackgroundResource(R.color.col9);
                    classColor = "#f1bffc";
                }
            }
        });

        ((ToggleButton)findViewById(R.id.color_button10)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundResource(R.color.col10d);
                    classColor = "#fcbfe3";
                    ((ToggleButton)findViewById(R.id.color_button2)).setBackgroundResource(R.color.col2);
                    ((ToggleButton)findViewById(R.id.color_button3)).setBackgroundResource(R.color.col3);
                    ((ToggleButton)findViewById(R.id.color_button4)).setBackgroundResource(R.color.col4);
                    ((ToggleButton)findViewById(R.id.color_button5)).setBackgroundResource(R.color.col5);
                    ((ToggleButton)findViewById(R.id.color_button6)).setBackgroundResource(R.color.col6);
                    ((ToggleButton)findViewById(R.id.color_button7)).setBackgroundResource(R.color.col7);
                    ((ToggleButton)findViewById(R.id.color_button8)).setBackgroundResource(R.color.col8);
                    ((ToggleButton)findViewById(R.id.color_button9)).setBackgroundResource(R.color.col9);
                    ((ToggleButton)findViewById(R.id.color_button1)).setBackgroundResource(R.color.col1);
                    tb1=1;
                    tb2=1;
                    tb3=1;
                    tb4=1;
                    tb5=1;
                    tb6=1;
                    tb7=1;
                    tb8=1;
                    tb9=1;
                    tb10=0;

                }
                else if(tb10==1)
                {
                    buttonView.setBackgroundResource(R.color.col10d);
                    classColor = "#fcbfe3";
                    ((ToggleButton)findViewById(R.id.color_button2)).setBackgroundResource(R.color.col2);
                    ((ToggleButton)findViewById(R.id.color_button3)).setBackgroundResource(R.color.col3);
                    ((ToggleButton)findViewById(R.id.color_button4)).setBackgroundResource(R.color.col4);
                    ((ToggleButton)findViewById(R.id.color_button5)).setBackgroundResource(R.color.col5);
                    ((ToggleButton)findViewById(R.id.color_button6)).setBackgroundResource(R.color.col6);
                    ((ToggleButton)findViewById(R.id.color_button7)).setBackgroundResource(R.color.col7);
                    ((ToggleButton)findViewById(R.id.color_button8)).setBackgroundResource(R.color.col8);
                    ((ToggleButton)findViewById(R.id.color_button9)).setBackgroundResource(R.color.col9);
                    ((ToggleButton)findViewById(R.id.color_button1)).setBackgroundResource(R.color.col1);
                    tb1=1;
                    tb2=1;
                    tb3=1;
                    tb4=1;
                    tb5=1;
                    tb6=1;
                    tb7=1;
                    tb8=1;
                    tb9=1;
                    tb10=0;
                }  else {
                    buttonView.setBackgroundResource(R.color.col10);
                    classColor = "#fcbfe3";
                }
            }
        });
    }
}
