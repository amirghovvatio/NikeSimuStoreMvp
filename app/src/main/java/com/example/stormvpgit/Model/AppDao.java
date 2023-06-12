package com.example.stormvpgit.Model;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface AppDao {
    @Insert
    long addCart(Cart cart);
    @Delete
    int deleteCart(Cart cart);
    @Update
    int updateCart(Cart cart);
    @Query("Select * From _cart")
    List<Cart> getAllCartList();
    @Query("Delete From _cart")
    void clearAllCart();
//    @Query("Select * From _shoes Where name Like :Q")
//    List<Cart> onCartSearch(String Q);





    @Insert
    long addFavorite(Favorite favorite);
    @Delete
    int deleteFavorite(Favorite favorite);
    @Update
    int updateFavorite(Favorite favorite);
    @Query("Select * From _favorite")
    List<Favorite> getAllFavorite();
    @Query("Delete From _favorite")
    void clearAllFav();
    @Query("Select * From _favorite Where name like :q")
    List<Favorite> onFavSearch(String q);


    @Query("Select * From _shoes order by price desc")
    List<Shoes> shoesByPriceDesc();

    @Query("Select * From _shoes order by price asc")
    List<Shoes> shoesByPriceAsc();

    @Query("Select * From _shoes order by name desc")
    List<Shoes> shoesByNameDesc();

    @Query("Select * From _shoes order by name asc")
    List<Shoes> shoesByNameAsc();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void fillShoes(List<Shoes> shoes);
    @Query("Select * From _shoes")
    List<Shoes> getAllShoes();
    @Query("Select * From _shoes where name like '%' || :Q || '%'")
    List<Shoes> searchItems(String Q);

}
