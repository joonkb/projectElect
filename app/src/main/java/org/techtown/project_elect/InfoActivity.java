package org.techtown.project_elect;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class InfoActivity extends AppCompatActivity {
static int posi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(posi);
    }

    public static InfoActivity newInstance(int a) {
        posi=a;
        return new InfoActivity();
    }

}
