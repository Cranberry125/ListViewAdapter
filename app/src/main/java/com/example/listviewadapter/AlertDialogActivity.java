package com.example.listviewadapter;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
public class AlertDialogActivity extends AppCompatActivity {
    private String dialogname;
    private TextView textview;
    private EditText editusername;
    private EditText editpassword;
    private Button btncancle;
    private Button btnsignin;
    private int image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alert_dialog);
        /**
         * 关联 AlertDialog.java文件
         */
//        AlertDialog alertdialog=new AlertDialog(this,"   ");
//        alertdialog.show();
        /*
        方法2  使用AlertDialog.Builder对象上的setView()将布局添加到 AlertDialog
         */


        // 创建对话框构建器
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        // 获取布局
        LayoutInflater inflater = getLayoutInflater();
        View view= View.inflate(AlertDialogActivity.this, R.layout.alert_dialog,null);
        // 获取布局中的控件
        editusername=(EditText) view.findViewById(R.id.enditusername);
        editpassword=(EditText)view.findViewById(R.id.editpassword);
        btnsignin=(Button) view.findViewById(R.id.btn_signin);
        btncancle=(Button) view.findViewById(R.id.btn_cancle);
        view.setBackgroundColor(R.drawable.header_logo);
        // 设置参数
        builder.setView(view);
        // 创建对话框
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

  }
}
