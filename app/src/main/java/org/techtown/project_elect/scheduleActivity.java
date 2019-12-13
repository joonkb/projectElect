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
        final LinearLayout frag = (LinearLayout)findViewById(R.id.frag);
        final RelativeLayout fragment = (RelativeLayout)findViewById(R.id.fragment);
        schedule_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // ListView 부분을 보이게 해준다.
                frag.setVisibility(View.VISIBLE);
                fragment.setVisibility(View.GONE);
                schedule_button.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                major_button.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                more_button.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            }
        });

        // 학과 버튼 클릭시 학과버튼 클릭 화면이 나오게 설정.
          major_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                frag.setVisibility(View.GONE);
                fragment.setVisibility(View.VISIBLE);
                major_button.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                schedule_button.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                more_button.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, new MajorFragment());
                fragmentTransaction.commit();
            }
        });
        more_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                frag.setVisibility(View.GONE);
                fragment.setVisibility(View.VISIBLE);
                more_button.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                schedule_button.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                major_button.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, new ScheduleFragment());
            }
        });
        database = FirebaseDatabase.getInstance();
        ref = database.getReference("User");
        listview = findViewById(R.id.listview);
        oData = new ArrayList<>();

        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                oData.clear();
                // 파이어베이스로 부터 가져옴.
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Schedule sc = snapshot.getValue(Schedule.class);
                    oData.add(sc);      // 가져온 데이터를 리스트에 넣고
                }
                adapter.notifyDataSetChanged(); // 리스트 저장 및 새로고침.
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w("scheduleActivity", "loadPost:onCancelled", databaseError.toException());
            }
        });
        adapter = new ScheduleAdapter(oData, this);
        listview.setAdapter(adapter);
    }
}