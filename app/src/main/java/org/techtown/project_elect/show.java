package org.techtown.project_elect;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class show extends AppCompatActivity {
    static int addr;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(addr);
    }

    public static MapFragment newInstance(int a) {
      addr=a;
        return new MapFragment();
    }

}
