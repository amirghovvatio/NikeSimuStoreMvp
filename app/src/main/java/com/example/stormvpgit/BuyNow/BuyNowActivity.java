package com.example.stormvpgit.BuyNow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.stormvpgit.Cart.CartActivity;
import com.example.stormvpgit.Model.Shoes;
import com.example.stormvpgit.R;

public class BuyNowActivity extends AppCompatActivity implements BuyNowContract.View {
    private ImageView imgMain;
    private TextView tvToolbar;
    private View cartIc;
    private View backIc;
    private View buyNowBtn;
    private Shoes shoes;
    private TextView tvPrice;
    private BuyNowContract.Presenter presenter;
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
        setContentView(R.layout.buy_now);
        //==================================================================
        colorSizeMethode();
        //=================================================================

        shoes=getIntent().getParcelableExtra("xTra");
        presenter=new BuyNowPresenter();

        imgMain=findViewById(R.id.imgBuyNow);
        tvToolbar=findViewById(R.id.tvBuyNow);
        cartIc=findViewById(R.id.cartBuyNow);
        backIc=findViewById(R.id.backIcBuyNow);
        buyNowBtn=findViewById(R.id.buyNowBtn);
        tvPrice=findViewById(R.id.tvPriceBuyNow);

        tvPrice.setText("$"+String.valueOf(shoes.getPrice()));
        imgMain.setImageResource(shoes.getRes());
        tvToolbar.setText(shoes.getName());



        backIc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onBackClicked();
            }
        });
        cartIc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onCartClicked();
            }
        });
        buyNowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onBuyNowClicked();
            }
        });


        presenter.onAttach(this);
    }

    @Override
    public void back() {
        onBackPressed();
    }

    @Override
    public void onBuyNow() {

    }

    @Override
    public void onCart() {
        Intent intent=new Intent(this, CartActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDetach();
    }
    public void colorSizeMethode(){
        red=findViewById(R.id.colorRedBuyNow);
        yellow=findViewById(R.id.colorYellowBuyNow);
        black=findViewById(R.id.colorBlackBuyNow);
        blue=findViewById(R.id.colorBlueBuyNow);
        green=findViewById(R.id.colorGreenBuyNow);
        tvCancelColor=findViewById(R.id.colorCancelBuyNow);
        colorPallette=findViewById(R.id.colorContainerBuyNow);
        //Color
        tvSelectColor=findViewById(R.id.tvColorSelectBuyNow);
        tvCancelSize=findViewById(R.id.tvCancelSizeBuyNow);
        tvSelectSize=findViewById(R.id.giveSizeTxtBuyNow);
        tvCancelSize.setVisibility(View.GONE);
        tvSizeOne=findViewById(R.id.sizeOneBuyNow);
        tvSizeTwo=findViewById(R.id.sizeTwoBuyNow);
        tvSizeThree=findViewById(R.id.sizeThreeBuyNow);
        tvSizeFour=findViewById(R.id.sizeFourBuyNow);
        tvSizeFive=findViewById(R.id.sizeFiveBuyNow);
        tvSizeSix=findViewById(R.id.tvSixBuyNow);
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