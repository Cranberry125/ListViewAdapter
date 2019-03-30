package com.example.listviewadapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class XMLMenuActivity extends AppCompatActivity {
    private TextView textview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xmlmenu);
        textview = (TextView) this.findViewById(R.id.textview);
        registerForContextMenu(textview);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.setfontcolor, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.font_10:
                item.setChecked(true);
                textview.setTextSize(10 * 2);
                break;
            case R.id.font_16:
                item.setChecked(true);
                textview.setTextSize(16 * 2);
                break;
            case R.id.font_20:
                item.setChecked(true);
                textview.setTextSize(20 * 2);
                break;
            case R.id.plain_menu:
                Toast.makeText(this, "单击菜单", Toast.LENGTH_LONG).show();
                break;
            case R.id.red_font:
                item.setChecked(true);
               textview.setTextColor(Color.RED);

               //textview.setTextColor(ContextCompat.getColor(this,R.color.colorRed));
               break;
            case R.id.black_font:
                item.setChecked(true);
                textview.setTextColor(Color.BLACK);

                break;
        }
        return true;
    }
}