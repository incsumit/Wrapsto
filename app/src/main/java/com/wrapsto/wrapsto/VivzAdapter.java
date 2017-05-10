package com.wrapsto.wrapsto;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;


public class VivzAdapter extends RecyclerView.Adapter<VivzAdapter.MyViewHolder>{

    private LayoutInflater inflator;
    VivzDatabaseAdapter vivzDatabaseAdapter;

    Context myContext;

    DatabaseManipulator databaseManipulator;


    List<Information> data= Collections.emptyList();

    public VivzAdapter(Context context,List<Information> data)
    {

        inflator=LayoutInflater.from(context);
        this.data=data;
        myContext = context;

    }


    @Override
    public  MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view=inflator.inflate(R.layout.custom_row, parent,false);
        final MyViewHolder holder = new MyViewHolder(view);
        vivzDatabaseAdapter = new VivzDatabaseAdapter(myContext);


        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
    Information current=data.get(position);
    holder.title.setText(current.title);
        holder.icon.setImageResource(current.iconid);
        holder.itemImage.setImageResource(current.itemImage);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView itemImage;
       TextView title;
        ImageView icon;
        ImageView increase;
        ImageView decrease;
        TextView text;
        private int count = 0;
        private Boolean inc_count = true;


        public MyViewHolder(View itemView) {
            super(itemView);
            itemImage= (ImageView) itemView.findViewById(R.id.itemImage);
            title= (TextView) itemView.findViewById(R.id.listText);
            icon=(ImageView)  itemView.findViewById(R.id.listIcon);

            increase = (ImageView) itemView.findViewById(R.id.add);
            decrease = (ImageView) itemView.findViewById(R.id.sub);
            text = (TextView) itemView.findViewById(R.id.res);

            increase.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {

                     databaseManipulator = new DatabaseManipulator(myContext);




                    if(text.getText().toString().equals("00") && inc_count)
                    {
                        ++count;

                        if(count<10)
                        {
                            text.setText(0+""+count);
                        }
                        else
                        {
                            text.setText(""+count);
                        }

                        inc_count = false;

                        Intent my_data = new Intent();
                        my_data.putExtra("Name",title. getText().toString());
                        my_data.putExtra("Quantity",text. getText().toString());
                        databaseManipulator.saveItems(my_data);



                    }
                    else if(!inc_count)
                    {
                        ++count;

                        if(count<10)
                        {
                            text.setText(0+""+count);
                        }
                        else
                        {
                            text.setText(""+count);
                        }


                        Intent my_data = new Intent();
                        my_data.putExtra("Name",title. getText().toString());
                        my_data.putExtra("Quantity",text. getText().toString());
                        databaseManipulator.updateItem(my_data , title.getText().toString());

                    }









                }
            }
            );

            decrease.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    if (count > 0) {



                        databaseManipulator = new DatabaseManipulator(myContext);

                        --count;
                        if(count<10)
                        {text.setText(0+""+count);}
                        else{
                            text.setText(""+count);
                        }

                        Intent my_data = new Intent();
                        my_data.putExtra("Name",title. getText().toString());
                        my_data.putExtra("Quantity",text. getText().toString());
                        databaseManipulator.updateItem(my_data , title.getText().toString());

                    }
                }
            });



        }
    }
}
