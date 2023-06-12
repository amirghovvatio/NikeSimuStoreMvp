package com.example.stormvpgit.Starter;

public class StarterPresenter implements StarterContract.Presenter{
    private StarterContract.View view;
    @Override
    public void onAttach(StarterContract.View view) {
        this.view=view;
    }

    @Override
    public void onDetach() {
        this.view=null;
    }

    @Override
    public void onStartClicked() {
        this.view.onStarted();
    }
}
