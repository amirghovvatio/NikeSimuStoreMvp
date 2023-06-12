package com.example.stormvpgit.Favorite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.stormvpgit.Detail.DetailActivity;
import com.example.stormvpgit.Model.AppDataBase;
import com.example.stormvpgit.Model.Favorite;
import com.example.stormvpgit.Model.Shoes;
import com.example.stormvpgit.R;

import java.util.List;

public class FavoriteActivity extends AppCompatActivity implements FavoriteContract.View, FavAdapter.FavAdapterEventListener {
    private FavoriteContract.Presenter presenter;
    private RecyclerView rvFavList;
    private FavAdapter adapter;
    private View clearAll;
    private ImageView backIc;
    private  View addAllToCart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.favorite_page);

        addAllToCart=findViewById(R.id.addAllToCartBtnFav);
        rvFavList=findViewById(R.id.rvFavoriteList);
        backIc=findViewById(R.id.backIcFav);
        clearAll=findViewById(R.id.cleaAll);

        backIc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onBackClicked();
            }
        });

        clearAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onClearAllClicked();
            }
        });

        presenter=new FavoritePresenter(AppDataBase.getAppDataBase(this).getDao());
        adapter=new FavAdapter(this);

        rvFavList.setAdapter(adapter);
        rvFavList.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));




        addAllToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onAddAllToCart();
            }
        });

        presenter.onAttach(this);
    }

    @Override
    public void showList(List<Favorite> favorites) {
        adapter.setFav(favorites);
    }

    @Override
    public void deleteAll() {
        adapter.deleteAll();
    }

    @Override
    public void deleteItem(Favorite favorite) {
        adapter.deleteItem(favorite);
    }

    @Override
    public void back() {
        onBackPressed();
    }

    @Override
    public void onAddAll() {
        adapter.deleteAll();
        Toast.makeText(this, "All Added To Cart !", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItem(Favorite favorite) {
        Shoes shoes=new Shoes();
        shoes.setPrice(favorite.getPrice());
        shoes.setName(favorite.getName());
        shoes.setRes(favorite.getRes());
        Intent intent=new Intent(this, DetailActivity.class);
        intent.putExtra("zTra",shoes);
        startActivity(intent);
    }

    @Override
    public void onDeleteClicked(Favorite favorite) {
        presenter.onDeleteClicked(favorite);
    }

    @Override
    public void onItemClicked(Favorite favorite) {
        presenter.onItem(favorite);
    }
}