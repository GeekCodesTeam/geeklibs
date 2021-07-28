package com.example.slbjiaozvideonew;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.slbjiaozvideonew.Tab_3_List.ListView.AutoPlayListViewActivity;
import com.example.slbjiaozvideonew.Tab_3_List.ListView.ListViewFragmentViewPagerActivity;
import com.example.slbjiaozvideonew.Tab_3_List.ListView.ListViewMultiHolderActivity;
import com.example.slbjiaozvideonew.Tab_3_List.ListView.ListViewToDetailActivity;
import com.example.slbjiaozvideonew.Tab_3_List.ListView.NormalListViewActivity;
import com.example.slbjiaozvideonew.Tab_3_List.ListView.RecyclerViewActivity;
import com.example.slbjiaozvideonew.Tab_3_List.ListView.tiktok.ActivityTikTok;


/**
 * Created by pengan.li on 2020/5/8.
 */
public class Fragment_3_List extends Fragment implements View.OnClickListener {

    private Button btn1, btn2, btn3, btn4, btn5, btn6, btn7;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = View.inflate(getContext(), R.layout.fragment_list, null);

        btn1 = view.findViewById(R.id.normal);
        btn2 = view.findViewById(R.id.listview_fragment_viewpager);
        btn3 = view.findViewById(R.id.multiholder);
        btn4 = view.findViewById(R.id.recyleview);
        btn5 = view.findViewById(R.id.list_to_detail);
        btn6 = view.findViewById(R.id.list_auto_play);
        btn7 = view.findViewById(R.id.btn_tiktok);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.normal) {
            startActivity(new Intent(getContext(), NormalListViewActivity.class));
        } else if (id == R.id.listview_fragment_viewpager) {
            startActivity(new Intent(getContext(), ListViewFragmentViewPagerActivity.class));
        } else if (id == R.id.multiholder) {
            startActivity(new Intent(getContext(), ListViewMultiHolderActivity.class));
        } else if (id == R.id.recyleview) {
            startActivity(new Intent(getContext(), RecyclerViewActivity.class));
        } else if (id == R.id.list_to_detail) {
            startActivity(new Intent(getContext(), ListViewToDetailActivity.class));
        } else if (id == R.id.list_auto_play) {
            startActivity(new Intent(getContext(), AutoPlayListViewActivity.class));
        } else if (id == R.id.btn_tiktok) {
            startActivity(new Intent(getContext(), ActivityTikTok.class));
        }
    }
}
