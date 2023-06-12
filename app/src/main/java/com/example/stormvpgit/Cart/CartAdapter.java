package com.example.stormvpgit.Cart;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.stormvpgit.Model.Cart;
import com.example.stormvpgit.R;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {
    private List<Cart> carts;
    private CartAdapterEventListener eventListener;

    public CartAdapter(CartAdapterEventListener eventListener) {
        this.eventListener = eventListener;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_list,parent,false);
        return new CartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
            holder.bindCart(carts.get(position));
    }
    public void clearAll(){
        this.carts.clear();
        notifyDataSetChanged();
    }
    public void setCarts(List<Cart> carts){
        this.carts=carts;
        notifyDataSetChanged();
    }
    public void deleteCart(Cart cart){
        int index=carts.indexOf(cart);
        carts.remove(cart);
        notifyItemRemoved(index);
    }

    @Override
    public int getItemCount() {
        return carts.size();
    }

    public class CartViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgMain;
        private ImageView imgFav;
        private ImageView deleteIc;
        private TextView tvName;
        private TextView tvPrice;
        private View buyNowBtn;
        public CartViewHolder(@NonNull View itemView) {
            super(itemView);
            imgMain=itemView.findViewById(R.id.mainImgCartList);
            imgFav=itemView.findViewById(R.id.addFavCartList);
            tvName=itemView.findViewById(R.id.tvMainCartList);
            tvPrice=itemView.findViewById(R.id.tvPriceCartList);
            buyNowBtn=itemView.findViewById(R.id.buyNowCartList);
            deleteIc=itemView.findViewById(R.id.cartListDelete);
        }
        public void bindCart(Cart cart){
            imgFav.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    eventListener.onFavorite(cart);
                }
            });
            deleteIc.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    eventListener.onDelteClicked(cart);
                }
            });
            imgMain.setImageResource(cart.getRes());
            tvName.setText(cart.getName());
            tvPrice.setText("$"+String.valueOf(cart.getPrice()));
            buyNowBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    eventListener.onBuyNow(cart);
                }
            });
        }
    }
    public interface CartAdapterEventListener{
        void onFavorite(Cart cart);
        void onBuyNow(Cart cart);
        void onDelteClicked(Cart cart);
    }
}
