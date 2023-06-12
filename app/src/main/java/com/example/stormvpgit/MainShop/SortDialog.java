package com.example.stormvpgit.MainShop;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.stormvpgit.R;

public class SortDialog extends DialogFragment {
    private int order=0;
    private int sort=0;
    private SortCallBack callBack;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        callBack= (SortCallBack) context;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder=new AlertDialog.Builder(getContext());
        View view= LayoutInflater.from(getContext()).inflate(R.layout.sort_dialoge,null,false);
        builder.setView(view);
        RadioGroup radioGroup=view.findViewById(R.id.radiGroupOrderBy);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.ascendingOrder:
                            order=1;
                        break;

                    case R.id.descendingOrder:
                            order=2;
                        break;
                }
            }
        });

        RadioGroup radioSort=view.findViewById(R.id.radiGroupSortBy);
        radioSort.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.nameSort:
                            sort=1;
                        break;
                    case R.id.priceSort:
                            sort=2;
                        break;
                }
            }
        });

        View sortBtn=view.findViewById(R.id.dialogSortBtn);
        sortBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sort != 0 && order != 0){
                callBack.onSorted(order,sort);
                dismiss();
                }
            }
        });

        return builder.create();
    }
    public interface SortCallBack{
        void onSorted(int order,int sort);
    }
}
