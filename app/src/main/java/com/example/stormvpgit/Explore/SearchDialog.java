package com.example.stormvpgit.Explore;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.stormvpgit.R;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

public class SearchDialog extends DialogFragment {
    private SearchCallBack callBack;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        callBack= (SearchCallBack) context;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder=new AlertDialog.Builder(getContext());
        View view= LayoutInflater.from(getContext()).inflate(R.layout.search_dialoge,null,false );
        builder.setView(view);
        TextInputEditText edtSearch=view.findViewById(R.id.edtSearch);
        ExtendedFloatingActionButton submitSearch=view.findViewById(R.id.submitSearch);
        submitSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callBack.onSearch(edtSearch.getText().toString());
                dismiss();
            }
        });
        return builder.create();
    }
    public interface SearchCallBack{
        void onSearch(String q);
    }
}
