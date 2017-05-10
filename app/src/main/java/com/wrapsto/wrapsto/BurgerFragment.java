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

public class BurgerFragment extends Fragment {
    private VivzAdapter adapter;
    private RecyclerView recyclerView;
    Button button;
    public BurgerFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View layout=inflater.inflate(R.layout.fragment_burger, container, false);

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
        int[] itemImage={R.drawable.burger10,R.drawable.burger11,R.drawable.burger12,R.drawable.burger13,R.drawable.burger14,R.drawable.burger15,R.drawable.burger16,R.drawable.burger};
        int[] icons={R.drawable.veg,R.drawable.veg,R.drawable.veg,R.drawable.veg,R.drawable.nonveg,R.drawable.nonveg,R.drawable.nonveg,R.drawable.nonveg};
        String[] titles={"Veg Burger ~ 55", "Aloo Tikki Burger ~ 60","Veg Cheesy Burger ~ 60","Paneer zinger Burger ~ 70","Chicken Burger ~ 55","Chicken Cheese Burger ~ 65","Tabdoori Chicken Burger ~ 70","Wrapsto Signature Burger ~ 75"};
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