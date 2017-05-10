package com.wrapsto.wrapsto;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.AuthData;
import com.firebase.client.Firebase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CheckOutActivity extends AppCompatActivity {
    ArrayList<HashMap<String, String>> my_arrayList;
    DatabaseManipulator databaseManipulator;

    ListView list;
    int price = 0;
    int sum = 0;
    TextView finalmsg,defaultmsg;
    String address, number;
    Firebase ref;
    HashMap<String, String> final_bill;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out);
        finalmsg=(TextView)findViewById(R.id.finalmsg);
        defaultmsg=(TextView)findViewById(R.id.defaultmsg);
        Firebase.setAndroidContext(this);
        ref = new Firebase("http://wrapsto.firebaseio.com");
        list = (ListView) findViewById(R.id.listView);
       // sum_text = (TextView) findViewById(R.id.sum);
        SharedPreferences preferences = getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        AuthData authData=ref.getAuth();
        ref.child("orders").child(authData.getUid()).child("items").setValue(my_arrayList);

        fill_hashmap();
       // sum_text.setText("" + sum);
        show_list();
        finalmsg.setText("Cash amount of "+sum+" rupees will be collected!");
        if (sum==0) {
            defaultmsg.setVisibility(View.VISIBLE);
            finalmsg.setVisibility(View.INVISIBLE);
        }
        else {
            defaultmsg.setVisibility(View.INVISIBLE);
        }
        editor.putBoolean("is_logged", true);
        editor.apply();
    }

    public void onCheckout(View v){
                    if(sum==0) {
                        Toast.makeText(CheckOutActivity.this, "Your cart is empty!", Toast.LENGTH_LONG).show();
                    }
                    else {
                        //String uid=getIntent().getStringExtra("uid");
                        AuthData authData=ref.getAuth();
                       ref.child("orders").child(authData.getUid()).child("items").setValue(my_arrayList);
                        Toast.makeText(CheckOutActivity.this, "Your order has been placed!", Toast.LENGTH_LONG).show();
                        finish();
                    }

        }


    private void fill_hashmap()
    {
        my_arrayList = new ArrayList<HashMap<String,String>>();
        databaseManipulator = new DatabaseManipulator(CheckOutActivity.this);


        Cursor eas = databaseManipulator.fetchenableItems();
        if (eas != null) {
            eas.moveToFirst();
            while (!eas.isAfterLast())
            {
                String title = eas.getString(1);
                String Quantity = eas.getString(2);



                if(title.equals("Veg Burger ~ 55"))
                {
                    price = Integer.parseInt(Quantity) * 55;
                }
                if(title.equals("Aloo Tikki Burger ~ 60"))
                {
                    price = Integer.parseInt(Quantity) * 60;
                }
                if(title.equals("Veg Cheesy Burger ~ 60"))
                {
                    price = Integer.parseInt(Quantity) * 60;
                }
                if(title.equals("Paneer zinger Burger ~ 70"))
                {
                    price = Integer.parseInt(Quantity) * 70;
                }
                if(title.equals("Chicken Burger ~ 55"))
                {
                    price = Integer.parseInt(Quantity) * 55;
                }
                if(title.equals("Chicken Cheese Burger ~ 65"))
                {
                    price = Integer.parseInt(Quantity) * 65;
                }
                if(title.equals("Tabdoori Chicken Burger ~ 70"))
                {
                    price = Integer.parseInt(Quantity) * 70;
                }
                if(title.equals("Wrapsto Signature Burger ~ 75"))
                {
                    price = Integer.parseInt(Quantity) * 75;
                }
                if(title.equals("Aloo Tikki Wrap ~ 40"))
                {
                    price = Integer.parseInt(Quantity) * 40;
                }
                if(title.equals("Seshmi Potato Chilli Wrap ~ 40"))
                {
                    price = Integer.parseInt(Quantity) * 40;
                }
                if(title.equals("Spicy Roasted Paneer Wrap ~ 50"))
                {
                    price = Integer.parseInt(Quantity) * 50;
                }
                if(title.equals("Mushroom Schzewan Wrap ~ 50"))
                {
                    price = Integer.parseInt(Quantity) * 50;
                }
                if(title.equals("Freash Vegetable Wrap ~ 60"))
                {
                    price = Integer.parseInt(Quantity) * 60;
                }
                if(title.equals("Wrapsto Mix Fillz Wrap ~ 60"))
                {
                    price = Integer.parseInt(Quantity) * 60;
                }
                if(title.equals("Veg Signature Wrap ~ 60"))
                {
                    price = Integer.parseInt(Quantity) * 60;
                }
                if(title.equals("Veg Cheesy Wrap ~ 70"))
                {
                    price = Integer.parseInt(Quantity) * 70;
                }
                if(title.equals("Pan Sizzling Chicken Wrap ~ 50"))
                {
                    price = Integer.parseInt(Quantity) * 50;
                }
                if(title.equals("Hydrabadi Chicken Wrap ~ 50"))
                {
                    price = Integer.parseInt(Quantity) * 50;
                }
                if(title.equals("Pepper Chiicken Wrap ~ 50"))
                {
                    price = Integer.parseInt(Quantity) * 50;
                }
                if(title.equals("Garlic Chicken Wrap ~ 50"))
                {
                    price = Integer.parseInt(Quantity) * 50;
                }
                if(title.equals("Chicken Tung Fung Wrap ~ 50"))
                {
                    price = Integer.parseInt(Quantity) * 50;
                }
                if(title.equals("Sizzled Egg Wrap ~ 50"))
                {
                    price = Integer.parseInt(Quantity) * 50;
                }
                if(title.equals("Russian Chicken Wrap ~ 60"))
                {
                    price = Integer.parseInt(Quantity) * 60;
                }
                if(title.equals("Mangolian Prawn Wrap ~ 60"))
                {
                    price = Integer.parseInt(Quantity) * 60;
                }
                if(title.equals("Chicken Kebab Wrap ~ 70"))
                {
                    price = Integer.parseInt(Quantity) * 70;
                }
                if(title.equals("Barbecue Chicken Wrap ~ 70"))
                {
                    price = Integer.parseInt(Quantity) * 70;
                }
                if(title.equals("Wrapsto Mix Fillz Wrap ~ 80"))
                {
                    price = Integer.parseInt(Quantity) * 80;
                }
                if(title.equals("Non-Veg Signature Wrap ~ 80"))
                {
                    price = Integer.parseInt(Quantity) * 80;
                }
                if(title.equals("Lebanese Wrap ~ 60"))
                {
                    price = Integer.parseInt(Quantity) * 60;
                }
                if(title.equals("Lebanese Salad ~ 70"))
                {
                    price = Integer.parseInt(Quantity) * 70;
                }
                if(title.equals("Cheese Nugget ~ 60"))
                {
                    price = Integer.parseInt(Quantity) * 60;
                }
                if(title.equals("Veg Maslal Nugget ~ 70"))
                {
                    price = Integer.parseInt(Quantity) * 70;
                }
                if(title.equals("Cheesy Finger ~ 60"))
                {
                    price = Integer.parseInt(Quantity) * 60;
                }
                if(title.equals("Sheekh Kabab ~ 60"))
                {
                    price = Integer.parseInt(Quantity) * 60;
                }
                if(title.equals("Chicken Nugget ~ 60"))
                {
                    price = Integer.parseInt(Quantity) * 60;
                }
                if(title.equals("Chicken Garlic Finger ~ 70"))
                {
                    price = Integer.parseInt(Quantity) * 70;
                }
                if(title.equals("Garlic Fish Finger ~ 80"))
                {
                    price = Integer.parseInt(Quantity) * 80;
                }

                sum = sum + price;
                final_bill = new HashMap<String, String>();
                final_bill.put("title", title);
                final_bill.put("Quantity", Quantity);
                final_bill.put("Price", Integer.toString(price));
                my_arrayList.add(final_bill);

                eas.moveToNext();
            }


        }

    }

    public void show_list()
    {

        ListAdapter adapter = new SimpleAdapter(
                CheckOutActivity.this, my_arrayList, R.layout.custom_checkout_row,
                new String[]{"title" , "Quantity" , "Price"},
                new int[]{R.id.title , R.id.res , R.id.price}
        );

        list.setAdapter(adapter);



    }

}
