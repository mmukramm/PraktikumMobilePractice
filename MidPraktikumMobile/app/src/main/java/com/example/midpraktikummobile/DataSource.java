package com.example.midpraktikummobile;

import java.util.ArrayList;
import java.util.Arrays;

public class DataSource {
    private static ArrayList<MenuModel> menus;

    public static ArrayList<MenuModel> getMenu(){
        menus = new ArrayList<MenuModel>(
                Arrays.asList(
                        new MenuModel("Chicken Noodles", "Combination between sweet and spicy noodles with a taste of chicken", "15000", "makanan", false),
                        new MenuModel("Jakarta Fried Rice", "Sweet taste of fried rice", "15000", "makanan", false),
                        new MenuModel("Gado Gado", "An Indonesian salad of raw, slightly boiled, blanched or steamed vegetables served with a peanut sauce dressing", "12000", "makanan", false),
                        new MenuModel("Wagyu Steak", "300gr of wagyu steak", "49000", "makanan", false),
                        new MenuModel("Korean Chicken Wing", "Spicy and sweet sauce with tasty chicken wing", "32000", "makanan", false),

                        new MenuModel("Sweet Ice Tea", "Ya sweet ice tea", "5000", "minuman", false),
                        new MenuModel("Pop Ice Kudapan", "Rare pop ice that made at Kudapan BNI Universitas Hasanuddin", "5000", "minuman", false),
                        new MenuModel("Milo", "Just an ordinary cold milo but served with heart", "7000", "minuman", false),
                        new MenuModel("Avocado Juice", "Rich and silky chilled beverage made of fresh avocado", "10000", "minuman", false),
                        new MenuModel("Cold Water", "A cold bottle of Le Minerale that has sweetness", "3000", "minuman", false)
                )
        );
        return menus;
    }
}
