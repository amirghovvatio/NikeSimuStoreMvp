package com.example.stormvpgit.Model;




import com.example.stormvpgit.R;

import java.util.ArrayList;
import java.util.List;

public class MainDataClass {
    public static List<Shoes> getAll(){
        List<Shoes> shoes=new ArrayList<>();
        shoes.add(new Shoes(1,"Air Max High",150, R.drawable.air));
        shoes.add(new Shoes(2,"Air Max Red",128,R.drawable.air2));
        shoes.add(new Shoes(3,"Air Max Simple",148,R.drawable.air3));
        shoes.add(new Shoes(4,"Air Max Plus",210,R.drawable.air4));
        shoes.add(new Shoes(5,"Air Max Low",279,R.drawable.air5));
        shoes.add(new Shoes(6,"Air Max Tiger",150,R.drawable.air6));
        shoes.add(new Shoes(7,"Air Max Minus",240,R.drawable.air7));
        shoes.add(new Shoes(8,"Air Max Pegasus",169,R.drawable.air8));
        shoes.add(new Shoes(9,"Air Max Us",123,R.drawable.air_9));
        shoes.add(new Shoes(10,"Air Max Army",145,R.drawable.air10));
        shoes.add(new Shoes(11,"Air Max CC",119,R.drawable.air11));
        shoes.add(new Shoes(12,"KD 15",349,R.drawable.basketball1));
        shoes.add(new Shoes(13,"Kyrie Flytrap",240,R.drawable.basketball2));
        shoes.add(new Shoes(14,"Lebron XX",419,R.drawable.basketball4));
        shoes.add(new Shoes(15,"Nike Zion W",520,R.drawable.basketball3));
        shoes.add(new Shoes(16,"Lebron Soldier",365,R.drawable.basketball5));
        shoes.add(new Shoes(17,"Kyrie Owe",215,R.drawable.basketball6));
        shoes.add(new Shoes(18,"Kyrie Infinity",136,R.drawable.basketball7));
        shoes.add(new Shoes(19,"CP3 No.1",940,R.drawable.basketball8));
        shoes.add(new Shoes(20,"Air Jordan Max",390,R.drawable.casual));
        shoes.add(new Shoes(21,"Air Jordan subs",210,R.drawable.casual1));
        shoes.add(new Shoes(22,"Air Jordan subs",410,R.drawable.casual2));
        shoes.add(new Shoes(23,"Nike Retro",159,R.drawable.casual3));
        shoes.add(new Shoes(24,"Nike Daily",134,R.drawable.casual4));
        shoes.add(new Shoes(25,"Air dub zero ",230,R.drawable.casual5));
        shoes.add(new Shoes(26,"Air max SC",290,R.drawable.casual6));
        shoes.add(new Shoes(27,"Air Vintage",310,R.drawable.casual6));
        shoes.add(new Shoes(28,"Air Vapor",199,R.drawable.casual7));
        shoes.add(new Shoes(29,"MaxFly",249,R.drawable.track1));
        shoes.add(new Shoes(30,"Zoom More",189,R.drawable.track2));
        shoes.add(new Shoes(31,"Zoom Victory",256,R.drawable.track3));
        shoes.add(new Shoes(32,"Alpha Fly",149,R.drawable.track4));
        shoes.add(new Shoes(33,"Javelin",179,R.drawable.track5));
        shoes.add(new Shoes(34,"High Jump",134,R.drawable.track6));
        shoes.add(new Shoes(35,"Metron",259,R.drawable.track7));
        shoes.add(new Shoes(36,"Vault Elite",300,R.drawable.track8));
        return shoes;
    }
    public static List<Shoes> getCasualList(){
        List<Shoes> shoes=new ArrayList<>();
        shoes.add(new Shoes(1,"Air Max High",150, R.drawable.air));
        shoes.add(new Shoes(2,"Air Max Red",128,R.drawable.air2));
        shoes.add(new Shoes(3,"Air Max Simple",148,R.drawable.air3));
        shoes.add(new Shoes(4,"Air Max Plus",210,R.drawable.air4));
        shoes.add(new Shoes(5,"Air Max Low",279,R.drawable.air5));
        shoes.add(new Shoes(6,"Air Max Tiger",150,R.drawable.air6));
        shoes.add(new Shoes(7,"Air Max Minus",240,R.drawable.air7));
        shoes.add(new Shoes(8,"Air Max Pegasus",169,R.drawable.air8));
        shoes.add(new Shoes(9,"Air Max Us",123,R.drawable.air_9));
        shoes.add(new Shoes(10,"Air Max Army",145,R.drawable.air10));
        shoes.add(new Shoes(11,"Air Max CC",119,R.drawable.air11));
        return shoes;
    }
    public static List<Shoes> getBasketballList(){
        List<Shoes> shoes=new ArrayList<>();
        shoes.add(new Shoes(1,"KD 15",349,R.drawable.basketball1));
        shoes.add(new Shoes(2,"Kyrie Flytrap",240,R.drawable.basketball2));
        shoes.add(new Shoes(3,"Lebron XX",419,R.drawable.basketball4));
        shoes.add(new Shoes(4,"Nike Zion W",520,R.drawable.basketball3));
        shoes.add(new Shoes(5,"Lebron Soldier",365,R.drawable.basketball5));
        shoes.add(new Shoes(6,"Kyrie Owe",215,R.drawable.basketball6));
        shoes.add(new Shoes(7,"Kyrie Infinity",136,R.drawable.basketball7));
        shoes.add(new Shoes(8,"CP3 No.1",940,R.drawable.basketball8));

        return shoes;
     }
    public static List<Shoes> getCasual(){
        List<Shoes> shoes=new ArrayList<>();
        shoes.add(new Shoes(1,"Air Jordan Max",390,R.drawable.casual));
        shoes.add(new Shoes(2,"Air Jordan subs",210,R.drawable.casual1));
         shoes.add(new Shoes(3,"Air Jordan subs",410,R.drawable.casual2));
         shoes.add(new Shoes(4,"Nike Retro",159,R.drawable.casual3));
         shoes.add(new Shoes(5,"Nike Daily",134,R.drawable.casual4));
         shoes.add(new Shoes(6,"Air dub zero ",230,R.drawable.casual5));
         shoes.add(new Shoes(7,"Air max SC",290,R.drawable.casual6));
         shoes.add(new Shoes(8,"Air Vintage",310,R.drawable.casual6));
         shoes.add(new Shoes(9,"Air Vapor",199,R.drawable.casual7));

         return shoes;
     }
    public static List<Shoes> getTracks(){
        List<Shoes> shoes=new ArrayList<>();
         shoes.add(new Shoes(1,"MaxFly",249,R.drawable.track1));
         shoes.add(new Shoes(2,"Zoom More",189,R.drawable.track2));
         shoes.add(new Shoes(3,"Zoom Victory",256,R.drawable.track3));
         shoes.add(new Shoes(4,"Alpha Fly",149,R.drawable.track4));
         shoes.add(new Shoes(5,"Javelin",179,R.drawable.track5));
         shoes.add(new Shoes(6,"High Jump",134,R.drawable.track6));
         shoes.add(new Shoes(7,"Metron",259,R.drawable.track7));
         shoes.add(new Shoes(8,"Vault Elite",300,R.drawable.track8));
        shoes.add(new Shoes(1,"Fly Easy",129,R.drawable.running));
        shoes.add(new Shoes(2,"Run Road",139,R.drawable.running2));
        shoes.add(new Shoes(3,"Free Run",209,R.drawable.running3));
        shoes.add(new Shoes(4,"Invicible",149,R.drawable.running4));
        shoes.add(new Shoes(5,"Next Nature",249,R.drawable.running5));
        shoes.add(new Shoes(6,"Turbo",245,R.drawable.running6));
        shoes.add(new Shoes(7,"Pegasus Plus",279,R.drawable.running7));
        shoes.add(new Shoes(8,"WildHorse",119,R.drawable.running8));
        shoes.add(new Shoes(9,"Vomero",99,R.drawable.running9));
        shoes.add(new Shoes(10,"Terra",86,R.drawable.running10));
        shoes.add(new Shoes(11,"Kiger",149, R.drawable.running11));
         return shoes;
     }
    public static List<Shoes> getRunning(){
        List<Shoes> shoes=new ArrayList<>();
        shoes.add(new Shoes(1,"Fly Easy",129,R.drawable.running));
        shoes.add(new Shoes(2,"Run Road",139,R.drawable.running2));
        shoes.add(new Shoes(3,"Free Run",209,R.drawable.running3));
        shoes.add(new Shoes(4,"Invicible",149,R.drawable.running4));
        shoes.add(new Shoes(5,"Next Nature",249,R.drawable.running5));
        shoes.add(new Shoes(6,"Turbo",245,R.drawable.running6));
        shoes.add(new Shoes(7,"Pegasus Plus",279,R.drawable.running7));
        shoes.add(new Shoes(8,"WildHorse",119,R.drawable.running8));
        shoes.add(new Shoes(9,"Vomero",99,R.drawable.running9));
        shoes.add(new Shoes(10,"Terra",86,R.drawable.running10));
        shoes.add(new Shoes(11,"Kiger",149,R.drawable.running11));
        shoes.add(new Shoes(1,"Air Sculpt",142,R.drawable.woman_r ));
        shoes.add(new Shoes(2,"TC 7900",192,R.drawable.woman_r2 ));
        shoes.add(new Shoes(3,"Court Legacy",139,R.drawable.woman_r3));
        shoes.add(new Shoes(4,"Airmax 90",299,R.drawable.woman_r4 ));
        shoes.add(new Shoes(5,"Air Force",164,R.drawable.woman_r5 ));
        shoes.add(new Shoes(6,"City Classic",199,R.drawable.woman_r6 ));
        shoes.add(new Shoes(7,"Tanjun",130,R.drawable.woman_r7 ));
        return shoes;
    }
    public static List<Shoes> getWoman(){
        List<Shoes> shoes=new ArrayList<>();
        shoes.add(new Shoes(1,"Air Sculpt",142,R.drawable.woman_r ));
        shoes.add(new Shoes(2,"TC 7900",192,R.drawable.woman_r2 ));
        shoes.add(new Shoes(3,"Court Legacy",139,R.drawable.woman_r3));
        shoes.add(new Shoes(4,"Airmax 90",299,R.drawable.woman_r4 ));
        shoes.add(new Shoes(5,"Air Force",164,R.drawable.woman_r5 ));
        shoes.add(new Shoes(6,"City Classic",199,R.drawable.woman_r6 ));
        shoes.add(new Shoes(7,"Tanjun",130,R.drawable.woman_r7 ));
        return shoes;
    }
    public static List<Shoes> newCollections(){
        List<Shoes> collections=new ArrayList<>();
        collections.add(new Shoes(1,"Vault Elite",300,R.drawable.track8));
        collections.add(new Shoes(2,"Air Vintage",310,R.drawable.casual6));
        collections.add(new Shoes(3,"Air Max CC",119,R.drawable.air11));
        collections.add(new Shoes(4,"Air max SC",290,R.drawable.casual6));
        collections.add(new Shoes(5,"Zoom More",189,R.drawable.track2));
        collections.add(new Shoes(6,"Kyrie Owe",215,R.drawable.basketball6));
        collections.add(new Shoes(7,"High Jump",134,R.drawable.track6));

        return collections;

    }
}
