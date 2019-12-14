package org.techtown.project_elect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), scheduleActivity.class);
                startActivity(intent);
            }
        });
    }

    private long lastTimeBackPressed;

    @Override
    public void onBackPressed() {
       if(System.currentTimeMillis() - lastTimeBackPressed < 1500){
           super.finish();
           return;
       }
       Toast.makeText(this, " '뒤로'  버튼을 한번 더 눌러 종료 합니다.", Toast.LENGTH_SHORT);
       lastTimeBackPressed = System.currentTimeMillis();
    }
}
