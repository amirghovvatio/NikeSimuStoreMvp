package com.example.stormvpgit.Detail;

import com.example.stormvpgit.BasePresenter;
import com.example.stormvpgit.BaseView;
import com.example.stormvpgit.Model.Cart;

public interface DetailContract {

    interface View extends BaseView{
        void back();
        void onCart();
        void onAddCart();
    }
    interface Presenter extends BasePresenter<View>{
        void onAddCartClicked(Cart cart);
        void onCartClicked();
        void onBackClicked();

    }
}
