package com.example.day_project_1.model;

import com.example.day_project_1.contract.HomeContract;
import com.example.day_project_1.data.ItemBean;
import com.example.mvplibrary.utils.INetCallBack;
import com.example.mvplibrary.utils.RetrofitUtils;

public class HomeModel implements HomeContract.IHomeModel {
    private HomeContract.IHomePresenter presenter;

    public HomeModel(HomeContract.IHomePresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public <T> void getHomeData(String url, INetCallBack<T> callBack) {
        RetrofitUtils.getInstance().get(url, new INetCallBack<ItemBean>() {
            @Override
            public void onSuccess(ItemBean itemBean) {
                callBack.onSuccess((T) itemBean);
            }

            @Override
            public void onFail(String err) {
                callBack.onFail(err);
            }
        });
    }
}
