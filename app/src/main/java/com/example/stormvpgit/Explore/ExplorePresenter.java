package com.example.stormvpgit.Explore;

import com.example.stormvpgit.Model.AppDao;
import com.example.stormvpgit.Model.Favorite;
import com.example.stormvpgit.Model.MainDataClass;
import com.example.stormvpgit.Model.Shoes;

public class ExplorePresenter implements ExploreContract.Presenter{
    private ExploreContract.View view;
    private AppDao dao;

    public ExplorePresenter(AppDao dao) {
        this.dao = dao;
    }

    @Override
    public void onAttach(ExploreContract.View view) {
        this.view=view;
        dao.fillShoes(MainDataClass.getAll());
        view.showList(dao.getAllShoes());
    }

    @Override
    public void onDetach() {
        this.view=null;
    }



    @Override
    public void onBuyNowClicked(Shoes shoes) {
        view.goToBuyNow(shoes);
    }

    @Override
    public void onSearchCicked() {
        view.onSearch();


    }

    @Override
    public void onSearchCallBack(String q) {
        view.onSearchResult(dao.searchItems(q));
    }

    @Override
    public void onSortClicked() {
        view.onSort();
    }

    @Override
    public void onAddFavoriteClicked(Favorite favorite) {
        long id=dao.addFavorite(favorite);
        if (id > 0){
            favorite.setFavId((int) id);
        }

    }

    @Override
    public void onItemClicked(Shoes shoes) {
        view.onItem(shoes);
    }

    @Override
    public void onBasketBallClicked() {
        view.onBasketBall(MainDataClass.getBasketballList());
    }

    @Override
    public void onCaualClicked() {
        view.onCasual(MainDataClass.getCasualList());
    }

    @Override
    public void onTracksClicked() {
        view.onTracks(MainDataClass.getTracks());
    }

    @Override
    public void onAirClicked() {
        view.onAir(MainDataClass.getCasual());
    }

    @Override
    public void onWomanClicked() {
        view.onWoman(MainDataClass.getWoman());
    }

    @Override
    public void onAllClicked() {
        view.onAll(dao.getAllShoes());
    }

    @Override
    public void onSorted(int order,int sort) {
       if (sort == 1 && order ==1){
           view.onSortedView(dao.shoesByNameAsc());
       }else if (sort == 1 && order ==2){
           view.onSortedView(dao.shoesByNameDesc());
       }else if (sort == 2 && order == 1){
           view.onSortedView(dao.shoesByPriceAsc());
       }else if (sort ==2 && order == 2){
           view.showList(dao.shoesByPriceDesc());

       }
    }
}
