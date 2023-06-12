package com.example.stormvpgit.Cart;

import com.example.stormvpgit.BasePresenter;
import com.example.stormvpgit.BaseView;
import com.example.stormvpgit.Model.Cart;
import com.example.stormvpgit.Model.Favorite;
import com.example.stormvpgit.Model.Shoes;

import java.util.List;

public interface CartContract {
    interface View extends BaseView{
        void showList(List<Cart> carts);
        void onFav();
        void onCheckOut();
        void onBuyNow(Shoes shoes);
        void onAddFav();
        void onBack();
        void onDelete(Cart cart);
        void onCheckOutChange();
    }
    interface Presenter extends BasePresenter<View>{
        void onBackClicked();
        void onFavClicked();
        void onCheckOutClicked();
        void onAddFavClicked(Favorite favorite);
        void onBuyNowClicked(Shoes shoes);
        void onDeleteClicked(Cart cart);
        void onCheckOutCallBacked();
    }
}
