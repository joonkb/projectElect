package org.techtown.project_elect;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.List;

public class scheduleActivity extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference ref;
    ListView listview;
    List<Schedule> oData;
    ScheduleAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        // 상단의 3개의 버튼 객체를 생성함.
        final Button schedule_button = (Button)findViewById(R.id.shedule_list);
        final Button major_button = (Button)findViewById(R.id.major);
        final Button more_button = (Button)findViewById(R.id.more);

        // 각각의 버튼을 눌렀을 때 프레그 먼트를 생성해준다.

        schedule_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // ListView 부분을 보이게 해준다.

                schedule_button.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                major_button.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                more_button.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frame, new ListFragment());
                fragmentTransaction.commit();
            }
        });

        // 학과 버튼 클릭시 학과버튼 클릭 화면이 나오게 설정.
          major_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                major_button.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                schedule_button.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                more_button.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frame, new MajorFragment());
                fragmentTransaction.commit();
            }
        });
        more_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                more_button.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                schedule_button.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                major_button.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frame, new ScheduleFragment());
            }
        });


    }
}