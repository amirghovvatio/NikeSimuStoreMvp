package com.example.stormvpgit.MainShop;

import com.example.stormvpgit.Model.AppDao;
import com.example.stormvpgit.Model.Cart;
import com.example.stormvpgit.Model.Favorite;
import com.example.stormvpgit.Model.MainDataClass;

public class MainShopPresenter implements MainShopContract.Presenter{
    private MainShopContract.View view;
    private AppDao appDao;

    public MainShopPresenter(AppDao appDao) {
        this.appDao = appDao;
    }

    @Override
    public void onAttach(MainShopContract.View view) {
        this.view=view;
        appDao.fillShoes(MainDataClass.newCollections());
        view.showNewCollectionList(MainDataClass.newCollections());
    }

    @Override
    public void onDetach() {
        this.view=null;
    }

    @Override
    public void onSeeAllClicked() {
        view.seeAll();
    }

    @Override
    public void onShopNowClicked() {
        view.shopNow();
    }

    @Override
    public void onCartClicked() {
        view.cart();
    }

    @Override
    public void onFavClicked() {
        view.onFav();
    }

    @Override
    public void onCartClickedTop() {
            view.onCart();
    }


    @Override
    public void onAddCartClicked(Cart cart) {
        long id=appDao.addCart(cart);
        if (id > 0){
            cart.setCartId((int) id);
            cart.setColor("Black");
            cart.setSize("42");
        }
        view.onCartAdded();
    }

    @Override
    public void onAddFavClicked(Favorite favorite) {
        long id=appDao.addFavorite(favorite);
        if (id > 0){
            favorite.setFavId((int) id);
            favorite.setColor("Black");
            favorite.setSize("42");
        }
        view.onFavAdded();
    }
}
