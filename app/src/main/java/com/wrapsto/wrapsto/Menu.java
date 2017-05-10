package com.wrapsto.wrapsto;


public class Menu {
    private String name;
    private int imageResouceId;

    public static final Menu[] menues = new Menu[]{
            new Menu("Wraps", R.drawable.wraps),
            new Menu("Burger", R.drawable.burger9),
            new Menu("Dips", R.drawable.dips)

    };

    public Menu(String name, int imageResouceId) {
        this.name = name;
        this.imageResouceId = imageResouceId;
    }
    public String getName(){
        return name;
    }

    public int getImageResouceId() {
        return imageResouceId;
    }
}
