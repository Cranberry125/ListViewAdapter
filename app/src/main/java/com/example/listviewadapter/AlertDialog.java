package com.example.listviewadapter;

import android.app.Dialog;
import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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
