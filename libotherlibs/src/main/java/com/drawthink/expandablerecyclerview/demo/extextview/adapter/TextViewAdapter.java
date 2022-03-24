package com.drawthink.expandablerecyclerview.demo.extextview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.drawthink.expandablerecyclerview.adapter.BaseRecyclerViewAdapter;
import com.drawthink.expandablerecyclerview.bean.RecyclerViewData;
import com.drawthink.expandablerecyclerview.demo.extextview.bean.TextViewChildBean;
import com.drawthink.expandablerecyclerview.demo.extextview.bean.TextViewGroupBean;
import com.drawthink.expandablerecyclerview.demo.extextview.viewholder.TextViewHolder;
import com.haier.cellarette.baselibrary.R;

import java.util.List;

public class TextViewAdapter extends BaseRecyclerViewAdapter<TextViewGroupBean, TextViewChildBean, TextViewHolder> {

    private Context ctx;
    private LayoutInflater mInflater;
    private List<RecyclerViewData> datas;

    public TextViewAdapter(Context ctx, List<RecyclerViewData> datas) {
        super(ctx, datas);
        mInflater = LayoutInflater.from(ctx);
        this.ctx = ctx;
        this.datas = datas;
    }

    /**
     * true 全部可展开
     * fasle  同一时间只能展开一个
     */
    @Override
    public boolean canExpandAll() {
        return false;
    }

    @Override
    public View getGroupView(ViewGroup parent) {
        return mInflater.inflate(R.layout.activity_expandableact_textview_group, parent, false);
    }

    @Override
    public View getChildView(ViewGroup parent) {
        return mInflater.inflate(R.layout.activity_expandableact_textview_child, parent, false);
    }

    @Override
    public TextViewHolder createRealViewHolder(Context ctx, View view, int viewType) {
        return new TextViewHolder(ctx, view, viewType);
    }

    /**
     * group View数据设置
     *
     * @param holder
     * @param groupPos
     * @param position
     * @param groupData
     */
    @Override
    public void onBindGroupHolder(TextViewHolder holder, int groupPos, int position, TextViewGroupBean groupData) {
        holder.group_tv_title.setText(groupData.getName());
    }

    /**
     * child View数据设置
     *
     * @param holder
     * @param groupPos
     * @param childPos
     * @param position
     * @param childData
     */
    @Override
    public void onBindChildpHolder(TextViewHolder holder, int groupPos, int childPos, int position, TextViewChildBean childData) {
        holder.child_tv_name.setText(childData.getName());
    }
}
