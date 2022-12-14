package com.example.grid2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

import static com.google.android.material.bottomnavigation.BottomNavigationView.*;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerAdaptor2 adaptor;
    RecyclerView.LayoutManager layoutManager;
    BottomNavigationView bottomNavigationView;
    ArrayList<String> pro_name;
    ArrayList<String> pro_price;
    ArrayList<Integer> mImages;
    ArrayList<String> pro_descrip;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.toolbar);
        setContentView(R.layout.activity_main);
        getSupportActionBar().show();

        pro_name = new ArrayList<>();
        pro_price = new ArrayList<>();
        mImages = new ArrayList<>();
        pro_descrip =new ArrayList<>();

        pro_name.add("headset");
        pro_name.add("Iphone 12");
        pro_name.add("dell pc");
        pro_name.add("nike shoe");
        pro_name.add("pc mouse");
        pro_name.add("nike AF1");
        pro_name.add("hp mouse");
        pro_name.add("wits hoodie");
        pro_name.add("gaming pad");
        pro_name.add("dell keyboard");
        pro_name.add("LED lights");

        mImages.add(R.drawable.headset);
        mImages.add(R.drawable.download);
        mImages.add(R.drawable.dell_pc);
        mImages.add(R.drawable.nikeshoe);
        mImages.add(R.drawable.mouse2);
        mImages.add(R.drawable.nike_af1);
        mImages.add(R.drawable.mouse);
        mImages.add(R.drawable.lastnike);
        mImages.add(R.drawable.gaming_pad);
        mImages.add(R.drawable.keyboard);
        mImages.add(R.drawable.led_lights);


        pro_descrip.add("The Yealink WH66 is the Industry-leading DECT wireless headset, with WH66 Dual and WH66 Mono two models, opening an entirely new form of desktop collaboration");
        pro_descrip.add("The iPhone 12 and iPhone 12 mini are part of Apple's latest generation of smartphones, offering OLED displays, 5G connectivity, the A14 chip for better performance");
        pro_descrip.add("Windows 10 Home\n" + "14.5-Inch QHD+ IPS Display\n" + "8GB RAM and 512GB SSD Storage\n" + "Intel Core i5 1135G7 Processor\n" + "Intel Iris Xe Graphics\n" + "Backlit Keyboard\n" + "Silver Palmrest");
        pro_descrip.add("Nike sportswear haritage");
        pro_descrip.add("The mouse is a computer input device used to move a cursor around a screen. The mouse buttons are used to interact with whatever is being");
        pro_descrip.add("Iconic style, legendary craftmanship ??? the Air Force 1 is a classic. Discover our sneaker collections for men, women and kids. Free deliveries and returns");
        pro_descrip.add("Intel Core i5 4th Gen 2.9GHz\n" + "Desktop\n" + "8GB DDR3 memory\n" + "240GB SSD Drive\n" + "DVD-Rom\n" + "Intel Gigabit Network Card\n" + "Intel HD Graphics\n" + "6 x USB 2.0 ports\n" + "4 x USB 3.0 ports\n" + "2 x DisplayPort For HD Multi- Screen Displays (Business alternative to HDMI)\n" + "19\" monitor (Brand may Vary)\n" + "Windows 10 Professional");
        pro_descrip.add("wits best wear brand");
        pro_descrip.add("extra strong, water proof, best LED light , 12inch screeen");
        pro_descrip.add("make your room cool with our led lights, the best lights in town");



        pro_price.add("R 345");
        pro_price.add("R 23445");
        pro_price.add("R 7493");
        pro_price.add("R 350");
        pro_price.add("R 130");
        pro_price.add("R 1800");
        pro_price.add("R 2999");
        pro_price.add("R 550");
        pro_price.add("R 5000");
        pro_price.add("R 402");
        pro_price.add("R 120");


        recyclerView = findViewById(R.id.recyclerView2);
        layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
        adaptor = new RecyclerAdaptor2(this, pro_name, pro_price, mImages,pro_descrip);
        recyclerView.setAdapter(adaptor);
        recyclerView.setHasFixedSize(true);
        bottomNavigationView = findViewById(R.id.bottom_navigator);
        bottomNavigationView.setSelectedItemId(R.id.home);
        bottomNavigationView.setOnNavigationItemSelectedListener(new OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.profile_page:
                        startActivity(new Intent(getApplicationContext(), Profile.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.home:
                        return true;
                    case R.id.MyStore:
                        startActivity(new Intent(getApplicationContext(), My_store.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.sell:
                        startActivity(new Intent(getApplicationContext(), Sell.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_manu, menu);
        MenuItem item = menu.findItem(R.id.action_search);
        androidx.appcompat.widget.SearchView searchView = (androidx.appcompat.widget.SearchView) item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adaptor.getFilter().filter(newText);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}