package com.example.stormvpgit.Starter;

import com.example.stormvpgit.BasePresenter;
import com.example.stormvpgit.BaseView;

public interface StarterContract {
    interface View extends BaseView {
        void onStarted();
    }
    interface Presenter extends BasePresenter<View>{
        void onStartClicked();
    }
}
