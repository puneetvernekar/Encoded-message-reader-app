package com.example.encodedmessagereader;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;

import java.util.Locale;

public class MainActivity3 extends AppCompatActivity {
    EditText msgd;
    EditText keyd;
    TextView decmsg;
    Button decode2;
    TextToSpeech t;
    Button speaker;
    String msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        msgd = findViewById(R.id.msgd);
        keyd = findViewById(R.id.keyd);
        decmsg = findViewById(R.id.decmsg);
        decode2 = findViewById(R.id.decode2);
        speaker = findViewById(R.id.speaker);

        if (!Python.isStarted()) {
            Python.start(new AndroidPlatform(this));
        }

        Python py1 = Python.getInstance();
        //py.key=msge;
        PyObject pyobj1 = py1.getModule("encode");

        decode2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PyObject ob = pyobj1.callAttr("dec", msgd.getText().toString(), keyd.getText().toString());
                String msg = ob.toString();
                decmsg.setText(msg);
            }
        });

        t = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    t.setLanguage(Locale.UK);
                }
            }
        });

        speaker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toSpeak = decmsg.getText().toString();

                t.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
    }
}

