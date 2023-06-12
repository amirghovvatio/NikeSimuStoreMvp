package com.example.stormvpgit.Explore;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.stormvpgit.R;

import java.util.ArrayList;
import java.util.List;

public class ButtonAdapter extends RecyclerView.Adapter<ButtonAdapter.ButtonViewHolder> {
    private List<String> categories=new ArrayList<>();
    private ButtonAdapterEventListener eventListener;


    public ButtonAdapter(ButtonAdapterEventListener eventListener){
        categories.add("All Shoes");
        categories.add("Basketball");
        categories.add("Casual");
        categories.add("Tracks");
        categories.add("Air Jordans");
        categories.add("Womans");
        this.eventListener = eventListener;
    }

    @NonNull
    @Override
    public ButtonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.expolore_btn_rv_list,parent,false);
        return new ButtonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ButtonViewHolder holder, int position) {
            holder.tvCategory.setText(categories.get(position));
            holder.bindButtons();
    }

    @Override
    public int getItemCount() {
        return 6;
    }


    public class ButtonViewHolder extends RecyclerView.ViewHolder{
        TextView tvCategory;
        public ButtonViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCategory=itemView.findViewById(R.id.tvCategroy);
        }
        public void bindButtons(){

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    eventListener.onItemzClicked(getAdapterPosition());
                    switch (getAdapterPosition()){
                        case 0:

                            break;
                        case 1:

                            break;
                        case 2:
                             break;
                        case 3:

                            break;
                        case 4:

                             break;
                        case 5:


                            break;
                    }


                }
                public void resetColor(){
                    itemView.setBackgroundColor(R.drawable.white_color);
                }
            });

        }

    }
    public interface ButtonAdapterEventListener{
        void onItemzClicked(int pos);

    }
}
