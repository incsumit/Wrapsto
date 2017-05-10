package com.wrapsto.wrapsto;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



import java.util.ArrayList;
import java.util.List;


public class DipsFragment extends Fragment {
    private VivzAdapter adapter;
    private RecyclerView recyclerView;
    public DipsFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View layout=inflater.inflate(R.layout.fragment_dips, container, false);
        recyclerView= (RecyclerView) layout.findViewById(R.id.abc);
        adapter=new VivzAdapter(getActivity(),getData());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return layout;

    }

    public static List<Information> getData(){

        List<Information> data=new ArrayList<>();
        int[] itemImage={R.drawable.dips1,R.drawable.dips2,R.drawable.dips3,R.drawable.dips4,R.drawable.dips5,R.drawable.dips6,R.drawable.dips7};
        int[] icons={R.drawable.veg,R.drawable.veg,R.drawable.veg,R.drawable.nonveg,R.drawable.nonveg,R.drawable.nonveg,R.drawable.nonveg};
        String[] titles={"Cheese Nugget ~ 60", "Veg Maslal Nugget ~ 70","Cheesy Finger ~ 60","Sheekh Kabab ~ 60","Chicken Nugget ~ 60","Chicken Garlic Finger ~ 70","Garlic Fish Finger ~ 80"};
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