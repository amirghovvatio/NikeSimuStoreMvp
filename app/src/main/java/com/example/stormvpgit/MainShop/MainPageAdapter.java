package com.example.stormvpgit.MainShop;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.stormvpgit.Model.Shoes;
import com.example.stormvpgit.R;

import java.util.List;

public class MainPageAdapter extends RecyclerView.Adapter<MainPageAdapter.MainViewHolder> {
    private List<Shoes> shoes;
    private MainAdapterEvent event;
    public MainPageAdapter(MainAdapterEvent event){

        this.event=event;
    }
    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list,parent,false);
        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        holder.bindData(shoes.get(position));
    }
    public void setShoes(List<Shoes> shoes){
        this.shoes=shoes;
        notifyDataSetChanged();
    }
    @Override
    public int getItemCount() {
        return shoes.size();
    }

    public class MainViewHolder extends RecyclerView.ViewHolder {
        ImageView favorite;
        ImageView shoes;
        View addToCart;
        TextView tvPrice;
        TextView tvName;
        public MainViewHolder(@NonNull View itemView) {
            super(itemView);
            favorite=itemView.findViewById(R.id.favoriteMain);
            shoes=itemView.findViewById(R.id.imageMain);
            addToCart=itemView.findViewById(R.id.addToCartBtn);
            tvPrice=itemView.findViewById(R.id.tvPriceMain);
            tvName=itemView.findViewById(R.id.tvNameMain);
        }
        public void bindData(Shoes shoes){
            favorite.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    event.onFavorite(shoes);
                }
            });
            this.shoes.setImageResource(shoes.getRes());
            addToCart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    event.onAddCart(shoes);
                }
            });
            tvPrice.setText("$"+String.valueOf(shoes.getPrice()));
            tvName.setText(shoes.getName());
        }
    }
    public interface MainAdapterEvent {
        void onFavorite(Shoes shoes);
        void onAddCart(Shoes shoes);
    }
}
