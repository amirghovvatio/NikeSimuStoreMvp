package com.example.stormvpgit.MainShop;

import static com.google.android.material.snackbar.Snackbar.make;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.stormvpgit.Cart.CartActivity;
import com.example.stormvpgit.Explore.ExploreActivity;
import com.example.stormvpgit.Favorite.FavoriteActivity;
import com.example.stormvpgit.Favorite.FavoritePresenter;
import com.example.stormvpgit.Model.AppDataBase;
import com.example.stormvpgit.Model.Cart;
import com.example.stormvpgit.Model.Favorite;
import com.example.stormvpgit.Model.Shoes;
import com.example.stormvpgit.R;
import com.example.stormvpgit.ShopNow.ShopNowActivity;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class MainShopActivity extends AppCompatActivity implements MainShopContract.View,MainPageAdapter.MainAdapterEvent {
    private View shopNowBtn;
    private TextView seeAll;
    private View cartBtn;
    private RecyclerView rvCollection;
    private MainPageAdapter adapter;
    private ImageView icCart;
    private ImageView icFav;

    private MainShopContract.Presenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainshop);

        icCart=findViewById(R.id.mainCartIc);
        icFav=findViewById(R.id.mainFavoritIc);
        shopNowBtn=findViewById(R.id.shopNowBtn);
        seeAll=findViewById(R.id.seeAllMain);
        cartBtn=findViewById(R.id.cartMainShop);
        rvCollection=findViewById(R.id.rvMain);


        icFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onFavClicked();
            }
        });

        icCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onCartClickedTop();
            }
        });

        adapter=new MainPageAdapter(this);
        presenter=new MainShopPresenter(AppDataBase.getAppDataBase(this).getDao());

        rvCollection.setAdapter(adapter);
        rvCollection.setLayoutManager(new GridLayoutManager(this,2,RecyclerView.VERTICAL,false));

        seeAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onSeeAllClicked();
            }
        });
        shopNowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onShopNowClicked();
            }
        });
        cartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onCartClicked();
            }
        });

        presenter.onAttach(this);
    }

    @Override
    public void showNewCollectionList(List<Shoes> shoes) {
        adapter.setShoes(shoes);
    }

    @Override
    public void shopNow() {
        Intent intent=new Intent(this, ShopNowActivity.class);
        startActivity(intent);
    }

    @Override
    public void seeAll() {
        Intent intent=new Intent(this, ExploreActivity.class);
        startActivity(intent);
    }

    @Override
    public void onCart() {
        Intent intent=new Intent(this,CartActivity.class);
        startActivity(intent);
    }

    @Override
    public void onFav() {
        Intent intent=new Intent(this, FavoriteActivity.class);
        startActivity(intent);
    }


    @Override
    public void cart() {
        Intent intent=new Intent(this, CartActivity.class);
        startActivity(intent);
    }

    @Override
    public void onFavAdded() {
        Toast.makeText(this, "Item Added To Favorite !", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCartAdded() {
        Toast.makeText(this, "Item Added To Cart !", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFavorite(Shoes shoes) {
        Favorite favorite=new Favorite();
        favorite.setName(shoes.getName());
        favorite.setPrice(shoes.getPrice());
        favorite.setRes(shoes.getRes());
        presenter.onAddFavClicked(favorite);
    }

    @Override
    public void onAddCart(Shoes shoes) {
        Cart cart=new Cart();
        cart.setName(shoes.getName());
        cart.setRes(shoes.getRes());
        cart.setPrice(shoes.getPrice());
        presenter.onAddCartClicked(cart);

    }
}