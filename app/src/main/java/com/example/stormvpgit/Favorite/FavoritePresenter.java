package com.example.stormvpgit.Favorite;

import com.example.stormvpgit.Model.AppDao;
import com.example.stormvpgit.Model.Cart;
import com.example.stormvpgit.Model.Favorite;

import java.util.ArrayList;
import java.util.List;

public class FavoritePresenter implements FavoriteContract.Presenter {
    private FavoriteContract.View view;
    private AppDao dao;

    public FavoritePresenter(AppDao dao) {
        this.dao = dao;
    }

    @Override
    public void onAttach(FavoriteContract.View view) {
        this.view=view;
        this.view.showList(dao.getAllFavorite());
    }

    @Override
    public void onDetach() {
        this.view=null;
    }

    @Override
    public void onDeleteClicked(Favorite favorite) {
        dao.deleteFavorite(favorite);
        view.deleteItem(favorite);
    }

    @Override
    public void onClearAllClicked() {
        dao.clearAllFav();
        view.deleteAll();
    }

    @Override
    public void onBackClicked() {
        view.back();
    }

    @Override
    public void onAddAllToCart() {
        List<Favorite> favoriteList=dao.getAllFavorite();
        List<Cart> carts=new ArrayList<>();
        for (int i = 0; i <favoriteList.size() ; i++) {
            Cart cart=new Cart();
            cart.setName(favoriteList.get(i).getName());
            cart.setPrice(favoriteList.get(i).getPrice());
            cart.setRes(favoriteList.get(i).getRes());
            long id=dao.addCart(cart);
            if (id > 0){
                cart.setCartId((int) id);
            }
        }
        dao.clearAllFav();
        view.onAddAll();

    }

    @Override
    public void onItem(Favorite favorite) {
        view.onItem(favorite);
    }
}
