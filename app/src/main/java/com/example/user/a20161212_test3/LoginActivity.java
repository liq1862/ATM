package com.example.user.a20161212_test3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    TextView name, passw;
    EditText usernmae, userpassw;
    Button chk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        findView();

        chk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strusername = usernmae.getText().toString();
                String struserpassw = userpassw.getText().toString();

                if(strusername.equals("iii") && struserpassw.equals("1111")){
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
        usernmae = (EditText) findViewById(R.id.editText);
        userpassw = (EditText) findViewById(R.id.editText2);
        chk = (Button) findViewById(R.id.button);
    }
}
