package com.example.stormvpgit.Detail;

import com.example.stormvpgit.Model.AppDao;
import com.example.stormvpgit.Model.Cart;

public class DetailPresenter implements DetailContract.Presenter{
    private DetailContract.View view;
    private AppDao dao;

    public DetailPresenter(AppDao dao) {
        this.dao = dao;
    }

    @Override
    public void onAttach(DetailContract.View view) {
        this.view=view;
    }

    @Override
    public void onDetach() {
        this.view=null;
    }

    @Override
    public void onAddCartClicked(Cart cart) {
        dao.addCart(cart);
        view.onAddCart();
    }

    @Override
    public void onCartClicked() {
        view.onCart();
    }

    @Override
    public void onBackClicked() {
        view.back();
    }
}
