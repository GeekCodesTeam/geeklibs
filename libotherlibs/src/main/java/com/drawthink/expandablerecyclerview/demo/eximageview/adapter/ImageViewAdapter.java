package com.drawthink.expandablerecyclerview.demo.eximageview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.drawthink.expandablerecyclerview.adapter.BaseRecyclerViewAdapter;
import com.drawthink.expandablerecyclerview.bean.RecyclerViewData;
import com.drawthink.expandablerecyclerview.demo.eximageview.bean.ImageViewChildBean;
import com.drawthink.expandablerecyclerview.demo.eximageview.bean.ImageViewGroupBean;
import com.drawthink.expandablerecyclerview.demo.eximageview.viewholder.ImageViewHolder;
import com.haier.cellarette.baselibrary.R;

import java.util.List;

public class ImageViewAdapter extends BaseRecyclerViewAdapter<ImageViewGroupBean, ImageViewChildBean, ImageViewHolder> {

    private Context ctx;
    private LayoutInflater mInflater;
    private List datas;

    public ImageViewAdapter(Context ctx, List<RecyclerViewData> datas) {
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
        return true;
    }

    @Override
    public View getGroupView(ViewGroup parent) {
        return mInflater.inflate(R.layout.activity_expandableact_imageview_group, parent, false);
    }

    @Override
    public View getChildView(ViewGroup parent) {
        return mInflater.inflate(R.layout.activity_expandableact_imageview_child, parent, false);
    }

    @Override
    public ImageViewHolder createRealViewHolder(Context ctx, View view, int viewType) {
        return new ImageViewHolder(ctx, view, viewType);
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
    public void onBindGroupHolder(ImageViewHolder holder, int groupPos, int position, ImageViewGroupBean groupData) {
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
    public void onBindChildpHolder(ImageViewHolder holder, int groupPos, int childPos, int position, ImageViewChildBean childData) {
        holder.child_iv_image.setImageResource(childData.getResId());
    }
}
