package com.example.encodedmessagereader;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button encode;
    Button decode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        encode = findViewById(R.id.encode);
        decode = findViewById(R.id.decode);
    }
        public void encode(View view)
        {
            Toast.makeText(MainActivity.this, "Moving to encoding screen", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, MainActivity2.class);
            startActivity(intent);
        }

        public void decode(View view1)
        {
            Toast.makeText(MainActivity.this, "Moving to decoding screen", Toast.LENGTH_SHORT).show();
            Intent intent2 = new Intent(this, MainActivity3.class);
            startActivity(intent2);
        }



}