package com.example.day_project_1.fragment;

import android.graphics.Color;
import android.util.Log;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.example.day_project_1.R;
import com.example.day_project_1.adapter.MyAdapter;
import com.example.day_project_1.contract.HomeContract;
import com.example.day_project_1.data.ItemBean;
import com.example.day_project_1.presenter.HomePresenter;
import com.example.mvplibrary.base.BaseFragment;
import com.example.mvplibrary.utils.URLConstant;

import java.util.List;

import butterknife.BindView;

public class HomeFragment extends BaseFragment<HomePresenter> implements HomeContract.IHomeView {


    @BindView(R.id.home_Recycler)
    RecyclerView homeRecycler;

    @Override
    protected void initData() {
        presenter.Home(URLConstant.NEWLIST);
    }

    @Override
    protected void initView() {
        VirtualLayoutManager layoutManager = new VirtualLayoutManager(getContext());
        //设置回收复用线程池大小
        RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        homeRecycler.setRecycledViewPool(viewPool);
        viewPool.setMaxRecycledViews(0, 10);
        //通栏
        MyAdapter myAdapter = initTongLan();

        DelegateAdapter adapter = new DelegateAdapter(layoutManager, true);
        adapter.addAdapter(myAdapter);
        homeRecycler.setLayoutManager(layoutManager);
        homeRecycler.setAdapter(adapter);
    }

    private MyAdapter initTongLan() {
        /**
          TODO 设置通栏布局
         */
        SingleLayoutHelper singleLayoutHelper = new SingleLayoutHelper();
        // 公共属性
        singleLayoutHelper.setItemCount(3);// 设置布局里Item个数
        //singleLayoutHelper.setPadding(0, 0, 0, 0);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
//        singleLayoutHelper.setMargin(50, 50, 50, 20);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        singleLayoutHelper.setBgColor(Color.GRAY);// 设置背景颜色
        singleLayoutHelper.setAspectRatio(6);// 设置设置布局内每行布局的宽与高的比
        MyAdapter myAdapter = new MyAdapter(singleLayoutHelper);
        return myAdapter;
    }

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_home;
    }

    @Override
    public HomePresenter getPresenter() {
        return new HomePresenter();
    }

    @Override
    public <T> void HomeRelt(T t) {
        ItemBean bean = (ItemBean) t;
        List<ItemBean.DataDTO.BannerDTO> banner = bean.getData().getBanner();

    }

    @Override
    public void tips(String string) {
        Log.e("TAG", "tips: " + string);
    }
}