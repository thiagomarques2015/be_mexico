package br.com.bemexico;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Thiago on 02/09/2016.
 */
public class Pool {

    public static class Color{
        public static int BURRITO = 1;
        public static final int POBLANO = 2;
    }

    private static HashMap<Integer, Detail> foods;

    static  {
        foods = new HashMap<>();
        // Burrito
        Detail burrito = new Detail();
        burrito.setTitle("Burrito");
        burrito.setImage(R.drawable.burrito);
        burrito.setTitleList1("Main");
        burrito.addList1("Flour tortillas");
        burrito.addList1("Meat and beans or refried beans");
        burrito.setTitleList2("Generally Used");
        burrito.addList2("Cheese");
        burrito.addList2("Rice");
        burrito.addList2("Lettuce");
        burrito.addList2("Guacamole");
        burrito.addList2("Salsa");
        burrito.addList2("Sour cream (in the U.S.)");
        foods.put(Color.BURRITO, burrito);
        // Poblano
        Detail poblano = new Detail();
        poblano.setTitle("Poblano");
        poblano.setImage(R.drawable.poblano);
        poblano.setExtra("The poblano from the city of Puebla, Mexico, and is the one that looks like the size and shape of a green pepper. The green tone is a little darker. I always see to sell on natureba the corner market a great dehydrated peppers until I learned that Poblanos peppers earn the name of ancho when dry and esturricadas");
        foods.put(Color.POBLANO, poblano);
        // Others
    }

    public static Detail get(int color){
        return foods.get(color);
    }

    public static HashMap<Integer, Detail> getMap(){
        return foods;
    }

    public static ArrayList<Detail> toArrayList(){
        return new ArrayList<Detail>(foods.values());
    }
}
