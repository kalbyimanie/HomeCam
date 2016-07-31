package com.example.abi.nosql;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.TextView;

public class FAQ extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);
        TextView textsatu = (TextView)findViewById(R.id.textsatu);
        TextView textdua = (TextView)findViewById(R.id.textdua);
        TextView texttiga = (TextView)findViewById(R.id.texttiga);

        String satu ="1. Apa itu HomeCAM?";
        SpannableString uline = new SpannableString(satu);
        uline.setSpan(new UnderlineSpan(), 0, satu.length(), 0);
        textsatu.setText(uline);

        String dua = "2. Apa saja kegunaan aplikasi HomeCAM?";
        SpannableString uline2 = new SpannableString(dua);
        uline2.setSpan(new UnderlineSpan(), 0, dua.length(), 0);
        textdua.setText(uline2);

        String tiga = "3. Bagaimana cara menggunakan HomeCAM?";
        SpannableString uline3 = new SpannableString(tiga);
        uline3.setSpan(new UnderlineSpan(), 0, tiga.length(), 0);
        texttiga.setText(uline3);

        textsatu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*setContentView(R.layout.questionsatu);*/
                startActivity(new Intent(FAQ.this, Questionsatu.class));
            }
        });

        textdua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*setContentView(R.layout.questiondua);*/
                startActivity(new Intent(FAQ.this, Questiondua.class));

            }
        });

        texttiga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*setContentView(R.layout.questiontiga);*/
                startActivity(new Intent(FAQ.this, Questiontiga.class));

            }
        });
    }
}
