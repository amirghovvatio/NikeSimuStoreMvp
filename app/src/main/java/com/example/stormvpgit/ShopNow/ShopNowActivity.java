package com.example.stormvpgit.ShopNow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.stormvpgit.Cart.CartActivity;
import com.example.stormvpgit.Model.AppDataBase;
import com.example.stormvpgit.Model.Cart;
import com.example.stormvpgit.Model.Shoes;
import com.example.stormvpgit.R;

public class ShopNowActivity extends AppCompatActivity implements ShopNowContract.View {
    private View addToCartBtn;
    private ShopNowContract.Presenter presenter;
    TextView tvCancelColor;
    View green;
    View red;
    View black;
    View yellow;
    View blue;
    LinearLayout colorPallette;
    TextView tvSizeOne;
    TextView tvSizeTwo;
    TextView tvSizeThree;
    TextView tvSizeFour;
    TextView tvSizeFive;
    TextView tvSizeSix;
    TextView tvCancelSize;
    TextView tvSelectSize;
    TextView tvSelectColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shop_now_page);
        presenter = new ShopNowPresenter(AppDataBase.getAppDataBase(this).getDao(), R.drawable.starter_shoe);
        colorSizeMethode();
        addToCartBtn = findViewById(R.id.infoAddToCartBtnNow);
        addToCartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onAddToCartClicked();
            }
        });

        presenter.onAttach(this);
    }

    @Override
    public void onCart(Cart cart) {
        Toast.makeText(this, "Added To Cart", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, CartActivity.class);
        startActivity(intent);
    }


   public void colorSizeMethode() {
       red = findViewById(R.id.colorRedNow);
       yellow = findViewById(R.id.colorYellowNow);
       black = findViewById(R.id.colorBlackNow);
       blue = findViewById(R.id.colorBlueNow);
       green = findViewById(R.id.colorGreenNow);
       tvCancelColor = findViewById(R.id.colorCancelNow);
       colorPallette = findViewById(R.id.colorContainerNow);
       //Color
       tvSelectColor = findViewById(R.id.tvColorSelectNow);
       tvCancelSize = findViewById(R.id.tvCancelSizeNow);
       tvSelectSize = findViewById(R.id.giveSizeTxtNow);
       tvCancelSize.setVisibility(View.GONE);
       tvSizeOne = findViewById(R.id.sizeOneNow);
       tvSizeTwo = findViewById(R.id.sizeTwoNow);
       tvSizeThree = findViewById(R.id.sizeThreeNow);
       tvSizeFour = findViewById(R.id.sizeFourNow);
       tvSizeFive = findViewById(R.id.sizeFiveNow);
       tvSizeSix = findViewById(R.id.tvSixNow);
       tvCancelColor.setVisibility(View.GONE);
       tvCancelColor.setVisibility(View.GONE);
       green.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               tvSelectColor.setText("Your Selected Color Is :");
               tvSelectColor.setTextSize(22);
               colorPallette.setBackgroundResource(R.drawable.green_color);
               red.setVisibility(View.GONE);
               yellow.setVisibility(View.GONE);
               black.setVisibility(View.GONE);
               blue.setVisibility(View.GONE);
               green.setVisibility(View.GONE);
               tvCancelColor.setVisibility(View.VISIBLE);

           }
       });
       red.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               tvSelectColor.setText("Your Selected Color Is :");
               tvSelectColor.setTextSize(22);

               colorPallette.setBackgroundResource(R.drawable.red_color);
               red.setVisibility(View.GONE);
               yellow.setVisibility(View.GONE);
               black.setVisibility(View.GONE);
               blue.setVisibility(View.GONE);
               green.setVisibility(View.GONE);
               tvCancelColor.setVisibility(View.VISIBLE);

           }
       });
       black.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               tvSelectColor.setText("Your Selected Color Is :");
               tvSelectColor.setTextSize(22);

               colorPallette.setBackgroundResource(R.drawable.black_color);
               red.setVisibility(View.GONE);
               yellow.setVisibility(View.GONE);
               black.setVisibility(View.GONE);
               blue.setVisibility(View.GONE);
               green.setVisibility(View.GONE);
               tvCancelColor.setVisibility(View.VISIBLE);

           }
       });
       yellow.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               tvSelectColor.setText("Your Selected Color Is :");
               tvSelectColor.setTextSize(22);

               colorPallette.setBackgroundResource(R.drawable.yellow_color);
               red.setVisibility(View.GONE);
               yellow.setVisibility(View.GONE);
               black.setVisibility(View.GONE);
               blue.setVisibility(View.GONE);
               green.setVisibility(View.GONE);
               tvCancelColor.setVisibility(View.VISIBLE);

           }
       });
       blue.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               tvSelectColor.setText("Your Selected Color Is :");
               tvSelectColor.setTextSize(22);
               colorPallette.setBackgroundResource(R.drawable.blue_color);
               red.setVisibility(View.GONE);
               yellow.setVisibility(View.GONE);
               black.setVisibility(View.GONE);
               blue.setVisibility(View.GONE);
               green.setVisibility(View.GONE);
               tvCancelColor.setVisibility(View.VISIBLE);
           }
       });
       tvCancelColor.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               tvSelectColor.setText("Select Your Color");
               tvSelectColor.setTextSize(16);
               colorPallette.setBackgroundResource(R.drawable.white_color);
               red.setVisibility(View.VISIBLE);
               yellow.setVisibility(View.VISIBLE);
               black.setVisibility(View.VISIBLE);
               blue.setVisibility(View.VISIBLE);
               green.setVisibility(View.VISIBLE);
               tvCancelColor.setVisibility(View.GONE);
           }
       });


       tvSizeOne.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               tvSelectSize.setText("Your Selected Size Is :");
               tvSelectSize.setTextSize(22);
               tvCancelSize.setVisibility(View.VISIBLE);
               tvSizeFive.setVisibility(View.GONE);
               tvSizeTwo.setVisibility(View.GONE);
               tvSizeThree.setVisibility(View.GONE);
               tvSizeFour.setVisibility(View.GONE);
               tvSizeSix.setVisibility(View.GONE);

           }
       });

       tvSizeTwo.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               tvSelectSize.setText("Your Selected Size Is :");
               tvSelectSize.setTextSize(22);
               tvCancelSize.setVisibility(View.VISIBLE);
               tvSizeOne.setVisibility(View.GONE);
               tvSizeFive.setVisibility(View.GONE);
               tvSizeThree.setVisibility(View.GONE);
               tvSizeFour.setVisibility(View.GONE);
               tvSizeSix.setVisibility(View.GONE);

           }
       });

       tvSizeThree.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               tvSelectSize.setText("Your Selected Size Is :");
               tvSelectSize.setTextSize(22);
               tvCancelSize.setVisibility(View.VISIBLE);
               tvSizeOne.setVisibility(View.GONE);
               tvSizeTwo.setVisibility(View.GONE);
               tvSizeFive.setVisibility(View.GONE);
               tvSizeFour.setVisibility(View.GONE);
               tvSizeSix.setVisibility(View.GONE);

           }
       });

       tvSizeFour.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               tvSelectSize.setText("Your Selected Size Is :");
               tvSelectSize.setTextSize(22);
               tvCancelSize.setVisibility(View.VISIBLE);
               tvSizeOne.setVisibility(View.GONE);
               tvSizeTwo.setVisibility(View.GONE);
               tvSizeThree.setVisibility(View.GONE);
               tvSizeFive.setVisibility(View.GONE);
               tvSizeSix.setVisibility(View.GONE);

           }
       });

       tvSizeFive.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               tvSelectSize.setText("Your Selected Size Is :");
               tvSelectSize.setTextSize(22);
               tvCancelSize.setVisibility(View.VISIBLE);
               tvSizeOne.setVisibility(View.GONE);
               tvSizeTwo.setVisibility(View.GONE);
               tvSizeThree.setVisibility(View.GONE);
               tvSizeFour.setVisibility(View.GONE);
               tvSizeSix.setVisibility(View.GONE);

           }
       });

       tvSizeSix.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               tvSelectSize.setText("Your Selected Size Is :");
               tvSelectSize.setTextSize(22);
               tvCancelSize.setVisibility(View.VISIBLE);
               tvSizeOne.setVisibility(View.GONE);
               tvSizeTwo.setVisibility(View.GONE);
               tvSizeThree.setVisibility(View.GONE);
               tvSizeFour.setVisibility(View.GONE);
               tvSizeFive.setVisibility(View.GONE);

           }
       });
       tvCancelSize.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               tvCancelSize.setVisibility(View.GONE);
               tvSizeOne.setVisibility(View.VISIBLE);
               tvSizeTwo.setVisibility(View.VISIBLE);
               tvSizeThree.setVisibility(View.VISIBLE);
               tvSizeFour.setVisibility(View.VISIBLE);
               tvSizeFive.setVisibility(View.VISIBLE);
               tvSizeSix.setVisibility(View.VISIBLE);
               tvSelectSize.setText("Select Your Size");
               tvSelectSize.setTextSize(16);

           }
       });


   }
}
