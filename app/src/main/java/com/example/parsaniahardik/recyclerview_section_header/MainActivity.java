package com.example.parsaniahardik.recyclerview_section_header;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CustomAdapter customAdapter;

    private String[] vehicleTypes = new String[]{"Cars", "Bikes",
            "Air Crafts","Old Vehicles"};

    private ArrayList<ListItem> listItemArrayList;

    private String[] childnames = new String[]{"Range Rover", "Lamborghini",
            "Rolls Royce","Ferrari","Harley davidson","Ducati","BMW","Honda","Boeing","Airbus","Royal Air","Space X","Horse","Elephant","Camel","Donkey"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycler);

        listItemArrayList = new ArrayList<>();
        populateList();

        customAdapter = new CustomAdapter(this,listItemArrayList);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
    }

    public interface ListItem {
        boolean isHeader();
        String getName();
    }

    private void populateList(){

        int headerdone = 0, childdone = 0;

        for(int i = 0; i < 20; i++){

            if(i == 0 || i == 5 | i == 10 | i == 15){
                HeaderModel vehicleModel = new HeaderModel();
                vehicleModel.setheader(vehicleTypes[headerdone]);
                listItemArrayList.add(vehicleModel);
                headerdone = headerdone + 1;
            }else {
                ChildModel childModel = new ChildModel();
                childModel.setChild(childnames[childdone]);
                listItemArrayList.add(childModel);
                childdone = childdone + 1;
            }
        }

    }
}
