package com.example.encodedmessagereader;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;

public class MainActivity2 extends AppCompatActivity {
    EditText msge;
    EditText keye;
    EditText encmsg;
    Button encode2;
    Button copy;
    public String ctxt;
    public ClipboardManager clipboardManager;
    public ClipData clipData;
    public String txtcopy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        msge=findViewById(R.id.msge);
        keye=findViewById(R.id.keye);
        encmsg=findViewById(R.id.encmsg);
        encode2=findViewById(R.id.encode2);
        copy=findViewById(R.id.copy);
        clipboardManager = (ClipboardManager)getSystemService(this.CLIPBOARD_SERVICE);


        if (! Python.isStarted()) {
            Python.start(new AndroidPlatform(this));
        }

        Python py=Python.getInstance();
        //py.key=msge;
        PyObject pyobj=py.getModule("encode");

        encode2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PyObject ob=pyobj.callAttr("enc",msge.getText().toString(),keye.getText().toString());
                String ctxt=ob.toString();
                encmsg.setText(ctxt);
            }
        });
        copy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txtcopy = encmsg.getText().toString();
                clipData = ClipData.newPlainText("text",txtcopy);
                clipboardManager.setPrimaryClip(clipData);
                Toast.makeText(getApplicationContext(),"Text is Copied to Clipboard", Toast.LENGTH_SHORT).show();

            }
        });




    }
}