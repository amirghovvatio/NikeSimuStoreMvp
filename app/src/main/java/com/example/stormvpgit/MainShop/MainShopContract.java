package com.example.stormvpgit.MainShop;

import com.example.stormvpgit.BasePresenter;
import com.example.stormvpgit.BaseView;
import com.example.stormvpgit.Model.Cart;
import com.example.stormvpgit.Model.Favorite;
import com.example.stormvpgit.Model.Shoes;

import java.util.List;

public interface MainShopContract {
    interface View extends BaseView{
        void showNewCollectionList(List<Shoes> shoes);
        void shopNow();
        void seeAll();
        void onCart();
        void onFav();
        void cart();
        void onFavAdded();
        void onCartAdded();
    }

    interface Presenter extends BasePresenter<View>{
        void onSeeAllClicked();
        void onShopNowClicked();
        void onCartClicked();


        void onFavClicked();
        void onCartClickedTop();
        void onAddCartClicked(Cart cart);
        void onAddFavClicked(Favorite favorite);
    }
}
