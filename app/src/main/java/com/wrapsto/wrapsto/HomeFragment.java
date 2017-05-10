package com.wrapsto.wrapsto;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;


public class HomeFragment extends Fragment implements View.OnClickListener {

    ImageButton button1;
    ImageButton button2;
    ImageButton button3;

    DatabaseManipulator databaseManipulator;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home,
                container, false);


        ImageView button1 = (ImageView) view.findViewById(R.id.imageview1);
        ImageView button2 = (ImageView) view.findViewById(R.id.imageview2);
        ImageView button3 = (ImageView) view.findViewById(R.id.imageview3);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);

        return  view;

    }

    @Override
    public void onResume() {
        super.onResume();
        clear_databse();
    }

    private void clear_databse()
    {
        databaseManipulator = new DatabaseManipulator(getActivity());
        getActivity().deleteDatabase("wrpaso_dataBase");

    }


    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageview1:
                Intent burger = new Intent(getContext(),MainActivity.class);
                burger.putExtra("my_position" , 0);
                startActivity(burger);
                break;
            case R.id.imageview2:
                Intent dips = new Intent(getContext() ,MainActivity.class);
                dips.putExtra("my_position" , 1);
                startActivity(dips);
                break;
            case R.id.imageview3:
                Intent wraps = new Intent(getContext() ,MainActivity.class);
                wraps.putExtra("my_position" , 2);
                startActivity(wraps);
                break;



        }
    }


}





