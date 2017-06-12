package com.rimy.threehorizontallistdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by yidong on 2017/6/7.
 */

public class TextAdapter extends BaseAdapter {
    private int selectedPos = -1;
    private Context mContext;

    private List<String> mObjects;

    private LayoutInflater mInflater;

    public TextAdapter(Context context, List<String> mObjects){
        this.mObjects = mObjects;
        this.mContext = context;
        mInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    public void refreshData(List<String> objects){
        mObjects = objects;
        notifyDataSetChanged();
    }

    //选中的position,及时更新数据
    public void setSelectedPos(int selectedPos) {
        this.selectedPos = selectedPos;
        notifyDataSetChanged();
    }
    @Override
    public int getCount() {

        return mObjects.size();
    }

    @Override
    public Object getItem(int pos) {
        return mObjects.get(pos).toString();
    }

    @Override
    public long getItemId(int pos) {
        return pos;
    }

    @Override
    public View getView(int pos, View convertView, ViewGroup arg2) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.price_spinner_item_layout, null);
            viewHolder = new ViewHolder();
            viewHolder.mTextView = (TextView) convertView.findViewById(R.id.textView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.mTextView.setSelected(selectedPos == pos);

        //选中后的标题字体颜色
        viewHolder.mTextView.setTextColor(selectedPos == pos ? 0xFFff5a5a : 0xFF41474f);
        viewHolder.mTextView.setText(mObjects.get(pos));

        return convertView;
    }


    public static class ViewHolder
    {
        public TextView mTextView;
    }

}