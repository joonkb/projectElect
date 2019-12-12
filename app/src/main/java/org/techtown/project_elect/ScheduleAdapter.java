package org.techtown.project_elect;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ScheduleAdapter extends BaseAdapter {

    LayoutInflater inflater = null;
    private List<Schedule> m_oData = null;
    private Context context;
    private int nListCnt = 0;

    public ScheduleAdapter(List<Schedule> _oData, Context context)
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

    @Override
    public View getView(int position, View view, ViewGroup parent)
    {
        View v = View.inflate(context, R.layout.schedule, null);
        TextView mday = (TextView)v.findViewById(R.id.day);
        TextView mtime = (TextView) v.findViewById(R.id.time);
        TextView mtitle = (TextView) v.findViewById(R.id.title);
        TextView mcontent = (TextView) v.findViewById(R.id.content);

        mday.setText(m_oData.get(position).day);
        mtime.setText(m_oData.get(position).time);
        mtitle.setText(m_oData.get(position).title);
        mcontent.setText(m_oData.get(position).content);
        return v;
    }
}
