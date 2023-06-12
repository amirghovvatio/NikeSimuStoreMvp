package com.example.stormvpgit.Cart;

import com.example.stormvpgit.Model.AppDao;
import com.example.stormvpgit.Model.Cart;
import com.example.stormvpgit.Model.Favorite;
import com.example.stormvpgit.Model.Shoes;

public class CartPresenter implements CartContract.Presenter{
    private CartContract.View view;
    private AppDao dao;

    public CartPresenter(AppDao dao) {
        this.dao = dao;
    }

    @Override
    public void onAttach(CartContract.View view) {
        this.view=view;
        this.view.showList(dao.getAllCartList());
    }

    @Override
    public void onDetach() {
        this.view=null;
    }

    @Override
    public void onBackClicked() {
        view.onBack();
    }

    @Override
    public void onFavClicked() {
        view.onFav();
    }

    @Override
    public void onCheckOutClicked() {
        view.onCheckOut();
    }

    @Override
    public void onAddFavClicked(Favorite favorite) {
        dao.addFavorite(favorite);
    }

    @Override
    public void onBuyNowClicked(Shoes shoes) {
        view.onBuyNow(shoes);
    }

    @Override
    public void onDeleteClicked(Cart cart) {
        int id=dao.deleteCart(cart);
        view.onDelete(cart);
    }

    @Override
    public void onCheckOutCallBacked() {
view.onCheckOutChange();    }
}
