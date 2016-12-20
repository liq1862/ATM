package com.example.user.a20161212_test3;

import android.content.ContentValues;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;



public class AddActivity extends AppCompatActivity {
    private EditText edDate;
    private EditText edInfo;
    private EditText edAmount;
    private MyDBHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        findView();
        helper = MyDBHelper.getInstence(this);
    }

    private void findView() {
        edDate = (EditText) findViewById(R.id.ed_date);
        edInfo = (EditText) findViewById(R.id.ed_info);
        edAmount = (EditText) findViewById(R.id.ed_amount);
    }

    public void add(View v){
        String cdate = edDate.getText().toString();
        String cinfo = edInfo.getText().toString();
        int amount = Integer.parseInt(edAmount.getText().toString());
        ContentValues contentValues = new ContentValues();
        contentValues.put("cdate",cdate);
        contentValues.put("info",cinfo);
        contentValues.put("amount",amount);

        long id = helper.getWritableDatabase().insert("exp",null,contentValues);

        Log.d("ADD",id+"");
    }
}
