package com.example.stormvpgit.ShopNow;

import com.example.stormvpgit.BasePresenter;
import com.example.stormvpgit.BaseView;
import com.example.stormvpgit.Model.Cart;
import com.example.stormvpgit.Model.Shoes;

public interface ShopNowContract {
    interface View extends BaseView{
        void onCart(Cart cart);
    }
    interface Presenter extends BasePresenter<View>{
        void onAddToCartClicked();
    }
}
