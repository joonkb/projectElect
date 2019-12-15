package org.techtown.project_elect;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class SelectFragment extends Fragment {

    FirebaseDatabase database;
    DatabaseReference ref;

    ListView listview;
    List<Major> oData;
    MajorAdapter adapter;
    @Override

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_select, container, false);

        database = FirebaseDatabase.getInstance();
        ref = database.getReference("Major");
        listview =view.getRootView().findViewById(R.id.major_candidate);
        oData = new ArrayList<>();
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                oData.clear();
                // 파이어베이스로 부터 가져옴.
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Major sc = snapshot.getValue(Major.class);
                    oData.add(sc);      // 가져온 데이터를 리스트에 넣고
                }
                adapter.notifyDataSetChanged(); // 리스트 저장 및 새로고침.
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w("scheduleActivity", "loadPost:onCancelled", databaseError.toException());
            }
        });
        adapter = new MajorAdapter(oData, view.getContext());
        listview.setAdapter(adapter);
        return view;
    }
}

