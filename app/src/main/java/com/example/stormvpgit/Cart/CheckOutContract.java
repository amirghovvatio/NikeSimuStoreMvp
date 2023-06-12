package com.example.stormvpgit.Cart;

import com.example.stormvpgit.BasePresenter;
import com.example.stormvpgit.BaseView;

public interface CheckOutContract {

    interface View extends BaseView{
        void checkOuted();
        void getInfoes(int price,int total);
    }
    interface Presenter extends BasePresenter<View>{
        void onCheckOutClicked();
    }
}
