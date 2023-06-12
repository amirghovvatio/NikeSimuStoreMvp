package com.example.stormvpgit.Explore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.stormvpgit.BuyNow.BuyNowActivity;
import com.example.stormvpgit.Cart.CheckOutDialoge;
import com.example.stormvpgit.Detail.DetailActivity;
import com.example.stormvpgit.MainShop.SortDialog;
import com.example.stormvpgit.Model.AppDataBase;
import com.example.stormvpgit.Model.Favorite;
import com.example.stormvpgit.Model.Shoes;
import com.example.stormvpgit.R;

import java.util.List;

public class ExploreActivity extends AppCompatActivity implements ExploreContract.View, ExploreAdapter.ExploreEventListener, ButtonAdapter.ButtonAdapterEventListener, SortDialog.SortCallBack, SearchDialog.SearchCallBack {
    private RecyclerView rvSortList;
    private RecyclerView rvShoesList;
    private ExploreAdapter adapterMain;
    private ButtonAdapter adapterSort;
    private View sortIc;
    private View searchIc;
    private ExploreContract.Presenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.see_all_page);

        presenter=new ExplorePresenter(AppDataBase.getAppDataBase(this).getDao());

        searchIc=findViewById(R.id.searchIc);
        searchIc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    presenter.onSearchCicked();
            }
        });
        rvSortList=findViewById(R.id.rvExploreSort);
        rvShoesList=findViewById(R.id.rvExploreShoesList);
        sortIc =findViewById(R.id.sortExplore);

        sortIc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onSortClicked();
            }
        });


        adapterMain=new ExploreAdapter(this);
        adapterSort=new ButtonAdapter(this);

        rvSortList.setAdapter(adapterSort);
        rvSortList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));

        rvShoesList.setAdapter(adapterMain);
        rvShoesList.setLayoutManager(new GridLayoutManager(this,2,RecyclerView.VERTICAL,false));

        presenter.onAttach(this);
    }

    @Override
    public void showList(List<Shoes> shoes) {
        adapterMain.setShoes(shoes);
    }

    @Override
    public void goToBuyNow(Shoes shoes) {
        Intent intent=new Intent(this, BuyNowActivity.class);
        intent.putExtra("xTra",shoes);
        startActivity(intent);
    }



    @Override
    public void onFav() {
        Toast.makeText(this, "Item Added To Favorite !", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSort() {
        SortDialog sortDialog=new SortDialog();
        sortDialog.show(getSupportFragmentManager(),null);
    }

    @Override
    public void onItem(Shoes shoes) {
        Intent intent=new Intent(this, DetailActivity.class);
        intent.putExtra("zTra",shoes);
        startActivity(intent);
    }

    @Override
    public void onTracks(List<Shoes> tracks) {
        adapterMain.changeList(tracks);
    }

    @Override
    public void onAir(List<Shoes> air) {
        adapterMain.changeList(air);
    }

    @Override
    public void onWoman(List<Shoes> woman) {
        adapterMain.changeList(woman);
    }

    @Override
    public void onBasketBall(List<Shoes> basketBall) {
        adapterMain.changeList(basketBall);
    }

    @Override
    public void onAll(List<Shoes> all) {
        adapterMain.changeList(all);
    }

    @Override
    public void onCasual(List<Shoes> casual) {
        adapterMain.changeList(casual);
    }

    @Override
    public void onSortedView(List<Shoes> shoes) {
        adapterMain.changeList(shoes);
    }

    @Override
    public void onSearch() {
        SearchDialog dialog=new SearchDialog();
        dialog.show(getSupportFragmentManager(),null);
    }

    @Override
    public void onSearchResult(List<Shoes> shoes) {
        adapterMain.changeList(shoes);
    }

    @Override
    public void onItemClicked(Shoes shoes) {
            presenter.onItemClicked(shoes);
    }

    @Override
    public void onFavClicked(Shoes shoes) {
        Favorite favorite=new Favorite();
        favorite.setRes(shoes.getRes());
        favorite.setPrice(shoes.getPrice());
        favorite.setName(shoes.getName());
        presenter.onAddFavoriteClicked(favorite);

    }

    @Override
    public void onBuyClicked(Shoes shoes) {
        presenter.onBuyNowClicked(shoes);
    }

    @Override
    public void onItemzClicked(int pos) {
        switch (pos){
            case 0:
                presenter.onAllClicked();
                break;
            case 1:
                presenter.onBasketBallClicked();
                break;
            case 2:
                presenter.onCaualClicked();
                break;
            case 3:
                presenter.onTracksClicked();
                break;
            case 4:
                presenter.onAirClicked();
                break;
            case 5:
                presenter.onWomanClicked();
                break;


        }
    }

    @Override
    public void onSorted(int order, int sort) {
        if (order == 1 && sort == 1){
            presenter.onSorted(order,sort);
        }else if (order == 1 && sort == 2){
            presenter.onSorted(order,sort);
        }else if (sort==2 && sort ==1){
            presenter.onSorted(order,sort);
        }else if (sort ==2 && sort ==2){
            presenter.onSorted(order,sort);
        }else {
            presenter.onAllClicked();
        }
    }

    @Override
    public void onSearch(String q) {
        presenter.onSearchCallBack(q);
    }

}