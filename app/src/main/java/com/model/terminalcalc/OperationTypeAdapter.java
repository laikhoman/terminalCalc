package com.model.terminalcalc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class OperationTypeAdapter extends BaseAdapter {
    Context context;
    String[] typeList;
    LayoutInflater inflter;

    public OperationTypeAdapter(Context applicationContext, String[] typeList) {
        this.context = applicationContext;
        this.typeList = typeList;
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return typeList.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.operation_spinner_items, null);
        TextView names = (TextView) view.findViewById(R.id.textView);
        names.setText(typeList[i]);
        return view;
    }
}