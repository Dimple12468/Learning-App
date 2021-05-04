package com.example.studyedge;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import com.example.studyedge.DRVinterface.LoadMore;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class homeScreen extends AppCompatActivity {

    private RecyclerView recyclerView;
    private staticRvAdapter staticRvAdapter;

    List<dynamicRvModel> items = new ArrayList<>();
    dynamicRvAdapter dynamicRvAdapt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        ArrayList<staticRvModel> item = new ArrayList<>();
        item.add(new staticRvModel(R.drawable.ic_baseline_library_books_24,"DSA"));
        item.add(new staticRvModel(R.drawable.ic_baseline_library_books_24,"Algo"));
        item.add(new staticRvModel(R.drawable.ic_baseline_library_books_24,"ADA"));
        item.add(new staticRvModel(R.drawable.ic_baseline_library_books_24,"Algebra"));
        item.add(new staticRvModel(R.drawable.ic_baseline_library_books_24,"SE"));

        recyclerView = findViewById(R.id.rv1);
        staticRvAdapter = new staticRvAdapter(item);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        recyclerView.setAdapter(staticRvAdapter);

        items.add(new dynamicRvModel("List item 1"));
        items.add(new dynamicRvModel("List item 1"));
        items.add(new dynamicRvModel("List item 1"));
        items.add(new dynamicRvModel("List item 1"));
        items.add(new dynamicRvModel("List item 1"));
        items.add(new dynamicRvModel("List item 1"));
        items.add(new dynamicRvModel("List item 1"));
        items.add(new dynamicRvModel("List item 1"));
        items.add(new dynamicRvModel("List item 1"));
        items.add(new dynamicRvModel("List item 1"));
        items.add(new dynamicRvModel("List item 1"));
        items.add(new dynamicRvModel("List item 1"));
        items.add(new dynamicRvModel("List item 1"));
        items.add(new dynamicRvModel("List item 1"));
        items.add(new dynamicRvModel("List item 1"));
        items.add(new dynamicRvModel("List item 1"));
        items.add(new dynamicRvModel("List item 1"));
        items.add(new dynamicRvModel("List item 1"));
        items.add(new dynamicRvModel("List item 1"));
        items.add(new dynamicRvModel("List item 1"));

        RecyclerView drv = findViewById(R.id.rv2);
        drv.setLayoutManager(new LinearLayoutManager(this));
        dynamicRvAdapt = new dynamicRvAdapter(drv,this,items);
        drv.setAdapter(dynamicRvAdapt);

        dynamicRvAdapt.setLoadMore(new LoadMore() {
            @Override
            public void onLoadMore() {
                if(items.size()<10){
                    item.add(null);
                    dynamicRvAdapt.notifyItemInserted(items.size() - 1);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            items.remove(items.size() - 1);
                            dynamicRvAdapt.notifyItemRemoved(items.size());

                            int index = items.size();
                            int end = index + 10;
                            for(int i = index;i<end;i++){
                                String name = UUID.randomUUID().toString();
                                dynamicRvModel item = new dynamicRvModel(name);
                                items.add(item);
                            }
                            dynamicRvAdapt.notifyDataSetChanged();
                            dynamicRvAdapt.setLoded();
                        }
                    },4000);
                }
                else
                    Toast.makeText(homeScreen.this, "Success", Toast.LENGTH_SHORT).show();
            }
        });
    }
}