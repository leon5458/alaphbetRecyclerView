package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //底部字母
    private RecyclerView bottomRecy;
    private RecyclerViewAdapter bottomAdapter;
    List<String> bottomList;
    int bottom_positon = 0;
    public String[] alaphbet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#"};

    //left
    private RecyclerView left_recy;

    private CommonAdapter<String> leftAdapter;
    List<String> leftList;

    //right
    private RecyclerView right_recy;
    private CommonAdapter<String> rightAdapter;
    List<String> rightList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        left_recy = findViewById(R.id.left_recy);
        leftList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            leftList.add("安庆");
        }
        View leftHeaderView = LayoutInflater.from(this).inflate(R.layout.left_item_layout, null);
        left_recy.setLayoutManager(new GridLayoutManager(this, 2));
        leftAdapter = new CommonAdapter<>(R.layout.left_item_layout, leftList);
        left_recy.setAdapter(leftAdapter);
        leftAdapter.setHeaderView(leftHeaderView, 1);
        final TextView leftText = leftHeaderView.findViewById(R.id.left_text);
        leftText.setText("A");
        leftAdapter.setOnCallBackData(new CommonAdapter.OnCallBackData<String>() {
            @Override
            public void convertView(BaseViewHolder holder, String item) {
                holder.setText(R.id.left_text, item);
            }
        });

        right_recy = findViewById(R.id.right_recy);
        rightList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            rightList.add("保定");
        }
        View RightHeaderView = LayoutInflater.from(this).inflate(R.layout.left_item_layout, null);
        right_recy.setLayoutManager(new GridLayoutManager(this, 2));
        rightAdapter = new CommonAdapter<>(R.layout.left_item_layout, rightList);
        right_recy.setAdapter(rightAdapter);
        rightAdapter.setHeaderView(RightHeaderView, 1);
        final TextView rightText = RightHeaderView.findViewById(R.id.left_text);
        rightText.setText("B");
        rightAdapter.setOnCallBackData(new CommonAdapter.OnCallBackData<String>() {
            @Override
            public void convertView(BaseViewHolder holder, String item) {
                holder.setText(R.id.left_text, item);
            }
        });

        bottomRecy = findViewById(R.id.bottom_recy);
        bottomList = new ArrayList<>();

        //添加固定数据
        for (int i = 0; i < alaphbet.length; i++) {
            bottomList.add(alaphbet[i]);
        }
        bottomRecy.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        bottomAdapter = new RecyclerViewAdapter(this, R.layout.bottom_item_layout, bottomList);
        bottomRecy.setAdapter(bottomAdapter);
        bottomAdapter.setOnItemClickListner(new RecyclerViewAdapter.OnItemClickListner() {
            @Override
            public void onItemClickListner(View v, int position) {
                bottom_positon = position;
                bottomAdapter.notifyDataSetChanged();

                leftList.clear();
                rightList.clear();
                leftAdapter.notifyDataSetChanged();
                rightAdapter.notifyDataSetChanged();
                Log.e("------positoin", String.valueOf(position));
                if (position == 0) {
                    leftText.setText("A");
                    for (int i = 0; i < 10; i++) {
                        leftList.add("安庆");
                    }
                    rightText.setText("B");
                    for (int i = 0; i < 10; i++) {
                        rightList.add("保定");
                    }
                }
                if (position == 1) {
                    leftText.setText("B");
                    for (int i = 0; i < 10; i++) {
                        leftList.add("北京");
                    }
                    rightText.setText("C");
                    for (int i = 0; i < 10; i++) {
                        rightList.add("重庆");
                    }
                }

            }
        });

        bottomAdapter.setCallBack(new RecyclerViewAdapter.CallBack() {
            @Override
            public <T> void convert(IViewHolder holder, T bean, int position) {
                TextView bottom_txt = (TextView) holder.getView(R.id.bottom_txt);
                holder.setText(R.id.bottom_txt, (String) bean);
                if (position == bottom_positon) {
                    bottom_txt.setBackgroundResource(R.drawable.drawable_corner_gray_shape);
                    bottom_txt.setTextColor(Color.parseColor("#ffffff"));
                } else {
                    bottom_txt.setBackgroundResource(R.drawable.drawable_corner_write_shape);
                    bottom_txt.setTextColor(Color.parseColor("#3D3D3D"));
                }


            }
        });


    }
}
