package org.techtown.project_elect;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Adapter;
import android.widget.ListAdapter;
import android.widget.ListView;

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
    ListView schedule_listview;
    List<Schedule> oData;
    ScheduleAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        database = FirebaseDatabase.getInstance();
        ref = database.getReference("User");
        schedule_listview = findViewById(R.id.schedule_listview);
        oData = new ArrayList<>();

        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Schedule user = snapshot.getValue(Schedule.class);
                    oData.add(user);
                }
                adapter.notifyDataSetChanged();
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w("MainActivity", "loadPost:onCancelled", databaseError.toException());
            }
        });
        schedule_listview = (ListView)findViewById(R.id.schedule_listview);
        ScheduleAdapter adapter = new  ScheduleAdapter(oData);
        schedule_listview.setAdapter(adapter);
    }
}
