package com.wrapsto.wrapsto;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class WrapsFragment extends Fragment {
    private VivzAdapter adapter;
    private RecyclerView recyclerView;
    Button button;
    public WrapsFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View layout=inflater.inflate(R.layout.fragment_wraps, container, false);

        recyclerView= (RecyclerView) layout.findViewById(R.id.abc_burger);
        adapter=new VivzAdapter(getActivity(),getData());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        return layout;
    }



    public static List<Information> getData(){

        List<Information> data=new ArrayList<>();
        int[] itemImage={R.drawable.wrap1,R.drawable.wrap2,R.drawable.wrap3,R.drawable.wrap4,R.drawable.wrap5,R.drawable.wrap6,R.drawable.wrap7,R.drawable.wrap8,R.drawable.wrap9,R.drawable.wrap10,R.drawable.wrap11,R.drawable.wrap12,R.drawable.wrap13,R.drawable.wrap14,R.drawable.wrap15,R.drawable.wrap16,R.drawable.wrap17,R.drawable.wrap18,R.drawable.wrap19,R.drawable.wrap20,R.drawable.wrap21,R.drawable.wrap22};
        int[] icons={R.drawable.veg,R.drawable.veg,R.drawable.veg,R.drawable.veg,R.drawable.veg,R.drawable.veg,R.drawable.veg,R.drawable.veg,R.drawable.nonveg,R.drawable.nonveg,R.drawable.nonveg,R.drawable.nonveg,R.drawable.nonveg,R.drawable.nonveg,R.drawable.nonveg,R.drawable.nonveg,R.drawable.nonveg,R.drawable.nonveg,R.drawable.nonveg,R.drawable.nonveg,R.drawable.nonveg,R.drawable.nonveg,};
        String[] titles={"Aloo Tikki Wrap ~ 40", "Seshmi Potato Chilli Wrap ~ 40","Spicy Roasted Paneer Wrap ~ 50","Mushroom Schzewan Wrap ~ 50","Freash Vegetable Wrap ~ 60","Wrapsto Mix Fillz Wrap ~ 60","Veg Signature Wrap ~ 60","Veg Cheesy Wrap ~ 70","Pan Sizzling Chicken Wrap ~ 50","Hydrabadi Chicken Wrap ~ 50","Pepper Chiicken Wrap ~ 50","Garlic Chicken Wrap ~ 50","Chicken Tung Fung Wrap ~ 50","Sizzled Egg Wrap ~ 50","Russian Chicken Wrap ~ 60","Mangolian Prawn Wrap ~ 60","Chicken Kebab Wrap ~ 70","Barbecue Chicken Wrap ~ 70","Wrapsto Mix Fillz Wrap ~ 80","Non-Veg Signature Wrap ~ 80","Lebanese Wrap ~ 60","Lebanese Salad ~ 70"};
        for (int i=0;i<titles.length && i<icons.length && i<itemImage.length;i++)
        {
            Information current=new Information();
            current.itemImage=itemImage[i];
            current.iconid=icons[i];
            current.title=titles[i];
            data.add(current);
        }
        return data;
    }

}