package com.example.klaus.books;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.BookListActivity);

        TextView txtResult = (TextView)findViewById(R.id.tvResponse);
        try{
            URL bookUrl = ApiUtil.buildUrl("cooking");
            String jsonResult = ApiUtil.getJson(bookUrl);
        }
        catch(Exception e){
            Log.d("error : " , e.getMessage());
        }
    }
}
