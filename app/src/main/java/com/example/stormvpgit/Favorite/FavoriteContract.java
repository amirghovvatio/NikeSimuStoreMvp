package com.example.stormvpgit.Favorite;

import com.example.stormvpgit.BasePresenter;
import com.example.stormvpgit.BaseView;
import com.example.stormvpgit.Model.Favorite;

import java.util.List;

public interface FavoriteContract {
    interface View extends BaseView{
        void showList(List<Favorite> favorites);
        void deleteAll();
        void deleteItem(Favorite favorite);
        void back();
        void onAddAll();
        void onItem(Favorite favorite);
    }

    interface Presenter extends BasePresenter<View>{
        void onDeleteClicked(Favorite favorite);
        void onClearAllClicked();
        void onBackClicked();
        void onAddAllToCart();
        void onItem(Favorite favorite);
    }
}
