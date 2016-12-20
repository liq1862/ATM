package com.example.user.a20161212_test3;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class FinanceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finance);
        setTitle("投資理財");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ListView listView = (ListView) findViewById(R.id.listView);

        MyDBHelper helper = new MyDBHelper(this,"expence.db",null,1);

        Cursor cursor = helper.getReadableDatabase().query("exp",null,null,null,null,null,null);

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,android.R.layout.simple_list_item_2,cursor,
                new String[] {"info","amount"},
                new int[] {android.R.id.text1, android.R.id.text2},0);
        listView.setAdapter(adapter);



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(FinanceActivity.this,AddActivity.class);
                startActivity(it);
            }
        });
    }

}
