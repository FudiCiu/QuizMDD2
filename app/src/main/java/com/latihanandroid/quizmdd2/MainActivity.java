package com.latihanandroid.quizmdd2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    public Button btnVideo1,btnVideo2,btnVideo3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnVideo1=(Button) findViewById(R.id.btnVideo1);
        btnVideo2=(Button) findViewById(R.id.btnVideo2);
        btnVideo3=(Button) findViewById(R.id.btnVideo3);
        btnVideo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,VideoActivity.class);
                intent.putExtra("Pilihan",0);
                startActivity(intent);
            }
        });
        btnVideo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,VideoActivity.class);
                intent.putExtra("Pilihan",1);
                startActivity(intent);
            }
        });
        btnVideo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,VideoActivity.class);
                intent.putExtra("Pilihan",2);
                startActivity(intent);
            }
        });

    }
}
