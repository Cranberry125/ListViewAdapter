package com.example.listviewadapter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

public class SimpleAdapterActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private String[] animals=new String[]{"Lion","Tiger","Monkey","Dog","Cat","Elephant"};
    private int[] images=new int[]{R.drawable.lion,R.drawable.tiger,R.drawable.monkey,
            R.drawable.dog,R.drawable.cat,R.drawable.elephant};
    private ListView listview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_item_main);
        List<Map<String, Object>> listitem = new ArrayList<Map<String, Object>>();
        for(int i=0;i<animals.length;i++){
            Map<String, Object> showitem=new HashMap<String,Object>();
            showitem.put("item_text",animals[i]);
            showitem.put("item_image",images[i]);
            listitem.add(showitem);
        }
        SimpleAdapter myAdapter=new SimpleAdapter(
                getApplicationContext(),
                listitem,
                R.layout.list_item,
                new String[]{"item_text","item_image"},
                new int[]{R.id.item_text,R.id.item_image}
        );
        listview=(ListView) findViewById(R.id.lv);
        listview.setAdapter(myAdapter);
        listview.setOnItemClickListener(this);
    }
    @Override
    public void onItemClick(AdapterView<?>parent, View view, int position, long id) {
        String text=(String) ((TextView)view.findViewById(R.id.item_text)).getText();
        view.setBackgroundColor(getResources().getColor(R.color.backgroundColor));
        Toast.makeText(this,text,Toast.LENGTH_SHORT).show();
    }

}

