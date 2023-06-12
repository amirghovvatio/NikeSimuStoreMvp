package com.example.stormvpgit.Cart;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.stormvpgit.MainShop.MainShopActivity;
import com.example.stormvpgit.Model.AppDataBase;
import com.example.stormvpgit.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.snackbar.Snackbar;

public class CheckOutDialoge extends BottomSheetDialogFragment implements CheckOutContract.View {
    private CheckOutContract.Presenter presenter;
    TextView tvPrice;
    TextView tvSelected;
    TextView tvTotal;
    private CheckOutCallBack callBack;
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        callBack= (CheckOutCallBack) context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.checkout,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        View btnCheckout=view.findViewById(R.id.checkOutBtn);
         tvPrice=view.findViewById(R.id.tvPriceCheckout);
         tvSelected=view.findViewById(R.id.tvSelected);
         tvTotal=view.findViewById(R.id.tvTotal);
        presenter=new CheckOutPresenter(AppDataBase.getAppDataBase(getContext()).getDao());

        btnCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onCheckOutClicked();
            }
        });

        presenter.onAttach(this);
    }

    @Override
    public void checkOuted() {
        dismiss();
        callBack.onCheckOutClicked();

    }

    @Override
    public void getInfoes(int price, int total) {
        tvTotal.setText(String.valueOf(total));
        tvSelected.setText(String.valueOf(total));
        tvPrice.setText("$"+String.valueOf(price));
    }
    public interface CheckOutCallBack{
        void onCheckOutClicked();
    }
}
