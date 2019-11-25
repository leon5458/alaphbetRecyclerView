package com.example.recyclerview;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * ********文件描述：********
 * ********作者：huleiyang********
 * ********创建时间：2019/11/25********
 * ********更改时间：2019/11/25********
 * ********版本号：1********
 */
public class CommonAdapter <T> extends BaseQuickAdapter<T, BaseViewHolder> {

    public CommonAdapter(@LayoutRes int layoutResId, @Nullable List<T> data) {
        super(layoutResId, data);
    }

    public CommonAdapter(@Nullable List<T> data) {
        super(data);
    }

    public CommonAdapter(@LayoutRes int layoutResId) {
        super(layoutResId);
    }


    private OnCallBackData<T> onCallBackData;

    @Override
    protected void convert(BaseViewHolder holder, T item) {
        if (onCallBackData != null) {
            onCallBackData.convertView(holder, item);
        }
    }
    public void setOnCallBackData (OnCallBackData<T> onCallBackData) {
        this.onCallBackData = onCallBackData;
    }

    public interface OnCallBackData<T> {
        void convertView(BaseViewHolder holder, T item);
    }
}
