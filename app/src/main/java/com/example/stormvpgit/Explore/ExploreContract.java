package com.example.stormvpgit.Explore;

import com.example.stormvpgit.BasePresenter;
import com.example.stormvpgit.BaseView;
import com.example.stormvpgit.Model.Favorite;
import com.example.stormvpgit.Model.Shoes;

import java.util.List;

public interface ExploreContract {
    interface View extends BaseView{
        void showList(List<Shoes> shoes);
        void goToBuyNow(Shoes shoes);
         void onFav();
         void onSort();
        void onItem(Shoes shoes);
        void onTracks(List<Shoes> tracks);
        void onAir(List<Shoes> air);
        void onWoman(List<Shoes> womans);
        void onBasketBall(List<Shoes> basketball);
        void onAll(List<Shoes> all);
        void onCasual(List<Shoes> casual);
        void onSortedView(List<Shoes> shoes);
        void onSearch();
        void onSearchResult(List<Shoes> shoes);

    }
    interface Presenter extends BasePresenter<View>{
         void onBuyNowClicked(Shoes shoes);
        void onSearchCicked();
        void onSearchCallBack(String q);
        void onSortClicked();
        void onAddFavoriteClicked(Favorite favorite);
        void onItemClicked(Shoes shoes);
        void onBasketBallClicked();
        void onCaualClicked();
        void onTracksClicked();
        void onAirClicked();
        void onWomanClicked();
        void onAllClicked();
       void onSorted(int order,int sort);



    }
}
