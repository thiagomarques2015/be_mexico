package br.com.bemexico;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Thiago on 02/09/2016.
 */
public class Pool {

    public static class Item {
        public static int BURRITO = 1;
        public static final int POBLANO = 2;
        public static final int GORDITA = 3;
        public static final int PANCITA = 4;
        public static final int PICO_DE_GALLO = 5;
        public static final int POZOLE = 6;
        public static final int SALSA = 7;
        public static final int TEQUILA = 8;
        public static final int DANCE1 = 9;
        public static final int DANCE2 = 10;
        public static final int DANCE3 = 11;
        public static final int DANCE4 = 12;
    }

    private static HashMap<Integer, Detail> items;

    static  {
        items = new HashMap<>();
        // Burrito
        Detail burrito = new Detail();
        burrito.setType(Item.BURRITO);
        burrito.setIcon(R.drawable.food);
        burrito.setTitle("Burrito");
        burrito.setDescription("It's very popular dish");
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
        items.put(Item.BURRITO, burrito);
        // Poblano
        Detail poblano = new Detail();
        poblano.setType(Item.POBLANO);
        poblano.setIcon(R.drawable.food);
        poblano.setTitle("Poblano");
        poblano.setDescription("The poblano from the city of Puebla, Mexico");
        poblano.setImage(R.drawable.poblano);
        poblano.setExtra("The poblano from the city of Puebla, Mexico, and is the one that looks like the size and shape of a green pepper. The green tone is a little darker. I always see to sell on natureba the corner market a great dehydrated peppers until I learned that Poblanos peppers earn the name of ancho when dry and esturricadas");
        items.put(Item.POBLANO, poblano);
        // Gordita
        Detail gordita = new Detail();
        gordita.setType(Item.GORDITA);
        gordita.setIcon(R.drawable.food);
        gordita.setExtra(" In Mexican cuisine is a small cake made with masa and stuffed with cheese, meat, or other fillings. It is similar to a pasty and to the Colombian/Venezuelan arepa." +
                "\n\n Gordita means \"chubby\" in Spanish. There are two main variations of this dish, one which is typically fried in a deep wok-shaped comal, consumed mostly on center and south Mexico, and another one baked on a regular comal, prepared as a thick tortilla.\n" +
                "\n" +
                "The most common and representative variation of this dish is the \"gordita de chicharrón\", filled with chicharron (a spiced stew of pork rind) which is widely consumed throughout Mexico.");
        gordita.setTitle("Gordita");
        gordita.setTitleList1("Main ingredients");
        gordita.addList1("Corn tortillas");
        gordita.addList1("Guisados (meat stew)");
        gordita.addList1("Salsa");
        gordita.setDescription("In Mexican cuisine is a small cake. It is similar to a pasty");
        gordita.setImage(R.drawable.gordita);
        items.put(Item.GORDITA, gordita);
        // Pancita
        Detail pancita = new Detail();
        pancita.setType(Item.PANCITA);
        pancita.setIcon(R.drawable.food);
        pancita.setTitle("Pancita");
        pancita.setDescription("You need knowing the typical dish from Spanish");
        pancita.setExtra("Menudo, or pancita, from Spanish: Panza; \"Gut/Stomach\") is a traditional Mexican soup, made with beef stomach (tripe) in broth with a red chili pepper base. Usually, lime, chopped onions, and chopped cilantro are added, as well as crushed oregano and crushed red chili peppers.\n" +
                "\n" +
                "Menudo is usually eaten with corn tortillas or other breads, such as bolillo. It is often chilled and reheated, which results in a more concentrated flavor. The popularity of menudo in Mexico is such that Mexico is a major export market for stomach tripe from US and Canadian beef producers.");
        pancita.setTitleList1("Main ingredients");
        pancita.addList1("Beef Tripe (cow stomach)");
        pancita.addList1("Broth");
        pancita.addList1("Lime");
        pancita.addList1("Onions");
        pancita.addList1("Cilantro");
        pancita.addList1("Oregano");
        pancita.addList1("Red chili peppers");
        pancita.setImage(R.drawable.pancita);
        items.put(Item.PANCITA, pancita);
        // Pico de Gallo
        Detail picoDeGalo = new Detail();
        picoDeGalo.setType(Item.PICO_DE_GALLO);
        picoDeGalo.setIcon(R.drawable.food);
        picoDeGalo.setTitle("Pico de gallo");
        picoDeGalo.setExtra("In Mexican cuisine, pico de gallo, literally beak of rooster, also called salsa fresca, is made from chopped tomato, onion, coriander leaves, fresh serranos (jalapeños or habaneros are used as alternatives), salt, and key lime juice. Other ingredients, such as shrimp or avocado, are also sometimes added.\n" +
                "\n" +
                "Pico de gallo can be used in much the same way as other Mexican liquid salsas, but since it contains less liquid, it can also be used as a main ingredient in dishes such as tacos and fajitas.");
        picoDeGalo.setDescription("Also called by salsa fresca in Mexican");
        picoDeGalo.setTitleList1("Main ingredients");
        picoDeGalo.addList1("Salsa");
        picoDeGalo.addList1("Filings made with tomato");
        picoDeGalo.addList1("Tomatillo");
        picoDeGalo.addList1("Onion");
        picoDeGalo.addList1("Serranos");
        picoDeGalo.addList1("Salt");
        picoDeGalo.addList1("Lime juice");
        picoDeGalo.addList1("Cucumber");
        picoDeGalo.addList1("Papaya");
        picoDeGalo.addList1("Chili");
        picoDeGalo.setImage(R.drawable.pico_de_gallo);
        items.put(Item.PICO_DE_GALLO, picoDeGalo);
        // Pozole
        Detail pozole = new Detail();
        pozole.setType(Item.POZOLE);
        pozole.setIcon(R.drawable.food);
        pozole.setTitle("Pozole");
        pozole.setDescription("A traditional soup from Mexico");
        pozole.setExtra("Pozole, which means \"hominy\", is a traditional soup or stew from Mexico, which once had ritual significance. It is made from hominy, with meat (typically pork), and can be seasoned and garnished with chile peppers, onion, garlic, radishes, avocado, salsa and/or limes.\n" +
                "\n" +
                "It is a typical dish in various states such as Sinaloa, Michoacán, Guerrero, Zacatecas, Jalisco, Morelos, State of Mexico and Distrito Federal. Pozole is served in Mexican restaurants worldwide.\n" +
                "\n" +
                "Pozole is frequently served as a celebratory dish throughout Mexico and by Mexican communities outside Mexico. Common occasions include quince años, weddings, birthdays, baptisms, and New Year's Day.");
        pozole.setTitleList1("Main ingredients");
        pozole.addList1("Horminy");
        pozole.addList1("Meat (usually pork)");
        pozole.addList1("Chile peppers");
        pozole.addList1("Seasonings");
        pozole.setImage(R.drawable.pozole);
        items.put(Item.POZOLE, pozole);
        // Salsa
        Detail salsa = new Detail();
        salsa.setType(Item.SALSA);
        salsa.setIcon(R.drawable.food);
        salsa.setTitle("Salsa");
        salsa.setExtra("Salsa is the Italian and Spanish term for sauce, and in English-speaking countries usually refers to the sauces typical of Mexican cuisine known as salsa picante, particularly those used as dips.\n" +
                "\n" +
                "Salsa is often a tomato-based sauce or dip which is heterogeneous and includes additional components such as onions, chilies, beans, corn, and various spices. They are typically piquant, ranging from mild to extremely hot.");
        salsa.setDescription("The sauces typical of Mexican cuisine");
        salsa.setTitleList1("Generally Used");
        salsa.addList1("Tomato");
        salsa.addList1("Chili peppers");
        salsa.setImage(R.drawable.salsa);
        items.put(Item.SALSA, salsa);
        // Tequila
        Detail tequila = new Detail();
        tequila.setType(Item.TEQUILA);
        tequila.setIcon(R.drawable.drink);
        tequila.setTitle("Tequila");
        tequila.setExtra("Tequila is a regional specific name for a distilled beverage made from the blue agave plant, primarily in the area surrounding the city of Tequila, 65 km (40 mi) northwest of Guadalajara, and in the highlands (Los Altos) of the central western Mexican state of Jalisco. Although tequila is similar to mezcal, modern tequila differs somewhat in the method of its production, in the use of only blue agave plants, as well as in its regional specificity.\n" +
                "\n" +
                "The red volcanic soil in the surrounding region is particularly well suited to the growing of the blue agave, and more than 300 million of the plants are harvested there each year. Agave tequila grows differently depending on the region. Blue agaves grown in the highlands Los Altos region are larger in size and sweeter in aroma and taste. Agaves harvested in the lowlands, on the other hand, have a more herbaceous fragrance and flavor.\n" +
                "\n" +
                "Mexican laws state that tequila can only be produced in the state of Jalisco and limited municipalities in the states of Guanajuato, Michoacán, Nayarit, and Tamaulipas. Tequila is recognized as a Mexican designation of origin product in more than 40 countries. It is protected through NAFTA in Canada and the United States, through bilateral agreements with individual countries such as Japan and Israel, and has been a protected designation of origin product in the constituent countries of the European Union since 1997.\n" +
                "\n" +
                "Tequila is most often made at a 38% alcohol content (76 U.S. proof) for domestic consumption, but can be produced between 31 and 55% alcohol content (62 and 110 U.S. proof). Per U.S law, tequila must contain at least 40% alcohol (80 U.S. proof) to be sold in the United States");
        tequila.setDescription("A drink with regional name from Mexico. Your composition is basic 38% alcohol");
        tequila.setImage(R.drawable.tequila);
        items.put(Item.TEQUILA, tequila);
        // Jarabe Tapatio
        Detail dance1 = new Detail();
        dance1.setType(Item.DANCE1);
        dance1.setIcon(R.drawable.dance);
        dance1.setTitle("Jarabe Tapatio");
        dance1.setDescription("It is considered the national dance of country");
        dance1.setExtra("\"Jarabe Tapatio\" or \"Mexican dance hat\": It is considered the national dance of country. The dance is about a love story between a man and a woman in a party. In a moment, the man throws his hat on the floor and dances around the hat and around the woman. She picks up the hat for to show that she accepts the his love, puts in her head and they go away happy");
        dance1.setImage(R.drawable.dance1);
        items.put(Item.DANCE1, dance1);
        // Dance 2
        Detail dance2 = new Detail();
        dance2.setType(Item.DANCE2);
        dance2.setIcon(R.drawable.dance);
        dance2.setTitle("La Danza de los Viejitos");
        dance2.setDescription("It is a old tradition. Usually by young people");
        dance2.setExtra("\"La Danza de los Viejitos\" or \"Dance of the old men\": It is a old tradition. It is usually performed by young people. They imitate older people in funny movements. they wear peasant clothes and they use masks of older faces, with a smile and no teeth");
        dance2.setImage(R.drawable.dance2);
        items.put(Item.DANCE2, dance2);
        // Dance 3
        Detail dance3 = new Detail();
        dance3.setType(Item.DANCE3);
        dance3.setIcon(R.drawable.dance);
        dance3.setTitle("Cha cha cha");
        dance3.setDescription("Very lively rhythm from Mexico");
        dance3.setExtra("\"Cha cha cha\": The cha cha cha is original of Mexico and is a very lively rhythm. It is a dance more caliente and is very similar to many Latin dances, for example, the Mambo");
        dance3.setImage(R.drawable.dance3);
        items.put(Item.DANCE3, dance3);
        // Dance 4
        Detail dance4 = new Detail();
        dance4.setType(Item.DANCE4);
        dance4.setIcon(R.drawable.dance);
        dance4.setTitle("Danzon");
        dance4.setDescription("Popular in Mexico by arrival of some immigrants");
        dance4.setExtra("\"Danzon\": The danzon is original of Cuba, but became popular in Mexico by arrival of some immigrants. It is a dance more romantic and is very similar to Valsa, but a little more lively. It is common in formal occasions and is only danced to two");
        dance4.setImage(R.drawable.dance4);
        items.put(Item.DANCE4, dance4);
        // Others
    }

    public static Detail get(int color){
        return items.get(color);
    }

    public static HashMap<Integer, Detail> getMap(){
        return items;
    }

    public static ArrayList<Detail> toArrayList(){
        return new ArrayList<Detail>(items.values());
    }
}
