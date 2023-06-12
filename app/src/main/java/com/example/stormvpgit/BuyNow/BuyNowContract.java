package com.example.stormvpgit.BuyNow;

import com.example.stormvpgit.BasePresenter;
import com.example.stormvpgit.BaseView;

public interface BuyNowContract {
    interface View extends BaseView{
        void back();
        void onBuyNow();
        void onCart();
    }
    interface Presenter extends BasePresenter<View>{
        void onBuyNowClicked();
        void onCartClicked();
        void onBackClicked();
    }
}
