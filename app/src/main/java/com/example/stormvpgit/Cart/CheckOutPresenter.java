package com.example.stormvpgit.Cart;

import com.example.stormvpgit.Model.AppDao;

public class CheckOutPresenter implements CheckOutContract.Presenter{
    private CheckOutContract.View view;
    private AppDao dao;

    public CheckOutPresenter(AppDao dao) {
        this.dao = dao;
    }

    @Override
    public void onAttach(CheckOutContract.View view) {
        this.view=view;
        int size=0;
        int price=0;
        for (int i = 0; i <dao.getAllCartList().size() ; i++) {
            size+=1;
            price+=dao.getAllCartList().get(i).getPrice();
        }
        this.view.getInfoes(price,size);
    }

    @Override
    public void onDetach() {
        this.view=null;
    }

    @Override
    public void onCheckOutClicked() {
        this.view.checkOuted();
        dao.clearAllCart();
    }
}
