package com.hans.swipesample.swipesample;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hans.swipe_recyclerview.SwipeMenu;
import com.hans.swipe_recyclerview.SwipeMenuBridge;
import com.hans.swipe_recyclerview.SwipeMenuCreator;
import com.hans.swipe_recyclerview.SwipeMenuItem;
import com.hans.swipe_recyclerview.SwipeMenuItemClickListener;
import com.hans.swipe_recyclerview.SwipeMenuRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private SwipeMenuRecyclerView mRecyclerView;
    private SwipeAdapter swipeAdapter;
    private List<ItemEntity> datas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.recycler_view);
        swipeAdapter = new SwipeAdapter(new ArrayList<ItemEntity>());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        datas = new ArrayList<>();
        datas.add(new ItemEntity());
        datas.add(new ItemEntity());
        datas.add(new ItemEntity());
        datas.add(new ItemEntity());
        datas.add(new ItemEntity());
        datas.add(new ItemEntity());
        datas.add(new ItemEntity());
        datas.add(new ItemEntity());
        datas.add(new ItemEntity());
        datas.add(new ItemEntity());
        datas.add(new ItemEntity());
        datas.add(new ItemEntity());
        datas.add(new ItemEntity());
        datas.add(new ItemEntity());
        datas.add(new ItemEntity());
        datas.add(new ItemEntity());
        datas.add(new ItemEntity());
        datas.add(new ItemEntity());
        datas.add(new ItemEntity());
        datas.add(new ItemEntity());
        datas.add(new ItemEntity());
        datas.add(new ItemEntity());
        datas.add(new ItemEntity());
        datas.add(new ItemEntity());
        datas.add(new ItemEntity());
        datas.add(new ItemEntity());
        datas.add(new ItemEntity());
        datas.add(new ItemEntity());

        mRecyclerView.setSwipeMenuCreator(swipeMenuCreator);
        mRecyclerView.setSwipeMenuItemClickListener(mMenuItemClickListener);

        mRecyclerView.setAdapter(swipeAdapter);
        swipeAdapter.addData(datas);
        View view = LayoutInflater.from(this).inflate(R.layout.item_menu_header, null);
        swipeAdapter.addHeaderView(view);
        View view2 = LayoutInflater.from(this).inflate(R.layout.item_menu_header, null);
        swipeAdapter.addHeaderView(view2);
        View view3 = LayoutInflater.from(this).inflate(R.layout.item_menu_header, null);
        swipeAdapter.addFooterView(view3);


    }

    /**
     * 菜单创建器，在Item要创建菜单的时候调用。
     */
    private SwipeMenuCreator swipeMenuCreator = new SwipeMenuCreator() {
        @Override
        public void onCreateMenu(SwipeMenu swipeLeftMenu, SwipeMenu swipeRightMenu, int viewType) {
            if (viewType == BaseQuickAdapter.HEADER_VIEW || viewType == BaseQuickAdapter.FOOTER_VIEW) {
                return;
            }
            int width = getResources().getDimensionPixelSize(R.dimen.dp_70);

            // 1. MATCH_PARENT 自适应高度，保持和Item一样高;
            // 2. 指定具体的高，比如80;
            // 3. WRAP_CONTENT，自身高度，不推荐;
            int height = ViewGroup.LayoutParams.MATCH_PARENT;

            // 添加左侧的，如果不添加，则左侧不会出现菜单。
            {
                SwipeMenuItem addItem = new SwipeMenuItem(MainActivity.this)
                        .setBackground(R.drawable.selector_green)
                        .setImage(R.mipmap.ic_action_add)
                        .setWidth(width)
                        .setHeight(height);
                swipeLeftMenu.addMenuItem(addItem); // 添加菜单到左侧。

                SwipeMenuItem closeItem = new SwipeMenuItem(MainActivity.this)
                        .setBackground(R.drawable.selector_red)
                        .setImage(R.mipmap.ic_action_close)
                        .setWidth(width)
                        .setHeight(height);
                swipeLeftMenu.addMenuItem(closeItem); // 添加菜单到左侧。
            }

            // 添加右侧的，如果不添加，则右侧不会出现菜单。
            {
                SwipeMenuItem deleteItem = new SwipeMenuItem(MainActivity.this)
                        .setBackground(R.drawable.selector_red)
                        .setImage(R.mipmap.ic_action_delete)
                        .setText("删除")
                        .setTextColor(Color.WHITE)
                        .setWidth(width)
                        .setHeight(height);
                swipeRightMenu.addMenuItem(deleteItem);// 添加菜单到右侧。

                SwipeMenuItem addItem = new SwipeMenuItem(MainActivity.this)
                        .setBackground(R.drawable.selector_green)
                        .setText("添加")
                        .setTextColor(Color.WHITE)
                        .setWidth(width)
                        .setHeight(height);
                swipeRightMenu.addMenuItem(addItem); // 添加菜单到右侧。
            }
        }
    };

    /**
     * RecyclerView的Item的Menu点击监听。
     */
    private SwipeMenuItemClickListener mMenuItemClickListener = new SwipeMenuItemClickListener() {
        @Override
        public void onItemClick(SwipeMenuBridge menuBridge) {
            menuBridge.closeMenu();

            int direction = menuBridge.getDirection(); // 左侧还是右侧菜单。
            int adapterPosition = menuBridge.getAdapterPosition(); // RecyclerView的Item的position。
            int menuPosition = menuBridge.getPosition(); // 菜单在RecyclerView的Item中的Position。

            if (direction == SwipeMenuRecyclerView.RIGHT_DIRECTION) {
                Toast.makeText(MainActivity.this, "list第" + adapterPosition + "; 右侧菜单第" + menuPosition, Toast.LENGTH_SHORT).show();
            } else if (direction == SwipeMenuRecyclerView.LEFT_DIRECTION) {
                Toast.makeText(MainActivity.this, "list第" + adapterPosition + "; 左侧菜单第" + menuPosition, Toast.LENGTH_SHORT).show();
            }
        }
    };
}
