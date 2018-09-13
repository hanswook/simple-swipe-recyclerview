package com.hans.swipesample.swipesample;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

public class SwipeAdapter extends BaseQuickAdapter<ItemEntity,BaseViewHolder> {

    public SwipeAdapter(@Nullable List<ItemEntity> data) {
        super(R.layout.item_menu_main,data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ItemEntity item) {

    }
}
