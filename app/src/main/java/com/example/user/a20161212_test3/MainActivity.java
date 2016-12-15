package com.example.user.a20161212_test3;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    boolean login = false;
    public static final int CHECK_OK = 1122;
    String[] func = {"餘額查詢","交易明細","最新消息","投資理財","離開"};
    int[] icon = {R.drawable.func_balance,
            R.drawable.func_exit,
            R.drawable.func_finance,
            R.drawable.func_history,
            R.drawable.func_news};


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        ListView lv = (ListView) findViewById(R.id.listView);
//        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,func);
//        lv.setAdapter(adapter);

//        Spinner spinner = (Spinner) findViewById(R.id.spinner);
//        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(MainActivity.this,R.array.notify_array,android.R.layout.simple_expandable_list_item_1);
//        spinner.setAdapter(adapter);
//
//        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(MainActivity.this,adapter.getItem(position),Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
        GridView gridView = (GridView) findViewById(R.id.gridView);
        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,func);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(this);

        if (login == false){
            Intent it = new Intent(MainActivity.this,LoginActivity.class);
            startActivityForResult(it,CHECK_OK);
        }




    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == CHECK_OK){
            if(resultCode == RESULT_OK){
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


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position){
            case 0:
                break;
        }

    }

    class IconAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return func.length;
        }

        @Override
        public Object getItem(int position) {
            return func[position];
        }

        @Override
        public long getItemId(int position) {
            return icon[position];
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View row = convertView;
            if(row == null){
                row = getLayoutInflater().inflate(R.layout.item_row,null);      //取得Layout物件
                ImageView img = (ImageView) row.findViewById(R.id.item_image);
                TextView tv = (TextView) row.findViewById(R.id.item_text);
                img.setImageResource(icon[position]);
                tv.setText(func[position]);
            }
            return row;
        }
    }
}
