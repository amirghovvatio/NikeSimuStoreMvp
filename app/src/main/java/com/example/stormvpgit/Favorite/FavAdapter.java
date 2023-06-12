package com.example.stormvpgit.Favorite;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.stormvpgit.Model.Favorite;
import com.example.stormvpgit.R;

import java.util.List;

public class FavAdapter extends RecyclerView.Adapter<FavAdapter.FavViewHolder> {
    private FavAdapterEventListener eventListener;
    private List<Favorite> favorites;

    public FavAdapter(FavAdapterEventListener eventListener) {
        this.eventListener = eventListener;
    }

    @NonNull
    @Override
    public FavViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.favorite_list,parent,false);
        return new FavViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavViewHolder holder, int position) {
        holder.bindFavorite(favorites.get(position));
    }
    public void deleteItem(Favorite favorite){
        int index=favorites.indexOf(favorite);
        favorites.remove(favorite);
        notifyItemRemoved(index);
    }
    public void deleteAll(){
        favorites.clear();
        notifyDataSetChanged();
    }

    public void setFav(List<Favorite> favorites){
        this.favorites=favorites;
        notifyDataSetChanged();
    }
    @Override
    public int getItemCount() {
        return favorites.size();
    }

    public class FavViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgMain;
        private TextView tvMain;
        private TextView tvPrice;
        private ImageView imgDelete;
        public FavViewHolder(@NonNull View itemView) {
            super(itemView);
            imgMain=itemView.findViewById(R.id.favImg);
            imgDelete=itemView.findViewById(R.id.deleteFav);
            tvPrice=itemView.findViewById(R.id.tvPriceFavList);
            tvMain=itemView.findViewById(R.id.tvNameFavList);
        }
        public void bindFavorite(Favorite favorite){
            imgMain.setImageResource(favorite.getRes());
            imgDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    eventListener.onDeleteClicked(favorite);
                }
            });
            tvPrice.setText("$"+String.valueOf(favorite.getPrice()));
            tvMain.setText(favorite.getName());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    eventListener.onItemClicked(favorite);
                }
            });
        }
    }
    public interface FavAdapterEventListener{
        void onDeleteClicked(Favorite favorite);
        void onItemClicked(Favorite favorite);
    }
}
