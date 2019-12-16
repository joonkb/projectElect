package org.techtown.project_elect;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MajorAdapter extends BaseAdapter {

    LayoutInflater inflater = null;
    private List<Major> m_oData = null;
    private Context context;
    private int nListCnt = 0;
    static int[] data;

    public MajorAdapter(List<Major> _oData, Context context)
    {
        this.m_oData = _oData;
        this.nListCnt = m_oData.size();
        this.context = context;
    }

    @Override
    public int getCount()
    {
        return m_oData.size();
    }

    @Override
    public Object getItem(int position)
    {
        return m_oData.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    static void getin(int[] a){
        data=a;

    }
    @Override
    public View getView(final int position, View view, ViewGroup parent)
    {
        View v = View.inflate(context, R.layout.major_list, null);

        ImageView iv1 = (ImageView)v.findViewById(R.id.profile1);
        ImageView iv2 = (ImageView)v.findViewById(R.id.profile2);
        Button bnt1=v.findViewById(R.id.info);
        Button bnt2=v.findViewById(R.id.song);
        TextView name1 = (TextView)v.findViewById(R.id.name1);
        TextView name2 = (TextView)v.findViewById(R.id.name2);

        TextView num1 = (TextView)v.findViewById(R.id.num1);
        TextView num2 = (TextView)v.findViewById(R.id.num2);

        TextView intro1 = (TextView)v.findViewById(R.id.intro1);
        TextView intro2 = (TextView)v.findViewById(R.id.intro2);

        TextView select_num = (TextView)v.findViewById(R.id.select_num);

      // Glide.with(getView()).load(m_oData.get(position).getProfile1());
       //Glide.with(getView()).load(m_oData.get(position).getProfile2());

        name1.setText(m_oData.get(position).name1);
        name2.setText(m_oData.get(position).name2);

        num1.setText(m_oData.get(position).num1);
        num2.setText(m_oData.get(position).num2);

        intro1.setText(m_oData.get(position).intro1);
        intro2.setText(m_oData.get(position).intro2);

        select_num.setText(m_oData.get(position).select_num);


        bnt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InfoActivity.newInstance(data[position]);
                Intent intent = new Intent(context, InfoActivity.class);
                context.startActivity(intent);
            }
        });

        return v;
    }
}