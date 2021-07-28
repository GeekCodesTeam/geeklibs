package com.example.slbappindex.index;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.slbappindex.R;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class ShouyeFooterAdapter extends RecyclerView.Adapter<ShouyeFooterAdapter.ViewHolder> {
    private LayoutInflater inflater;
    private Context context;
    private List<ShouyeFooterBean> mratings;
    private String hongdiao_count;

    public ShouyeFooterAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        mratings = new ArrayList<ShouyeFooterBean>();
    }

    public String getHongdiao_count() {
        return hongdiao_count;
    }

    public void setHongdiao_count(String hongdiao_count) {
        this.hongdiao_count = hongdiao_count;
    }

    public void setContacts(List<ShouyeFooterBean> ratings) {
        this.mratings = ratings;
    }

    public void addConstacts(List<ShouyeFooterBean> ratings) {
        this.mratings.addAll(ratings);
    }

    public List<ShouyeFooterBean> getMratings() {
        return mratings;
    }

    @Override
    public int getItemCount() {
        if (mratings == null)
            return 0;
        return mratings.size();
    }

    public Object getItem(int position) {
        return mratings.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.activity_shouye_footer_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.iv_imgurl = view.findViewById(R.id.iv_imgurl);
        viewHolder.tv_content1 = view.findViewById(R.id.tv_content1);
        viewHolder.tv_hongdian1 = view.findViewById(R.id.tv_hongdian1);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int position) {
        final ShouyeFooterBean ratings = mratings.get(position);
        //设置图片bufen

//        GlideUtil.display(context, viewHolder.iv_imgurl, ratings.getSku_image(), GlideOptionsFactory.get(GlideOptionsFactory.Type.RADIUS));
//        Glide.with(context).load(ratings.getSku_image()).skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.NONE).into(viewHolder.iv_imgurl);
        if (!TextUtils.isEmpty(getHongdiao_count()) && position == 2) {
            viewHolder.tv_hongdian1.setText("+" + getHongdiao_count());
        } else {
            viewHolder.tv_hongdian1.setText("");
        }
        viewHolder.tv_content1.setText(ratings.getText_content());
        if (ratings.isEnselect()) {
            //选中
            viewHolder.iv_imgurl.setImageResource(ratings.getText_icon2());
            viewHolder.tv_content1.setTextColor(ContextCompat.getColor(context, R.color.color_519AF4));
        } else {
            //未选中
            viewHolder.iv_imgurl.setImageResource(ratings.getText_icon());
            viewHolder.tv_content1.setTextColor(ContextCompat.getColor(context, R.color.color_637191));
        }

        //如果设置了回调，则设置点击事件
        if (mOnItemClickLitener != null) {
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickLitener.onItemClick(viewHolder.itemView, position);
                }
            });
        }
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView iv_imgurl;//ImgUrl
        private TextView tv_content1;//
        private TextView tv_hongdian1;//

        ViewHolder(View view) {
            super(view);
        }
    }

    /**
     * ItemClick的回调接口
     *
     * @author geek
     */
    public interface OnItemClickLitener {
        void onItemClick(View view, int position);
    }

    private OnItemClickLitener mOnItemClickLitener;

    public void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener) {
        this.mOnItemClickLitener = mOnItemClickLitener;
    }

    public String formatPrice2(double price) {
        DecimalFormat df = new DecimalFormat("######0.00");

        return df.format(price);
    }
}