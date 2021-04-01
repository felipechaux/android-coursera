package com.example.petagram;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.petagram.adapter.MascotaAdapter;
import com.example.petagram.pojo.Mascota;

import java.util.ArrayList;

public class ListMascotaFavorita extends BaseActivity {

    private SwipeRefreshLayout sfiMyIndicator;
    private RecyclerView recyclerListMascotasFavoritas;
    private ArrayList<Mascota> mascotasFavoritas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_mascota_favorita);

        configActionBar();

        sfiMyIndicator = findViewById(R.id.sfiMyIndicator);
        recyclerListMascotasFavoritas = findViewById(R.id.rvMascotasFavoritas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        recyclerListMascotasFavoritas.setLayoutManager(llm);

        logicIndicator();
        initListMascotasFavoritas();
        initAdapter();
    }

    public void initListMascotasFavoritas() {
        try {
            mascotasFavoritas = new ArrayList<>();
            mascotasFavoritas.add(new Mascota("Pelusa", "https://png.pngtree.com/png-clipart/20190411/ourlarge/pngtree-kirkys-hand-painted-elements-for-pet-dogs-png-image_924657.jpg", 5));
            mascotasFavoritas.add(new Mascota("Max", "https://png.pngtree.com/element_origin_min_pic/17/07/21/103c21b14dba749cb1aee8bb17e18185.jpg", 5));
            mascotasFavoritas.add(new Mascota("BlackMens", "https://png.pngtree.com/png-clipart/20210119/ourlarge/pngtree-png-dog-image-png-image_2763385.jpg", 5));
            mascotasFavoritas.add(new Mascota("Navideño", "https://png.pngtree.com/png-vector/20201028/ourlarge/pngtree-golden-retriever-dog-wearing-a-santa-hat-for-christmas-vector-illustration-png-image_2381030.jpg", 5));
            mascotasFavoritas.add(new Mascota("BlackMens", "https://png.pngtree.com/png-vector/20200205/ourlarge/pngtree-adorable-puppy-dog-cute-with-ribbon-watercolor-illustration-png-image_2141717.jpg", 5));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initAdapter() {
        try {
            MascotaAdapter adapter = new MascotaAdapter(mascotasFavoritas, this,false);
            recyclerListMascotasFavoritas.setAdapter(adapter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressLint("ResourceType")
    private void logicIndicator() {
        try {
            sfiMyIndicator.setOnRefreshListener(this::refreshContent);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void refreshContent() {
        try {
            initListMascotasFavoritas();
            MascotaAdapter adapter = new MascotaAdapter(mascotasFavoritas, this,false);
            recyclerListMascotasFavoritas.setAdapter(adapter);
            sfiMyIndicator.setRefreshing(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void configActionBar() {
        try {
            Toolbar toolbar = (Toolbar) findViewById(R.id.myActionBar);
            setSupportActionBar(toolbar);
            ImageButton btnFavoritos = toolbar.findViewById(R.id.btnFavoritos);
            btnFavoritos.setVisibility(View.GONE);
            ImageButton btnHome = toolbar.findViewById(R.id.imgHuellita);
            btnHome.setOnClickListener(view -> startActivity(new Intent(this, MascotasActivity.class)));
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //soporte para menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mascota_menu, menu);
        return true;
    }

    //soporte para navegacion back
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}