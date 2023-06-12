package com.example.stormvpgit.Detail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.stormvpgit.Cart.CartActivity;
import com.example.stormvpgit.Model.AppDataBase;
import com.example.stormvpgit.Model.Cart;
import com.example.stormvpgit.Model.Shoes;
import com.example.stormvpgit.R;

public class DetailActivity extends AppCompatActivity implements DetailContract.View{
    private Shoes shoes;
    private ImageView imgMain;
    private TextView tvPrice;
    private TextView tvMain;
    private View addToCartBtn;
    private ImageView backIc;
    private View cartIc;
    private DetailContract.Presenter presenter;
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
        setContentView(R.layout.info_page);
        colorSizeMethode();

        shoes=getIntent().getParcelableExtra("zTra");
        presenter=new DetailPresenter(AppDataBase.getAppDataBase(this).getDao());

        tvPrice=findViewById(R.id.tvPriceInfo);
        backIc=findViewById(R.id.backIcInfo);
        imgMain=findViewById(R.id.imgInfo);
        tvMain=findViewById(R.id.tvMainInfo);
        addToCartBtn=findViewById(R.id.infoAddToCartBtn);
        cartIc=findViewById(R.id.cartInfoPage);

        cartIc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onCartClicked();
            }
        });

        tvPrice.setText("$"+String.valueOf(shoes.getPrice()));

        backIc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onBackClicked();
            }
        });

        imgMain.setImageResource(shoes.getRes());
        tvMain.setText(shoes.getName());


        addToCartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cart cart=new Cart();
                cart.setRes(shoes.getRes());
                cart.setPrice(shoes.getPrice());
                cart.setName(shoes.getName());

                presenter.onAddCartClicked(cart);
            }
        });


        presenter.onAttach(this);
    }

    @Override
    public void back() {
        onBackPressed();
    }

    @Override
    public void onCart() {
        Intent intent=new Intent(this, CartActivity.class);
        startActivity(intent);
    }

    @Override
    public void onAddCart() {
        Toast.makeText(this, "It Is Successfully Added To Cart !", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDetach();
    }

    public void colorSizeMethode(){
//

        red=findViewById(R.id.colorRed);
        yellow=findViewById(R.id.colorYellow);
        black=findViewById(R.id.colorBlack);
        blue=findViewById(R.id.colorBlue);
        green=findViewById(R.id.colorGreen);
        tvCancelColor=findViewById(R.id.colorCancel);
        colorPallette=findViewById(R.id.colorContainer);
        //Color
        tvSelectColor=findViewById(R.id.tvColorSelect);
        tvCancelSize=findViewById(R.id.tvCancelSize);
        tvSelectSize=findViewById(R.id.giveSizeTxt);
        tvCancelSize.setVisibility(View.GONE);
        tvSizeOne=findViewById(R.id.sizeOne);
        tvSizeTwo=findViewById(R.id.sizeTwo);
        tvSizeThree=findViewById(R.id.sizeThree);
        tvSizeFour=findViewById(R.id.sizeFour);
        tvSizeFive=findViewById(R.id.sizeFive);
        tvSizeSix=findViewById(R.id.tvSix);
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