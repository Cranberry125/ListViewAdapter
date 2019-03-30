# ListViewAdapter


## 用于跳转的主页面：</br>


![主页面](https://i.loli.net/2019/03/30/5c9f75413748b.jpg)</br>


# 第一题SimpleAdapter</br>


```
==============================================SimpleAdapterActivity.java==============================================


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

============================================list_item-main.xml===========================================================

<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".SimpleAdapterActivity">

    <ListView
        android:id="@+id/lv"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_margin="5dp"
        android:divider="#d9d9d9"
        android:dividerHeight="1dp"
        >
    </ListView>
</RelativeLayout>

==============================================list_item.xml=============================================================

<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@color/colorPrimary"
    >
       <TextView
           android:id="@+id/item_text"
           android:layout_width="wrap_content"
           android:layout_height="wrap_content"
           android:textSize="18sp"
           android:layout_weight="1"
           android:layout_gravity="left"
           />
    <ImageView
        android:id="@+id/item_image"
        android:layout_width="48dp"
        android:layout_height="48dp"
        android:layout_margin="8dp"
        android:layout_gravity="right"
        android:baselineAlignBottom="true"
        />

</LinearLayout>


```

![动物头像](https://i.loli.net/2019/03/30/5c9f754e53acc.jpg)





# 第二题  AlertDialog弹出对话框</br>
```
=============================================AlertDialogActivity.java================================================


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


==============================================AlertDialog.java========================================================
public class AlertDialog extends Dialog {
    private String dialogname;
    private TextView textview;
    private EditText editusername;
    private EditText editpassword;
    private Button btncancle;
    private Button btnsignin;
    private int image=R.drawable.header_logo;

    public AlertDialog(Context context, String dialogname){
        super(context);
        this.dialogname=dialogname;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.alert_dialog);
        editusername=(EditText)findViewById(R.id.enditusername);
        editpassword=(EditText)findViewById(R.id.editpassword);
        btnsignin=(Button) findViewById(R.id.btn_signin);
        btncancle=(Button) findViewById(R.id.btn_cancle);
        btnsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btncancle.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                dismiss();
            }

        });


    }
}

=====================================================alert_dialog.xml======================================================

<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:id="@+id/alertlayout"
    >

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_alignParentEnd="true"
        android:layout_alignParentRight="true"
        android:layout_gravity="center"
        android:layout_marginEnd="0dp"
        android:layout_marginRight="0dp"
        android:background="#FFFAF0"
        android:orientation="vertical"
        >


        <ImageView
            android:id="@+id/header_image"
            android:layout_width="300dp"
            android:layout_height="40dp"
            android:layout_gravity="center"
            android:layout_margin="0dp"
            android:background="@drawable/header_logo"
            android:baselineAlignBottom="true" />

        <LinearLayout
            android:id="@+id/ll_edit"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:orientation="vertical"
           >

            <EditText
                android:id="@+id/enditusername"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:hint="Username"
                android:textSize="25sp"
                android:textStyle="italic" />

            <EditText
                android:id="@+id/editpassword"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:hint="Password"
                android:textSize="25sp"
                android:textStyle="italic" />
        </LinearLayout>
        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="50dp"
            android:orientation="horizontal">
            <Button
                android:id="@+id/btn_cancle"
                android:layout_width="150dp"
                android:layout_height="wrap_content"
                android:text="Cancle" />
            <Button
                android:id="@+id/btn_signin"
                android:layout_width="160dp"
                android:layout_height="wrap_content"
                android:text="Sign in" />
        </LinearLayout>


    </LinearLayout>


</RelativeLayout>


```

![弹出对话框](https://i.loli.net/2019/03/30/5c9f7695793ae.jpg)




# 第三题 XML自定义菜单</br>
```
=========================================XMLMenuActivity.java==========================================================

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

=================================================xmlmenu.xml================================================================
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".XMLMenuActivity"
    >
    <TextView
        android:id="@+id/textview"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:hint="hello world"/>

</LinearLayout>


```

![菜单改变文本字体颜色页面1](https://i.loli.net/2019/03/30/5c9f7559ce9ba.jpg)</br>
![菜单改变文本字体颜色页面2](https://i.loli.net/2019/03/30/5c9f7563d3a8d.jpg)</br>




# 第四题  ActionMode上下文菜单</br>
```
=========================================ActionModeActivity.java=====================================

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
==============================================listview_actionmode.xml===============================================

<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical">

    <ListView
        android:id="@+id/listview"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_margin="5dp"
        android:divider="#d9d9d9"
        android:dividerHeight="1dp"></ListView>

</LinearLayout>

============================================item_actionmode.xml================================================
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:id="@+id/layoutColor">

    <ImageView
        android:id="@+id/item_icon"
        android:layout_width="71dp"
        android:layout_height="53dp"
        android:layout_gravity="left"
        android:layout_weight="1" />

    <TextView
        android:id="@+id/item_count"
        android:layout_width="84dp"
        android:layout_height="45dp"
        android:layout_alignParentTop="true"
        android:layout_alignParentEnd="true"
        android:layout_alignParentRight="true"
        android:layout_gravity="right"
        android:layout_marginTop="11dp"
        android:layout_marginEnd="169dp"
        android:layout_marginRight="169dp"
        android:textColor="@color/colorBlack"
        android:textSize="20sp" />

</RelativeLayout>

```

![菜单上下文页面1](https://i.loli.net/2019/03/30/5c9f757964d71.jpg)
![菜单上下文长按页面：](https://i.loli.net/2019/03/30/5c9f76b1c89aa.jpg)</br>
