package com.example.user.a20161212_test3;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    TextView name, passw;
    EditText username, userpassw;
    Button chk;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        sharedPreferences =getSharedPreferences("atm",MODE_PRIVATE);
        findView();

        username.setText(sharedPreferences.getString("uid",""));

        chk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strusername = username.getText().toString();
                String struserpassw = userpassw.getText().toString();

                if(strusername.equals("iii") && struserpassw.equals("1111")){
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("uid",strusername);
                    editor.commit();

                    Toast.makeText(LoginActivity.this,"登入成功",Toast.LENGTH_LONG).show();
                    getIntent().putExtra("username",strusername);
                    getIntent().putExtra("userpassword",struserpassw);
                    setResult(RESULT_OK,getIntent());
                    finish();
                }
                else{
                    Toast.makeText(LoginActivity.this,"登入失敗",Toast.LENGTH_LONG).show();
                }
            }
        });


    }

    private void findView() {
        name = (TextView) findViewById(R.id.textView2);
        passw = (TextView) findViewById(R.id.textView3);
        username = (EditText) findViewById(R.id.editText);
        userpassw = (EditText) findViewById(R.id.editText2);
        chk = (Button) findViewById(R.id.button);
    }
}
