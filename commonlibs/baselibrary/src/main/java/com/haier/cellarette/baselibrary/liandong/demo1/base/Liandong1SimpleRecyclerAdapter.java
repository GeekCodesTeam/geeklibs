package com.haier.cellarette.baselibrary.liandong.demo1.base;

import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/**
 * @author pengbo
 * @date 2018/5/22
 */
public abstract class Liandong1SimpleRecyclerAdapter<T> extends RecyclerView.Adapter<Liandong1SimpleViewHolder<T>> {

    protected List<T> mListData;

    private Liandong1SimpleRecyclerAdapter.OnItemClickListener<T> onItemClickListener;
    private Liandong1SimpleRecyclerAdapter.OnItemLongClickListener<T> mOnItemLongClickListener;

    public void setOnItemClickListener(OnItemClickListener<T> onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
    public void setOnItemLongClickListener(OnItemLongClickListener<T> mOnItemLongClickListener) {
        this.mOnItemLongClickListener = mOnItemLongClickListener;
    }
    void onItemClick(T data, int index) {
        if (onItemClickListener != null) {
            onItemClickListener.onItemClick(data, index);
        }

    }
    void onItemLongClick(T data,int index){
        if(mOnItemLongClickListener!=null){
            mOnItemLongClickListener.onItemLongClick(data,index);
        }
    }

    /**
     * 设置列表数据
     * @param data
     */
    public void setListData(List<T> data) {
        this.mListData = data;
    }

    @Override
    public void onBindViewHolder(Liandong1SimpleViewHolder<T> holder, int position) {
        holder.refresh(mListData.get(position), position);
    }

    @Override
    public void onBindViewHolder(Liandong1SimpleViewHolder<T> holder, int position, List<Object> payloads) {
        if (payloads.isEmpty()){
            holder.refresh(mListData.get(position), position);
        }else{
            holder.refreshItemWidget(mListData.get(position), position,payloads);
        }
    }

    @Override
    public int getItemCount() {
        return mListData == null ? 0 : mListData.size();
    }

    public interface OnItemClickListener<T> {
        void onItemClick(T item, int index);
    }
    public interface OnItemLongClickListener<T>{
        void onItemLongClick(T item, int position);
    }
}