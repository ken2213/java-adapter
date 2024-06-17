package com.example.adapter;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // 1 - Adapterview: ListView
        listview = findViewById(R.id.listview);

        // 2 - Data Source: String array
        String[] countries = {"USA", "Germany", "Saudi Arabia", "France"};

        /*
           3 - Adapter: acts as a bridge between the
                        'data source' and the 'AdapterView'
        */
        //        ArrayAdapter<String> adapter = new ArrayAdapter<>(
        //                this,
        //                android.R.layout.simple_list_item_1,
        //                countries
        //        );
        MyCustomAdapter adapter = new MyCustomAdapter(this, countries);


        // Link Listview with the Adapter
        listview.setAdapter(adapter);
    }
}