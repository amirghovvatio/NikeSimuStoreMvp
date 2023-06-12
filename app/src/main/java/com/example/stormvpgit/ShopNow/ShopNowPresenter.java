package com.example.stormvpgit.ShopNow;


import com.example.stormvpgit.Model.AppDao;
import com.example.stormvpgit.Model.Cart;
import com.example.stormvpgit.Model.Shoes;
import com.example.stormvpgit.R;

public class ShopNowPresenter implements ShopNowContract.Presenter {
    private ShopNowContract.View view;
    private AppDao appDao;
    private int res;

    public ShopNowPresenter(AppDao appDao,int res) {
        this.appDao = appDao;
        this.res=res;
    }

    @Override
    public void onAttach(ShopNowContract.View view) {
        this.view=view;
    }

    @Override
    public void onDetach() {
        this.view=null;
    }

    @Override
    public void onAddToCartClicked() {
        Cart cart=new Cart();
        cart.setRes(res);
        cart.setName("Summer Nike");
        cart.setPrice(89);
        long id=appDao.addCart(cart);
        if (id > 0){
            cart.setCartId((int) id);
        }
        this.view.onCart(cart);
    }
}
