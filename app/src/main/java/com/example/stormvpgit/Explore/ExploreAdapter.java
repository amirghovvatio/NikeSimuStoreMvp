package com.example.stormvpgit.Explore;

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

public class ExploreAdapter extends RecyclerView.Adapter<ExploreAdapter.ExploreViewHolder> {
    private List<Shoes> shoes;
    private ExploreEventListener exploreEventListener;

    public ExploreAdapter(ExploreEventListener exploreEventListener) {
        this.exploreEventListener = exploreEventListener;
    }

    @NonNull
    @Override
    public ExploreViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.ex_list,parent,false);
        return new ExploreViewHolder(view);
    }
    public void setShoes(List<Shoes> shoes){
        this.shoes=shoes;
        notifyDataSetChanged();
    }
    public void changeList(List<Shoes>shoes){
        this.shoes=shoes;
        notifyDataSetChanged();
    }
    @Override
    public void onBindViewHolder(@NonNull ExploreViewHolder holder, int position) {
        holder.bindAll(shoes.get(position));
    }

    @Override
    public int getItemCount() {
        return shoes.size();
    }

    public class ExploreViewHolder extends RecyclerView.ViewHolder {
        private ImageView fav;
        private ImageView main;
        private TextView tvName;
        private TextView tvPrice;
        private View btnBuyNow;
        public ExploreViewHolder(@NonNull View itemView) {
            super(itemView);
            fav=itemView.findViewById(R.id.exploreFav);
            main=itemView.findViewById(R.id.exploreMainImg);
            tvName=itemView.findViewById(R.id.exploreTvName);
            tvPrice=itemView.findViewById(R.id.exploreTvPrice);
            btnBuyNow=itemView.findViewById(R.id.exploreBuyNowBtn);

        }
        public void bindAll(Shoes shoes){
            main.setImageResource(shoes.getRes());
            tvName.setText(shoes.getName());
            tvPrice.setText("$"+String.valueOf(shoes.getPrice()));
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    exploreEventListener.onItemClicked(shoes);
                }
            });
            btnBuyNow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    exploreEventListener.onBuyClicked(shoes);
                }
            });
            fav.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    exploreEventListener.onFavClicked(shoes);
                }
            });
        }
    }
    public interface ExploreEventListener{
        void onItemClicked(Shoes shoes);
        void onFavClicked(Shoes shoes);
        void onBuyClicked(Shoes shoes);
    }
}
