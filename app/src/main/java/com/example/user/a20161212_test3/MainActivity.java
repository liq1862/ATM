package com.example.user.a20161212_test3;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    boolean login = false;
    public static final int CHECK_OK = 1122;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (login == false){
            Intent it = new Intent(MainActivity.this,LoginActivity.class);
            startActivityForResult(it,CHECK_OK);
        }


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == CHECK_OK){
            Log.d("REQ","req");
            if(resultCode == RESULT_OK){
                Log.d("RES","res");
                String uid = data.getStringExtra("username");
                String pw = data.getStringExtra("userpassword");
                AlertDialog.Builder builder =new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("登入成功");
                builder.setPositiveButton("確定",null);
                builder.show();
            }
            else{
                finish();
            }
        }
    }

}
