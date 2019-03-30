package com.example.listviewadapter;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ActionModeActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private String count[] = new String[]{"One", "Two", "Three", "Four", "Five"};
    private int icons[] = new int[]{R.mipmap.ic_launcher, R.mipmap.ic_launcher,
            R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher};
    private ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_actionmode);
        listview = (ListView) findViewById(R.id.listview);
        List<Map<String, Object>> listitem = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < count.length; i++) {
            Map<String, Object> showitem = new HashMap<String, Object>();
            showitem.put("item_icon", icons[i]);
            showitem.put("item_count", count[i]);
            listitem.add(showitem);
        }
        SimpleAdapter actionAdapter = new SimpleAdapter(
                getApplicationContext(),
                listitem,
                R.layout.item_actionmode,
                new String[]{"item_icon", "item_count"},
                new int[]{R.id.item_icon, R.id.item_count}

        );
        listview.setAdapter(actionAdapter);
        listview.setOnItemClickListener(this);
        this.registerForContextMenu(listview);


    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(1, 1, 1, "删除");

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 1:
                Toast.makeText(ActionModeActivity.this, "点击删除", Toast.LENGTH_SHORT).show();
                break;

        }
        return super.onContextItemSelected(item);
    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        view.setBackgroundColor(getResources().getColor(R.color.colorLightGrayGreen));

    }

}
