package com.example.stormvpgit.BuyNow;

public class BuyNowPresenter implements BuyNowContract.Presenter{
    private BuyNowContract.View view;
    @Override
    public void onAttach(BuyNowContract.View view) {
        this.view=view;
    }

    @Override
    public void onDetach() {
        this.view=null;
    }

    @Override
    public void onBuyNowClicked() {
        view.onBuyNow();
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
