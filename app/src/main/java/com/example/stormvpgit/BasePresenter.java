package com.example.stormvpgit;

public interface BasePresenter<T extends BaseView> {
    void onAttach(T view);
    void onDetach();
}
