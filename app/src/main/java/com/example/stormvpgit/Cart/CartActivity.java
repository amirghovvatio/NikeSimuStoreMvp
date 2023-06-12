package com.example.stormvpgit.Cart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.stormvpgit.BuyNow.BuyNowActivity;
import com.example.stormvpgit.Explore.SearchDialog;
import com.example.stormvpgit.Favorite.FavoriteActivity;
import com.example.stormvpgit.Model.AppDataBase;
import com.example.stormvpgit.Model.Cart;
import com.example.stormvpgit.Model.Favorite;
import com.example.stormvpgit.Model.Shoes;
import com.example.stormvpgit.R;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class CartActivity extends AppCompatActivity implements CartContract.View, CartAdapter.CartAdapterEventListener, CheckOutDialoge.CheckOutCallBack {
    private RecyclerView rvCart;
    private CartContract.Presenter presenter;
    private CartAdapter adapter;
    private ImageView favIc;
    private ImageView backIc;
    private View checkOutBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cart_page);

        presenter=new CartPresenter(AppDataBase.getAppDataBase(this).getDao());
        adapter=new CartAdapter(this);

        checkOutBtn=findViewById(R.id.cartPagePayBtn);
        backIc=findViewById(R.id.backIcCart);
        favIc=findViewById(R.id.favBtnCart);
        rvCart=findViewById(R.id.rvCartShoesList);

        rvCart.setAdapter(adapter);
        rvCart.setLayoutManager(new GridLayoutManager(this,2,RecyclerView.VERTICAL,false));

        backIc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onBackClicked();
            }
        });

        favIc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onFavClicked();
            }
        });

        checkOutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onCheckOutClicked();
            }
        });


        presenter.onAttach(this);
    }

    @Override
    public void showList(List<Cart> carts) {
        adapter.setCarts(carts);
    }

    @Override
    public void onFav() {
        Intent intent=new Intent(this, FavoriteActivity.class);
        startActivity(intent);
    }

    @Override
    public void onCheckOut() {
        CheckOutDialoge dialoge=new CheckOutDialoge();
        dialoge.show(getSupportFragmentManager(),null);
    }

    @Override
    public void onBuyNow(Shoes shoes) {
            Intent intent=new Intent(this, BuyNowActivity.class);
            intent.putExtra("xTra",shoes);
            startActivity(intent);
    }

    @Override
    public void onAddFav() {

    }

    @Override
    public void onBack() {
        onBackPressed();
    }

    @Override
    public void onDelete(Cart cart) {
            adapter.deleteCart(cart);
    }

    @Override
    public void onCheckOutChange() {
        adapter.clearAll();
    }

    @Override
    public void onFavorite(Cart cart) {
        Favorite favorite=new Favorite();
        favorite.setName(cart.getName());
        favorite.setPrice(cart.getPrice());
        favorite.setRes(cart.getRes());

        presenter.onAddFavClicked(favorite);
    }

    @Override
    public void onBuyNow(Cart cart) {
        Shoes shoes=new Shoes();
        shoes.setRes(cart.getRes());
        shoes.setName(cart.getName());
        shoes.setPrice(cart.getPrice());

        presenter.onBuyNowClicked(shoes);
    }

    @Override
    public void onDelteClicked(Cart cart) {
        presenter.onDeleteClicked(cart);
    }


    @Override
    public void onCheckOutClicked() {
        presenter.onCheckOutCallBacked();
    }
}